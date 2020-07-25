/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BUSGetAuthor;
import BUS.BUSGetBook;
import BUS.BUSGetCustomer;
import BUS.BUSGetGenre;
import BUS.BUSGetStaff;
import BUS.BUSOrderManager;
import BUS.BUSRole;
import DTO.Staff;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tik
 */
public class GUIAnalysis {
    //Nhan vien
    Staff staff;
    //Data transfer object
    BUSGetStaff busStaff = new BUSGetStaff();
    BUSRole busRole = new BUSRole();
    BUSGetBook busBook = new BUSGetBook();
    BUSGetGenre busGenre = new BUSGetGenre();
    BUSGetAuthor busAuthor = new BUSGetAuthor();
    BUSGetCustomer busCustomer = new BUSGetCustomer();
    BUSOrderManager busOrder = new BUSOrderManager();
    
    ArrayList<Staff> listStaffGlobal = new ArrayList<>();
    Staff staffSelected = new Staff();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    Date today = new Date();
    Calendar cal = Calendar.getInstance();
    public JPanel initComponents(Staff staff){
        // Nhan vien
         this.staff = staff;
        //Panel chinh
        pnlMainPanel.setBackground(Cl.colorBackground);
        pnlMainPanel.setBorder(Cl.blueLine);
        pnlMainPanel.setPreferredSize(new Dimension(1110, 700));
        //Khoảng thời gian
        pnlDateZone.setPreferredSize(new Dimension(1050, 50));
        pnlDateZone.setBackground(Cl.colorBackground);
        pnlDateZone.setBorder(Cl.blueLine);
        JPanel pnlDateStart = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 0));
        pnlDateStart.setBackground(Cl.colorBackground);
        JLabel lblDateStart = new JLabel("Từ ngày: ");
        lblDateStart.setForeground(Cl.colorBlue);
        lblDateStart.setFont(Cl.fontContentM);
        
        txtDateStart.setPreferredSize(new Dimension(90,30));
        txtDateStart.setBorder(Cl.whiteLineS);
        cal.add(Calendar.DATE, -30);
        txtDateStart.setText(dateFormatter.format(cal.getTime()));
        
        JButton btnPickStartDate = new JButton("...");
        btnPickStartDate.setPreferredSize(new Dimension(30,30));
        btnPickStartDate.setForeground(Cl.colorBlue);
        btnPickStartDate.setBorder(Cl.blueLine);
        btnPickStartDate.setBackground(Cl.colorBackground);
        btnPickStartDate.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                txtDateStart.setText(new DatePicker(btnPickStartDate).setPickedDateYearMonthDate());
            }
        });
        
        pnlDateStart.add(lblDateStart);
        pnlDateStart.add(txtDateStart);
        pnlDateStart.add(btnPickStartDate);
            
            //Chọn ngày kết thúc
        JPanel pnlDateEnd = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 0));
        pnlDateEnd.setBackground(Cl.colorBackground);
        JLabel lblDateEnd = new JLabel("Đến: ");
        lblDateEnd.setForeground(Cl.colorBlue);
        lblDateEnd.setFont(Cl.fontContentM);
        
        txtDateEnd.setPreferredSize(new Dimension(90,30));
        txtDateEnd.setBorder(Cl.whiteLineS);
        txtDateEnd.setText(dateFormatter.format(today));
        
        JButton btnPickEndDate = new JButton("...");
        btnPickEndDate.setPreferredSize(new Dimension(30,30));
        btnPickEndDate.setForeground(Cl.colorBlue);
        btnPickEndDate.setBorder(Cl.blueLine);
        btnPickEndDate.setBackground(Cl.colorBackground);
        btnPickEndDate.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                txtDateEnd.setText(new DatePicker(btnPickEndDate).setPickedDateYearMonthDate());
            }
        });
        
        pnlDateEnd.add(lblDateEnd);
        pnlDateEnd.add(txtDateEnd);
        pnlDateEnd.add(btnPickEndDate);
            //End chọn ngày kết thúc
            //Button submit
            btnAnalysis.setPreferredSize(new Dimension(200,50));
            btnAnalysis.setBorder(Cl.blueLine);
            btnAnalysis.setFont(Cl.fontContentMB);
            btnAnalysis.setForeground(Cl.colorRed);
            btnAnalysis.setBackground(Cl.colorBackground);
            btnAnalysis.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent evt){
                    analysis();
                }
                public void mouseEntered(MouseEvent evt){
                    btnAnalysis.setBorder(Cl.redLineL);
                }
                public void mouseExited(MouseEvent evt){
                    btnAnalysis.setBorder(Cl.blueLine);
                }
            });
        pnlDateZone.add(pnlDateStart);
        pnlDateZone.add(pnlDateEnd);
        pnlDateZone.add(btnAnalysis);
        //Nội dung thống kê
        pnlAnalysisContent.setPreferredSize(new Dimension(1052,502));
        pnlAnalysisContent.setBorder(Cl.blueLineS);
                //Tên giá trị thống kê
        pnlTitleAnalysis.setPreferredSize(new Dimension(1050, 50));
        pnlTitleAnalysis.setBackground(Cl.colorBackground);
        
        JPanel pnlTitleAnalysisArray[] = new JPanel[titleAnalysis.length];
        for(int i=0; i<pnlTitleAnalysisArray.length; i++){
            pnlTitleAnalysisArray[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            pnlTitleAnalysisArray[i].setBackground(Cl.colorBackground);
            
            txtTopAnalysis[i] = new JTextField();
            txtTopAnalysis[i].setPreferredSize(new Dimension(25,24));
            txtTopAnalysis[i].setBorder(Cl.whiteLineS);
            txtTopAnalysis[i].setText(5+"");
            
            JLabel lblTitle = new JLabel(titleAnalysis[i]);
            lblTitle.setPreferredSize(new Dimension(170,50));
            lblTitle.setVerticalAlignment(JLabel.CENTER);
            lblTitle.setForeground(Cl.colorBlue);
            lblTitle.setFont(Cl.fontContentM);
            
            pnlTitleAnalysisArray[i].add(txtTopAnalysis[i]);
            pnlTitleAnalysisArray[i].add(lblTitle);
            pnlTitleAnalysis.add(pnlTitleAnalysisArray[i]);
        }
        pnlAnalysisContent.add(pnlTitleAnalysis);
                //Bảng giá trị thống kê
        pnlTblAnalysis.setPreferredSize(new Dimension(1050, 450));
        pnlTblAnalysis.setBackground(Cl.colorBackground);

        JPanel pnlTblAnalysisBackground[] = new JPanel[titleAnalysis.length];
        for(int i=0; i<pnlTblAnalysisBackground.length; i++){
            pnlTblAnalysisBackground[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            pnlTblAnalysisBackground[i].setBackground(Cl.colorBackground);
            
            tblArrayAllTable[i].setModel(modelArrayAllModel[i]);
            tblArrayAllTable[i].setPreferredSize(new Dimension(200,430));
            scrollTblAnalysis[i] = new JScrollPane(tblArrayAllTable[i]);
            scrollTblAnalysis[i].setPreferredSize(new Dimension(200,430));
            scrollTblAnalysis[i].setBackground(Cl.colorBackground);
            pnlTblAnalysisBackground[i].add(scrollTblAnalysis[i]);
            pnlTblAnalysis.add(pnlTblAnalysisBackground[i]);
        }
        showColorTable();
        pnlAnalysisContent.add(pnlTblAnalysis);
        //Pnl thống kê tổng quan
        pnlOverviewAnalysis.setPreferredSize(new Dimension(1050, 100));
        pnlOverviewAnalysis.setBackground(Cl.colorBackground);
        //pnlOverviewAnalysis.setBorder(Cl.blueLine);
        
        String nameOverview[] = {"Số khách hàng:", "Số sách bán được:", "Tổng doanh thu:"};
        JPanel pnlOverviewContent[] = new JPanel[nameOverview.length];
        for(int i=0; i<pnlOverviewContent.length; i++){
            pnlOverviewContent[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
            pnlOverviewContent[i].setBackground(Cl.colorBackground);
            pnlOverviewContent[i].setBorder(Cl.blueLine);
            pnlOverviewContent[i].setPreferredSize(new Dimension(270, 50));
            
            JLabel lblName = new JLabel(nameOverview[i]);
            lblName.setForeground(Cl.colorBlue);
            lblName.setFont(Cl.fontContentMB);
            
            txtOverviewValue[i].setPreferredSize(new Dimension(100, 30));
            txtOverviewValue[i].setBorder(Cl.whiteLineS);
            txtOverviewValue[i].setFont(Cl.fontContentLB);
            pnlOverviewContent[i].add(lblName);
            pnlOverviewContent[i].add(txtOverviewValue[i]);
            pnlOverviewAnalysis.add(pnlOverviewContent[i]);
        }
        JButton btnExportExcel = new JButton("Xuất excel");
        btnExportExcel.setPreferredSize(new Dimension(150,50));
        btnExportExcel.setBackground(Cl.colorBackground);
        btnExportExcel.setBorder(Cl.greenLineL);
        btnExportExcel.setForeground(Cl.colorGreen);
        btnExportExcel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                ExcelPOI.writeFileExcelAnalysis(titleAnalysis ,tblArrayAllTable, nameOverview, txtOverviewValue);
            }
        });
        pnlOverviewAnalysis.add(btnExportExcel);
        pnlMainPanel.add(pnlDateZone);
        pnlMainPanel.add(pnlAnalysisContent);
        pnlMainPanel.add(pnlOverviewAnalysis);
        analysis();
        return pnlMainPanel;
    }
    public void analysis(){
        String startDate = txtDateStart.getText();
        String endDate = txtDateEnd.getText();
        String topBook = txtTopAnalysis[0].getText();
        String topCate = txtTopAnalysis[1].getText();
        String topAuthor = txtTopAnalysis[2].getText();
        String topCustomer = txtTopAnalysis[3].getText();
        String topStaff = txtTopAnalysis[4].getText();
        loadTableBook( Integer.parseInt(topBook),  startDate,  endDate);
        loadTableCate(Integer.parseInt(topCate), startDate, endDate);
        loadTableAuthor(Integer.parseInt(topAuthor), startDate, endDate);
        loadTableCustomer(Integer.parseInt(topCustomer), startDate, endDate);
        loadTableStaff(Integer.parseInt(topStaff), startDate, endDate);
        
        try {
            txtRevenue.setText(busOrder.getRevenue(startDate, endDate) + "");
            txtSales.setText(busOrder.getSales(startDate, endDate)+"");
            txtTotalCustomer.setText(busOrder.getTotalCustomer(startDate, endDate)+"");
        } catch (Exception ex) {
            Logger.getLogger(GUIAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadTableBook(int top, String startDate, String endDate){
        try {
            ResultSet result = busBook.getTopBookSelled(top, startDate, endDate);
            modelTblBookAnalysis.setColumnIdentifiers(new Object[]{ "Sách", "Doanh số"});
            tblBookAnalysis.getColumnModel().getColumn(0).setPreferredWidth(150);
            modelTblBookAnalysis.setRowCount(0);
            while(result.next()){
                modelTblBookAnalysis.addRow(new Object[]{
                    result.getString("title"),
                    result.getString("quantity")
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadTableCate(int top, String startDate, String endDate){
        try {
            ResultSet result = busGenre.getTopGenreSelled(top, startDate, endDate);
            modelTblCateAnalysis.setColumnIdentifiers(new Object[]{ "Thể loại", "Doanh số"});
            tblCateAnalysis.getColumnModel().getColumn(0).setPreferredWidth(150);
            modelTblCateAnalysis.setRowCount(0);
            while(result.next()){
                modelTblCateAnalysis.addRow(new Object[]{
                    result.getString("genre_name"),
                    result.getString("quantity")
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void loadTableAuthor(int top, String startDate, String endDate){
        try {
            ResultSet result = busAuthor.getTopAuthorSelled(top, startDate, endDate);
            modelTblAuthorAnalysis.setColumnIdentifiers(new Object[]{ "Tên", "Doanh số"});
            tblAuthorAnalysis.getColumnModel().getColumn(0).setPreferredWidth(150);
            modelTblAuthorAnalysis.setRowCount(0);
            while(result.next()){
                modelTblAuthorAnalysis.addRow(new Object[]{
                    result.getString("first_name")+" "+result.getString("last_name"),
                    result.getString("quantity")
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void loadTableCustomer(int top, String startDate, String endDate){
        try {
            ResultSet result = busCustomer.getTopCustomerSelled(top, startDate, endDate);
            modelTblCustomerAnalysis.setColumnIdentifiers(new Object[]{ "Tên", "Doanh số"});
            tblCustomerAnalysis.getColumnModel().getColumn(0).setPreferredWidth(150);
            modelTblCustomerAnalysis.setRowCount(0);
            while(result.next()){
                modelTblCustomerAnalysis.addRow(new Object[]{
                    result.getString("first_name")+" "+result.getString("last_name"),
                    result.getString("quantity")
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void loadTableStaff(int top, String startDate, String endDate){
        try {
            ResultSet result = busStaff.getTopStaffSelled(top, startDate, endDate);
            modelTblStaffAnalysis.setColumnIdentifiers(new Object[]{ "Tên", "Doanh số"});
            tblStaffAnalysis.getColumnModel().getColumn(0).setPreferredWidth(150);
            modelTblStaffAnalysis.setRowCount(0);
            while(result.next()){
                modelTblStaffAnalysis.addRow(new Object[]{
                    result.getString("name"),
                    result.getString("quantity")
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public JTable[] showColorTable() {
        
        for (int i = 0; i < tblArrayAllTable.length; i++) {
            tblArrayAllTable[i].setRowHeight(30);
            tblArrayAllTable[i].setBackground(Cl.colorBackground);
            tblArrayAllTable[i].setForeground(Color.white);
            tblArrayAllTable[i].setGridColor(Color.DARK_GRAY);
            tblArrayAllTable[i].setSelectionForeground(Cl.colorBlue);
            tblArrayAllTable[i].setSelectionBackground(Cl.colorBackground);
            tblArrayAllTable[i].getTableHeader().setBackground(Cl.colorBackground);
            tblArrayAllTable[i].getTableHeader().setForeground(Cl.colorBlue);
            tblArrayAllTable[i].getTableHeader().setFont(Cl.fontContentMB);
        }
        return tblArrayAllTable;
    }
    
    JPanel pnlMainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
    //Khoảng thời gian
    JPanel pnlDateZone = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
    JTextField txtDateStart = new JTextField();
    JTextField txtDateEnd = new JTextField();
    JButton btnAnalysis = new JButton("THỐNG KÊ");
    
    JPanel pnlAnalysisContent = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    //Tên các giá trị thống kê
    JPanel pnlTitleAnalysis = new JPanel(new GridLayout(1, 6));
    String titleAnalysis[] = {"Sách bán chạy", "Thể loại bán chạy", "Tác giả", "Khách hàng thân quen", "Nhân viên tích cực"};
    JTextField txtTopAnalysis[] = new JTextField[titleAnalysis.length];
    //Bảng giá trị thống kê
    JPanel pnlTblAnalysis = new JPanel(new GridLayout(1, 6));
    JScrollPane scrollTblAnalysis[] = new JScrollPane[titleAnalysis.length];
    
    DefaultTableModel modelTblBookAnalysis = new DefaultTableModel();
    JTable tblBookAnalysis = new JTable();
    DefaultTableModel modelTblCateAnalysis = new DefaultTableModel();
    JTable tblCateAnalysis = new JTable();
    DefaultTableModel modelTblAuthorAnalysis = new DefaultTableModel();
    JTable tblAuthorAnalysis = new JTable();
    DefaultTableModel modelTblCustomerAnalysis = new DefaultTableModel();
    JTable tblCustomerAnalysis = new JTable();
    DefaultTableModel modelTblStaffAnalysis = new DefaultTableModel();
    JTable tblStaffAnalysis = new JTable();
    
    JTable tblArrayAllTable[] = {tblBookAnalysis, tblCateAnalysis, tblAuthorAnalysis, tblCustomerAnalysis, tblStaffAnalysis};
    DefaultTableModel modelArrayAllModel[] = {modelTblBookAnalysis, modelTblCateAnalysis, modelTblAuthorAnalysis, modelTblCustomerAnalysis, modelTblStaffAnalysis};
    // Các giá trị tổng quan
    JPanel pnlOverviewAnalysis = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
    JTextField txtRevenue = new JTextField("0");
    JTextField txtSales = new JTextField("0");
    JTextField txtTotalCustomer = new JTextField("0");
    JTextField txtOverviewValue[] = {txtTotalCustomer, txtSales,txtRevenue };
}
