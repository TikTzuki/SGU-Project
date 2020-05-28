/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BUSGetAuthor;
import BUS.BUSGetBook;
import BUS.BUSGetCustomer;
import BUS.BUSGetDiscount;
import BUS.BUSGetDiscountDetail;
import BUS.BUSGetGenre;
import DTO.Author;
import DTO.Book;
import DTO.Customer;
import DTO.Discount;
import DTO.DiscountDetail;
import DTO.Genre;
import DTO.Order;
import DTO.OrderItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tik
 */
public class GUIOrderManager extends JFrame{
    private Font fontContent = new Font(Font.SERIF, 0, 12);
    public JPanel pnlMainPanel;
    JTabbedPane tabbedPane;
    JPanel pnlCreateOrder;
    JPanel pnlOrderManager;
    JTable tblProduct;
    DefaultTableModel modelTblProduct;
    JPanel pnlSelectedProduct;
    JPanel pnlSelectedProductDetail;
    JPanel pnlInstanceOrder;
    JTable tblOrderDetail;
    DefaultTableModel modelTblOrderdetail;
    //Tong hoa don
    JLabel lblTotalPriceOrderBefDis = new JLabel("Tổng (chưa áp khuyến mãi):");
    JLabel lblTotalPriceOrderBefDisValue = new JLabel("0");
    JLabel lblTotalValueDiscount = new JLabel("Khuyen mai:");
    JLabel lblTotalValueDiscountValue = new JLabel("0");
    JLabel lblTotalPriceOrder = new JLabel("Tổng :");
    JLabel lblTotalPriceOrderValue = new JLabel("0");
    
