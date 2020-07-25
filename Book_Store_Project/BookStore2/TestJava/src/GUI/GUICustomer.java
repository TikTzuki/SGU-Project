/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Customer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author Admin
 */
public class GUICustomer extends JFrame
{
    JPanel p9, pImg, pInfo, pButton, pTable;
    JLabel lbImg, lbContent, lbFunction, lbCustomer_ID, lbFirst_Name, lbLast_Name, lbEmail, lbPhone_Number, lbAddress;
    JTextField txtCustomer_ID, txtFirst_Name, txtLast_Name, txtEmail, txtPhone_Number, txtAddress;
    JButton btnShowAll, btnAdd, btnEdit, btnDel, btnImpExl, btnExpExl;
    
    DefaultTableModel model = new DefaultTableModel();
    JTable tblCustomer = new JTable(model);
    JScrollPane jScroll = new JScrollPane(tblCustomer);
    
    public GUICustomer() 
    {
        setSize(1000,1000);
        setLayout(new BorderLayout(0, 0));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
        setVisible(true);
    }
    
    public void init()
    {
        //Panel Image
        pImg = new JPanel();
        pImg.setPreferredSize(new Dimension(250, 200));
        pImg.setBackground(Color.green);
        ImageIcon icon = loadIcon("src/images/customer.png", 200, 150);
        lbImg = new JLabel();
        lbImg.setIcon(icon);
        
        pImg.add(lbImg);
        
        
        //Panel Info
        pInfo = new JPanel();
        pInfo.setPreferredSize(new Dimension(200, 200));
        pInfo.setBackground(new Color(255, 218, 185));
        
        Dimension setSizeLabelInfo = new Dimension(200, 20);
        Dimension setSizeTextInfo = new Dimension(200, 30);
        
        lbCustomer_ID = new JLabel("Customer ID:");
        lbCustomer_ID.setHorizontalAlignment(JLabel.CENTER);
        lbCustomer_ID.setPreferredSize(setSizeLabelInfo);
        lbFirst_Name = new JLabel("First Name:");
        lbFirst_Name.setHorizontalAlignment(JLabel.CENTER);
        lbFirst_Name.setPreferredSize(setSizeLabelInfo);
        lbLast_Name = new JLabel("Last Name:");
        lbLast_Name.setHorizontalAlignment(JLabel.CENTER);
        lbLast_Name.setPreferredSize(setSizeLabelInfo);
        lbEmail = new JLabel("Email:");
        lbEmail.setHorizontalAlignment(JLabel.CENTER);
        lbEmail.setPreferredSize(setSizeLabelInfo);
        lbPhone_Number = new JLabel("Phone Number:");
        lbPhone_Number.setHorizontalAlignment(JLabel.CENTER);
        lbPhone_Number.setPreferredSize(setSizeLabelInfo);
        lbAddress = new JLabel("Address:");
        lbAddress.setHorizontalAlignment(JLabel.CENTER);
        lbAddress.setPreferredSize(setSizeLabelInfo);
        
        txtCustomer_ID = new JTextField();
        //txtCustomer_ID.setHorizontalAlignment(JLabel.CENTER);
        txtCustomer_ID.setPreferredSize(setSizeTextInfo);
        txtFirst_Name = new JTextField();
        //txtFirst_Name.setHorizontalAlignment(JLabel.CENTER);
        txtFirst_Name.setPreferredSize(setSizeTextInfo);
        txtLast_Name = new JTextField();
        //txtLast_Name.setHorizontalAlignment(JLabel.CENTER);
        txtLast_Name.setPreferredSize(setSizeTextInfo);
        txtEmail = new JTextField();
        //txtEmail.setHorizontalAlignment(JLabel.CENTER);
        txtEmail.setPreferredSize(setSizeTextInfo);
        txtPhone_Number = new JTextField();
        //txtPhone_Number.setHorizontalAlignment(JLabel.CENTER);
        txtPhone_Number.setPreferredSize(setSizeTextInfo);
        txtAddress = new JTextField();
        //txtAddress.setHorizontalAlignment(JLabel.CENTER);
        txtAddress.setPreferredSize(setSizeTextInfo);
        
        pInfo.add(lbCustomer_ID);
        pInfo.add(txtCustomer_ID);
        pInfo.add(lbFirst_Name);
        pInfo.add(txtFirst_Name);
        pInfo.add(lbLast_Name);
        pInfo.add(txtLast_Name);
        pInfo.add(lbEmail);
        pInfo.add(txtEmail);
        pInfo.add(lbPhone_Number);
        pInfo.add(txtPhone_Number);
        pInfo.add(lbAddress);
        pInfo.add(txtAddress);
        
        
        //Panel Button
        pButton = new JPanel();
        pButton.setPreferredSize(new Dimension(200, 200));
        pButton.setBackground(new Color(255, 218, 185));
        
        btnShowAll = new JButton("Show All");
        btnAdd = new JButton("Add");
        btnEdit = new JButton("Edit");
        btnDel = new JButton("Delete");
        btnImpExl = new JButton("Import Excel");
        btnExpExl = new JButton("Export Excel");
        
        pButton.add(btnShowAll);
        pButton.add(btnAdd);
        pButton.add(btnEdit);
        pButton.add(btnDel);
        pButton.add(btnImpExl);
        pButton.add(btnExpExl);
        
        
        //Panel Table
        pTable = new JPanel();
        pTable.setPreferredSize(new Dimension(0, 500));
        pTable.setBackground(new Color(255, 218, 185));
        
        JTableHeader jHeader = tblCustomer.getTableHeader();
        jHeader.setBackground(new Color(0, 125, 0));
        jHeader.setForeground(Color.white);
        tblCustomer.setRowHeight(25);
        tblCustomer.setSelectionBackground(Color.yellow);
        
        tblCustomer.setModel(new DefaultTableModel(
                new Object [][]{{"001", "Nguyễn Văn", "Linh"},
        {"002", "Võ Văn", "Kiệt"},
        {"003", "Nguyễn Tri", "Phương"}},  //vi du. chua ket noi db
                new String [] {"Customer ID", "First Name", "Last Name", "Email", "Phone Number", "Address"}
        ));
        tblCustomer.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblCustomer.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblCustomer.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblCustomer.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblCustomer.getColumnModel().getColumn(5).setPreferredWidth(150);
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = tblCustomer.getSelectedRow();
                //JOptionPane.showMessageDialog(null, "row:"+i);
                txtCustomer_ID.setText(tblCustomer.getModel().getValueAt(i, 0).toString());
                txtFirst_Name.setText(tblCustomer.getModel().getValueAt(i, 1).toString());
                txtLast_Name.setText(tblCustomer.getModel().getValueAt(i, 2).toString());
                txtEmail.setText(tblCustomer.getModel().getValueAt(i, 3).toString());
                txtPhone_Number.setText(tblCustomer.getModel().getValueAt(i, 4).toString());
                txtAddress.setText(tblCustomer.getModel().getValueAt(i, 5).toString());
            }
        }); 
       
        jScroll.setPreferredSize(new Dimension(900, 300));
        pTable.add(jScroll);
        
        
        //add 
        add(pImg, BorderLayout.WEST);    //left
        add(pInfo, BorderLayout.CENTER); 
        add(pButton, BorderLayout.EAST); //right
        add(pTable, BorderLayout.SOUTH); //root
    }
    
    
    //copy bạn Long
    public ImageIcon loadIcon(String linkImage, int width, int height) {/*linkImage là tên icon, k kích thước chiều rộng mình muốn,m chiều dài và hàm này trả về giá trị là 1 icon.*/
        try {
            BufferedImage image = ImageIO.read(new File(linkImage));//đọc ảnh dùng BufferedImage
            int x = width;
            int y = height;
            int ix = image.getWidth();
            int iy = image.getHeight();
            int dx = 0, dy = 0;
            if (x / y > ix / iy) {
                dy = y;    
                dx = dy * ix / iy;
            } else {
                dx = x;
                dy = dx * iy / ix;
            }
            return new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
        } catch (IOException ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    /*
    public static void main(String[] args) 
    {
        new GUICustomer();
    }*/
}
