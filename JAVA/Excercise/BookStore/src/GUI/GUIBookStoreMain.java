/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BUSGetStaff;
import DTO.Staff;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author root
 */
public class GUIBookStoreMain{
    GUIOrderManager orderManager = new GUIOrderManager();
    private Staff staff;
    private BUSGetStaff busStaff = new BUSGetStaff();
    private JFrame frMain = new JFrame();
    private JFrame frLogin;
    private JLayeredPane layerContent = new JLayeredPane();
    //Left side menu
    private JPanel LeftSideMenu = new JPanel();
    private JPanel pnlOrderManagerIiem = new JPanel();
    private JPanel pnlBookManagerItem = new JPanel();
    //Top
    private JPanel pnlTopMenu = new JPanel();
    public GUIBookStoreMain(){
        //initLogin();
        initComp();
    }
    
    public void initComp(){
        frMain.setLayout(new BorderLayout());
        //Left side bar
        pnlOrderManagerIiem.add(new JLabel("Quan ly hoa don"));
        pnlBookManagerItem.add(new JLabel("Quan ly sach"));
        LeftSideMenu.add(pnlOrderManagerIiem);
        LeftSideMenu.add(pnlBookManagerItem);
        LeftSideMenu.setPreferredSize(new Dimension(200, 1000));
        frMain.add(LeftSideMenu, BorderLayout.WEST);
        //Top menu
        pnlTopMenu.setPreferredSize(new Dimension(1100, 50));
        frMain.add(pnlTopMenu, BorderLayout.NORTH);
        //
        
        //JPanel pnlMain = orderManager.initComponents();
        layerContent.add(orderManager.initComponents());
        layerContent.setPreferredSize(new Dimension(1100, 1000));
        
        frMain.add(layerContent,BorderLayout.CENTER);
        
        frMain.setVisible(true);
        frMain.pack();
        frMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frMain.setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        GUIBookStoreMain main = new GUIBookStoreMain();
    }

}
