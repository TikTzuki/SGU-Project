package GUI;

import BUS.Book_BUS;
import DTO.Book_DTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FrameHienThi_Book 
{
    JPanel pBook;
    JLabel label_hinhAnh, label_id_sach, label_tensach, label_soluong, label_gia, label_loai, label_ngayxuatban, label_id_tacgia, label_vien, label_timkiem, label_timkiemma, label_timkiemgia;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt_timkiem, txt_timkiemma;
    JButton buttonThem, buttonSua, buttonXoa, buttonnhapE, buttonxuatE, button_timkiem, button_timkiemma, button_showAll, button_anh;
    JComboBox com_gia,com_theloai;
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane jscrollpane = new JScrollPane(table);

    public FrameHienThi_Book() {
       /* setSize(1000, 700);
        setLayout(null);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pan = SanPham();
        add(pan);
        //Doc();
        setVisible(true);*/
    }

    public JPanel SanPham() {
        pBook = new JPanel();
        pBook.setPreferredSize(new Dimension(1100, 700));
        pBook.setBounds(0, 0, 1000, 660);
        //pBook.setBackground(Color.WHITE);
        pBook.setBackground(new Color(204, 255, 255));
        pBook.setLayout(null);
        //Border bo = BorderFactory.createLineBorder(Color.yellow);
        //pBook.setBorder(BorderFactory.createTitledBorder(bo,"Sản Phẩm",TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        JPanel pan_contain = new JPanel();
        pan_contain.setBounds(0, 0, 1000, 7);
        pan_contain.setBackground(new Color(102, 204, 255));
        pBook.add(pan_contain);

        JPanel pan_anh = new JPanel();
        pan_anh.setBounds(50, 10, 310, 300);
        //pan_anh.setBackground(Color.WHITE);
        pan_anh.setBackground(new Color(204, 255, 255));
        pan_anh.setLayout(null);
        label_hinhAnh = new JLabel();
        label_hinhAnh.setBounds(10, 10, 290, 240);
        label_hinhAnh.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        pan_anh.add(label_hinhAnh);
        button_anh = new JButton();
        button_anh.setText("Chọn ảnh");
        button_anh.setBounds(80, 260, 150, 30);
        button_anh.setBackground(new Color(255, 204, 204));
        //button_anh.setForeground(Color.WHITE);
        pan_anh.add(button_anh);
        pBook.add(pan_anh);

        JPanel pan_label = new JPanel();
        pan_label.setLayout(null);
        //pan_label.setBackground(Color.WHITE);
        pan_label.setBackground(new Color(204, 255, 255));
        pan_label.setBounds(360, 10, 340, 300);
        //pan_label.setFont(new Font("Tahoma", 1, 19));
        label_id_sach = new JLabel("Mã sản phẩm");
        label_id_sach.setBounds(20, 20, 150, 30);
        pan_label.add(label_id_sach);
        label_tensach = new JLabel("Tên sản phẩm");
        label_tensach.setBounds(20, 60, 150, 30);
        pan_label.add(label_tensach);
        label_soluong = new JLabel("Số lượng");
        label_soluong.setBounds(20, 100, 150, 30);
        pan_label.add(label_soluong);
        label_gia = new JLabel("Đơn giá(VNĐ)");
        label_gia.setBounds(20, 140, 150, 30);
        pan_label.add(label_gia);
        
        
        
        label_loai = new JLabel("Tên thể loại");
        label_loai.setBounds(20, 180, 150, 30);
        pan_label.add(label_loai);
        label_ngayxuatban = new JLabel("Ngày xuất bản");
        label_ngayxuatban.setBounds(20, 220, 150, 30);
        pan_label.add(label_ngayxuatban);
        label_id_tacgia = new JLabel("Tên tác giả");
        label_id_tacgia.setBounds(20, 260, 150, 30);
        pan_label.add(label_id_tacgia);

        txt1 = new JTextField();
        txt1.setBounds(120, 20, 200, 30);
        txt1.setEditable(false);
        txt2 = new JTextField();
        txt2.setBounds(120, 60, 200, 30);
        txt3 = new JTextField();
        txt3.setBounds(120, 100, 200, 30);
        txt4 = new JTextField();
        txt4.setBounds(120, 140, 200, 30);
        txt5 = new JTextField();
        txt5.setBounds(120, 180, 200, 30);
        /*
        String[] theloai = {"Văn học Việt Nam", "Văn học nước ngoài","Tin học"};
        com_theloai = new JComboBox(theloai);
        com_theloai.setBounds(120, 180, 150, 30);
        pBook.add(com_theloai);
        */
        txt6 = new JTextField();
        txt6.setBounds(120, 220, 200, 30);
        txt7 = new JTextField();
        txt7.setBounds(120, 260, 200, 30);
        pan_label.add(txt1);
        pan_label.add(txt2);
        pan_label.add(txt3);
        pan_label.add(txt4);
        pan_label.add(txt5);
        //pan_label.add(com_theloai);
        pan_label.add(txt6);
        pan_label.add(txt7);

        pBook.add(pan_label);

        //panel.add(createPaneBorder(titleBorder,"title border center just and default prsition"));
        JPanel pan_button = new JPanel();
        pan_button.setLayout(null);
        //pan_button.setBackground(Color.WHITE);
        pan_button.setBackground(new Color(204, 255, 255));
        pan_button.setBounds(700, 10, 210, 300);
        /*
        JLabel la = new JLabel("Chức năng");
        la.setFont(new Font("Tahoma", 3, 15));
         */
        //pan_button.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
        pan_button.setBorder(BorderFactory.createTitledBorder(blueBorder, "Chức năng", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        button_showAll = new JButton();
        button_showAll = new JButton();
        button_showAll.setText("Danh sách");
        button_showAll.setBackground(new Color(204, 204, 0));
        button_showAll.setBounds(30, 30, 150, 30);
        button_showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                //Doc();
            }
        });
        pan_button.add(button_showAll);

        buttonThem = new JButton();
        buttonThem.setText("Thêm");
        buttonThem.setBackground(new Color(0, 255, 204));
        buttonThem.setBounds(30, 75, 150, 30);
        buttonThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Them();
            }

        });
        pan_button.add(buttonThem);

        buttonSua = new JButton();
        buttonSua.setText("Sửa");
        buttonSua.setBackground(new Color(255, 51, 51));
        buttonSua.setBounds(30, 120, 150, 30);
        buttonSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Sua();
            }

        });
        pan_button.add(buttonSua);

        buttonXoa = new JButton();
        buttonXoa.setText("Xóa");
        buttonXoa.setBackground(new Color(0, 204, 255));
        buttonXoa.setBounds(30, 165, 150, 30);
        buttonXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Xoa();
                //DTO dto = new DTO();
                String id = txt1.getText();
                Book_BUS bus = new Book_BUS();
                bus.Xoa(id);
            }

        });
        pan_button.add(buttonXoa);

        buttonnhapE = new JButton();
        buttonnhapE.setText("Nhập EXCEL");
        buttonnhapE.setBackground(new Color(102, 255, 51));
        buttonnhapE.setBounds(30, 210, 150, 30);
        pan_button.add(buttonnhapE);

        buttonxuatE = new JButton();
        buttonxuatE.setText("Xuất EXCEL");
        buttonxuatE.setBackground(new Color(255, 51, 255));
        buttonxuatE.setBounds(30, 255, 150, 30);

        pan_button.add(buttonxuatE);

        pBook.add(pan_button);

        label_vien = new JLabel("-------------------------------------------------------------Tìm kiếm thông tin-----------------------------------------------------------");
        label_vien.setFont(new Font("Tahoma", 1, 15));
        label_vien.setBounds(50, 315, 950, 30);
        pBook.add(label_vien);

        label_timkiem = new JLabel("Tìm kiếm: ");
        label_timkiem.setFont(new Font("Tahoma", 1, 15));
        label_timkiem.setBounds(50, 355, 80, 30);
        pBook.add(label_timkiem);
        txt_timkiem = new JTextField("Nhập tên cần tìm kiếm...");
        txt_timkiem.setBounds(130, 350, 200, 40);
        txt_timkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_timkiem.setText(null);
            }
        });
        txt_timkiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    String ten = txt_timkiem.getText();
                    ten = ten.trim();//cắt các dấu cách ở đầu và cuối chuỗi.

                  //  TimKiemTen(ten);
                }
            }
        });
        pBook.add(txt_timkiem);
        button_timkiem = new JButton();
        button_timkiem.setIcon(new ImageIcon("bieutuongtimkiem.jpg"));
        button_timkiem.setBounds(330, 350, 40, 39);
        button_timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ten = txt_timkiem.getText();
                ten = ten.trim();//cắt các dấu cách ở đầu và cuối chuỗi.
                
                //TimKiemTen(ten);
            }

        });
        
        pBook.add(button_timkiem);

        label_timkiemma = new JLabel("Tìm kiếm theo mã: ");
        label_timkiemma.setFont(new Font("Tahoma", 1, 15));
        label_timkiemma.setBounds(410, 355, 140, 30);
        pBook.add(label_timkiemma);
        txt_timkiemma = new JTextField("Nhập mã...");
        txt_timkiemma.setBounds(550, 350, 80, 40);
        txt_timkiemma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_timkiemma.setText(null);
            }
        });
        txt_timkiemma.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    int index = Integer.parseInt(txt_timkiemma.getText());
                    //timkiemma(index);
                }
            }
        });
        pBook.add(txt_timkiemma);
        button_timkiemma = new JButton();
        button_timkiemma.setIcon(new ImageIcon("bieutuongtimkiem.jpg"));
        button_timkiemma.setBounds(630, 350, 40, 39);
        button_timkiemma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = Integer.parseInt(txt_timkiemma.getText());
                //timkiemma(index);
            }

        });
        
        pBook.add(button_timkiemma);

        label_timkiemgia = new JLabel("Tìm theo giá: ");
        label_timkiemgia.setFont(new Font("Tahoma", 1, 15));
        label_timkiemgia.setBounds(710, 355, 140, 30);
        pBook.add(label_timkiemgia);
        String[] gia = {"Không", "Dưới 100K", "Từ 100K - 300K", "Trên 300K"};
        com_gia = new JComboBox(gia);
        com_gia.setBounds(810, 350, 100, 40);
        com_gia.setBackground(Color.WHITE);
        pBook.add(com_gia);

        TaoTable();

        return pBook;
    }

    public void TaoTable() {
        /*
        table.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá (VNĐ)", "Mã thể loại", "Ngày xuất bản", "Mã ID tác giả", "isbn"
                }
        ));
        */
        //Doc();
        jscrollpane.setBounds(65, 410, 830, 206);
        pBook.add(jscrollpane);
        //JTableHeader tbh = table.getTableHeader();
        //tbh.setFont(new Font("Tahoma", 1, 15));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setBackground(new Color(153, 204, 255));
        table.getTableHeader().setFont(new Font("Tahoma", 1, 13));
        table.setRowHeight(30);
        //tbh.setForeground(Color.yellow);
        table.setSelectionBackground(new Color(255, 255, 0));//màu nền khi click chuột vào một row trên table
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = table.getSelectedRow();
                //JOptionPane.showMessageDialog(null, "row:"+i);
                txt1.setText(table.getModel().getValueAt(i, 0).toString());
                txt2.setText(table.getModel().getValueAt(i, 1).toString());
                txt3.setText(table.getModel().getValueAt(i, 2).toString());
                txt4.setText(table.getModel().getValueAt(i, 3).toString());
                txt5.setText(table.getModel().getValueAt(i, 4).toString());
                txt6.setText(table.getModel().getValueAt(i, 5).toString());
                txt7.setText(table.getModel().getValueAt(i, 6).toString());
            }
        });
        pBook.add(jscrollpane);
    }
    
    public static void main(String[] args) {
        FrameHienThi_Book fr = new FrameHienThi_Book();
    }
