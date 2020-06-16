/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BUSGetStaff;
import BUS.BUSRole;
import DTO.Staff;
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
        
        pnlDateZone.add(pnlDateStart);
        //Tên các giá trị thống kê
        pnlTitleAnalysis.setPreferredSize(new Dimension(1050, 50));
        pnlTitleAnalysis.setBackground(Cl.colorBackground);
        pnlTitleAnalysis.setBorder(Cl.blueLine);
        //Bảng giá trị thống kê
        pnlTblAnalysis.setPreferredSize(new Dimension(1050, 450));
        pnlTblAnalysis.setBackground(Cl.colorBackground);
        pnlTblAnalysis.setBorder(Cl.blueLine);
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
    JPanel pnlMainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
    //Khoảng thời gian
    JPanel pnlDateZone = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
    JTextField txtDateStart = new JTextField();
    JTextField txtDateEnd = new JTextField();
    JButton btnAnalysis = new JButton("Thống kê");
    //Tên các giá trị thống kê
    JPanel pnlTitleAnalysis = new JPanel(new GridLayout(6, 1));
    String titleAnalysis[] = {"Sách bán chạy", "Thể loại bán chạy", "Tác giả", "Khách hàng thân quen", "Nhân viên tích cực"};
    JTextField txtTopAnalysis[] = new JTextField[titleAnalysis.length];
    //Bảng giá trị thống kê
    JPanel pnlTblAnalysis = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
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
    // Các giá trị tổng quan
    JPanel pnlOverviewAnalysis = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
}
