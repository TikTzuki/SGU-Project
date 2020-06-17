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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
    private JPanel TopMenu = new JPanel(null);
    ArrayList<String> listContentMenuItem;
    JPanel pnlMenuItem[];
    JLabel lblMenuItem[];
    //Main
        //Nơi khai báo các panel chính
        // VŨ, TRÂN, NINH KHAI BÁO GUI VỚI HÀM KHỞI TẠO TRỐNG
    GUIAnalysis analysis = new GUIAnalysis();
    FrameHienThi_Book vu = new FrameHienThi_Book();
    FrameTacGia author = new FrameTacGia();
    FrameTheLoai category = new FrameTheLoai();
    GUIOrderManager orderManager = new GUIOrderManager();
    GUICustomer_tran customerManager = new GUICustomer_tran();
    GUIStaffManager staffManager = new GUIStaffManager();
        //Mảng chứa nội dung chính
    JPanel[] pnlMainContentArray;
    private JLayeredPane layeredContent = new JLayeredPane();
    
    public GUIBookStoreMain(Staff staff){
        this.staff = staff;
        System.out.println(staff.getPhone_number());
        initComp();
        
    }
    public GUIBookStoreMain(){
        
        try {
            this.staff = busStaff.getStaffById(1);
            initComp();
        } catch (Exception ex) {
            Logger.getLogger(GUIBookStoreMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void initComp(){
        
        this.setLayout(new BorderLayout());
        this.setUndecorated(true);
        
        //Left side bar
        LeftSideMenu.setBackground(Cl.colorBackground);
        LeftSideMenu.setPreferredSize(new Dimension(200, 600));
        Dimension dimesionMenuItemSize = new Dimension(204,50);
        ArrayList<String> listContentMenuItemTemp = new ArrayList<>();
        listContentMenuItemTemp.add("Thống kê");
        listContentMenuItemTemp.add("Quản lý sách");
        listContentMenuItemTemp.add("Quản lý hóa đơn");
        listContentMenuItemTemp.add("Quản lý tac gia");
        listContentMenuItemTemp.add("Quản lý the loai");
        listContentMenuItemTemp.add("Quản lý khuyến mãi");
        listContentMenuItemTemp.add("Quản lý khách hàng");
        listContentMenuItemTemp.add("Quản lý nhân viên");
        switch(staff.getRole_id()){
            case 1:
                //Admin có toàn quyền
                break;
            case 2:
                //Manager cũng toàn quyền như admin, chỉ là không thể sửa tài khoản admin
                break;
            case 3:
                //Cắt chức năng quản lý nhân viên
                listContentMenuItemTemp.set(6, null);
                break;
        }
        
        listContentMenuItem = listContentMenuItemTemp;
        pnlMenuItem = new JPanel[listContentMenuItem.size()];
        lblMenuItem = new JLabel[listContentMenuItem.size()];
        
                    //Panel cấn vào flow layout
        JPanel temp = new JPanel();
        temp.setBackground(new Color(0,0,0,0));
        temp.setPreferredSize(new Dimension(200,20));
        LeftSideMenu.add(temp);
        //Từng lựa chọn của menu trái
        for(int i=0; i<listContentMenuItem.size(); i++){
            //Nếu phần tử của listContentMenuItem thứ i là null thì ẩn tính năng
            pnlMenuItem[i] = new JPanel(new FlowLayout(FlowLayout.CENTER,10,12));
            lblMenuItem[i] = new JLabel(listContentMenuItem.get(i));
            if(listContentMenuItem.get(i) == null){
                continue;
            }
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
        //Top menu
        ImageIcon iconBook = loadIcon("src/images/book_store_logo.png", 160, 50);
        JLabel lblLogo = new JLabel(iconBook);
        lblLogo.setBounds(20, 0, 160, 50);
        
            //Người dùng
        JLabel lblUser = new JLabel("Helo, "+staff.getName());
        lblUser.setFont(Cl.fontContentMB);
        lblUser.setForeground(Cl.colorBlue);
        lblUser.setBounds(1050, 0, 200, 50);
            //Icon đóng
        ImageIcon iconClose = loadIcon("src/images/close.png", 50, 50);
        ImageIcon iconCloseHover = loadIcon("src/images/closeHover.png", 50, 50);
        JLabel lblClose = new JLabel(iconClose);
        lblClose.setBounds(1250, 0, 50, 50);
        JFrame mainTemp = this;
        lblClose.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                mainTemp.dispose();
            }
            public void mouseEntered(MouseEvent evt){
                lblClose.setIcon(iconCloseHover);
            }
            public void mouseExited(MouseEvent evt){
                lblClose.setIcon(iconClose);
            }
        });
        
        TopMenu.add(lblLogo);
        TopMenu.add(lblUser);
        TopMenu.add(lblClose);
        TopMenu.setPreferredSize(new Dimension(1100,50));
        TopMenu.setBackground(Cl.colorBackground);
        
        this.add(LeftSideMenu, BorderLayout.WEST);
        this.add(TopMenu, BorderLayout.NORTH);
        // Main content
        layeredContent.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        layeredContent.setBackground(Cl.colorBackground);
        layeredContent.setPreferredSize(new Dimension(1110,700));
        
        //Khởi tạo nội panel chứa nội dung chính
        JPanel pnlAnalysis = analysis.initComponents(staff);
        JPanel pnlBookManager = vu.SanPham();                          // VŨ
        JPanel pnlAuthorManager = author.init();                        //VU
        JPanel pnlCategory = category.init();                           //VU
        JPanel pnlOrderManager = orderManager.initComponents(staff);  // LONG
        JPanel pnlDiscountManager = new  JPanel();                    //NINH
        JPanel pnlCustomerManager = customerManager.init();                //TRÂN
        JPanel pnlStaffManager = staffManager.initComponents(staff);                       //LONG
        //Tạo ra 1 mảng tạm để chứ các content panel và đưa vào mảng content panel
        JPanel[] pnlMainContentArrayTemp = {pnlAnalysis,pnlBookManager,pnlOrderManager,pnlAuthorManager,pnlCategory,pnlDiscountManager,pnlCustomerManager,pnlStaffManager};
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
        GUIBookStoreMain main = new GUIBookStoreMain();
    }

}
