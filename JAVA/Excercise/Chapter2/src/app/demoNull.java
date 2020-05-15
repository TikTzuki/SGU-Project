/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;

/**
 *
 * @author Tik
 */
public class demoNull extends javax.swing.JFrame{
    public demoNull(){
        initComponents();
}
    private void initComponents(){
        
        JFrame mainFrame = new JFrame("Tik'ss App");
        JPanel bg = new JPanel();
        JPanel pnlSideMenu = new JPanel();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        
        mainFrame.setSize(800, 800);
        mainFrame.setLayout(null);
        mainFrame.add(bg);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        bg.setSize(800, 800);
        bg.setBackground(new Color(255, 255, 255));
        
        bg.setLayout(null);
        bg.add(pnlSideMenu);
        pnlSideMenu.add(jPanel1);
        jPanel1.add(jLabel1);
        
        pnlSideMenu.setLayout(null);
        
        jPanel1.setLayout(null);
        
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/icons8_delete_32px.png")));
        
        jLabel1.setBounds(20, 20, 77, 32);
        
        
        jPanel1.setBounds(0, 0, 230, 50);
        
        
        pnlSideMenu.setBounds(0, 0, 230, 500);
        
       // pnlSideMenu.setBackground(new Color(178, 255, 89));
        //jPanel1.setBackground(new Color(178, 0, 89));
        
        
        
        
       
        
        
        
        
        
        
    }
     public static void main(String[] args) {
        demoNull demo = new demoNull();
    }
}
