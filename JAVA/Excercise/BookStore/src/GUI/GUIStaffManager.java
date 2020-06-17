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
        pnlSelectedStaff.setBounds(40, 5, 460, 280);
        pnlSelectedStaff.setBorder(Cl.blueLine);
        pnlSelectedStaff.setBackground(Cl.colorBackground);
        JLabel lblNamePnlSelectedStaff = new JLabel("Nhân viên");
        lblNamePnlSelectedStaff.setPreferredSize(new Dimension(390, 24));
        lblNamePnlSelectedStaff.setForeground(Cl.colorBlue);
        lblNamePnlSelectedStaff.setFont(Cl.fontContentMB);
        lblNamePnlSelectedStaff.setHorizontalAlignment(JLabel.CENTER);
        pnlSelectedStaff.add(lblNamePnlSelectedStaff);
            //Label người dùng đang được chọn
            JPanel pnlLblSelectedStaff = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
            pnlLblSelectedStaff.setPreferredSize(new Dimension(90,240));
            pnlLblSelectedStaff.setBackground(Cl.colorBackground);
        for(int i=0; i<lblSelectedStaff.length; i++){
            lblSelectedStaff[i] = new JLabel(nameSelectedStaff[i]);
            lblSelectedStaff[i].setPreferredSize(new Dimension(100, 26));
            lblSelectedStaff[i].setForeground(Color.white);
            lblSelectedStaff[i].setFont(Cl.fontContentM);
            pnlLblSelectedStaff.add(lblSelectedStaff[i]);
        }
            pnlSelectedStaff.add(pnlLblSelectedStaff);
           //Texfield người dùng đang được chọn
           JPanel pnlTxtSelectedStaffValue = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
           pnlTxtSelectedStaffValue.setPreferredSize(new Dimension(220, 240));
           pnlTxtSelectedStaffValue.setBackground(Cl.colorBackground);
        for(int i=0; i<txtSelectedStaffValue.length; i++){
            txtSelectedStaffValue[i] = new JTextField();
            txtSelectedStaffValue[i].setPreferredSize(new Dimension(200,26));
            txtSelectedStaffValue[i].setFont(Cl.fontContentMB);
            txtSelectedStaffValue[i].setBorder(Cl.whiteLine);
            if(i==0){
                txtSelectedStaffValue[i].setEditable(false);
            }
            pnlTxtSelectedStaffValue.add(txtSelectedStaffValue[i]);
        }
        //CBB giới tính
        cbbSex.setModel(modelCbbSex);
        cbbSex.setPreferredSize(new Dimension(100,24));
        cbbSex.setBackground(Cl.colorBackground);
        cbbSex.setForeground(Color.white);
        modelCbbSex.addElement("Nam");
        modelCbbSex.addElement("Nữ");
        modelCbbSex.addElement("Khác");
        // Khối gạch
        JPanel block = new JPanel();
        block.setPreferredSize(new Dimension(100,24));
        block.setBackground(new Color(0,0,0,0));
        //CBB quyền hạn
        cbbRole.setModel(modelCbbRole);
        cbbRole.setPreferredSize(new Dimension(100,24));
        cbbRole.setBackground(Cl.colorBackground);
        cbbRole.setForeground(Color.white);
        for(String role : busRole.getRoleName()){
            modelCbbRole.addElement(role);
        }
        //CBB trạng thái
        cbbState.setModel(modelCbbState);
        cbbState.setPreferredSize(new Dimension(100,24));
        cbbState.setBackground(Cl.colorBackground);
        cbbState.setForeground(Color.white);
        modelCbbState.addElement("1. Hiện");
        modelCbbState.addElement("0. Ẩn");
        
        pnlTxtSelectedStaffValue.add(cbbSex);
        pnlTxtSelectedStaffValue.add(block);
        pnlTxtSelectedStaffValue.add(cbbRole);
        pnlTxtSelectedStaffValue.add(cbbState);
       pnlSelectedStaff.add(pnlTxtSelectedStaffValue);
            //Panel điều khiển
        JPanel pnlControlSelectedStaff = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        pnlControlSelectedStaff.setPreferredSize(new Dimension(90,240));
        pnlControlSelectedStaff.setBackground(Cl.colorBackground);
        btnSaveChangeStaff.setPreferredSize(new Dimension(90,30));
        btnSaveChangeStaff.setBackground(Cl.colorBackground);
        btnSaveChangeStaff.setBorder(Cl.blueLine);
        btnSaveChangeStaff.setFont(Cl.fontContentMB);
        btnSaveChangeStaff.setForeground(Cl.colorBlue);
        btnSaveChangeStaff.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                saveSelectedStaff();
                repaintAllTable();
            }
            public void mouseEntered(MouseEvent evt){
                btnSaveChangeStaff.setBorder(Cl.greenLineL);
                btnSaveChangeStaff.setForeground(Cl.colorGreen);
            }
            public void mouseExited(MouseEvent evt){
                btnSaveChangeStaff.setBorder(Cl.blueLine);
                btnSaveChangeStaff.setForeground(Cl.colorBlue);
            }
        });
        btnDeleteStaff.setPreferredSize(new Dimension(90,30));
        btnDeleteStaff.setBackground(Cl.colorBackground);
        btnDeleteStaff.setBorder(Cl.blueLine);
        btnDeleteStaff.setFont(Cl.fontContentMB);
        btnDeleteStaff.setForeground(Cl.colorBlue);
        btnDeleteStaff.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                deleteSelectedStaff();
                repaintAllTable();
            }

            public void mouseEntered(MouseEvent evt) {
                btnDeleteStaff.setBorder(Cl.redLineL);
                btnDeleteStaff.setForeground(Cl.colorRed);
            }

            public void mouseExited(MouseEvent evt) {
                btnDeleteStaff.setBorder(Cl.blueLine);
                btnDeleteStaff.setForeground(Cl.colorBlue);
            }
        });
        
        pnlControlSelectedStaff.add(btnSaveChangeStaff);
        pnlControlSelectedStaff.add(btnDeleteStaff);
        pnlSelectedStaff.add(pnlControlSelectedStaff);
        //Panel thêm user
        pnlAddStaff.setBounds(600, 5, 450, 280);
        pnlAddStaff.setBorder(Cl.blueLine);
        pnlAddStaff.setBackground(Cl.colorBackground);
        JLabel lblNamePnlAddStaff = new JLabel("Thêm nhân viên");
        lblNamePnlAddStaff.setPreferredSize(new Dimension(390, 24));
        lblNamePnlAddStaff.setForeground(Cl.colorBlue);
        lblNamePnlAddStaff.setFont(Cl.fontContentMB);
        lblNamePnlAddStaff.setHorizontalAlignment(JLabel.CENTER);
        pnlAddStaff.add(lblNamePnlAddStaff);
            //Label người dùng đang được chọn
            JPanel pnlLblAddStaff = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
            pnlLblAddStaff.setPreferredSize(new Dimension(90,240));
            pnlLblAddStaff.setBackground(Cl.colorBackground);
        for(int i=0; i<lblAddStaff.length; i++){
            lblAddStaff[i] = new JLabel(nameAddStaff[i]);
            lblAddStaff[i].setPreferredSize(new Dimension(100, 26));
            lblAddStaff[i].setForeground(Color.white);
            lblAddStaff[i].setFont(Cl.fontContentM);
            pnlLblAddStaff.add(lblAddStaff[i]);
        }
            pnlAddStaff.add(pnlLblAddStaff);
           //Texfield người dùng đang được chọn
           JPanel pnlTxtAddStaffValue = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
           pnlTxtAddStaffValue.setPreferredSize(new Dimension(220, 240));
           pnlTxtAddStaffValue.setBackground(Cl.colorBackground);
        for(int i=0; i<txtAddStaffValue.length; i++){
            txtAddStaffValue[i] = new JTextField();
            txtAddStaffValue[i].setPreferredSize(new Dimension(200,26));
            txtAddStaffValue[i].setFont(Cl.fontContentMB);
            txtAddStaffValue[i].setBorder(Cl.whiteLine);
            pnlTxtAddStaffValue.add(txtAddStaffValue[i]);
        }
        //CBB giới tính
        cbbSexAdd.setModel(modelCbbSexAdd);
        cbbSexAdd.setPreferredSize(new Dimension(100,24));
        cbbSexAdd.setBackground(Cl.colorBackground);
        cbbSexAdd.setForeground(Color.white);
        modelCbbSexAdd.addElement("Nam");
        modelCbbSexAdd.addElement("Nữ");
        modelCbbSexAdd.addElement("Khác");
        // Khối gạch
        JPanel block2 = new JPanel();
        block2.setPreferredSize(new Dimension(100,24));
        block2.setBackground(new Color(0,0,0,0));
        //CBB quyền hạn
        cbbRoleAdd.setModel(modelCbbRoleAdd);
        cbbRoleAdd.setPreferredSize(new Dimension(100,24));
        cbbRoleAdd.setBackground(Cl.colorBackground);
        cbbRoleAdd.setForeground(Color.white);
        for(String role : busRole.getRoleName()){
            modelCbbRoleAdd.addElement(role);
        }
        //CBB trạng thái
        cbbStateAdd.setModel(modelCbbStateAdd);
        cbbStateAdd.setPreferredSize(new Dimension(100,24));
        cbbStateAdd.setBackground(Cl.colorBackground);
        cbbStateAdd.setForeground(Color.white);
        modelCbbStateAdd.addElement("1. Hiện");
        modelCbbStateAdd.addElement("0. Ẩn");
        
        pnlTxtAddStaffValue.add(cbbSexAdd);
        pnlTxtAddStaffValue.add(block2);
        pnlTxtAddStaffValue.add(cbbRoleAdd);
        pnlTxtAddStaffValue.add(cbbStateAdd);
        pnlAddStaff.add(pnlTxtAddStaffValue);
        //Panel thao tác user
        JPanel pnlControlAddStaff = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 50));
        pnlControlAddStaff.setPreferredSize(new Dimension(90,240));
        pnlControlAddStaff.setBackground(Cl.colorBackground);
        btnAddStaff.setPreferredSize(new Dimension(90,30));
        btnAddStaff.setBackground(Cl.colorBackground);
        btnAddStaff.setBorder(Cl.blueLine);
        btnAddStaff.setForeground(Cl.colorBlue);
        btnAddStaff.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                addStaff();
                repaintAllTable();
            }
            public void mouseEntered(MouseEvent evt){
                btnAddStaff.setBorder(Cl.greenLineL);
                btnAddStaff.setForeground(Cl.colorGreen);
            }
            public void mouseExited(MouseEvent evt){
                btnAddStaff.setBorder(Cl.blueLine);
                btnAddStaff.setForeground(Cl.colorBlue);
            }
        });
        
        pnlControlAddStaff.add(btnAddStaff);
        pnlAddStaff.add(pnlControlAddStaff);
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
        scrollTblStaff.setVerticalScrollBar(Cl.verticalScrollBar());
        
        showColorTable();
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
                    staff.getName(),
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
            txtSelectedStaffValue[1].setText(staffSelected.getName());
            txtSelectedStaffValue[2].setText(staffSelected.getEmail());
            txtSelectedStaffValue[3].setText(staffSelected.getPhone_number());
            txtSelectedStaffValue[4].setText(staffSelected.getPassword());
            modelCbbSex.setSelectedItem(staffSelected.getSex());
            modelCbbRole.setSelectedItem(staffSelected.getRole_id()+". "+busRole.getRoleNameById(staffSelected.getRole_id()));
            if(staffSelected.getState() == 1){
                modelCbbState.setSelectedItem("1. Hiện");
            } else {
                modelCbbState.setSelectedItem("0. Ẩn");
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIStaffManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void saveSelectedStaff(){
        if(txtSelectedStaffValue[0].getText().equals(""))
            return;
        for(int i=0; i<txtSelectedStaffValue.length; i++){
            if(txtSelectedStaffValue[i].getText().equals("") || txtSelectedStaffValue[i].getText().equals(null)){
                JOptionPane.showMessageDialog(null, "Không được để trống");
            }
        }
        Staff newStaff = new Staff();
        newStaff.setStaff_id(Integer.parseInt(txtSelectedStaffValue[0].getText()));
        newStaff.setName(txtSelectedStaffValue[1].getText());
        newStaff.setEmail(txtSelectedStaffValue[2].getText());
        newStaff.setPhone_number(txtSelectedStaffValue[3].getText());
        newStaff.setPassword(txtSelectedStaffValue[4].getText());
        newStaff.setSex(cbbSex.getSelectedItem().toString());
        newStaff.setRole_id(Integer.parseInt(cbbRole.getSelectedItem().toString().substring(0, 1)));
        newStaff.setState(Integer.parseInt(cbbState.getSelectedItem().toString().substring(0, 1)));
        try {
            int isConfirm = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn lưu", "Lưu", JOptionPane.YES_NO_OPTION);
            if(isConfirm==JOptionPane.YES_OPTION){
                busStaff.updates(newStaff);
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIStaffManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteSelectedStaff(){
        if(txtSelectedStaffValue[0].getText().equals(""))
            return;
        Staff newStaff = new Staff();
        newStaff.setStaff_id(Integer.parseInt(txtSelectedStaffValue[0].getText()));
        newStaff.setName(txtSelectedStaffValue[1].getText());
        newStaff.setEmail(txtSelectedStaffValue[2].getText());
        newStaff.setPhone_number(txtSelectedStaffValue[3].getText());
        newStaff.setPassword(txtSelectedStaffValue[4].getText());
        newStaff.setSex(cbbSex.getSelectedItem().toString());
        newStaff.setRole_id(Integer.parseInt(cbbRole.getSelectedItem().toString().substring(0, 1)));
        newStaff.setState(-1);
                try {
            int isConfirm = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa", "xóa", JOptionPane.YES_NO_OPTION);
            if(isConfirm==JOptionPane.YES_OPTION){
                busStaff.updates(newStaff);
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIStaffManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addStaff(){
        try {
            for(int i=0; i<txtAddStaffValue.length; i++){
                if(txtAddStaffValue[i].getText().equals("") || txtAddStaffValue[i].getText().equals(null)){
                    JOptionPane.showMessageDialog(null, "Không được để trống");
                    return;
                }
            }
            if(busStaff.isUsePhoneNumber(txtAddStaffValue[2].getText())){
                JOptionPane.showMessageDialog(null, "Số điện thoại đã được dùng");
                return;
            }
            Staff newStaff = new Staff();
            newStaff.setStaff_id(0);
            newStaff.setName(txtAddStaffValue[0].getText());
            newStaff.setEmail(txtAddStaffValue[1].getText());
            newStaff.setPhone_number(txtAddStaffValue[2].getText());
            newStaff.setPassword(txtAddStaffValue[3].getText());
            newStaff.setSex(cbbSexAdd.getSelectedItem().toString());
            newStaff.setRole_id(Integer.parseInt(cbbRoleAdd.getSelectedItem().toString().substring(0, cbbRoleAdd.getSelectedItem().toString().indexOf("."))));
            newStaff.setState(Integer.parseInt(cbbStateAdd.getSelectedItem().toString().substring(0, cbbStateAdd.getSelectedItem().toString().indexOf("."))));
            busStaff.inserts(newStaff);
        } catch (Exception ex) {
            Logger.getLogger(GUIStaffManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void repaintAllTable(){
        showTabelStaff();
    }
    public JTable[] showColorTable() {
        for (int i = 0; i < TableArray.length; i++) {
            TableArray[i].setBackground(Cl.colorBackground);
            TableArray[i].setForeground(Color.white);
            TableArray[i].setGridColor(Color.DARK_GRAY);
            TableArray[i].setSelectionForeground(Cl.colorBlue);
            TableArray[i].setSelectionBackground(Cl.colorBackground);
            TableArray[i].getTableHeader().setBackground(Cl.colorBackground);
            TableArray[i].getTableHeader().setForeground(Cl.colorBlue);
            TableArray[i].getTableHeader().setFont(Cl.fontContentMB);
        }
        return TableArray;
    }
    public JPanel pnlMainPanel = new JPanel();
    //Panel user đang chọn
    public JPanel pnlSelectedStaff = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
    public String nameSelectedStaff[] = {"Id","Tên", "Email", "Số điện thoại", "Mật khẩu", "Giới tính", "Quyền"};
    public JLabel lblSelectedStaff[] = new JLabel[nameSelectedStaff.length];
   public JTextField txtSelectedStaffValue[] = new JTextField[nameSelectedStaff.length-2];
   public JComboBox<String> cbbSex = new JComboBox<>();
   public DefaultComboBoxModel modelCbbSex = new DefaultComboBoxModel();
   public JComboBox<String> cbbRole = new JComboBox<>();
   public DefaultComboBoxModel modelCbbRole = new DefaultComboBoxModel();
   public JComboBox<String> cbbState = new JComboBox<>();
   public DefaultComboBoxModel modelCbbState = new DefaultComboBoxModel();
   public JButton btnSaveChangeStaff = new JButton("Lưu");
   public JButton btnDeleteStaff = new JButton("Xóa");
    //Panel thêm user
    public JPanel pnlAddStaff = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
    public String nameAddStaff[] = {"Tên", "Email", "Số điện thoại", "Mật khẩu", "Giới tính", "Quyền"};
    public JLabel lblAddStaff[] = new JLabel[nameAddStaff.length];
    public JTextField txtAddStaffValue[] = new JTextField[nameAddStaff.length - 2];
    public JComboBox<String> cbbSexAdd = new JComboBox<>();
    public DefaultComboBoxModel modelCbbSexAdd = new DefaultComboBoxModel();
    public JComboBox<String> cbbRoleAdd = new JComboBox<>();
    public DefaultComboBoxModel modelCbbRoleAdd = new DefaultComboBoxModel();
    public JComboBox<String> cbbStateAdd = new JComboBox<>();
    public DefaultComboBoxModel modelCbbStateAdd = new DefaultComboBoxModel();
    public JButton btnAddStaff = new JButton("Thêm");
    //Table tất cả user
    public DefaultTableModel modelTblStaff = new DefaultTableModel();
    public JTable tblStaff = new JTable();
    public JScrollPane scrollTblStaff = new JScrollPane();
    JTable TableArray[] = {tblStaff};
}
