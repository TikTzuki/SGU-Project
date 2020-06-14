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
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author root
 */
public class GUIBookStoreMain extends JFrame{
    
    private Staff staff = new Staff();
    private BUSGetStaff busStaff = new BUSGetStaff();
    
    //Left side menu
    private JPanel LeftSideMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,-2,-2));
    private JPanel TopMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
    String contentMenuItem[];
    JPanel pnlMenuItem[];
    JLabel lblMenuItem[];
    //Main
        //Nơi khai báo các panel chính
        // VŨ, TRÂN, NINH KHAI BÁO GUI VỚI HÀM KHỞI TẠO TRỐNG
    FrameHienThi_Book vu = new FrameHienThi_Book();
    GUIOrderManager orderManager = new GUIOrderManager();
        //Mảng chứa nội dung chính
    JPanel[] pnlMainContentArray;
    private JLayeredPane layeredContent = new JLayeredPane();
    
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
        Dimension dimesionMenuItemSize = new Dimension(204,50);
        
        String[] contentMenuItemTemp = {"Thống kê","Quản lý sách","Quản lý hóa đơn","Quản lý xuất nhập","Quản lý khuyến mãi","Quản lý khách hàng","Quản lý nhân viên"};
        contentMenuItem = contentMenuItemTemp;
        pnlMenuItem = new JPanel[contentMenuItem.length];
        lblMenuItem = new JLabel[contentMenuItem.length];
        
        JPanel temp = new JPanel();
        temp.setBackground(Cl.colorBackground);
        temp.setPreferredSize(dimesionMenuItemSize);
        LeftSideMenu.add(temp);
        for(int i=0; i<contentMenuItem.length; i++){
            pnlMenuItem[i] = new JPanel(new FlowLayout(FlowLayout.CENTER,10,12));
            lblMenuItem[i] = new JLabel(contentMenuItem[i]);
            lblMenuItem[i].setFont(Cl.fontContentLB);
            lblMenuItem[i].setForeground(Color.white);
            
            pnlMenuItem[i].add(lblMenuItem[i]);
            pnlMenuItem[i].setBackground(Cl.colorBackground);
            pnlMenuItem[i].setPreferredSize(dimesionMenuItemSize);
            pnlMenuItem[i].setBorder(Cl.whiteLine);
            int selectPanelIndex=i;
            pnlMenuItem[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent evt) {
                    switchPanel(selectPanelIndex);
                }
            });
            LeftSideMenu.add(pnlMenuItem[i]);
        }
        
        TopMenu.setPreferredSize(new Dimension(1100,50));
        LeftSideMenu.setBackground(Cl.colorBackground);
        LeftSideMenu.setPreferredSize(new Dimension(200, 600));
        this.add(LeftSideMenu, BorderLayout.WEST);
        this.add(TopMenu, BorderLayout.NORTH);
        // Main content
        layeredContent.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        layeredContent.setPreferredSize(new Dimension(1110,700));
        
        //Khởi tạo nội panel chứa nội dung chính
        JPanel pnlAnalysis = new JPanel();
        JPanel pnlBookManager = vu.SanPham();                          // VŨ
        JPanel pnlOrderManager = orderManager.initComponents(staff);  // LONG
        JPanel pnlPublisherManager = new JPanel();                    //VŨ
        JPanel pnlDiscountManager = new  JPanel();                    //NINH
        JPanel pnlCustomerManager = new JPanel();                    //TRÂN
        JPanel pnlStaffManager = new JPanel();                       //LONG
        //Tạo ra 1 mảng tạm để chứ các content panel và đưa vào mảng content panel
        JPanel[] pnlMainContentArrayTemp = {pnlAnalysis,pnlBookManager,pnlOrderManager,pnlPublisherManager,pnlDiscountManager,pnlCustomerManager,pnlStaffManager};
        pnlMainContentArray = pnlMainContentArrayTemp;

        for (int i=0; i<pnlMainContentArray.length; i++) {
            //pnlMainContentArray[i].setBackground(Cl.colorBackground);
            layeredContent.add(pnlMainContentArray[i],pnlMainContentArray.length-i,0);
        }

        this.add(layeredContent,BorderLayout.CENTER);

        this.setVisible(true);
        this.pack();
        //this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public void switchPanel(int selectPanelIndex) {
        for (int i = 0; i < pnlMenuItem.length; i++) {
            if(i==selectPanelIndex){
                lblMenuItem[selectPanelIndex].setForeground(Cl.colorBlue);
                pnlMenuItem[selectPanelIndex].setBorder(Cl.blueLine);
                continue;
            }
            pnlMenuItem[i].setBorder(Cl.whiteLine);
            lblMenuItem[i].setForeground(Color.white);
        }
        
        layeredContent.removeAll();
        layeredContent.add(pnlMainContentArray[selectPanelIndex]);
        layeredContent.repaint();
        layeredContent.revalidate();
    }
            
    public static void main(String[] args) {
        GUIBookStoreMain main = new GUIBookStoreMain();
    }

}
