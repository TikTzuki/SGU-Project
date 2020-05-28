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
        setSize(310, 500);
        
        pnlBackground.setLayout(null);
        pnlBackground.setBounds(0, 0, 300, 500);
        //pnlBackground.setBackground(Color.red);
        
        ImageIcon imgBackground = new ImageIcon();
        imgBackground = loadIcon("src/images/background_login.png", 300, 500);
        lblBackground = new JLabel(imgBackground);
        lblBackground.setBounds(0, 0, 300, 500);
        
        JPanel pnlPhoneNumber = new JPanel();
        JTextField txtPhoneNumber = new JTextField();
        JPanel pnlPassword = new JPanel();
        JTextField txtPassword = new JTextField();
        
        txtPhoneNumber.setPreferredSize(new Dimension(180, 30));
        pnlPhoneNumber.setBounds(5,50,280, 70);
        Border bdPhoneNumber = BorderFactory.createTitledBorder("Số điện thoại");
        pnlPhoneNumber.setBorder(new TitledBorder(bdPhoneNumber));
        pnlPhoneNumber.setBackground(new Color(0, 0, 0, 0));
        
        pnlPhoneNumber.add(txtPhoneNumber);
        
        
        pnlPassword.setPreferredSize(new Dimension(300,40));
        txtPassword.setPreferredSize(new Dimension(150,20));
        
        pnlPassword.add(txtPassword);
        
        pnlBackground.add(pnlPhoneNumber);
        pnlBackground.add(pnlPassword);
        pnlBackground.add(lblBackground);
        
        add(pnlBackground);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
    }
    public static void main(String[] args) {
        GUILogin login = new GUILogin();
    }
}
