/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Tik
 */
public class GUI extends JFrame {
     public GUI() {
 
        initComponents();
    }
 
    public final void initComponents() {
        this.setLayout(new BorderLayout(0, 0));
        // Create horizontal toolbar
        JToolBar horizontalToolbar = new JToolBar();
        JButton btnSinhVien = new JButton("Sinh Vien");
        btnSinhVien.setBorder(new EmptyBorder(0,0,0,0));
        horizontalToolbar.add(btnSinhVien);
        horizontalToolbar.setPreferredSize(new Dimension(700,40));
        
        add(horizontalToolbar, BorderLayout.NORTH);
        //Create vertical toolbar
        JPanel pnlVerticalToolbar = new JPanel();
        pnlVerticalToolbar.setPreferredSize(new Dimension(150, 400));
        pnlVerticalToolbar.setBackground(new Color(220, 220, 220, 250));
        
        add(pnlVerticalToolbar, BorderLayout.WEST);
        //Create contain panel
        JPanel pnlContent = new JPanel();
        pnlContent.setBackground(new Color(255,255,255,255));
        
        
        add(pnlContent);
        
        pack(); 
        setTitle("Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    public static void main(String[] args) {
 
        SwingUtilities.invokeLater(new Runnable() {
 
            public void run() {
 
                GUI ex = new GUI();
                ex.setVisible(true);
            }
        });
    }
}
