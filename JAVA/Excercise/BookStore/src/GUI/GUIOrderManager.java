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
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tik
 */
public class GUIOrderManager{
    private Color colorPink = new Color(255,97,194,255);
    private Color colorBlueWeak = new Color(97,255,218,255);
    private Color colorBlue = new Color(32,164,243,255);
    private Color colorCream = new Color(255,205,97,255);
    private Color colorRice = new Color(229,218,218,255);
    private Color colorGray = new Color(93,87,107,255);
    //Nhan vien
    Staff staff;
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
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");  
    Date today = new Date();
    //Date transfer object
    private BUSGetBook busBook = new BUSGetBook();
    private BUSOrderManager busOrder = new BUSOrderManager();
    private BUSOrderItemManager busOrderItem = new BUSOrderItemManager();
    private BUSGetGenre busGenre = new BUSGetGenre();
    private BUSGetAuthor busAuthor = new BUSGetAuthor();
    private BUSGetDiscount busDiscount = new BUSGetDiscount();
    private BUSGetDiscountDetail busDiscountDetail = new BUSGetDiscountDetail();
    static private ArrayList<Book> bookListGlobal = new ArrayList<>();
    static private ArrayList<OrderItem> orderItemListGlobal = new ArrayList<>();
    static private Order orderGlobal = new Order();
    static private Book selectedBookGlobal = new Book();
    static private ArrayList<Discount> discountListGlobal = new ArrayList<>();
    static private Discount selectedDiscountGolbal = new Discount();
    static private ArrayList<DiscountDetail> discountDetailListGlobal = new ArrayList<>();
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
        pnlMainPanel.setBackground(Color.white);
        //Tạo tabbedPane chứa panel tạo hóa đơn, quản lý hóa đơn
        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Color.white);
        //Tạo panel tạo hóa đơn
        pnlCreateOrder = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlCreateOrder.setPreferredSize(new Dimension(1100, 700));
        pnlCreateOrder.setBackground(Color.white);
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
        pnlSelectedProductDetail.setBackground(colorRice);
        
        Dimension selectedProductLabelSize = new Dimension(60, 20);
        JPanel pnlBlock = new JPanel(); pnlBlock.setPreferredSize(new Dimension(200, 120)); pnlBlock.setBackground(colorRice);
        
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

        JLabel lblAttachProductToOrder = new JLabel("Thêm vào >>");
        
        pnlAttachProductToOrder.add(lblAttachProductToOrder);
        
        pnlCreateOrder.add(pnlAttachProductToOrder);
            //Panel hóa đơn hiện tại
        pnlInstanceOrder = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlInstanceOrder.setPreferredSize(new Dimension(560,320));
        //Panel bên trái hóa đơn hiện tại
        JPanel pnlLeftInstanceOrder = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlLeftInstanceOrder .setPreferredSize(new Dimension(410,320));
        JLabel lblOrderDetail = new JLabel("Hóa đơn");
        tblOrderDetail = new JTable();
        tblOrderDetail.setPreferredSize(new Dimension(400,500));
        tblOrderDetail.setModel(new DefaultTableModel(
            new Object[][]{
            
            },
            new Object[]{"ID","Tên sách","Giá bán","#","Thành tiền"}));
        JScrollPane scrollTblOrderDetail = new JScrollPane(tblOrderDetail);
        scrollTblOrderDetail.setPreferredSize(new Dimension(400,240));
        
        Dimension sizeOrderCalc = new Dimension(190, 16);
        lblTotalPriceOrderBefDis.setPreferredSize(sizeOrderCalc);
        lblTotalPriceOrderValue.setPreferredSize(sizeOrderCalc);
        lblTotalValueDiscount.setPreferredSize(sizeOrderCalc);
        
        lblTotalPriceOrderBefDisValue.setPreferredSize(new Dimension(190, 16));
        lblTotalPriceOrderValue.setPreferredSize(new Dimension(190, 16));
        lblTotalValueDiscountValue.setPreferredSize(new Dimension(190, 16));

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
        pnlRightInstanceOrder.setBackground(colorRice);
        
        Dimension controlSize = new Dimension(100,20);
        lblSaveOrder.setPreferredSize(controlSize);
        lblClearOrder.setPreferredSize(controlSize);
        lblDeleteOrderItem.setPreferredSize(controlSize);
        cbbDiscount.setPreferredSize(new Dimension(146, 20));
        //Discount
        cbbDiscount.setModel(modelCbbDiscount = showCbbDiscount());
        btnApplyDiscount.setPreferredSize(new Dimension(100, 20));
        pnlDiscount.setPreferredSize(new Dimension(150, 50));
        pnlDiscount.setBackground(colorRice);
        //Chon id khach hang
        pnlCustomerId.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pnlCustomerId.setBackground(colorRice);
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
        scrollPane.setPreferredSize(new Dimension(1100, 300));
        pnlCreateOrder.add(scrollPane);
        
        //Tạo panel quản lý hóa đơn
        pnlOrderManager = new JPanel();
        pnlOrderManager.setPreferredSize(new Dimension(1000, 500));
        pnlOrderManager.setBackground(Color.white);
        
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
        lblSaveOrder.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                saveOrder(evt);
            };
        });
        modelTblProduct = (DefaultTableModel) tblProduct.getModel();
        modelTblOrderdetail = (DefaultTableModel) tblOrderDetail.getModel();
        showTableProduct();
        return pnlMainPanel;
    }

    public static void main(String[] args) {
        GUIOrderManager pnlMainPanel = new GUIOrderManager();
    }
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
        lblBookGenre.setText("Thể loại");
        lblBookName.setText("Tên");
        lblBookAuthor.setText("Tác giả");
        lblBookPrice.setText("Giá");
        lblBookQuantity.setText("Số lượng");
        lblISBN.setText("ISBN");
        
        //Lấy book từ id
        try {
            selectedBookGlobal = busBook.getBookById(tblProduct.getValueAt(selectedRowIndex, 0).toString());
            ImageIcon iiconBook
                    = loadIcon("src/images/" + selectedBookGlobal.getBook_id() + ".jpg", 200, 300);
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
    public void showTblOrderDetail(MouseEvent evt) {
        // Nếu sản phẩm không tồn tại, hoặc có số lượng = 0, hoặc không điền số lượng
        if (lblBookImg.getIcon() == null || txtBookQuantity.getText().equalsIgnoreCase("0") || txtBookQuantity.getText().equalsIgnoreCase("")) {
            return;
        }
        int quantity = Integer.parseInt(txtBookQuantity.getText());
        int price = selectedBookGlobal.getPrice()*Integer.parseInt(txtBookQuantity.getText());
        //Neu chua co thi them san pham vao order item list
        if (orderItemListGlobal.isEmpty()) {

            OrderItem newOrderItem = new OrderItem(0, selectedBookGlobal.getBook_id(), quantity, price);
            orderItemListGlobal.add(newOrderItem);
        } else {
            //neu roi thi cap nhat lai so luong va thanh tien
            for (OrderItem orderItem : orderItemListGlobal) {
                if (orderItem.getBook_id() == selectedBookGlobal.getBook_id()) {
                    orderItem.setQuantity(quantity);
                    orderItem.setPrice(price);
                }
            }
        }
        modelTblOrderdetail.setRowCount(0);
        for(OrderItem orderItem: orderItemListGlobal){
            modelTblOrderdetail.addRow(new Object[]{
                orderItem.getBook_id(),
                selectedBookGlobal.getBook_id(),
                selectedBookGlobal.getPrice(),
                orderItem.getQuantity(),
                orderItem.getPrice()
            });
        }
        //Tinh tong hoa don
        showTotalValueOrder();
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
            sum += orderItem.getPrice() * orderItem.getQuantity();
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
        Order orderForInsert;
        
        int staff_id = this.staff.getStaff_id();
        int order_id = 0;
        String discount_name = modelCbbDiscount.getSelectedItem().toString();
        String discount_id = discount_name.substring(0, discount_name.indexOf(". "));
        String customer_id;
        if(txtCustomerId.getText().equals("")){
                    customer_id = "0";
        } else {
            customer_id = txtCustomerId.getText();
        }
        String order_date = dateFormatter.format(today);
        String total = lblTotalPriceOrderValue.getText().substring(0, lblTotalPriceOrderValue.getText().indexOf("vnđ")-1);
        orderForInsert = new Order(staff_id, Integer.parseInt(discount_id), Integer.parseInt(customer_id), order_date, Integer.parseInt(total));
        System.out.println(orderForInsert.toString());
        BUSOrderManager busOrder = new BUSOrderManager();
        try {
            busOrder.inserts(orderForInsert);
            order_id = busOrder.getLastOrderId();
        } catch (Exception ex) {
            Logger.getLogger(GUIOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(order_id);
        BUSOrderItemManager busOrderItem = new BUSOrderItemManager();
        for(int i=0; i<modelTblOrderdetail.getRowCount(); i++){
            OrderItem orderItem = new OrderItem();
            
        }
        
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
