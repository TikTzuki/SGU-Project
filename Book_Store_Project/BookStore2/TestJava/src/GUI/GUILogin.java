/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BUSGetStaff;
import DTO.Staff;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Tik Tzuki
 */
public class GUILogin extends JFrame{
    private Staff staff = new Staff();
    private BUSGetStaff busStaff = new BUSGetStaff();
    private JPanel pnlBackground = new JPanel();
    private JLabel lblBackground = new JLabel();
    JTextField txtPhoneNumber = new JTextField();
    JTextField txtPassword = new JTextField();
    public GUILogin(){
        initLogin();
    }
    public void initLogin(){
        int labelWidth = 50;
        int lbelHeight = 20;
        int textfieldWidth = 150;
        int textfieldHeigh = 20;
        int panelWidth = 300;
        int panelHeight = 40;
        setTitle("Đăng nhập");
        setSize(300, 500);
        
        pnlBackground.setLayout(null);
        pnlBackground.setBounds(0, 0, 300, 500);
        //pnlBackground.setBackground(Color.red);
        
        ImageIcon imgBackground = new ImageIcon();
        imgBackground = loadIcon("src/images/background_login.png", 300, 500);
        lblBackground = new JLabel(imgBackground);
        lblBackground.setBounds(0, 0, 300, 500);
        //Phone number
        JPanel pnlPhoneNumber = new JPanel();

        txtPhoneNumber.setPreferredSize(new Dimension(180, 30));
        pnlPhoneNumber.setBounds(10,50,280, 70);
        Border bdPhoneNumber = BorderFactory.createTitledBorder("Số điện thoại");
        pnlPhoneNumber.setBorder(new TitledBorder(bdPhoneNumber));
        pnlPhoneNumber.setBackground(new Color(0, 0, 0, 0));
        
        pnlPhoneNumber.add(txtPhoneNumber);
        // Password
        JPanel pnlPassword = new JPanel();
        txtPassword.setPreferredSize(new Dimension(180,30));
        pnlPassword.setBounds(10, 140, 280, 70);
        Border bdPassword = BorderFactory.createTitledBorder("Mat khau");
        pnlPassword.setBorder(bdPassword);
        pnlPassword.setBackground(new Color(0,0,0,0));
        
        pnlPassword.add(txtPassword);
        // Login
        JPanel pnlLogin = new JPanel();
        JLabel lblLogin = new JLabel("Dang nhap");
        
        Border bdLogin = BorderFactory.createLineBorder(Color.white);
        pnlLogin.setBorder(bdLogin);
        pnlLogin.setBounds(50, 250, 200, 50);
        pnlLogin.setBackground(new Color(0,0,0,0));
        
        lblLogin.setFont(new Font(Font.MONOSPACED, 1, 20));
        lblLogin.setHorizontalAlignment(JLabel.CENTER);
        lblLogin.setPreferredSize(new Dimension(200, 40));
        lblLogin.setForeground(Color.white);
        pnlLogin.add(lblLogin);
        pnlLogin.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                login();
            }
        });
        // 
        pnlBackground.add(pnlPhoneNumber);
        pnlBackground.add(pnlPassword);
        pnlBackground.add(pnlLogin);
        pnlBackground.add(lblBackground);
        
        add(pnlBackground);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void login(){
        String phone_number = txtPhoneNumber.getText();
        String password = txtPassword.getText();
        staff.setPhone_number(phone_number);
        staff.setPassword(password);

        try {
            if (busStaff.checkStaff(staff)) {
                staff = busStaff.getStaffByPhoneNumber(phone_number);
                this.setVisible(false);
                GUIBookStoreMain bookStore = new GUIBookStoreMain(staff);
            } else {
            }
        } catch (Exception ex) {
            Logger.getLogger(GUILogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
    }/*
    public static void main(String[] args) {
        
        GUILogin login = new GUILogin();
        //System.out.print(myStaff.getEmail());
    }*/
}
