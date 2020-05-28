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
    private Color colorPink = new Color(255,97,194,255);
    private Color colorBlueWeak = new Color(97,255,218,255);
    private Color colorBlue = new Color(32,164,243,255);
    private Color colorCream = new Color(255,205,97,255);
    private Color colorRice = new Color(229,218,218,255);
    private Color colorGray = new Color(93,87,107,255);
    
    private Staff staff = new Staff();
    private BUSGetStaff busStaff = new BUSGetStaff();
    
    //Left side menu
    private JPanel LeftSideMenu = new JPanel(new FlowLayout(FlowLayout.CENTER,1,1));
    String contentMenuItem[];
    JPanel pnlMenuItem[];
    
    //Main
        //Nơi khai báo các panel chính
        // VŨ, TRÂN, NINH KHAI BÁO GUI VỚI HÀM KHỞI TẠO TRỐNG
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
        Dimension dimesionMenuItemSize = new Dimension(200,50);
        
        String[] contentMenuItemTemp = {"Thống kê","Quản lý sách","Quản lý hóa đơn","Quản lý xuất nhập","Quản lý khuyến mãi","Quản lý khách hàng","Quản lý nhân viên"};
        contentMenuItem = contentMenuItemTemp;
        pnlMenuItem = new JPanel[contentMenuItem.length];
        
        for(int i=0; i<contentMenuItem.length; i++){
            pnlMenuItem[i] = new JPanel(new FlowLayout(FlowLayout.CENTER,10,12));
            JLabel lblMenuItem = new JLabel(contentMenuItem[i]);
            lblMenuItem.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
            lblMenuItem.setForeground(colorGray);
            pnlMenuItem[i].add(lblMenuItem);
            pnlMenuItem[i].setBackground(colorBlueWeak);
            pnlMenuItem[i].setPreferredSize(dimesionMenuItemSize);
            int j=i;
            pnlMenuItem[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent evt){
                    switchPanel(j);
                }
            });
            LeftSideMenu.add(pnlMenuItem[i]);
        }
        
        LeftSideMenu.setBackground(Color.white);
        LeftSideMenu.setPreferredSize(new Dimension(200, 600));
        this.add(LeftSideMenu, BorderLayout.WEST);
        // Main content
        layeredContent.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        layeredContent.setPreferredSize(new Dimension(1110,700));
        
        //Khởi tạo nội panel chứa nội dung chính
        JPanel pnlAnalysis = new JPanel();
        JPanel pnlBookManager = new JPanel();                         // VŨ
        JPanel pnlOrderManager = orderManager.initComponents(staff);  // LONG
        JPanel pnlPublisherManager = new JPanel();                    //VŨ
        JPanel pnlDiscountManager = new JPanel();                    //NINH
        JPanel pnlCustomerManager = new JPanel();                    //TRÂN
        JPanel pnlStaffManager = new JPanel();                       //LONG
        //Tạo ra 1 mảng tạm để chứ các content panel và đưa vào mảng content panel
        JPanel[] pnlMainContentArrayTemp = {pnlAnalysis,pnlBookManager,pnlOrderManager,pnlPublisherManager,pnlDiscountManager,pnlCustomerManager,pnlStaffManager};
        pnlMainContentArray = pnlMainContentArrayTemp;

        for (int i=0; i<pnlMainContentArray.length; i++) {
            layeredContent.add(pnlMainContentArray[i],pnlMainContentArray.length-i,0);
        }

        this.add(layeredContent,BorderLayout.CENTER);

        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //frMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public void switchPanel(int selectPanelIndex){
        for (JPanel jPanel : pnlMenuItem) {
            jPanel.setBackground(colorBlueWeak);
        }
        pnlMenuItem[selectPanelIndex].setBackground(colorBlue);
        
        layeredContent.removeAll();
        layeredContent.add(pnlMainContentArray[selectPanelIndex]);
        layeredContent.repaint();
        layeredContent.revalidate();
    }
            
    public static void main(String[] args) {
        GUIBookStoreMain main = new GUIBookStoreMain();
    }

}
