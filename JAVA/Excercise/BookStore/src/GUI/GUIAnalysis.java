/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BUSGetStaff;
import BUS.BUSRole;
import DTO.Staff;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
    
    ArrayList<Staff> listStaffGlobal = new ArrayList<>();
    Staff staffSelected = new Staff();
    
    public JPanel initComponents(Staff staff){
        // Nhan vien
         this.staff = staff;
        //Panel chinh
        pnlMainPanel.setBackground(Cl.colorBackground);
        pnlMainPanel.setPreferredSize(new Dimension(1100, 700));
        //Khoảng thời gian
        pnlDateZone.setPreferredSize(new Dimension(1050, 50));
        pnlDateZone.setBackground(Cl.colorBackground);
        pnlDateZone.setBorder(Cl.blueLine);
        JPanel pnlDateStart = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 0));
        JLabel lblDateStart = new JLabel("Từ ngày: ");
        lblDateStart.setFont(Cl.fontContentM);
        
        txtDateStart.setPreferredSize(new Dimension(90,30));
        txtDateStart.setBorder(Cl.whiteLineS);
        
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
        JLabel lblDateEnd = new JLabel("Từ ngày: ");
        lblDateEnd.setFont(Cl.fontContentM);
        
        txtDateEnd.setPreferredSize(new Dimension(90,30));
        txtDateEnd.setBorder(Cl.whiteLineS);
        
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
            btnAnalysis.setPreferredSize(new Dimension(100,50));
            btnAnalysis.setBorder(Cl.blueLine);
            btnAnalysis.setForeground(Cl.colorBlue);
            btnAnalysis.setBackground(Cl.colorBackground);
            btnAnalysis.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent evt){
                    analysis();
                }
            });
        pnlDateZone.add(pnlDateStart);
        pnlDateZone.add(pnlDateEnd);
        pnlDateZone.add(btnAnalysis);
        //Tên các giá trị thống kê
        pnlTitleAnalysis.setPreferredSize(new Dimension(1050, 50));
        pnlTitleAnalysis.setBackground(Cl.colorBackground);
        pnlTitleAnalysis.setBorder(Cl.blueLine);
        
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
        //Bảng giá trị thống kê
        pnlTblAnalysis.setPreferredSize(new Dimension(1050, 450));
        pnlTblAnalysis.setBackground(Cl.colorBackground);
        pnlTblAnalysis.setBorder(Cl.blueLine);
        JPanel pnlTblAnalysisBackground[] = new JPanel[titleAnalysis.length];
        for(int i=0; i<pnlTblAnalysisBackground.length; i++){
            pnlTblAnalysisBackground[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            pnlTblAnalysisBackground[i].setBackground(Cl.colorBackground);
            
            tblArrayAllTable[i].setModel(modelArrayAllModel[i]);
            tblArrayAllTable[i].setPreferredSize(new Dimension(200,450));
            scrollTblAnalysis[i] = new JScrollPane(tblArrayAllTable[i]);
            scrollTblAnalysis[i].setPreferredSize(new Dimension(200,450));
            scrollTblAnalysis[i].setBackground(Cl.colorBackground);
            pnlTblAnalysisBackground[i].add(scrollTblAnalysis[i]);
            pnlTblAnalysis.add(pnlTblAnalysisBackground[i]);
        }
        showColorTable();
        //Pnl thống kê tổng quan
        pnlOverviewAnalysis.setPreferredSize(new Dimension(1050, 100));
        pnlOverviewAnalysis.setBackground(Cl.colorBackground);
        pnlOverviewAnalysis.setBorder(Cl.blueLine);
        
        pnlMainPanel.add(pnlDateZone);
        pnlMainPanel.add(pnlTitleAnalysis);
        pnlMainPanel.add(pnlTblAnalysis);
        pnlMainPanel.add(pnlOverviewAnalysis);
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
        
        
    }
    public void loadTableBook(int top, String startDate, String endDate){
        
    }
    public JTable[] showColorTable() {
        for (int i = 0; i < tblArrayAllTable.length; i++) {
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
    JButton btnAnalysis = new JButton("Thống kê");
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
}
