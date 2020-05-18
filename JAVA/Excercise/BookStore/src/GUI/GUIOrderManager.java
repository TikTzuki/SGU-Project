/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BUSGetAuthor;
import BUS.BUSGetBook;
import BUS.BUSGetGenre;
import DTO.Author;
import DTO.Book;
import DTO.Genre;
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

    public JPanel pnlMainPanel;
    JTabbedPane tabbedPane;
    JPanel pnlCreateOrder;
    JPanel pnlOrderManager;
    JTable tblProduct;
    DefaultTableModel modelTblProduct;
    JPanel pnlSelectedProduct;
    JPanel pnlSelectedProductDetail;
    JPanel pnlInstanceOrder;
    public GUIOrderManager() {
        initComponents();
        modelTblProduct = (DefaultTableModel) tblProduct.getModel();
        showTableProduct();
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents() {
        pnlMainPanel = new JPanel(new BorderLayout());
        //Tạo tabbedPane chứa panel tạo hóa đơn, quản lý hóa đơn
        tabbedPane = new JTabbedPane();

        //Tạo panel tạo hóa đơn
        pnlCreateOrder = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        pnlCreateOrder.setPreferredSize(new Dimension(1200, 5000));
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
        
        Dimension selectedProductLabelSize = new Dimension(200, 20);
        JPanel pnlBlock = new JPanel(); pnlBlock.setPreferredSize(new Dimension(200, 120));
        lblBookGenre.setPreferredSize(selectedProductLabelSize);
        lblBookName.setPreferredSize(selectedProductLabelSize);
        lblBookAuthor.setPreferredSize(selectedProductLabelSize);
        lblBookPrice.setPreferredSize(selectedProductLabelSize);
        lblBookQuantity.setPreferredSize(new Dimension(60, 20));
        txtBookQuantity.setPreferredSize(new Dimension(30, 20));
        lblISBN.setPreferredSize(selectedProductLabelSize);
        
        pnlSelectedProductDetail.add(pnlBlock);
        pnlSelectedProductDetail.add(lblBookGenre);
        pnlSelectedProductDetail.add(lblBookName);
        pnlSelectedProductDetail.add(lblBookAuthor);
        pnlSelectedProductDetail.add(lblBookPrice);
        pnlSelectedProductDetail.add(lblBookQuantity);
        pnlSelectedProductDetail.add(txtBookQuantity);
        pnlSelectedProductDetail.add(lblISBN);
        
        pnlSelectedProduct.add(lblBookImg,BorderLayout.WEST);
        pnlSelectedProduct.add(pnlSelectedProductDetail,BorderLayout.EAST);

        pnlCreateOrder.add(pnlSelectedProduct);
            //Button thêm sản phẩm vào hóa đơn
        JPanel pnlAttachProductToOrder = new JPanel();
         pnlAttachProductToOrder.addMouseListener(new MouseAdapter() {
             public void mousePressed(MouseEvent evt){
                 attachProductToOrder(evt);
             }
         });
        JLabel lblAttachProductToOrder = new JLabel("Thêm vào hóa đơn >>");
        
        pnlAttachProductToOrder.add(lblAttachProductToOrder);
        
        pnlCreateOrder.add(pnlAttachProductToOrder);
            //Panel hóa đơn hiện tại
        pnlInstanceOrder = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlInstanceOrder.setPreferredSize(new Dimension(550,320));
        //Panel bên trái hóa đơn hiện tại
        JPanel pnlOrderDetail = new JPanel();
        pnlOrderDetail.setPreferredSize(new Dimension(400,320));
        JLabel lblOrderDetail = new JLabel("Hóa đơn");
        JTable tblOrderDetail = new JTable();
        tblOrderDetail.setPreferredSize(new Dimension(400,500));
        JScrollPane scrollTblOrderDetail = new JScrollPane(tblOrderDetail);
        scrollTblOrderDetail.setPreferredSize(new Dimension(400,260));
        JLabel lblTotalDetail = new JLabel("Tổng");
        
        pnlOrderDetail.add(lblOrderDetail);
        pnlOrderDetail.add(scrollTblOrderDetail);
        pnlOrderDetail.add(lblTotalDetail);
        
        //Thêm panel bên trái vào hóa đơn hiện tại
        pnlInstanceOrder.add(pnlOrderDetail);
        //Panel bên phải hóa dơn hiện tại
        JPanel pnlRightInstanceOrder = new JPanel();
        pnlRightInstanceOrder.setPreferredSize(new Dimension(150,320));
        pnlRightInstanceOrder.setBackground(Color.PINK);
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
        scrollPane.setPreferredSize(new Dimension(1000, 400));
        pnlCreateOrder.add(scrollPane);
        
        //Tạo panel quản lý hóa đơn
        pnlOrderManager = new JPanel();
        pnlOrderManager.setPreferredSize(new Dimension(1200, 500));
        pnlOrderManager.setBackground(Color.cyan);
        
        //
        tabbedPane.addTab("Thêm hóa đơn", null, pnlCreateOrder, "Thêm hóa đơn");
        tabbedPane.addTab("Quản lý hóa đơn",null,pnlOrderManager,"Quản lý hóa đơn");

        pnlMainPanel.add(tabbedPane, BorderLayout.CENTER);

        add(pnlMainPanel);
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
                    //ảnh
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
        

        ImageIcon iiconBook =
        loadIcon("src/images/"+tblProduct.getValueAt(selectedRowIndex, 0).toString()+".jpg", 200, 300);
        lblBookImg.setIcon(iiconBook);
        lblBookGenre.setText("Thể loại: "+tblProduct.getValueAt(selectedRowIndex, 1).toString());
        lblBookName.setText("Tên sách: "+tblProduct.getValueAt(selectedRowIndex, 2).toString());
        lblBookAuthor.setText("Tác giả: "+tblProduct.getValueAt(selectedRowIndex, 3).toString());
        lblBookPrice.setText("Giá: "+tblProduct.getValueAt(selectedRowIndex, 4).toString());
        lblBookQuantity.setText("Số lượng: ");
        txtBookQuantity.setText("0");
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
                keyLockOnlyNumberInLimit(evt, Integer.parseInt(tblProduct.getValueAt(selectedRowIndex, 5).toString()));
            }
        });
        lblISBN.setText("ISBN: "+tblProduct.getValueAt(selectedRowIndex, 6).toString());


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
        //Trường hợp ký tự vừa nhập vào là Backspace
        if(keyRealeased == "Backspace")
            return;
        //Kiểm tra ký tự đã realeased bằng Regex
        if(!patern.matcher(keyRealeased).matches())
        {   
            txtBookQuantity.setText(txtBookQuantity.getText().substring(0,txtBookQuantity.getText().length()-1));
        }
        //Nếu số lượng mua vượt quá số lượng có sẵn 
        if(Integer.parseInt(txtBookQuantity.getText()) > limit )
        {
            txtBookQuantity.setText(txtBookQuantity.getText().substring(0,txtBookQuantity.getText().length()-1));
        }
    }
    public void attachProductToOrder(MouseEvent evt){
         
     }
    JLabel lblBookImg = new JLabel();
    JLabel lblBookGenre = new JLabel("Thể loại");
    JLabel lblBookName = new JLabel("Tên sách");
    JLabel lblBookAuthor = new JLabel("Tác giả");
    JLabel lblBookPrice = new JLabel("Giá");
    JLabel lblBookQuantity = new JLabel("Số lượng");
    JTextField txtBookQuantity = new JTextField();
    JLabel lblISBN = new JLabel("ISBN");
}
