/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerisetable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import sun.text.normalizer.CharTrie;

/**
 *
 * @author Tik
 */
public class frame extends JFrame {

    public frame() {
        initComp();
    }

    public void initComp() {

        // Logo
        JPanel logo = new JPanel(null);
        logo.setBounds(0, 0, 150, 150);
        logo.setBackground(Color.red);
        ImageIcon catIcon = new ImageIcon("src/images/cat.jpg");
        JLabel lblImg = new JLabel(catIcon);
        lblImg.setBounds(0, 0, 150, 150);
        logo.add(lblImg);

        add(logo);

        // ListLabel
        JPanel pnlListLabel = new JPanel(new GridLayout(5, 1));
        pnlListLabel.setBounds(150, 0, 150, 150);
        pnlListLabel.setBackground(Color.GREEN);
        String[] labelSinhVien = {"Mã sinh viên", "Họ tên", "Năm sinh", "Địa chỉ", "Số điện thoại"};
        JLabel[] lbl = new JLabel[labelSinhVien.length];
        for (int i = 0; i < labelSinhVien.length; i++) {
            lbl[i] = new JLabel(labelSinhVien[i]);
            pnlListLabel.add(lbl[i]);
            lbl[i].setHorizontalTextPosition(JLabel.CENTER);
        }

        add(pnlListLabel);
        // List Text Field
        JPanel pnlListTextField = new JPanel(new GridLayout(5, 1));
        pnlListTextField.setBounds(300, 0, 150, 150);
        JTextField txtMSV = new JTextField();
        JTextField txtTen = new JTextField();
        JTextField txtNamSinh = new JTextField();
        JTextField txtDiaChi = new JTextField();
        JTextField txtSDT = new JTextField();

        pnlListTextField.add(txtMSV);
        pnlListTextField.add(txtTen);
        pnlListTextField.add(txtNamSinh);
        pnlListTextField.add(txtDiaChi);
        pnlListTextField.add(txtSDT);

        add(pnlListTextField);
        // List Control
        JPanel pnlControl = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlControl.setBounds(450, 0, 150, 150);
        pnlControl.setBackground(Color.yellow);
        JButton btnThem = new JButton("Them");
        JButton btnSua = new JButton("Sua");
        JButton btnXoa = new JButton("Xoa");
        btnThem.setPreferredSize(new Dimension(100, 30));
        btnSua.setPreferredSize(new Dimension(100, 30));
        btnXoa.setPreferredSize(new Dimension(100, 30));
        btnThem.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClicked(evt);
            }
        });
        btnSua.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClicked(evt);
            }
        });
        btnXoa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClicked(evt);
            }
        });

        pnlControl.add(btnThem);
        pnlControl.add(btnSua);
        pnlControl.add(btnXoa);

        add(pnlControl);
        //Table Sinh vien
        JPanel pnlBackgroundTable = new JPanel(null);
        pnlBackgroundTable.setBounds(0, 150, 600, 500);

        String[] columnName = {"Ma SV", "Ho Ten", "Nam Sinh", "Dia chi", "So dien thoai"};
        Object[][] data = {
            {"1", "Nguyen Van Tèo", "1-1-2000", "45 Nguyen Khoai", "09567456"},
            {"2", "Nguyen Van Nam", "1-1-2000", "40 Nguyen Van Kiet", "09645455"},};
        JTable tbl = new JTable(data, columnName);
        tbl.setPreferredSize(new Dimension(0, 1000));
        tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(0, 0, 580, 300);
        pnlBackgroundTable.add(scroll);
        //Sua mau header table
        JTableHeader header = tbl.getTableHeader();
        header.setBackground(Color.yellow);
        header.setForeground(Color.lightGray);
        //Sua mau row duoc chon
        tbl.setSelectionBackground(Color.blue);
        tbl.setSelectionForeground(Color.lightGray);
        // Xu ly xu kien table
        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int selectedRowIndex = tbl.getSelectedRow();
                txtMSV.setText(tbl.getValueAt(selectedRowIndex, 0).toString());
                txtTen.setText(tbl.getValueAt(selectedRowIndex, 1).toString());
                txtNamSinh.setText(tbl.getValueAt(selectedRowIndex, 2).toString());
                txtDiaChi.setText(tbl.getValueAt(selectedRowIndex, 3).toString());
                txtSDT.setText(tbl.getValueAt(selectedRowIndex, 4).toString());
            }
        });

        add(pnlBackgroundTable);
        //
        setLayout(null);
        setTitle("Long");
        setPreferredSize(new Dimension(600, 500));
        setSize(600, 500);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void btnClicked(MouseEvent evt) {
        JOptionPane.showConfirmDialog(rootPane, "Ban vua click vao button");
    }
}
