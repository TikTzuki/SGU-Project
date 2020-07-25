/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
import DTO.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
//import jxl.write.WriteException;




/**
 *
 * @author Tik
 */
public class GUIOrderManager{

    //Nhan vien
    Staff staff;
    
    public JPanel pnlMainPanel;
    JTabbedPane tabbedPane;
    JPanel pnlCreateOrder;
    JPanel pnlOrderManager;
    JTable tblProduct = new JTable();
    DefaultTableModel modelTblProduct;
    JPanel pnlSelectedProduct;
    JPanel pnlSelectedProductDetail;
    JPanel pnlInstanceOrder;
    JTable tblOrderDetail = new JTable();
    DefaultTableModel modelTblOrderdetail;
    //Tong hoa don
    JLabel lblTotalPriceOrderBefDis = new JLabel("Tổng (chưa áp khuyến mãi):");
    JLabel lblTotalPriceOrderBefDisValue = new JLabel("0");
    JLabel lblTotalValueDiscount = new JLabel("Khuyen mai:");
    JLabel lblTotalValueDiscountValue = new JLabel("0");
    JLabel lblTotalPriceOrder = new JLabel("Tổng :");
    JLabel lblTotalPriceOrderValue = new JLabel("0");
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");  
    Date today = new Date();
    //Data transfer object
    private BUSGetBook busBook = new BUSGetBook();
    private BUSOrderManager busOrder = new BUSOrderManager();
    private BUSOrderItemManager busOrderItem = new BUSOrderItemManager();
    private BUSGetGenre busGenre = new BUSGetGenre();
    private BUSGetAuthor busAuthor = new BUSGetAuthor();
    private BUSGetDiscount busDiscount = new BUSGetDiscount();
    private BUSGetDiscountDetail busDiscountDetail = new BUSGetDiscountDetail();
    private BUSGetCustomer busCustomer = new BUSGetCustomer();
    private BUSGetStaff busStaff = new BUSGetStaff();
    static private ArrayList<Book> bookListGlobal = new ArrayList<>();
    static private ArrayList<OrderItem> orderItemListGlobal = new ArrayList<>();
    static private Order orderGlobal = new Order();
    static private Book selectedBookGlobal = new Book();
    static private ArrayList<Discount> discountListGlobal = new ArrayList<>();
    static private Discount selectedDiscountGolbal = new Discount();
    static private ArrayList<DiscountDetail> discountDetailListGlobal = new ArrayList<>();
    static private ArrayList<Customer> customerListGlobal = new ArrayList<>();
    static private Customer selectedCustomerGlobal = new Customer();
    static private ArrayList<Order> orderListGolbal = new ArrayList<>();
    static private Order selectedOrderGolbal = new Order();
    static private ArrayList<OrderItem> selectedOrderItem = new ArrayList<>();
    public GUIOrderManager() {
        //initComponents();
        
        /*
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);*/
    }

    public JPanel initComponents(Staff staff) {
        // Nhan vien
         this.staff = staff;
        //Panel chinh
        pnlMainPanel = new JPanel(new BorderLayout());
        pnlMainPanel.setBackground(Cl.colorBackground);
        pnlMainPanel.setBorder(Cl.blueLine);
        //Tạo tabbedPane chứa panel tạo hóa đơn, quản lý hóa đơn
        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Cl.colorBackground);
        tabbedPane.setForeground(Color.DARK_GRAY);
       
        //Tạo panel tạo hóa đơn
        pnlCreateOrder = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlCreateOrder.setPreferredSize(new Dimension(1100, 600));
        pnlCreateOrder.setBackground(Cl.colorBackground);
            //Panel sản phẩm đang được chọn
        pnlSelectedProduct = new JPanel(new BorderLayout(0, 0));
        pnlSelectedProduct.setPreferredSize(new Dimension(424, 320));
        pnlSelectedProduct.setBorder(Cl.blueLine);
            //Label sản phẩm đang được chọn
        JLabel lblSelectedProduct = new JLabel("Sản phẩm đang chọn");
        lblSelectedProduct.setFont(Cl.fontContentMB);
        lblSelectedProduct.setPreferredSize(new Dimension(420, 20));
        lblSelectedProduct.setHorizontalAlignment(JLabel.CENTER);
        lblSelectedProduct.setForeground(Cl.colorBlue);
        pnlSelectedProduct.setBackground(Cl.colorBackground);
        pnlSelectedProduct.add(lblSelectedProduct,BorderLayout.NORTH);
            //Ảnh sản phẩm đang đc chọn
        lblBookImg.setPreferredSize(new Dimension(200, 300));
        lblBookImg.setHorizontalAlignment(JLabel.CENTER);
            //Thông tin sản phẩm đang đc chọn
        pnlSelectedProductDetail = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        pnlSelectedProductDetail.setPreferredSize(new Dimension(220, 300));
        pnlSelectedProductDetail.setBackground(Cl.colorBackground);
        
        JPanel pnlBlock = new JPanel(); pnlBlock.setPreferredSize(new Dimension(200, 50)); pnlBlock.setBackground(Cl.colorBackground);
            
        Dimension selectedProductLabelSize = new Dimension(60, 20);
        for(int i=0; i<lblSelectedBookArray.length; i++){
            lblSelectedBookArray[i].setPreferredSize(selectedProductLabelSize);
            lblSelectedBookArray[i].setFont(Cl.fontContentS);
        }
        
        
        lblBookIdValue.setPreferredSize(new Dimension(100,20));
        txtBookQuantity.setPreferredSize(new Dimension(50, 20));
        
        for(int i=0; i<lblSelectedBookValueArray.length; i++){
            lblSelectedBookValueArray[i].setForeground(Color.white);
            lblSelectedBookValueArray[i].setPreferredSize(new Dimension(140, 20));
            lblSelectedBookValueArray[i].setFont(Cl.fontContentSB);
        }
        
        pnlSelectedProductDetail.add(pnlBlock);
        pnlSelectedProductDetail.add(lblBookId);
        pnlSelectedProductDetail.add(lblBookIdValue);
        pnlSelectedProductDetail.add(lblBookGenre);
        pnlSelectedProductDetail.add(lblBookGenreValue);
        pnlSelectedProductDetail.add(lblBookName);
        pnlSelectedProductDetail.add(lblBookNameValue);
        pnlSelectedProductDetail.add(lblBookAuthor);
        pnlSelectedProductDetail.add(lblBookAuthorValue);
        pnlSelectedProductDetail.add(lblBookPrice);
        pnlSelectedProductDetail.add(lblBookPriceValue);
        pnlSelectedProductDetail.add(lblISBN);
        pnlSelectedProductDetail.add(lblISBNValue);
        pnlSelectedProductDetail.add(lblBookQuantity);
        pnlSelectedProductDetail.add(txtBookQuantity);
        
        
        pnlSelectedProduct.add(lblBookImg,BorderLayout.WEST);
        pnlSelectedProduct.add(pnlSelectedProductDetail,BorderLayout.EAST);
            // End Thông tin sản phẩm đang đc chọn
        pnlCreateOrder.add(pnlSelectedProduct);
            //Button thêm sản phẩm vào hóa đơn
        JPanel pnlAttachProductToOrder = new JPanel();
        pnlAttachProductToOrder.setBackground(Cl.colorBackground);
        pnlAttachProductToOrder.setBorder(Cl.blueLine);
        JLabel lblAttachProductToOrder = new JLabel("Thêm vào >>");
        lblAttachProductToOrder.setForeground(Cl.colorBlue);
        pnlAttachProductToOrder.add(lblAttachProductToOrder);
         pnlAttachProductToOrder.addMouseListener(new MouseAdapter() {
             public void mousePressed(MouseEvent evt){
                    showTblOrderDetail();
             }
             public void mouseEntered(MouseEvent evt){
                 pnlAttachProductToOrder.setBackground(Cl.colorBlue);
                 lblAttachProductToOrder.setForeground(Cl.colorBackground);
             }
             public void mouseExited(MouseEvent evt){
                  pnlAttachProductToOrder.setBackground(Cl.colorBackground);
                  lblAttachProductToOrder.setForeground(Cl.colorBlue);
             }
         });
        
