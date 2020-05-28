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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author root
 */
public class GUIBookStoreMain extends JFrame{
    private Color pink = new Color(255,97,194,100);
    private Color blue = new Color(97,255,218,100);
    private Color cream = new Color(255,205,97,100);
    GUIOrderManager orderManager = new GUIOrderManager();
    private Staff staff = new Staff();
    private BUSGetStaff busStaff = new BUSGetStaff();
    private JLayeredPane layerContent = new JLayeredPane();
    //Left side menu
    private JPanel LeftSideMenu = new JPanel();
    private JPanel pnlOrderManagerIiem = new JPanel();
    private JPanel pnlBookManagerItem = new JPanel();
    //Top
    private JPanel pnlTopMenu = new JPanel();
    
    public GUIBookStoreMain(Staff staff){
        this.staff = staff;
        System.out.println(staff.getPhone_number());
        initComp();
    }
    public GUIBookStoreMain(){
        //initLogin();
        initComp();
    }
    public void initComp(){
        this.setLayout(new BorderLayout());
        //Left side bar
        Dimension dimesionMenuItemSize = new Dimension(150,50);
        pnlOrderManagerIiem.add(new JLabel("Quan ly hoa don"));
        pnlOrderManagerIiem.setBackground(new Color(97,255,218,50));
        pnlOrderManagerIiem.setPreferredSize(dimesionMenuItemSize);
        pnlOrderManagerIiem.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                switchPanel(pnlOrderManagerIiem);
            }
        });
        
        pnlBookManagerItem.add(new JLabel("Quan ly sach"));
        pnlBookManagerItem.setBackground(new Color(97,255,218,50));
        pnlBookManagerItem.setPreferredSize(dimesionMenuItemSize);
        
        LeftSideMenu.add(pnlOrderManagerIiem);
        LeftSideMenu.add(pnlBookManagerItem);
        LeftSideMenu.setPreferredSize(new Dimension(200, 1000));
        this.add(LeftSideMenu, BorderLayout.WEST);
        //
        JPanel pnlorderManager = orderManager.initComponents();
        layerContent.setLayout(new FlowLayout());
        layerContent.add(pnlorderManager,10,0);
        
        
        this.add(layerContent);
        
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //frMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public void switchPanel(JPanel selectedPanel){
        
    }
            
    public static void main(String[] args) {
        GUIBookStoreMain main = new GUIBookStoreMain();
    }

}
