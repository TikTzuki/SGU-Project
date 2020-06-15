/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BUS.*;
import DTO.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.write.WriteException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 *
 * @author Tik
 */
public class GUIStaffManager {
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
        pnlMainPanel = new JPanel(null);
        pnlMainPanel.setBackground(Cl.colorBackground);
        pnlMainPanel.setPreferredSize(new Dimension(1110, 700));
        
        //Panel user đang chọn
        pnlSelectedStaff.setBounds(40, 5, 400, 270);
        pnlSelectedStaff.setBorder(Cl.blueLine);
        for(int i=0; i<lblSelectedStaff.length; i++){
            lblSelectedStaff[i] = new JLabel(nameSelectedStaff[i]);
            lblSelectedStaff[i].setPreferredSize(new Dimension(100, 24));
            pnlSelectedStaff.add(lblSelectedStaff[i]);
        }
        
        cbbRole.setModel(modelCbbRole);
        cbbRole.setPreferredSize(new Dimension(100,24));
        for(String role : busRole.getRoleName()){
            modelCbbRole.addElement(role);
        }
        pnlSelectedStaff.add(cbbRole);
        
        //Panel thêm user
        pnlAddStaff.setBounds(500, 5, 400, 270);
        pnlAddStaff.setBorder(Cl.blueLine);
        //Table tất cả user
        tblStaff.setPreferredSize(new Dimension(1000, 500));
        tblStaff.setModel(modelTblStaff);
        modelTblStaff.setColumnIdentifiers(new String[]{"Id","Tên", "Email", "Số điện thoại", "Mật khẩu", "Giới tính", "Quyền"});
        showTabelStaff();
        tblStaff.addMouseListener(new MouseAdapter() {
             public void mousePressed(MouseEvent e) {
                 showSelectedStaff();
             }
            
        });
        
        
        scrollTblStaff.setBounds(40, 300, 1000, 300);
        scrollTblStaff.setViewportView(tblStaff);
        scrollTblStaff.setViewportBorder(Cl.blueLine);
        scrollTblStaff.setVerticalScrollBar(Cl.verticalScrollBar());
        
        pnlMainPanel.add(pnlSelectedStaff);
        pnlMainPanel.add(pnlAddStaff);
        pnlMainPanel.add(scrollTblStaff);
        return pnlMainPanel;
    }
    public void showTabelStaff(){
        try {
            listStaffGlobal = busStaff.getStaff("role_id >="+staff.getRole_id());
            modelTblStaff.setRowCount(0);
            for(Staff staff: listStaffGlobal){
                modelTblStaff.addRow(new Object[]{
                    staff.getStaff_id(),
                    staff.getFirst_name()+" "+staff.getLast_name(),
                    staff.getEmail(),
                    staff.getPhone_number(),
                    staff.getPassword(),
                    staff.getSex(),
                    busRole.getRoleNameById(staff.getRole_id())
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIStaffManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showSelectedStaff(){
        try {
            int selectedRow = tblStaff.getSelectedRow();
            int staff_id = Integer.parseInt(modelTblStaff.getValueAt(selectedRow, 0).toString());
            staffSelected = busStaff.getStaffById(staff_id);
            
            txtSelectedStaffValue[0].setText(staffSelected.getStaff_id()+"");
            txtSelectedStaffValue[1].setText(staffSelected.getFirst_name()+" "+staffSelected.getLast_name());
            txtSelectedStaffValue[2].setText(staffSelected.getEmail());
            txtSelectedStaffValue[3].setText(staffSelected.getPhone_number());
            txtSelectedStaffValue[4].setText(staffSelected.getPassword());
            txtSelectedStaffValue[5].setText(staffSelected.getSex());
            
        } catch (Exception ex) {
            Logger.getLogger(GUIStaffManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public JPanel pnlMainPanel = new JPanel();
    //Panel user đang chọn
    public JPanel pnlSelectedStaff = new JPanel();
    public String nameSelectedStaff[] = {"Id", "Tên", "Email", "Số điện thoại", "Mật khẩu", "Giới tính", "Quyền"};
    public JLabel lblStaffId = new JLabel();
    public JLabel lblStaffName = new JLabel();
    public JLabel lblStaffEmail = new JLabel();
    public JLabel lblStaffPhone = new JLabel();
    public JLabel lblStaffPassword = new JLabel();
    public JLabel lblStaffSex = new JLabel();
    public JLabel lblStaffRole = new JLabel();
    public JLabel lblSelectedStaff[] = {lblStaffId, lblStaffName, lblStaffEmail, lblStaffPhone, lblStaffPassword, lblStaffSex, lblStaffRole};
      
   public JTextField txtSelectedStaffValue[] = new JTextField[nameSelectedStaff.length-1];
   public JComboBox<String> cbbRole = new JComboBox<>();
   public DefaultComboBoxModel modelCbbRole = new DefaultComboBoxModel();
    //Panel thêm user
    public JPanel pnlAddStaff = new JPanel();
    //Table tất cả user
    public DefaultTableModel modelTblStaff = new DefaultTableModel();
    public JTable tblStaff = new JTable();
    public JScrollPane scrollTblStaff = new JScrollPane();
}