        pnlCreateOrder.add(pnlAttachProductToOrder);
            //Panel hóa đơn hiện tại
        pnlInstanceOrder = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pnlInstanceOrder.setPreferredSize(new Dimension(560,320));
        pnlInstanceOrder.setBorder(Cl.blueLine);
        pnlInstanceOrder.setBackground(Cl.colorBackground);
        
        JLabel lblOrderDetail = new JLabel("Hóa đơn");
        lblOrderDetail.setHorizontalAlignment(JLabel.CENTER);
        lblOrderDetail.setFont(Cl.fontContentMB);
        lblOrderDetail.setForeground(Cl.colorBlue);
        lblOrderDetail.setPreferredSize(new Dimension(400,20));
        //Panel bên trái hóa đơn hiện tại
        JPanel pnlLeftInstanceOrder = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlLeftInstanceOrder.setPreferredSize(new Dimension(410,296));
        pnlLeftInstanceOrder.setBackground(Cl.colorBackground);
        
        tblOrderDetail.setPreferredSize(new Dimension(400,500));
        
        tblOrderDetail.setModel(new DefaultTableModel(
            new Object[][]{
            
            },
            new Object[]{"ID","Tên sách","Giá bán","#","Thành tiền"}));
        tblOrderDetail.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblOrderDetail.getColumnModel().getColumn(1).setPreferredWidth(200);
        JScrollPane scrollTblOrderDetail = new JScrollPane(tblOrderDetail);
        scrollTblOrderDetail.setPreferredSize(new Dimension(400,240));
        
        Dimension sizeOrderCalc = new Dimension(190, 16);
        lblTotalPriceOrderBefDis.setForeground(Color.white);
        lblTotalPriceOrderBefDis.setPreferredSize(sizeOrderCalc);
        lblTotalPriceOrderValue.setForeground(Color.white);
        lblTotalPriceOrderValue.setPreferredSize(sizeOrderCalc);
        lblTotalValueDiscount.setForeground(Color.white);
        lblTotalValueDiscount.setPreferredSize(sizeOrderCalc);
        lblTotalPriceOrder.setForeground(Color.white);
        lblTotalPriceOrder.setPreferredSize(sizeOrderCalc);
        
        lblTotalPriceOrderBefDisValue.setPreferredSize(new Dimension(190, 16));
        lblTotalPriceOrderBefDisValue.setForeground(Color.white);
        lblTotalPriceOrderValue.setPreferredSize(new Dimension(190, 16));
        lblTotalPriceOrderValue.setForeground(Color.white);
        lblTotalValueDiscountValue.setPreferredSize(new Dimension(190, 16));
        lblTotalValueDiscountValue.setForeground(Color.white);

        pnlLeftInstanceOrder.add(scrollTblOrderDetail);
        pnlLeftInstanceOrder.add(lblTotalPriceOrderBefDis);
        pnlLeftInstanceOrder.add(lblTotalPriceOrderBefDisValue);
        pnlLeftInstanceOrder.add(lblTotalValueDiscount);
        pnlLeftInstanceOrder.add(lblTotalValueDiscountValue);
        pnlLeftInstanceOrder.add(lblTotalPriceOrder);
        pnlLeftInstanceOrder.add(lblTotalPriceOrderValue);
        
        //Thêm tên panel hóa đơn hiện tại
        pnlInstanceOrder.add(lblOrderDetail);
        //Thêm panel bên trái vào hóa đơn hiện tại
        pnlInstanceOrder.add(pnlLeftInstanceOrder);
        //Panel bên phải hóa dơn hiện tại
        JPanel pnlRightInstanceOrder = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
        pnlRightInstanceOrder.setPreferredSize(new Dimension(140,296));
        pnlRightInstanceOrder.setBackground(Cl.colorBackground);
        
        Dimension controlSize = new Dimension(100,20);
        lblSaveOrder.setPreferredSize(controlSize);
        lblSaveOrder.setHorizontalAlignment(JLabel.CENTER);
        lblSaveOrder.setForeground(Cl.colorBlue);
        lblClearOrder.setPreferredSize(controlSize);
        lblClearOrder.setHorizontalAlignment(JLabel.CENTER);
        lblClearOrder.setForeground(Cl.colorBlue);
        lblDeleteOrderItem.setPreferredSize(controlSize);
        lblDeleteOrderItem.setHorizontalAlignment(JLabel.CENTER);
        lblDeleteOrderItem.setForeground(Cl.colorBlue);
        pnlSaveOrder.setBorder(Cl.blueLine);
        pnlSaveOrder.setBackground(Cl.colorBackground);
        pnlClearOrder.setBorder(Cl.blueLine);
        pnlClearOrder.setBackground(Cl.colorBackground);
        pnlDeleteOrderItem.setBorder(Cl.blueLine);
        pnlDeleteOrderItem.setBackground(Cl.colorBackground);
        //Discount
        cbbDiscount.setPreferredSize(new Dimension(140, 24));
        cbbDiscount.setForeground(Color.white);
        cbbDiscount.setBackground(Cl.colorBackground);
        cbbDiscount.setModel(modelCbbDiscount = showCbbDiscount());
        btnApplyDiscount.setPreferredSize(new Dimension(120, 24));
        btnApplyDiscount.setBackground(Cl.colorBackground);
        btnApplyDiscount.setBorder(Cl.blueLine);
        btnApplyDiscount.setForeground(Cl.colorBlue);
        pnlDiscount.setPreferredSize(new Dimension(150, 60));
        pnlDiscount.setBackground(Cl.colorBackground);
        //Chon id khach hang
        pnlCustomerId.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pnlCustomerId.setBackground(Cl.colorBackground);
        lblCustomerId.setPreferredSize(new Dimension(70, 24));
        lblCustomerId.setForeground(Color.white);
        txtCustomerId.setPreferredSize(new Dimension(50,24));
        btnSearchCustomerId.setPreferredSize(new Dimension(20, 24));
        btnSearchCustomerId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNSearchCustomer(e);
            }
        });
        
        pnlSaveOrder.add(lblSaveOrder);
        pnlClearOrder.add(lblClearOrder);
        pnlDeleteOrderItem.add(lblDeleteOrderItem);
        pnlDiscount.add(cbbDiscount);
        pnlDiscount.add(btnApplyDiscount);
        pnlCustomerId.add(lblCustomerId);
        pnlCustomerId.add(txtCustomerId);
        pnlCustomerId.add(btnSearchCustomerId);
        
        pnlRightInstanceOrder.add(pnlSaveOrder);
        pnlRightInstanceOrder.add(pnlClearOrder);
        pnlRightInstanceOrder.add(pnlDeleteOrderItem);
        pnlRightInstanceOrder.add(pnlDiscount);
        pnlRightInstanceOrder.add(pnlCustomerId);
        //Them bang luu, xoa hoa don vao panel hoa don hien tien
        pnlInstanceOrder.add(pnlRightInstanceOrder);
        //Thêm panel hóa đơn hiện tại
        pnlCreateOrder.add(pnlInstanceOrder);
        
            //Table sản phẩm
        tblProduct.setPreferredSize(new Dimension(0, 1000));
        
        tblProduct.setModel(new DefaultTableModel(
        new Object [][]{},
        new String [] {"ID","Thể loại", "Tên", "Tác giả", "Giá", "Còn lại", "ISBN"}
        ));
        tblProduct.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblProduct.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblProduct.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                showSelectedProduct(evt);
            }
        });
            //Scrollpane chứa tabel sản phẩm
        JScrollPane scrollPane = new JScrollPane(tblProduct);
        scrollPane.setPreferredSize(new Dimension(1100, 300));
        pnlCreateOrder.add(scrollPane);