    public GUIOrderManager() {
        //initComponents();
        
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel initComponents() {
        pnlMainPanel = new JPanel(new BorderLayout());
        //Tạo tabbedPane chứa panel tạo hóa đơn, quản lý hóa đơn
        tabbedPane = new JTabbedPane();

        //Tạo panel tạo hóa đơn
        pnlCreateOrder = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        pnlCreateOrder.setPreferredSize(new Dimension(1200, 1000));
        pnlCreateOrder.setBackground(Color.ORANGE);
            //Panel sản phẩm đang được chọn
        pnlSelectedProduct = new JPanel(new BorderLayout());
        pnlSelectedProduct.setPreferredSize(new Dimension(400, 320));
            //Label sản phẩm đang được chọn
        JLabel lblSelectedProduct = new JLabel("Sản phẩm đang chọn");
        lblSelectedProduct.setPreferredSize(new Dimension(400, 20));
        lblSelectedProduct.setHorizontalAlignment(JLabel.CENTER);
        pnlSelectedProduct.add(lblSelectedProduct,BorderLayout.NORTH);
            //Ảnh sản phẩm đang đc chọn
        lblBookImg.setPreferredSize(new Dimension(200, 300));
        lblBookImg.setHorizontalAlignment(JLabel.CENTER);
            //Thông tin sản phẩm đang đc chọn
        pnlSelectedProductDetail = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        pnlSelectedProductDetail.setPreferredSize(new Dimension(200, 300));
        pnlSelectedProductDetail.setBackground(Color.red);
        
        Dimension selectedProductLabelSize = new Dimension(50, 20);
        JPanel pnlBlock = new JPanel(); pnlBlock.setPreferredSize(new Dimension(200, 120));
        
        lblBookId.setPreferredSize(selectedProductLabelSize);
        lblBookId.setFont(fontContent);
        lblBookGenre.setPreferredSize(selectedProductLabelSize);
        lblBookGenre.setFont(fontContent);
        lblBookName.setPreferredSize(selectedProductLabelSize);
        lblBookName.setFont(fontContent);
        lblBookAuthor.setPreferredSize(selectedProductLabelSize);
        lblBookAuthor.setFont(fontContent);
        lblBookPrice.setPreferredSize(selectedProductLabelSize);
        lblBookPrice.setFont(fontContent);
        lblBookQuantity.setPreferredSize(new Dimension(100, 20));
        lblBookQuantity.setFont(fontContent);
        lblISBN.setPreferredSize(selectedProductLabelSize);
        lblISBN.setFont(fontContent);
        lblBookIdValue.setPreferredSize(new Dimension(100,20));
        txtBookQuantity.setPreferredSize(new Dimension(50, 20));
        
        
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
        pnlSelectedProductDetail.add(lblBookQuantity);
        pnlSelectedProductDetail.add(txtBookQuantity);
        pnlSelectedProductDetail.add(lblISBN);
        pnlSelectedProductDetail.add(lblISBNValue);
        
        pnlSelectedProduct.add(lblBookImg,BorderLayout.WEST);
        pnlSelectedProduct.add(pnlSelectedProductDetail,BorderLayout.EAST);

        pnlCreateOrder.add(pnlSelectedProduct);
            //Button thêm sản phẩm vào hóa đơn
        JPanel pnlAttachProductToOrder = new JPanel();
         pnlAttachProductToOrder.addMouseListener(new MouseAdapter() {
             public void mousePressed(MouseEvent evt){
                    showTblOrderDetail(evt);
             }
         });

        JLabel lblAttachProductToOrder = new JLabel("Thêm vào hóa đơn >>");
        
        pnlAttachProductToOrder.add(lblAttachProductToOrder);
        
        pnlCreateOrder.add(pnlAttachProductToOrder);
            //Panel hóa đơn hiện tại
        pnlInstanceOrder = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlInstanceOrder.setPreferredSize(new Dimension(550,320));
        //Panel bên trái hóa đơn hiện tại
        JPanel pnlLeftInstanceOrder = new JPanel();
        pnlLeftInstanceOrder .setPreferredSize(new Dimension(400,320));
        JLabel lblOrderDetail = new JLabel("Hóa đơn");
        tblOrderDetail = new JTable();
        tblOrderDetail.setPreferredSize(new Dimension(400,500));
        tblOrderDetail.setModel(new DefaultTableModel(
            new Object[][]{
            
            },
            new Object[]{"ID","Tên sách","Giá bán","#","Thành tiền"}));
        JScrollPane scrollTblOrderDetail = new JScrollPane(tblOrderDetail);
        scrollTblOrderDetail.setPreferredSize(new Dimension(400,260));
        

        pnlLeftInstanceOrder.add(lblOrderDetail);
        pnlLeftInstanceOrder.add(scrollTblOrderDetail);
        pnlLeftInstanceOrder.add(lblTotalPriceOrderBefDis);
        pnlLeftInstanceOrder.add(lblTotalPriceOrderBefDisValue);
        pnlLeftInstanceOrder.add(lblTotalValueDiscount);
        pnlLeftInstanceOrder.add(lblTotalValueDiscountValue);
        pnlLeftInstanceOrder.add(lblTotalPriceOrder);
        pnlLeftInstanceOrder.add(lblTotalPriceOrderValue);
        
        //Thêm panel bên trái vào hóa đơn hiện tại
        pnlInstanceOrder.add(pnlLeftInstanceOrder);
        //Panel bên phải hóa dơn hiện tại
        JPanel pnlRightInstanceOrder = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
        pnlRightInstanceOrder.setPreferredSize(new Dimension(150,320));
        pnlRightInstanceOrder.setBackground(Color.PINK);
        
        Dimension controlSize = new Dimension(100,20);
        lblSaveOrder.setPreferredSize(controlSize);
        lblClearOrder.setPreferredSize(controlSize);
        lblDeleteOrderItem.setPreferredSize(controlSize);
        cbbDiscount.setPreferredSize(new Dimension(146, 20));
        //Discount
        cbbDiscount.setModel(modelCbbDiscount = showCbbDiscount());
        btnApplyDiscount.setPreferredSize(new Dimension(100, 20));
        pnlDiscount.setPreferredSize(new Dimension(150, 50));
        //Chon id khach hang
        pnlCustomerId.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        lblCustomerId.setPreferredSize(new Dimension(70, 20));
        txtCustomerId.setPreferredSize(new Dimension(50,20));
        btnSearchCustomerId.setPreferredSize(new Dimension(20, 20));
        btnSearchCustomerId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNSearchCustomer(e);{
                 JFrame findCustomer = new JFrame("Tìm khách hàng");
                }
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
        tblProduct = new JTable();
        tblProduct.setPreferredSize(new Dimension(0, 1000));
        
        tblProduct.setModel(new DefaultTableModel(
        new Object [][]{},
        new String [] {"Mã sách","Thể loại", "Tên", "Tác giả", "Giá", "Còn lại", "ISBN"}
        ));
        tblProduct.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                showSelectedProduct(evt);
            }
        });
            //Scrollpane chứa tabel sản phẩm
        JScrollPane scrollPane = new JScrollPane(tblProduct);
        scrollPane.setPreferredSize(new Dimension(1000, 300));
        pnlCreateOrder.add(scrollPane);
        
        //Tạo panel quản lý hóa đơn
        pnlOrderManager = new JPanel();
        pnlOrderManager.setPreferredSize(new Dimension(1100, 500));
        pnlOrderManager.setBackground(Color.cyan);
        
        //
        tabbedPane.addTab("Thêm hóa đơn", null, pnlCreateOrder, "Thêm hóa đơn");
        tabbedPane.addTab("Quản lý hóa đơn",null,pnlOrderManager,"Quản lý hóa đơn");

        pnlMainPanel.add(tabbedPane, BorderLayout.CENTER);
        
        //Bat su kien cho button applyDiscount
        btnApplyDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                applyDiscount(evt);
            }
        });
        lblSaveOrder.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                saveOrder(evt);
            };
        });
        //Table
        modelTblProduct = (DefaultTableModel) tblProduct.getModel();
        modelTblOrderdetail = (DefaultTableModel) tblOrderDetail.getModel();
        showTableProduct();
        add(pnlMainPanel);
        return pnlMainPanel;
    }

    public static void main(String[] args) {
        GUIOrderManager pnlMainPanel = new GUIOrderManager();
    }
    public void showTableProduct() {
        modelTblProduct.setRowCount(0);
        BUSGetBook busBook = new BUSGetBook();
        BUSGetGenre busGenre = new BUSGetGenre();
        BUSGetAuthor busAuthor = new BUSGetAuthor();
        
        ArrayList<Book> listBook;    

        try {
            listBook = busBook.getBook();
            Genre genre;
            Author author;
            for (Iterator<Book> obj = listBook.iterator(); obj.hasNext();) {
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
            lblBookGenre.setText("Thể loại");
            lblBookName.setText("Tên");
            lblBookAuthor.setText("Tác giả");
            lblBookPrice.setText("Giá");
            lblBookQuantity.setText("Số lượng");
            lblISBN.setText("ISBN");
        
        ImageIcon iiconBook =
        loadIcon("src/images/"+tblProduct.getValueAt(selectedRowIndex, 0).toString()+".jpg", 200, 300);
        lblBookImg.setIcon(iiconBook);
        lblBookIdValue.setText(tblProduct.getValueAt(selectedRowIndex,0).toString());
        lblBookGenreValue.setText(tblProduct.getValueAt(selectedRowIndex, 1).toString());
        lblBookNameValue.setText(tblProduct.getValueAt(selectedRowIndex, 2).toString());
        lblBookAuthorValue.setText(tblProduct.getValueAt(selectedRowIndex, 3).toString());
        lblBookPriceValue.setText(tblProduct.getValueAt(selectedRowIndex, 4).toString());
        txtBookQuantity.setText("1");
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
        lblISBNValue.setText(tblProduct.getValueAt(selectedRowIndex, 6).toString());


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
        }

    }
    public void showTblOrderDetail(MouseEvent evt) {
        if (lblBookImg.getIcon() == null || txtBookQuantity.getText() == "0") {
            return;
        }
        //Xet xem da co san pham trong hoa don chua, neu roi thi cap nhat lai so luong va thanh tien
        for (int i = 0; i < modelTblOrderdetail.getRowCount(); i++) {
            if (modelTblOrderdetail.getValueAt(i, 0) == lblBookIdValue.getText()) {
                modelTblOrderdetail.setValueAt(txtBookQuantity.getText(), i, 3);
                modelTblOrderdetail.setValueAt(
                        Integer.parseInt(lblBookPriceValue.getText()) * Integer.parseInt(txtBookQuantity.getText()),
                         i, 4);
                //Tinh tong hoa don
                showTotalValueOrder();
                return;
            }
        }
        //Neu chua co thi them san pham vao hoa don
        modelTblOrderdetail.addRow(new Object[]{
            lblBookIdValue.getText(),
            lblBookNameValue.getText(),
            lblBookPriceValue.getText(),
            txtBookQuantity.getText(),
            Integer.parseInt(lblBookPriceValue.getText()) * Integer.parseInt(txtBookQuantity.getText())
        });
        //Tinh tong hoa don
        showTotalValueOrder();
    }
    public DefaultComboBoxModel showCbbDiscount(){
        BUSGetDiscount discount = new BUSGetDiscount();
        DefaultComboBoxModel modelCbb = new DefaultComboBoxModel();
        ArrayList<Discount> discountList = new ArrayList<>();
        try {
            discountList = discount.getDiscount();
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Discount temp:discountList){
            modelCbb.addElement(temp.getDiscount_name());
        }
        return modelCbb;
    }
    public void showTotalValueOrder() {
        int sum = 0 ;
        int discount = 0;
        if(lblTotalValueDiscountValue.getText()!="Ap ma khong thanh cong")
            discount = Integer.parseInt(lblTotalValueDiscountValue.getText());
        for (int i = 0; i < modelTblOrderdetail.getRowCount(); i++) {
            sum+= Integer.parseInt(modelTblOrderdetail.getValueAt(i, 4).toString());
        }
        lblTotalPriceOrderBefDisValue.setText(""+sum);
        lblTotalPriceOrderValue.setText(""+(sum-discount)+" vnđ");
    }
    public void applyDiscount(ActionEvent evt){
        int discountValue = 0;
        BUSGetDiscount busDiscount = new BUSGetDiscount();
        BUSGetDiscountDetail busDiscountDetail = new BUSGetDiscountDetail();
        String nameOfDiscount = modelCbbDiscount.getSelectedItem().toString();
        int discountType = Integer.parseInt(lblTotalPriceOrderBefDisValue.getText());
        Discount discountTemp = new Discount();
        ArrayList<DiscountDetail> discountDetailList = new ArrayList<>();
        try {
            discountTemp = busDiscount.getDiscountByName("discount_name='"+nameOfDiscount+"' and discount_type<="+discountType);
            if(discountTemp.getDiscount_id()==-1){
                lblTotalValueDiscountValue.setText("Ap ma khong thanh cong");
                showTotalValueOrder();
                return;
            };
            discountDetailList = busDiscountDetail.getDiscountDetails(" discount_id="+discountTemp.getDiscount_id());
            for(DiscountDetail disTemp:discountDetailList){
                for(int i=0; i<modelTblOrderdetail.getRowCount(); i++){
                    if(disTemp.getBook_id()==Integer.parseInt(modelTblOrderdetail.getValueAt(i, 0).toString())){
                        discountValue += (disTemp.getPercent()*Integer.parseInt(modelTblOrderdetail.getValueAt(i, 4).toString()))/100;
                    };
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblTotalValueDiscountValue.setText(""+discountValue);
        showTotalValueOrder();
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
                //String condition = "customer_id LIKE '%"+partent+"%' OR first_name LIKE '%"+partent+"%' OR last_name LIKE '%"+partent+"%' OR phone_number LIKE '%"+partent+"%'";
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
                ArrayList<Customer> cusTempList = new ArrayList<>();
                try {
                    cusTempList = busCustomer.getCustomer(condition);
                } catch (Exception ex) {
                    Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                for(Customer cus: cusTempList){
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
                String customerIdFound = tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0).toString();
                txtCustomerId.setText(customerIdFound);
            }
        });
    }
    public void saveOrder(MouseEvent evt){
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        int staff_id = 1;
        String discount_name = modelCbbDiscount.getSelectedItem().toString();
        
        
    }
    JLabel lblBookImg = new JLabel();
    JLabel lblBookId = new JLabel();
    JLabel lblBookGenre = new JLabel();
    JLabel lblBookName = new JLabel();
    JLabel lblBookAuthor = new JLabel();
    JLabel lblBookPrice = new JLabel();
    JLabel lblBookQuantity = new JLabel();
    JLabel lblISBN = new JLabel();
    
    JLabel lblBookIdValue = new JLabel();
    JLabel lblBookGenreValue  = new JLabel();
    JLabel lblBookNameValue  = new JLabel();
    JLabel lblBookAuthorValue  = new JLabel();
    JLabel lblBookPriceValue  = new JLabel();
    JTextField txtBookQuantity = new JTextField();
    JLabel lblISBNValue  = new JLabel();
    
    JScrollPane scrollTblOrderDetail;/*
    JLabel lblTotalValueDiscount = new JLabel();
    JLabel lblTotalValueDiscountValue = new JLabel();
    JLabel lblTotalPriceOrder = new JLabel();
    JLabel lblTotalPriceOrderBefDisValue = new JLabel();
    JLabel lblTotalPriceOrderValue = new JLabel();*/
    
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
    JButton btnApplyDiscount = new JButton("Ap ma");
    JLabel lblCustomerId = new JLabel("ID khach:");
    JTextField txtCustomerId = new JTextField();
    JButton btnSearchCustomerId = new JButton("S");
}