/*
    public void Doc() {
        Book_BUS bus = new Book_BUS();
        if (bus.ds == null) {
            bus.showAll();
        }
        Vector header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Số lượng");
        header.add("Đơn giá (VNĐ)");
        header.add("Tên thể loại");
        header.add("Ngày xuất bản");
        header.add("Tên tác giả");
        header.add("isbni");

        model = new DefaultTableModel(header, 0);

        for (book_DTO dto : BUS.ds) {
            Vector row = new Vector();
            row.add(dto.book_id);
            row.add(dto.title);
            row.add(dto.availabel_quantity);
            row.add(dto.price);
            row.add(dto.genre_name);
            row.add(dto.publication_date);
            row.add(dto.author_firstname+" "+dto.author_lastname);
            row.add(dto.isbn);
            model.addRow(row);

        }
        table.setModel(model);

    }

    public void TimKiemTen(String ten)
    {
        Book_BUS bus = new Book_BUS();
        if (BUS.ds == null) {
            bus.showAll();
        }
        Vector header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Số lượng");
        header.add("Đơn giá (VNĐ)");
        header.add("Tên thể loại");
        header.add("Ngày xuất bản");
        header.add("Tên tác giả");
        header.add("isbni");

        model = new DefaultTableModel(header, 0);
        for (DTO dto : BUS.ds) 
        {
            //dto.title.startsWith(ten) : coi thử dto.title có bằng chuỗi tên ko.
            dto.title = dto.title.trim();
            int index = dto.title.compareToIgnoreCase(ten);//nếu so sánh hai chuổi bằng nha thì trả về 0.
            if(index == 0)
            {
                Vector row = new Vector();
                row.add(dto.book_id);
                row.add(dto.title);
                row.add(dto.availabel_quantity);
                row.add(dto.price);
                row.add(dto.genre_name);
                row.add(dto.publication_date);
                row.add(dto.author_firstname+" "+dto.author_lastname);
                row.add(dto.isbn);
                model.addRow(row);
            }
        }
        table.setModel(model);
    }
    
    public void TimKiemGia(int gia)
    {
        Book_BUS bus = new Book_BUS();
        if (BUS.ds == null) {
            bus.showAll();
        }
        Vector header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Số lượng");
        header.add("Đơn giá (VNĐ)");
        header.add("Tên thể loại");
        header.add("Ngày xuất bản");
        header.add("Tên tác giả");
        header.add("isbni");

        model = new DefaultTableModel(header, 0);
        for (Book_DTO dto : BUS.ds) 
        {
            if(dto.price<=gia)
            {
                Vector row = new Vector();
                row.add(dto.book_id);
                row.add(dto.title);
                row.add(dto.availabel_quantity);
                row.add(dto.price);
                row.add(dto.genre_name);
                row.add(dto.publication_date);
                row.add(dto.author_firstname+" "+dto.author_lastname);
                row.add(dto.isbn);
                model.addRow(row);
            }
        }
        table.setModel(model);
    }
    
    public void timkiemma(int ma)
    {
        Book_BUS bus = new Book_BUS();
        if (BUS.ds == null) {
            bus.showAll();
        }
        Vector header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Số lượng");
        header.add("Đơn giá (VNĐ)");
        header.add("Tên thể loại");
        header.add("Ngày xuất bản");
        header.add("Tên tác giả");
        header.add("isbni");

        model = new DefaultTableModel(header, 0);
        for (Book_DTO dto : BUS.ds) 
        {
            if(dto.book_id==ma)
            {
                Vector row = new Vector();
                row.add(dto.book_id);
                row.add(dto.title);
                row.add(dto.availabel_quantity);
                row.add(dto.price);
                row.add(dto.genre_name);
                row.add(dto.publication_date);
                row.add(dto.author_firstname+" "+dto.author_lastname);
                row.add(dto.isbn);
                model.addRow(row);
            }
        }
        table.setModel(model);
    }
    
    public void Them() {
        //DTO dto = new  DTO();

        Book_DTO dto = new Book_DTO();
        //dto.book_id = Integer.parseInt(txt1.getText());
        dto.title = txt2.getText();
        dto.availabel_quantity = Integer.parseInt(txt3.getText());
        dto.price = Integer.parseInt(txt4.getText());
        dto.genre_id = Integer.parseInt(txt5.getText());
        dto.publication_date = txt6.getText();
        dto.author_id = Integer.parseInt(txt7.getText());

        Book_BUS bus = new Book_BUS();
        bus.Them(dto);

        Doc();;
    }
    
    public void Xoa() {
        //DTO dto = new DTO();
        String id = txt1.getText();
        BUS bus = new BUS();
        bus.Xoa(id);
    }
    
    public void Sua() {
        Book_DTO dto = new Book_DTO();
        dto.book_id = Integer.parseInt(txt1.getText());
        dto.title = txt2.getText();
        dto.availabel_quantity = Integer.parseInt(txt3.getText());
        dto.price = Integer.parseInt(txt4.getText());
        dto.genre_id = Integer.parseInt(txt5.getText());
        dto.publication_date = txt6.getText();
        dto.author_id = Integer.parseInt(txt7.getText());
        Book_BUS bus = new Book_BUS();
        bus.Sua(dto);
        
        Doc();
    }

    */
}