/* ------------------------------------------------------------------------------------------------ */
        //Tạo panel quản lý hóa đơn
        pnlOrderManager = new JPanel();
        pnlOrderManager.setPreferredSize(new Dimension(1100, 668));
        pnlOrderManager.setBackground(Cl.colorBackground);
        
        //Jpanel chi tiết hóa đơn
        pnlOrderItem.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        pnlOrderItem.setPreferredSize(new Dimension(1120, 270));
        pnlOrderItem.setBackground(Cl.colorBackground);
            //Label hóa đơn
            JLabel lblOrder = new JLabel("Hóa đơn");
            lblOrder.setFont(Cl.fontContentMB);
            lblOrder.setForeground(Cl.colorBlue);
            lblOrder.setHorizontalAlignment(JLabel.CENTER);
            lblOrder.setPreferredSize(new Dimension(550,30));
            //Panel Chi tiết hóa đơn 
            pnlOrderItemLeft.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
            showPnlOrderItem();
            pnlOrderItemLeft.setPreferredSize(new Dimension(550,240));
            
            //Label chi tiết hóa đơn
            JLabel lblOrderItem = new JLabel("Chi tiết");
            lblOrderItem.setFont(Cl.fontContentMB);
            lblOrderItem.setForeground(Cl.colorBlue);
            lblOrderItem.setHorizontalAlignment(JLabel.CENTER);
            lblOrderItem.setPreferredSize(new Dimension(500,30));
            //Table chi tiết hóa đơn
            
            tblOrderItem.setModel(new DefaultTableModel(new Object[][]{}, new String[]{
                "ID","Tên sách","Tác giả","ISBN","#","Giá","Thành tiền"
            }));
            tblOrderItem.setPreferredSize(new Dimension(550,240));
            tblOrderItem.setPreferredScrollableViewportSize(new Dimension(410,240));
            
            tblOrderItem.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblOrderItem.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblOrderItem.getColumnModel().getColumn(2).setPreferredWidth(100);/*
            tblOrderItem.getColumnModel().getColumn(3).setPreferredWidth(100);*/
            tblOrderItem.getColumnModel().getColumn(4).setPreferredWidth(20);
            tblOrderItem.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblOrderItem.getColumnModel().getColumn(6).setPreferredWidth(50);
            
            scrollTblOrderItem.setViewportView(tblOrderItem);
            scrollTblOrderItem.setPreferredSize(new Dimension(500, 240));
            
            //Panel thao tác hóa đơn
            pnlOrderItemControl.setPreferredSize(new Dimension(20,240));
            pnlOrderItemControl.setBackground(Cl.colorBackground);
            
        pnlOrderItem.add(lblOrder);
        pnlOrderItem.add(lblOrderItem);
        pnlOrderItem.add(pnlOrderItemLeft);
        pnlOrderItem.add(scrollTblOrderItem);
        pnlOrderItem.add(pnlOrderItemControl);
        
        //JPanel tìm kiếm
        pnlSearchOrder.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        pnlSearchOrder.setPreferredSize(new Dimension(1100,110));
        pnlSearchOrder.setBackground(Cl.colorBackground);
        pnlSearchOrderCondition.setPreferredSize(new Dimension(900,110));
        pnlSearchOrderCondition.setBackground(Cl.colorBackground);
        showSearchCondition();
        JPanel pnlSearchButton = new JPanel();
        JLabel lblSearchButton = new JLabel("Tìm kiếm", 0);
        lblSearchButton.setForeground(Cl.colorGreen);
        lblSearchButton.setFont(Cl.fontContentMB);
        pnlSearchButton.add(lblSearchButton);
        pnlSearchButton.setBackground(Cl.colorBackground);
        pnlSearchButton.setBorder(Cl.greenLine);
        pnlSearchButton.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e){
            searchOrder();
        }
        public void mouseEntered(MouseEvent e){
            pnlSearchButton.setBackground(Cl.colorGreen);
            lblSearchButton.setForeground(Cl.colorBackground);
        }
        public void mouseExited(MouseEvent e){
            pnlSearchButton.setBackground(Cl.colorBackground);
            lblSearchButton.setForeground(Cl.colorGreen);
        }
        
        });
        cbbLogicOrder.setBackground(Cl.colorBackground);
        cbbLogicOrder.setForeground(Color.white);
        cbbLogicOrder.setPreferredSize(new Dimension(50,34));
        pnlSearchOrder.add(pnlSearchOrderCondition);
        pnlSearchOrder.add(pnlSearchButton);
        pnlSearchOrder.add(cbbLogicOrder);
        //Table hóa đơn
        tblOrder.setPreferredSize(new Dimension(1000, 220));
        tblOrder.setModel(new DefaultTableModel(new Object[][]{}, new String[]{
            "Mã hđ","Khách hàng", "Người bán", "Khuyến mãi", "Ngày lập", "Số lượng sản phẩm", "Tổng"
        }));
        tblOrder.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                showLblOrderItemLeftValue();
                showTblOrderItem();
            }
        });
        
        scrollTblOrder.setViewportView(tblOrder);
        scrollTblOrder.setPreferredSize(new Dimension(900,230));
        
        JPanel pnlTblOrder = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        pnlTblOrder.setPreferredSize(new Dimension(1100,230));
        pnlTblOrder.setBackground(Cl.colorBackground);
        //Panel thao tác hóa đơn
        JPanel pnlOrderControl = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlOrderControl.setPreferredSize(new Dimension(110, 230));
        pnlOrderControl.setBackground(Cl.colorBackground);
        
        btnExportExcel.setFont(Cl.fontContentMB);
        btnExportExcel.setForeground(Cl.colorGreen);
        btnExportExcel.setPreferredSize(new Dimension(100, 30));
        btnExportExcel.setBackground(Cl.colorBackground);
        btnExportExcel.setBorder(Cl.greenLine);
        pnlOrderControl.add(btnExportExcel);
        
        pnlTblOrder.add(scrollTblOrder);
        pnlTblOrder.add(pnlOrderControl);
        
        pnlOrderManager.add(pnlOrderItem);
        pnlOrderManager.add(pnlSearchOrder);
        pnlOrderManager.add(pnlTblOrder);
        //
        tabbedPane.addTab("Thêm hóa đơn", null, pnlCreateOrder, "Thêm hóa đơn");
        tabbedPane.addTab("Quản lý hóa đơn",null,pnlOrderManager,"Quản lý hóa đơn");

        pnlMainPanel.add(tabbedPane, BorderLayout.CENTER);
        
        //Bat su kien cho button applyDiscount
        btnApplyDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                    showTotalValueOrder();
            }
        });
        pnlSaveOrder.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                saveOrder(evt);
                repaintAllTable();
            }
            public void mouseEntered(MouseEvent evt){
                 pnlSaveOrder.setBackground(Cl.colorBlue);
                 lblSaveOrder.setForeground(Cl.colorBackground);
             }
             public void mouseExited(MouseEvent evt){
                  pnlSaveOrder.setBackground(Cl.colorBackground);
                  lblSaveOrder.setForeground(Cl.colorBlue);
             }
        });
        pnlClearOrder.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                clearOrder(evt);
            }
            public void mouseEntered(MouseEvent evt){
                 pnlClearOrder.setBackground(Cl.colorBlue);
                 lblClearOrder.setForeground(Cl.colorBackground);
             }
             public void mouseExited(MouseEvent evt){
                  pnlClearOrder.setBackground(Cl.colorBackground);
                  lblClearOrder.setForeground(Cl.colorBlue);
             }
        });
        pnlDeleteOrderItem.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                deleteSelectedOrderItem(evt);
            }
            public void mouseEntered(MouseEvent evt){
                 pnlDeleteOrderItem.setBackground(Cl.colorBlue);
                 lblDeleteOrderItem.setForeground(Cl.colorBackground);
             }
             public void mouseExited(MouseEvent evt){
                  pnlDeleteOrderItem.setBackground(Cl.colorBackground);
                  lblDeleteOrderItem.setForeground(Cl.colorBlue);
             }
        });
        btnExportExcel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                 ExcelPOI.writeFileExcel(tblOrder);
            }
            public void mouseEntered(MouseEvent evt){
                btnExportExcel.setBackground(Cl.colorGreen);
                btnExportExcel.setForeground(Cl.colorBackground);
            }
            public void mouseExited(MouseEvent evt){
                btnExportExcel.setBackground(Cl.colorBackground);
                btnExportExcel.setForeground(Cl.colorGreen);
            }
        });
        //Hàm tô màu cho tất cả table
        showColorTable();
        modelTblProduct = (DefaultTableModel) tblProduct.getModel();
        modelTblOrderdetail = (DefaultTableModel) tblOrderDetail.getModel();
        modelTblOrder = (DefaultTableModel) tblOrder.getModel();
        modelTblOrderItem = (DefaultTableModel) tblOrderItem.getModel();
        showTableProduct();
        showTableOrder();
        return pnlMainPanel;
    }
    //Methods tab add order manager
    public void showTableProduct() {
        modelTblProduct.setRowCount(0);
        try {
            bookListGlobal = this.busBook.getBook();
            Genre genre;
            Author author;
            for (Iterator<Book> obj = bookListGlobal.iterator(); obj.hasNext();) {
                Book book=obj.next();
                genre = busGenre.getGenreByBookId(book.getBook_id());
                author = busAuthor.getAuthorByBookId(book.getBook_id());
                modelTblProduct.addRow(new Object[]{
                    //ảnh & id
                    book.getBook_id(),
                    //loại sách
                    genre.getName(),
                    //tên
                    book.getTitle(),
                    //tác giả
                    author.getFirst_name()+" "+author.getLast_name(),
                    //giá
                    book.getPrice(),
                    //còn lại
                    book.getAvailable_quantity(),
                    //isbn
                    book.getIsbn(),
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void showSelectedProduct(MouseEvent evt){
        int selectedRowIndex = tblProduct.getSelectedRow();
        lblBookId.setText("ID ");
        lblBookId.setForeground(Color.white);
        lblBookGenre.setText("Thể loại");
        lblBookGenre.setForeground(Color.white);
        lblBookName.setText("Tên");
        lblBookName.setForeground(Color.white);
        lblBookAuthor.setText("Tác giả");
        lblBookAuthor.setForeground(Color.white);
        lblBookPrice.setText("Giá");
        lblBookPrice.setForeground(Color.white);
        lblBookQuantity.setText("Số lượng");
        lblBookQuantity.setForeground(Color.white);
        lblISBN.setText("ISBN");
        lblISBN.setForeground(Color.white);
        
        //Lấy book từ id
        try {
            selectedBookGlobal = busBook.getBookById(Integer.parseInt(tblProduct.getValueAt(selectedRowIndex, 0).toString()));
            ImageIcon iiconBook = loadIcon("src/images/" + selectedBookGlobal.getImage(), 200, 300);
            lblBookImg.setIcon(iiconBook);
            lblBookIdValue.setText(selectedBookGlobal.getBook_id() + "");
            
            lblBookGenreValue.setText(busGenre.getGenreNameByBookId(selectedBookGlobal.getBook_id()));
            lblBookNameValue.setText(selectedBookGlobal.getTitle());
            lblBookAuthorValue.setText(busAuthor.getAuthorNameById(selectedBookGlobal.getAuthor_id()));
            lblBookPriceValue.setText(selectedBookGlobal.getPrice()+"");
            txtBookQuantity.setText("1");
            lblISBNValue.setText(selectedBookGlobal.getIsbn());
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        txtBookQuantity.addKeyListener(new KeyListener() {
            String keyPressed, instanceString;
            @Override
            public void keyTyped(KeyEvent evt) {
            }

            @Override
            public void keyPressed(KeyEvent evt) {
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                System.out.println(KeyEvent.getKeyText(evt.getKeyCode()));
                keyLockOnlyNumberInLimit(evt, Integer.parseInt(tblProduct.getValueAt(selectedRowIndex, 5).toString()));
            }
        });
        


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
    public void keyLockOnlyNumberInLimit(KeyEvent evt, int limit){
        String keyRealeased = KeyEvent.getKeyText(evt.getKeyCode());
        Pattern patern = Pattern.compile("\\d{1,2}");
        //Trường hợp ký tự vừa nhập vào là ký tự không hiển thị
        String[] specialChar = {"Caps Lock","Alt","Num Lock","Backspace","Windows",
            "Escape","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12",
            "Scroll Lock","Pause","Insert","Home","Page Up","Delete","End","Page Down","Left","Up",
            "Down","Right","Enter","Ctrl","Begin","Shift"
        };
        for(String temp:specialChar){
            if(keyRealeased == temp)
                return;
        }
        //Kiểm tra ký tự đã realeased bằng Regex || Số lượng mua vượt quá số lượng có sẵn
        if(!patern.matcher(keyRealeased).matches() || Integer.parseInt(txtBookQuantity.getText()) > limit )
        {   
            txtBookQuantity.setText(txtBookQuantity.getText().substring(0,txtBookQuantity.getText().length()-1));
            if(txtBookQuantity.getText().length()==0){
                txtBookQuantity.setText("1");
            }
        }

    }
    public void showTblOrderDetail() {
        try {
            // Nếu sản phẩm không tồn tại, hoặc có số lượng = 0, hoặc không điền số lượng
            if (lblBookImg.getIcon() == null || txtBookQuantity.getText().equalsIgnoreCase("0") || txtBookQuantity.getText().equalsIgnoreCase("")) {
                return;
            }
            int quantity = Integer.parseInt(txtBookQuantity.getText());
            int price = selectedBookGlobal.getPrice() * Integer.parseInt(txtBookQuantity.getText());
            //Trường hợp xét từng sản phẩm trong list trùng với sản phẩm đang chọn
            if (!orderItemListGlobal.isEmpty()) {
                for (OrderItem orderItem : orderItemListGlobal) {
                    if (orderItem.getBook_id() == selectedBookGlobal.getBook_id()) {
                        orderItem.setQuantity(quantity);
                        orderItem.setPrice(price);
                        modelTblOrderdetail.setRowCount(0);
                        for (OrderItem ODItem : orderItemListGlobal) {
                            Book bookTemp = busBook.getBookById(ODItem.getBook_id());
                            modelTblOrderdetail.addRow(new Object[]{
                                ODItem.getBook_id(),
                                bookTemp.getTitle(),
                                bookTemp.getPrice(),
                                ODItem.getQuantity(),
                                ODItem.getPrice()
                            });
                        }
                        showTotalValueOrder();
                        return;
                    }
                }
            }
            //Truong hop trống hoac có sản phẩm mới được thêm
            OrderItem newOrderItem = new OrderItem(0, selectedBookGlobal.getBook_id(), quantity, price);
            orderItemListGlobal.add(newOrderItem);
            Book bookTemp = busBook.getBookById(newOrderItem.getBook_id());
            modelTblOrderdetail.addRow(new Object[]{
                newOrderItem.getBook_id(),
                bookTemp.getTitle(),
                bookTemp.getPrice(),
                newOrderItem.getQuantity(),
                newOrderItem.getPrice()
            });
            showTotalValueOrder();
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public DefaultComboBoxModel showCbbDiscount(){
        DefaultComboBoxModel modelCbb = new DefaultComboBoxModel();
        try {
            discountListGlobal = busDiscount.getDiscount();
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modelCbb.addElement("0. Không áp mã");
        //Thêm khuyến mãi vào combo box
        for(Discount temp:discountListGlobal){
            modelCbb.addElement(temp.getDiscount_id()+". "+temp.getDiscount_name());
        }
        return modelCbb;
    }
    public void showTotalValueOrder() {
        applyDiscount();
        int sum = 0 ;
        int discount = 0;
        for (OrderItem orderItem : orderItemListGlobal) {
            sum += orderItem.getPrice();
            System.out.println("SUM: "+sum);
            if (selectedDiscountGolbal.getDiscount_id() != 0 && selectedDiscountGolbal.getDiscount_type()<=sum) {
                for (DiscountDetail dcDetail : discountDetailListGlobal) {
                    if (orderItem.getBook_id() == dcDetail.getBook_id()) {
                        //Công thức: giá tiền x số lượng x phần trăm giảm
                        discount += (dcDetail.getPercent() * orderItem.getPrice() * orderItem.getQuantity()) / 100;
                    }
                }
            }
        }
        lblTotalPriceOrderBefDisValue.setText(""+sum);
        lblTotalValueDiscountValue.setText(""+discount);
        lblTotalPriceOrderValue.setText(""+(sum-discount)+" vnđ");
    }
    public void applyDiscount(){
        String temp = cbbDiscount.getSelectedItem().toString();
        int selectedDiscountId = Integer.parseInt(temp.substring(0, temp.indexOf(". ")));
        // Nếu không chọn mã giảm giá thì set id giảm giá đang chọn bằng 0
        if(selectedDiscountId==0){
            selectedDiscountGolbal.setDiscount_id(0);
            lblTotalValueDiscountValue.setText("Không có mã giảm giá.");
            return;
        }
        try {
            //Lấy discount hiện tại
            selectedDiscountGolbal = busDiscount.getDiscountBtId(selectedDiscountId);
            System.out.println(selectedDiscountGolbal.toString());
            //Lấy danh sách chi tiết discount hiện tại
            discountDetailListGlobal = busDiscountDetail.getDiscountDetailsById(selectedDiscountGolbal.getDiscount_id());
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showNSearchCustomer(ActionEvent e) {
        JFrame findCustomer = new JFrame("Tìm khách hàng");
        JTextField txtSearch = new JTextField();
        JButton btnSearch = new JButton("Tìm");
        DefaultTableModel modelTblCustomer = new DefaultTableModel(new Object[][]{}, new String[]{
            "ID", "Tên", "SĐT"
        });
        JTable tblCustomer = new JTable(modelTblCustomer);
        JButton btnChose = new JButton("Chọn");
        findCustomer.setSize(340, 340);
        txtSearch.setPreferredSize(new Dimension(150, 30));
        btnSearch.setPreferredSize(new Dimension(60, 30));
        btnChose.setPreferredSize(new Dimension(100, 30));
        findCustomer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        BUSGetCustomer busCustomer = new BUSGetCustomer();
        ArrayList<Customer> customerList = new ArrayList<>();
        try {
            if(txtSearch.getText()!=""){
                String partent = txtSearch.getText();
                String condition = "customer_id LIKE '%"+partent+"%' OR first_name LIKE '%"+partent+"%' OR last_name LIKE '%"+partent+"%' OR phone_number LIKE '%"+partent+"%'";
                customerList = busCustomer.getCustomer();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Customer cus: customerList){
            modelTblCustomer.addRow(new Object[]{
                cus.getCustomer_id(),
                cus.getFirst_name()+cus.getLast_name(),
                cus.getPhone_number()
            });
        }
        
        tblCustomer.setPreferredSize(new Dimension(300, 500));
        JScrollPane scrollForTblCustomer = new JScrollPane(tblCustomer);
        scrollForTblCustomer.setPreferredSize(new Dimension(300, 200));
        findCustomer.add(txtSearch);
        findCustomer.add(btnSearch);
        findCustomer.add(scrollForTblCustomer);
        findCustomer.add(btnChose);
        
        findCustomer.setLocationRelativeTo(btnSearchCustomerId);
        findCustomer.setVisible(true);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelTblCustomer.setRowCount(0);
                String condition = "1";
                String partent = txtSearch.getText();
                if(partent!=""){
                    condition = "customer_id LIKE '%" + partent 
                            +"%' OR first_name LIKE '%" + partent 
                            +"%' OR last_name LIKE '%" + partent
                            +"%' OR phone_number LIKE '%" + partent + "%'";
                }
                
                try {
                    customerListGlobal = busCustomer.getCustomer(condition);
                } catch (Exception ex) {
                    Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                for(Customer cus: customerListGlobal){
                    modelTblCustomer.addRow(new Object[]{
                        cus.getCustomer_id(),
                        cus.getFirst_name()+cus.getLast_name(),
                        cus.getPhone_number()
                    });
                }
                
            }
        });
        btnChose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String customerIdFound = tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0).toString();
                    selectedCustomerGlobal = busCustomer.getCustomerById(Integer.parseInt(customerIdFound));
                    txtCustomerId.setText(selectedCustomerGlobal.getCustomer_id()+"");
                    findCustomer.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void saveOrder(MouseEvent evt){
        Order orderForInsert;
        
        int order_id = 0;
        String customer_id;
        if(txtCustomerId.getText().equals("")){
                    customer_id = "0";
        } else {
            customer_id = txtCustomerId.getText();
        }
        String order_date = dateFormatter.format(today);
        String total = lblTotalPriceOrderValue.getText().substring(0, lblTotalPriceOrderValue.getText().indexOf("vnđ")-1);
        orderForInsert = new Order(staff.getStaff_id(), selectedDiscountGolbal.getDiscount_id(), Integer.parseInt(customer_id), order_date, Integer.parseInt(total));
        System.out.println(orderForInsert.toString());
        int isConfirm = JOptionPane.showConfirmDialog(null, "Xác nhận tạo hóa đơn?", "Alert", JOptionPane.YES_NO_OPTION);
        if(isConfirm == JOptionPane.NO_OPTION){
            return;
        }
        try {
            busOrder.inserts(orderForInsert);
            //Lấy ra id của order vừa insert
            order_id = busOrder.getLastOrderId();
            System.out.println("Thêm thành công");
            //Set lại order id cho từng order item và thêm vào order_item
            for (OrderItem orderItem : orderItemListGlobal) {
                System.out.println(orderItem);
                orderItem.setOrder_id(order_id);
                System.out.println(orderItem);
                busOrderItem.inserts(orderItem);
                //Update lại số sản phẩm tồn kho
                Book bookForUpdate = busBook.getBookById(orderItem.getBook_id());
                bookForUpdate.setAvailable_quantity(bookForUpdate.getAvailable_quantity()-orderItem.getQuantity());
                busBook.updates(bookForUpdate);
            }
            
            
        JOptionPane.showMessageDialog(null, "Thêm hóa đơn thành công");
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void clearOrder(MouseEvent evt){
        orderItemListGlobal.clear();
        modelTblOrderdetail.setRowCount(0);
        showTotalValueOrder();
    }
    public void deleteSelectedOrderItem(MouseEvent evt){
        int selectedRow = tblOrderDetail.getSelectedRow();
        if(selectedRow<0)
            return;
        orderItemListGlobal.remove(selectedRow);
        modelTblOrderdetail.removeRow(selectedRow);
        showTotalValueOrder();
    }
    
    // Methods tab Order manager
    public void showTableOrder(){
        try {
            modelTblOrder.setRowCount(0);
            orderListGolbal = busOrder.getOrder();
            for(Order order: orderListGolbal){
                Customer cus = busCustomer.getCustomerById(order.getCustomer_id());
                Staff staff = busStaff.getStaffById(order.getStaff_id());
                Discount discount = busDiscount.getDiscountBtId(order.getDiscount_id());
                ArrayList<OrderItem> orderItemList = busOrderItem.getOrderItemById(order.getOrder_id());
                int sumQuantity = 0;
                for(OrderItem orderItem : orderItemList){
                    sumQuantity += orderItem.getQuantity();
                }
                modelTblOrder.addRow(new Object[]{
                    order.getOrder_id(),
                    cus.getFirst_name()+" "+cus.getLast_name(),
                    staff.getName(),
                    discount.getDiscount_name(),
                    order.getOrder_date(),
                    sumQuantity,
                    order.getTotal()
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showPnlOrderItem(){
        for(int i=0; i<namePnlOrderItem.length; i++){
            pnlOrderItemArray[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
            pnlOrderItemArray[i].setPreferredSize(new Dimension(550, 30));
            pnlOrderItemArray[i].setBackground(Cl.colorBackground);
            JLabel lblName = new JLabel(namePnlOrderItem[i]);
            lblName.setFont(Cl.fontContentM);
            lblName.setForeground(Color.white);
            pnlOrderItemArray[i].add(lblName);
            lblPnlOrderItemValue[i] = new JLabel();
            lblPnlOrderItemValue[i].setFont(Cl.fontContentMB);
            lblPnlOrderItemValue[i].setForeground(Color.white);
            pnlOrderItemArray[i].add(lblPnlOrderItemValue[i]);
            pnlOrderItemLeft.add(pnlOrderItemArray[i]);
        }
    }
    public void showLblOrderItemLeftValue(){
        try {
            int selectedRowIndex = tblOrder.getSelectedRow();
            selectedOrderGolbal = busOrder.getOrderById(Integer.parseInt(tblOrder.getValueAt(selectedRowIndex, 0).toString()));
            ArrayList<OrderItem> selectedOrderItemList = busOrderItem.getOrderItemById(selectedOrderGolbal.getOrder_id());
            int sumQuantity=0, sumPrice = 0;
            for(OrderItem temp : selectedOrderItemList){
                sumQuantity += temp.getQuantity();
                sumPrice += temp.getPrice();
            }
            Customer cus = busCustomer.getCustomerById(selectedOrderGolbal.getCustomer_id());
            Staff staff = busStaff.getStaffById(selectedOrderGolbal.getStaff_id());
            Discount discount = busDiscount.getDiscountBtId(selectedOrderGolbal.getDiscount_id());
            lblPnlOrderItemValue[0].setText(selectedOrderGolbal.getOrder_id()+"");
            lblPnlOrderItemValue[1].setText(selectedOrderGolbal.getCustomer_id()+", "+cus.getFirst_name()+" "+cus.getLast_name()+", "+cus.getAddress()+", "+cus.getPhone_number());
            lblPnlOrderItemValue[2].setText(selectedOrderGolbal.getStaff_id()+", "+staff.getName()+", "+staff.getPhone_number());
            lblPnlOrderItemValue[3].setText(selectedOrderGolbal.getDiscount_id()+", "+discount.getDiscount_name()+", "+discount.getStart_date()+" đến "+discount.getEnd_date());
            lblPnlOrderItemValue[4].setText(selectedOrderGolbal.getOrder_date());
            lblPnlOrderItemValue[5].setText(sumQuantity+"");
            lblPnlOrderItemValue[6].setText(sumPrice+" đ "+"( -"+(sumPrice-selectedOrderGolbal.getTotal())+"đ ).");
            lblPnlOrderItemValue[7].setText(selectedOrderGolbal.getTotal()+" đ");
            
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showTblOrderItem() {
       try{
            selectedOrderItem = busOrderItem.getOrderItemById(selectedOrderGolbal.getOrder_id());
            modelTblOrderItem.setRowCount(0);
            for (OrderItem oi : selectedOrderItem) {
                Book bookTemp = busBook.getBookById(oi.getBook_id());
                Author authorTemp = busAuthor.getAuthorByBookId(bookTemp.getBook_id());
                modelTblOrderItem.addRow(new Object[]{
                    oi.getBook_id(),
                    bookTemp.getTitle(),
                    authorTemp.getFirst_name()+" "+authorTemp.getLast_name(),
                    bookTemp.getIsbn(),
                    oi.getQuantity(),
                    bookTemp.getPrice(),
                    oi.getPrice(),});
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showSearchCondition(){
        //Them combo box 
    cbbLogicOrder.addItem("AND");
    cbbLogicOrder.addItem("OR");
    cbbLogicOrder.setPreferredSize(new Dimension(55,20));
        //Thêm Panel điều kiện search; thiết lập giá trị và sự kiện cho từng text field,button theo mảng String[] namePnlSearch
        for(int i=0; i<namePnlSearch.length; i++){
            pnlSearchConditionArray[i] = new JPanel();
            pnlSearchConditionArray[i].setBackground(Cl.colorBackground);
            Border borderSearch = BorderFactory.createTitledBorder(Cl.blueLine, namePnlSearch[i], 2, 0, Cl.fontContentS, Cl.colorBlue);
            pnlSearchConditionArray[i].setBorder(borderSearch);
            pnlSearchConditionArray[i].setPreferredSize(new Dimension(200, 50));
            
            txtSearchConditionArray[i].setPreferredSize(new Dimension(110,20));
            txtSearchConditionArray[i].setBorder(Cl.whiteLine);
            btnSearchConditonArray[i].setPreferredSize(new Dimension(20,20));
            btnSearchConditonArray[i].setBackground(Cl.colorBackground);
            btnSearchConditonArray[i].setBorder(Cl.blueLine);
            btnSearchConditonArray[i].setForeground(Cl.colorBlue);
            JButton btnTemp = btnSearchConditonArray[i];
            JTextField txtTemp = txtSearchConditionArray[i];
            String strTemp = namePnlSearch[i];
            btnSearchConditonArray[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showDialogSearch(btnTemp, txtTemp, strTemp);
                }
            });
            pnlSearchConditionArray[i].add(txtSearchConditionArray[i]);
            pnlSearchConditionArray[i].add(btnSearchConditonArray[i]);
            
            pnlSearchOrderCondition.add(pnlSearchConditionArray[i]);
        }
        //Search theo ngay lap
        displayOrderDateCondition();
    }
    public void displayOrderDateCondition(){
        Border borderSearch = BorderFactory.createTitledBorder(Cl.blueLine, "Ngày lập", 0, 0, Cl.fontContentS, Cl.colorBlue);
        JPanel pnlSearchConditionOrderdate = new JPanel();
        pnlSearchConditionOrderdate.setBorder(borderSearch);
        pnlSearchConditionOrderdate.setBackground(Cl.colorBackground);
        pnlSearchConditionOrderdate.setPreferredSize(new Dimension(300,50));

        txtSearchOrderDateBef.setPreferredSize(new Dimension(90, 20));
        txtSearchOrderDateBef.setBorder(Cl.whiteLine);
        btnSearchOrderDateBef.setPreferredSize(new Dimension(20,20));
        btnSearchOrderDateBef.setBorder(Cl.blueLine);
        btnSearchOrderDateBef.setBackground(Cl.colorBackground);
        btnSearchOrderDateBef.setForeground(Cl.colorBlue);
        pnlSearchConditionOrderdate.add(txtSearchOrderDateBef);
        pnlSearchConditionOrderdate.add(btnSearchOrderDateBef);
        
        txtSearchOrderDateAft.setPreferredSize(new Dimension(90, 20));
        txtSearchOrderDateAft.setBorder(Cl.whiteLine);
        btnSearchOrderDateAft.setPreferredSize(new Dimension(20,20));
        btnSearchOrderDateAft.setBackground(Cl.colorBackground);
        btnSearchOrderDateAft.setBorder(Cl.blueLine);
        btnSearchOrderDateAft.setForeground(Cl.colorBlue);
        pnlSearchConditionOrderdate.add(txtSearchOrderDateAft);
        pnlSearchConditionOrderdate.add(btnSearchOrderDateAft);
        
        pnlSearchOrderCondition.add(pnlSearchConditionOrderdate);
        btnSearchOrderDateBef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSearchOrderDateBef.setText( new DatePicker(btnSearchOrderDateBef).setPickedDateYearMonthDate());
            }
        });
        btnSearchOrderDateAft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSearchOrderDateAft.setText( new DatePicker(btnSearchOrderDateAft).setPickedDateYearMonthDate());
            }
        });
    }
    public void showDialogSearch(JButton btnParent, JTextField txtTarget, String searchBy) {
        //Tạo dialog xuất hiện theo btnParent, Tùy vào điều kiện condition mà dialog load table khác nhau nhờ hàm loadDataForSearch
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        JPanel bg = new JPanel(new BorderLayout());
        bg.setPreferredSize(new Dimension(300, 150));

        JPanel pnlSearch = new JPanel();

        JTextField txtSearch = new JTextField();
        txtSearch.setPreferredSize(new Dimension(50, 20));
        JButton btnSearch = new JButton("Tìm");
        

        pnlSearch.add(txtSearch);
        pnlSearch.add(btnSearch);

        JTable tblSearch = new JTable();
        JScrollPane srollSearch = new JScrollPane(tblSearch);
        //Load data cho table
        loadDataForSearch(tblSearch, searchBy, "");
        
        JButton btnChose = new JButton("Chọn");
        btnChose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Đặt giá trị đầu tiên vào ô tìm kiếm
                int selectedRowIndex = tblSearch.getSelectedRow();
                txtTarget.setText(tblSearch.getValueAt(selectedRowIndex, 0).toString());
                dialog.dispose();
            }
        });
        bg.add(pnlSearch, BorderLayout.NORTH);
        bg.add(srollSearch, BorderLayout.CENTER);
        bg.add(btnChose, BorderLayout.SOUTH);
        //search
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String condition = txtSearch.getText();
                loadDataForSearch(tblSearch, searchBy, condition);
            }
        });
        dialog.add(bg);
        dialog.pack();
        dialog.setLocationRelativeTo(btnParent);
        dialog.setVisible(true);
        

    }
    public void loadDataForSearch(JTable table, String searchBy ,String condition) {
        //Tùy vào điều điện conditon mà kích hoạt các case khác nhau, condition dựa trên String[] namePnlSearch
        try {
            DefaultTableModel model;
            switch (searchBy) {
                case "Mã hóa đơn":
                    table.setPreferredScrollableViewportSize(new Dimension(100, 100));
                    table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"ID"}));
                    model = (DefaultTableModel) table.getModel();
                    ArrayList<Order> orderList = new ArrayList<>();
                    if(condition.equals("")){
                        orderList = busOrder.getOrder();
                    } else {
                        orderList = busOrder.getOrderBySearchLikeId(Integer.parseInt(condition));
                    }
                    model.setRowCount(0);
                    for (Order obj : orderList) {
                        model.addRow(new Object[]{obj.getOrder_id()});
                    }
                    break;
                case "Khách hàng":
                    table.setPreferredScrollableViewportSize(new Dimension(100, 100));
                    table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Tên"}));
                    model = (DefaultTableModel) table.getModel();
                    ArrayList<Customer> customerList = new ArrayList<>();
                    if(condition.equals("")){
                        customerList = busCustomer.getCustomer();
                    } else {
                        customerList = busCustomer.getCustomerBySearchLikeIdName(condition);
                    }
                    model.setRowCount(0);
                    for (Customer obj : customerList) {
                        model.addRow(new Object[]{obj.getCustomer_id(), obj.getFirst_name() +" "+ obj.getLast_name()});
                    }
                    break;
                case "Người bán":
                    table.setPreferredScrollableViewportSize(new Dimension(100, 100));
                    table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Tên"}));
                    model = (DefaultTableModel) table.getModel();
                    ArrayList<Staff> staffList = new ArrayList<>();
                    if(condition.equals("")){
                        staffList = busStaff.getStaff();
                    } else {
                        staffList = busStaff.getStaffBySearchLikeIdName(condition);
                    }
                    model.setRowCount(0);
                    for (Staff obj : staffList) {
                        model.addRow(new Object[]{obj.getStaff_id(), obj.getName()});
                    }
                    break;
                case "Sách":
                    table.setPreferredScrollableViewportSize(new Dimension(100, 100));
                    table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Tên"}));
                    model = (DefaultTableModel) table.getModel();
                    ArrayList<Book> bookList = new ArrayList<>();
                    if(condition.equals("")){
                        bookList = busBook.getBook();
                    } else {
                        bookList = busBook.getBookBySearchLikeIdName(condition);
                    }
                    model.setRowCount(0);
                    for (Book obj : bookList) {
                        model.addRow(new Object[]{obj.getBook_id(), obj.getTitle()});
                    }
                    break;
                case "Tác giả":
                    table.setPreferredScrollableViewportSize(new Dimension(100, 100));
                    table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Tên"}));
                    model = (DefaultTableModel) table.getModel();
                    ArrayList<Author> authorList = new ArrayList<>();
                    if(condition.equals("")){
                        authorList = busAuthor.getAuthor();
                    } else {
                        authorList = busAuthor.getAuthorBySearchLikeIdName(condition);
                    }
                    model.setRowCount(0);
                    for (Author obj : authorList) {
                        model.addRow(new Object[]{obj.getAuthor_id(), obj.getFirst_name()+" "+obj.getLast_name()});
                    }
                    break;
                case "Khuyến mãi áp dụng":
                    table.setPreferredScrollableViewportSize(new Dimension(100, 100));
                    table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Tên", "Loại"}));
                    model = (DefaultTableModel) table.getModel();
                    ArrayList<Discount> discountList = new ArrayList<>();
                    if(condition.equals("")){
                        discountList = busDiscount.getDiscount();
                    } else {
                        discountList = busDiscount.getDiscountBySearchLikeIdNameType(condition);
                    }
                    model.setRowCount(0);
                    for (Discount obj : discountList) {
                        model.addRow(new Object[]{obj.getDiscount_id(), obj.getDiscount_name(), obj.getDiscount_type()});
                    }
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void searchOrder(){
        try {
            String orderIdPatern = txtSearchOrderId.getText();
            String customerPatern = txtSearchCustomer.getText();
            String staffPatern = txtSearchStaff.getText();
            String bookPatern = txtSearchBook.getText();
            String authorPatern = txtSearchAuthor.getText();
            String discountPatern = txtSearchDiscount.getText();
            String orderDateBef = txtSearchOrderDateBef.getText();
            String orderDateAft = txtSearchOrderDateAft.getText();
            
            //Truong hop tat ca dieu kien search deu trong
            if(orderIdPatern.equals("") && customerPatern.equals("") &&  staffPatern.equals("") && bookPatern.equals("") && authorPatern.equals("") && authorPatern.equals("") && orderDateBef.equals("") && orderDateAft.equals("")){
                modelTblOrder.setRowCount(0);
                showTableOrder();
                return;
            }

            modelTblOrder.setRowCount(0);
            String logic = cbbLogicOrder.getSelectedItem().toString();
            ArrayList<Order> resultOrderSearchList = busOrder.searchOrder(logic,orderIdPatern, customerPatern, staffPatern, bookPatern, authorPatern, discountPatern, orderDateBef, orderDateAft);
            for(Order order: resultOrderSearchList){
                Customer cus = busCustomer.getCustomerById(order.getCustomer_id());
                Staff staff = busStaff.getStaffById(order.getStaff_id());
                Discount discount = busDiscount.getDiscountBtId(order.getDiscount_id());
                ArrayList<OrderItem> orderItemList = busOrderItem.getOrderItemById(order.getOrder_id());
                int sumQuantity = 0;
                for (OrderItem orderItem : orderItemList) {
                    sumQuantity += orderItem.getQuantity();
                }
                Object temp[] = {
                    order.getOrder_id(),
                    cus.getFirst_name() + " " + cus.getLast_name(),
                    staff.getName(),
                    discount.getDiscount_name(),
                    order.getOrder_date(),
                    sumQuantity,
                    order.getTotal()
                };
                modelTblOrder.addRow(temp);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public JTable[] showColorTable(){
        for(int i=0; i<TableArray.length; i++){
            TableArray[i].setRowHeight(30);
            TableArray[i].setBackground(Cl.colorBackground);
            TableArray[i].setForeground(Color.white);
            TableArray[i].setGridColor(Color.DARK_GRAY);
            TableArray[i].setSelectionForeground(Cl.colorBlue);
            TableArray[i].setSelectionBackground(Cl.colorBackground);
            TableArray[i].getTableHeader().setBackground(Cl.colorBackground);
            TableArray[i].getTableHeader().setForeground(Cl.colorBlue);
            TableArray[i].getTableHeader().setFont(Cl.fontContentMB);
        }
        return TableArray;
    }
    public void repaintAllTable(){
        this.showTableOrder();
        this.showTableProduct();
        this.showTblOrderDetail();
        this.showTblOrderItem();
        this.showTotalValueOrder();
    }
    // Components tab order manager
    // Sản phẩm được chọn
    JLabel lblBookImg = new JLabel();
    JLabel lblBookId = new JLabel();
    JLabel lblBookGenre = new JLabel();
    JLabel lblBookName = new JLabel();
    JLabel lblBookAuthor = new JLabel();
    JLabel lblBookPrice = new JLabel();
    JLabel lblBookQuantity = new JLabel();
    JLabel lblISBN = new JLabel();
    JLabel lblSelectedBookArray[] = {lblBookId, lblBookGenre, lblBookName, lblBookAuthor, lblBookPrice, lblBookQuantity, lblISBN};
    
    JLabel lblBookIdValue = new JLabel();
    JLabel lblBookGenreValue  = new JLabel();
    JLabel lblBookNameValue  = new JLabel();
    JLabel lblBookAuthorValue  = new JLabel();
    JLabel lblBookPriceValue  = new JLabel();
    JTextField txtBookQuantity = new JTextField();
    JLabel lblISBNValue  = new JLabel();
    JLabel lblSelectedBookValueArray[] = {lblBookIdValue, lblBookGenreValue, lblBookNameValue, lblBookAuthorValue, lblBookPriceValue, lblISBNValue};
     // End sản phẩm được chọn
    
    JScrollPane scrollTblOrderDetail;
    
    JPanel pnlSaveOrder = new JPanel();
    JPanel pnlClearOrder = new JPanel();
    JPanel pnlDeleteOrderItem = new JPanel();
    JPanel pnlDiscount = new JPanel();
    JPanel pnlCustomerId = new JPanel();
    JLabel lblSaveOrder = new JLabel("Lưu");
    JLabel lblClearOrder = new JLabel("Xóa hết");
    JLabel lblDeleteOrderItem = new JLabel("Xóa");
    JComboBox<Object> cbbDiscount = new JComboBox<>();
    DefaultComboBoxModel<Object> modelCbbDiscount = new DefaultComboBoxModel<>();
    JButton btnApplyDiscount = new JButton("Áp mã");
    JLabel lblCustomerId = new JLabel("ID khach:");
    JTextField txtCustomerId = new JTextField();
    JButton btnSearchCustomerId = new JButton("S");
    
    //Components tab order manager
    JPanel pnlOrderItem = new JPanel();
        //Panel chi tiết hóa đơn
    JPanel pnlOrderItemLeft = new JPanel();
    String[] namePnlOrderItem = {"Mã hóa đơn:","Khách hàng:","Người bán:","Khuyến mãi:","Ngày lập:","Số lượng:","Trước khuyến mãi:","Tổng:"};
    JLabel[] lblPnlOrderItemValue = new JLabel[namePnlOrderItem.length];
    JPanel[] pnlOrderItemArray = new JPanel[namePnlOrderItem.length];
        //Table chi tiết hóa đơn
    DefaultTableModel modelTblOrderItem = new DefaultTableModel();
    JTable tblOrderItem = new JTable();
    JScrollPane scrollTblOrderItem = new JScrollPane();
        //Panel thao tác hóa đơn
    JPanel pnlOrderItemControl = new JPanel();
    JButton btnExportExcel = new JButton("Báo cáo");
        //Panel tìm kiếm
    String[] namePnlSearch = {"Mã hóa đơn", "Khách hàng", "Người bán", "Sách", "Tác giả" , "Khuyến mãi áp dụng"};
    JTextField txtSearchOrderId = new JTextField();
    JTextField txtSearchCustomer = new JTextField();
    JTextField txtSearchStaff = new JTextField();
    JTextField txtSearchBook = new JTextField();
    JTextField txtSearchAuthor = new JTextField();
    JTextField txtSearchDiscount = new JTextField();
    JTextField txtSearchOrderDateBef = new JTextField();
    JTextField txtSearchOrderDateAft = new JTextField();
    JTextField[] txtSearchConditionArray = {txtSearchOrderId,txtSearchCustomer,txtSearchStaff,txtSearchBook,txtSearchAuthor,txtSearchDiscount};
    JButton btnSearchOrderId = new JButton("...");
    JButton btnSearchCustomer = new JButton("...");
    JButton btnSearchStaff = new JButton("...");
    JButton btnSearchBook = new JButton("...");
    JButton btnSearchAuthor = new JButton("...");
    JButton btnSearchDiscount = new JButton("...");
    JButton btnSearchOrderDateBef = new JButton("...");
    JButton btnSearchOrderDateAft = new JButton("...");
    JButton[] btnSearchConditonArray = {btnSearchOrderId,btnSearchCustomer,btnSearchStaff,btnSearchBook,btnSearchAuthor,btnSearchDiscount};
    JComboBox<String> cbbLogicOrder = new JComboBox<>();
    
    JPanel[] pnlSearchConditionArray = new JPanel[namePnlSearch.length];
    JPanel pnlSearchOrderCondition = new JPanel();
    JPanel pnlSearchOrder = new JPanel();
        //Table hóa đơn
    DefaultTableModel modelTblOrder = new DefaultTableModel();
    JTable tblOrder = new JTable();
    JScrollPane scrollTblOrder = new JScrollPane();
    
    //All of table array 
    JTable TableArray[] = {tblOrder,tblOrderItem, tblOrderDetail, tblProduct};
}
