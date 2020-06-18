/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

/**
 * ----------------- @author nguyenvanquan7826 -----------------
 */

public class ExcelPOI {

    // create and write new file *.xls
    static public void writeFileExcel(JTable tbl) {
        WritableWorkbook workbook = null;
        //Open file select
        JFileChooser chooserFile = new JFileChooser();
        FileNameExtensionFilter fe = new FileNameExtensionFilter("Excel","xls");
        chooserFile.setFileFilter(fe);
        
        int chooser = chooserFile.showSaveDialog(chooserFile);
        if (chooser == JFileChooser.APPROVE_OPTION) {
            File file = chooserFile.getSelectedFile();
            
            // create workbook
            try {
                workbook = Workbook.createWorkbook(file);
            } catch (IOException ex) {
                Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // create sheet
        WritableSheet sheet1 = workbook.createSheet("KTPM K10B", 0);
        // create Label and add to sheet
        //sheet1.addCell(new Label(0, 0, "DANH SÁCH SINH VIÊN TIÊU BIỂU"));

        // row begin write data
        int rowBegin = 1;
        int colBegin = 0;
        for (int i = 0; i < tbl.getColumnCount(); i++) {
            try {
                sheet1.addCell(new Label(i, 0, tbl.getColumnName(i).toString()));
            } catch (WriteException ex) {
                Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int row = rowBegin, i = 0; row < tbl.getRowCount() + rowBegin; row++, i++) {
            for (int col = colBegin, j = 0; col < tbl.getColumnCount() + colBegin; col++, j++) {
                try {
                    sheet1.addCell(new Label(col, row, tbl.getValueAt(i, j).toString()));
                } catch (WriteException ex) {
                    Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            // write file
            workbook.write();
        } catch (IOException ex) {
            Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // close
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("create and write success");
    }
    static public void writeFileExcelAnalysis(String titleAnalysis[], JTable tbl[], String nameOverview[], JTextField OverviewValue[]) {
        WritableWorkbook workbook = null;
        //Open file select
        JFileChooser chooserFile = new JFileChooser();
        FileNameExtensionFilter fe = new FileNameExtensionFilter("Excel","xls");
        chooserFile.setFileFilter(fe);
        
        int chooser = chooserFile.showSaveDialog(chooserFile);
        if (chooser == JFileChooser.APPROVE_OPTION) {
            File file = chooserFile.getSelectedFile();
            
            // create workbook
            try {
                workbook = Workbook.createWorkbook(file);
            } catch (IOException ex) {
                Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // create sheet
        WritableSheet sheet1 = workbook.createSheet("Thống kê", 0);
        // create Label and add to sheet
        //sheet1.addCell(new Label(0, 0, "DANH SÁCH SINH VIÊN TIÊU BIỂU"));
        int rowBegin = 0;
        int colBegin = 0;
        //Title Analysis
        for(int i=0; i<titleAnalysis.length; i++){
            try {
                sheet1.addCell(new Label(colBegin++, rowBegin, titleAnalysis[i]));
            } catch (WriteException ex) {
                Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
            }
            colBegin+=2;
        }
        //Title tables
        rowBegin = 1;
        colBegin = 0;
        for (int j = 0; j < tbl.length; j++) {
            for (int i = 0; i < tbl[j].getColumnCount(); i++) {
                try {
                    sheet1.addCell(new Label(colBegin++, rowBegin, tbl[j].getColumnName(i).toString()));
                } catch (WriteException ex) {
                    Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            colBegin++;
        }

        // row begin write data
        rowBegin = 2;
        colBegin = 0;
        for (int k = 0; k < tbl.length; k++) {
            for (int row = rowBegin, i = 0; row < tbl[k].getRowCount() + rowBegin; row++, i++) {
                for (int col = colBegin, j = 0; col < tbl[k].getColumnCount() + colBegin; col++, j++) {
                    try {
                        sheet1.addCell(new Label(col, row, tbl[k].getValueAt(i, j).toString()));
                        sheet1.addCell(new Label(col, row, tbl[k].getValueAt(i, j).toString()));
                    } catch (WriteException ex) {
                        Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            rowBegin=2;
            colBegin+=tbl[k].getColumnCount()+1;
        }
        rowBegin+=tbl[0].getRowCount()+5;
        colBegin=0;
        for(int i=0; i<OverviewValue.length; i++){
            try {
                sheet1.addCell(new Label(colBegin++,rowBegin,nameOverview[i]));
                sheet1.addCell(new Label(colBegin++,rowBegin,OverviewValue[i].getText()));
            } catch (WriteException ex) {
                Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            // write file
            workbook.write();
        } catch (IOException ex) {
            Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // close
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ExcelPOI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("create and write success");
    }
    // open and read file *.xls
    private void readFileExcel() throws IOException {
        Workbook workbook;
        try {
            // create workbook to open file
            workbook = Workbook.getWorkbook(new File("G:/a.xsl"));
            // get sheet want read
            Sheet sheet = workbook.getSheet(0);
            // get number row and col contain data
            int rows = sheet.getRows();
            int cols = sheet.getColumns();
 
            System.out.println("Data in file:");
            // read data in each cell
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    Cell cell = sheet.getCell(col, row);
                    System.out.print(cell.getContents() + "\t");
                }
                System.out.println("\n");
            }
            // close
            workbook.close();
        } catch (BiffException e) {
            System.out.println("File not found\n" + e.toString());
        }
    }
 
    // open and write file is exists
    /*
    private void openAndWriteFileExcel() throws IOException, BiffException, WriteException {
        Workbook workbook;
        WritableWorkbook writeWorkbook;
        try {
            // open file
            workbook = Workbook.getWorkbook(new File("G:/a.xsl"));
            // create file copy of root file to write file
            writeWorkbook = Workbook.createWorkbook(new File("G:/a.xsl"),
                    workbook);
 
            // get sheet to write
            WritableSheet sheet1 = writeWorkbook.getSheet(0);
            int col = 3;
            int rowBegin = 3;
            // write data (formula)
            for (int row = rowBegin; row < data.length + rowBegin - 1; row++) {
                Formula f = new Formula(col, row, "IF(C" + (row + 1)
                        + ">8, \"Xuất sắc\", \"Giỏi\")");
                sheet1.addCell(f);
            }
            writeWorkbook.write();
 
            // close
            writeWorkbook.close();
        } catch (RowsExceededException e) {
            System.out.println("File not found\n" + e.toString());
        }
        System.out.println("open and write success");
    }*/

}
