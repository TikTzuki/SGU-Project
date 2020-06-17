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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import org.omg.CORBA.portable.OutputStream;

public class FrameHienThi_Book 
{
    JPanel pBook;
    JLabel label_hinhAnh, label_id_sach, label_tensach, label_soluong, label_gia, label_loai, label_ngayxuatban, label_id_tacgia, label_vien, label_timkiem, label_timkiemma, label_timkiemgia;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt_timkiem, txt_timkiemma;
    JButton buttonClear, buttonThem, buttonSua, buttonXoa, buttonnhapE, buttonxuatE, button_timkiem, button_timkiemma, button_showAll, button_anh,button_themtheloai,button_themtacgia;
    JComboBox com_gia,com_theloai,com_tacgia;
    JTable table = new JTable();
    DefaultComboBoxModel modelComTheLoai; 
    DefaultComboBoxModel modelComTacGia = new DefaultComboBoxModel(); 
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane jscrollpane = new JScrollPane(table);
    File file;
            
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
        pBook.setPreferredSize(new Dimension(1100,700));
        pBook.setBounds(0, 0, 1100, 700);
        //pBook.setBackground(Color.WHITE);
        //pBook.setBackground(new Color(204, 255, 255));
        pBook.setLayout(null);
        //Border bo = BorderFactory.createLineBorder(Color.yellow);
        //pBook.setBorder(BorderFactory.createTitledBorder(bo,"Sản Phẩm",TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        pBook.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JPanel pan_contain = new JPanel();
        pan_contain.setBounds(0, 0, 1000, 7);
        pan_contain.setBackground(new Color(102, 204, 255));
        pBook.add(pan_contain);

        JPanel pan_anh = new JPanel();
        pan_anh.setBounds(50, 10, 310, 300);
        //pan_anh.setBackground(Color.WHITE);
        //pan_anh.setBackground(new Color(204, 255, 255));
        pan_anh.setLayout(null);
        
        label_hinhAnh = new JLabel();
        label_hinhAnh.setBounds(10, 10, 290, 240);
        label_hinhAnh.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        label_hinhAnh.setHorizontalAlignment(label_hinhAnh.CENTER);
        //ImageIcon iiconBook =
        //loadIcon("src/images/"+tblProduct.getValueAt(selectedRowIndex, 0).toString()+".jpg", 290, 240);
        //label_hinhAnh.setIcon(iiconBook);
        pan_anh.add(label_hinhAnh);
        button_anh = new JButton();
        button_anh.setText("Chọn ảnh");
        button_anh.setBounds(80, 260, 150, 30);
        button_anh.setBackground(new Color(255, 204, 204));
        button_anh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//chỉ hiển thị file
                int returnValue = fileChooser.showOpenDialog(pBook);
                if(returnValue==JFileChooser.APPROVE_OPTION)
                {
                    file = fileChooser.getSelectedFile();//lấy tên file
                    System.out.println(file.getName());
                    //lấy đường dẫn file để lưu vào 1 trường trong csdl
                    String pathFile = file.getAbsolutePath();//đường dẫn file
                    System.out.println(pathFile);
                    //String pathFile1 = file.getAbsolutePath().replace("//", "==");
                    BufferedImage b;
                    try {
                        b = ImageIO.read(file);
                        label_hinhAnh.setIcon(new ImageIcon(b));
                    } catch (Exception e) {
                    }
                }
                
            }

        });
        pan_anh.add(button_anh);
        pBook.add(pan_anh);

        JPanel pan_label = new JPanel();
        pan_label.setLayout(null);
        //pan_label.setBackground(Color.WHITE);
        //pan_label.setBackground(new Color(204, 255, 255));
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
        //txt5 = new JTextField();
        //txt5.setBounds(120, 180, 200, 30);
        
        //Load thể loại=====================================================================================
        
        kt();
        
        button_themtheloai = new JButton();
        //==============
        button_themtheloai.setLayout(null);
        ImageIcon imTL = loadIcon("src/images/plus.png",30,30);
        JLabel TL = new JLabel(imTL);
        TL.setBounds(0, 0, 30, 30);
        button_themtheloai.add(TL);
        
        //=========================
        button_themtheloai.setFont(new Font("Tahoma", 1, 7));
        button_themtheloai.setBounds(291, 180, 30, 30);
        button_themtheloai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                FrameTheLoai frtheLoai = new FrameTheLoai();
                frtheLoai.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                com_theloai.repaint();
            }

        });
        
        txt6 = new JTextField();
        txt6.setBounds(120, 220, 160, 30);
        txt6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt6.setText(null);
            }
        });
        JButton lich = new JButton(new ImageIcon("calendar.png"));
        lich.setBounds(280, 220, 40, 29);
        final JFrame f2 = new JFrame();
        lich.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
		txt6.setText(new DatePicker(f2).setPickedDateYearMonthDate());
            }
	});
        pan_label.add(lich);
        //txt7 = new JTextField();
        //txt7.setBounds(120, 260, 200, 30);
        //Book_BUS bus = new Book_BUS();
        
        //=========================Load tác giả
        Book_BUS bus = new Book_BUS();
        ArrayList<Book_DTO> arr1 = bus.Select_TacGia();
        for(Book_DTO dto : arr1)
        {
            modelComTacGia.addElement(dto.author_firstname+" "+dto.author_lastname);
            //modelCom.addElement(dto.genre_id);
        }
        com_tacgia = new JComboBox(modelComTacGia);
        com_tacgia.setBounds(120, 260, 170, 30);
        
        button_themtacgia = new JButton();
        //==============
        button_themtacgia.setLayout(null);
        ImageIcon imTG = loadIcon("src/images/plus.png",30,30);
        JLabel TG = new JLabel(imTG);
        TG.setBounds(0, 0, 30, 30);
        button_themtacgia.add(TG);
        
        //=========================Thêm tác giả
        button_themtacgia.setFont(new Font("Tahoma", 1, 7));
        button_themtacgia.setBounds(291, 260, 30, 30);
        button_themtacgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FrameTacGia frtacgia = new FrameTacGia();
                frtacgia.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                
            }

        });
        pan_label.add(txt1);
        pan_label.add(txt2);
        pan_label.add(txt3);
        pan_label.add(txt4);
        //pan_label.add(txt5);
        pan_label.add(com_theloai);
        pan_label.add(button_themtheloai);
        pan_label.add(txt6);
        //pan_label.add(txt7);
        pan_label.add(com_tacgia);
        pan_label.add(button_themtacgia);
        pBook.add(pan_label);

        //panel.add(createPaneBorder(titleBorder,"title border center just and default prsition"));
        JPanel pan_button = new JPanel();
        pan_button.setLayout(null);
        //pan_button.setBackground(Color.WHITE);
        //pan_button.setBackground(new Color(204, 255, 255));
        pan_button.setBounds(700, 10, 350, 300);
        /*
        JLabel la = new JLabel("Chức năng");
        la.setFont(new Font("Tahoma", 3, 15));
         */
        //pan_button.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
        pan_button.setBorder(BorderFactory.createTitledBorder(blueBorder, "Chức năng", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        button_showAll = new JButton();
        button_showAll.setLayout(null);
        ImageIcon imAll = loadIcon("src/images/study.png",50,50);
        JLabel iconAll = new JLabel(imAll);
        iconAll.setBounds(0, 0, 50, 50);
        button_showAll.add(iconAll);
        JLabel labelAll = new JLabel("Danh sách");
        labelAll.setFont(new Font("Tahoma", 1, 17));
        labelAll.setBounds(50, 0, 90, 50);
        labelAll.setForeground(Color.yellow);
        button_showAll.add(labelAll);
        
        //button_showAll.setText("Danh sách");
        button_showAll.setBackground(new Color(204, 204, 0));
        //ImageIcon im = new ImageIcon("bieutuongtimkiem.jpg");
        
        //button_showAll.setIcon(im);
        button_showAll.setBounds(30, 30, 150, 50);
        button_showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txt1.setText(null);
                txt2.setText(null);
                txt3.setText(null);
                txt4.setText(null);
                txt6.setText(null);
                txt_timkiem.setText(null);
                txt_timkiemma.setText(null);
                label_hinhAnh.setIcon(null);
                Doc();
            }
        });
        pan_button.add(button_showAll);

        buttonThem = new JButton();
        //==============
        buttonThem.setLayout(null);
        ImageIcon imThem = loadIcon("src/images/iconThem.png",50,50);
        JLabel iconThem = new JLabel(imThem);
        iconThem.setBounds(0, 0, 50, 50);
        buttonThem.add(iconThem);
        JLabel labelThem = new JLabel("Thêm");
        labelThem.setFont(new Font("Tahoma", 1, 17));
        labelThem.setBounds(60, 0, 90, 50);
        labelThem.setForeground(Color.yellow);
        buttonThem.add(labelThem);
        //=========================
        buttonThem.setBackground(new Color(0, 255, 204));
        buttonThem.setBounds(30, 95, 150, 50);
        buttonThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Them();
                txt1.setText(null);
                txt2.setText(null);
                txt3.setText(null);
                txt4.setText(null);
                txt6.setText(null);
                label_hinhAnh.setIcon(null);
                
            }

        });
        pan_button.add(buttonThem);

        buttonSua = new JButton();
        //==============
        buttonSua.setLayout(null);
        ImageIcon imSua = loadIcon("src/images/paper.png",50,50);
        JLabel iconSua = new JLabel(imSua);
        iconSua.setBounds(0, 0, 50, 50);
        buttonSua.add(iconSua);
        JLabel labelSua = new JLabel("Sửa");
        labelSua.setFont(new Font("Tahoma", 1, 17));
        labelSua.setBounds(60, 0, 90, 50);
        labelSua.setForeground(Color.yellow);
        buttonSua.add(labelSua);
        //=========================
        //buttonSua.setText("Sửa");
        buttonSua.setBackground(new Color(255, 51, 51));
        buttonSua.setBounds(30, 160, 150, 50);
        buttonSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa","Alert",JOptionPane.YES_NO_OPTION);
                if(i==0)
                {
                    Sua();
                    txt1.setText(null);
                    txt2.setText(null);
                    txt3.setText(null);
                    txt4.setText(null);
                    txt6.setText(null);
                    label_hinhAnh.setIcon(null);
                }
                
            }

        });
        pan_button.add(buttonSua);

        buttonXoa = new JButton();
        //==============
        buttonXoa.setLayout(null);
        ImageIcon imXoa = loadIcon("src/images/iconXoa.png",50,50);
        JLabel iconXoa = new JLabel(imXoa);
        iconXoa.setBounds(0, 0, 50, 50);
        buttonXoa.add(iconXoa);
        JLabel labelXoa = new JLabel("Xóa");
        labelXoa.setFont(new Font("Tahoma", 1, 17));
        labelXoa.setBounds(60, 0, 90, 50);
        labelXoa.setForeground(Color.yellow);
        buttonXoa.add(labelXoa);
        //=========================
        buttonXoa.setBackground(new Color(0, 204, 255));
        buttonXoa.setBounds(30, 225, 150, 50);
        buttonXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa","Alert",JOptionPane.YES_NO_OPTION);
                if(i==0)
                {
                    Xoa();
                    txt1.setText(null);
                    txt2.setText(null);
                    txt3.setText(null);
                    txt4.setText(null);
                    txt6.setText(null);
                    label_hinhAnh.setIcon(null);
                }
            }

        });
        pan_button.add(buttonXoa);

        buttonClear = new JButton();
        //==============
        buttonClear.setLayout(null);
        ImageIcon imClear = loadIcon("src/images/iconClear.png",50,50);
        JLabel iconClear = new JLabel(imClear);
        iconClear.setBounds(0, 0, 50, 50);
        buttonClear.add(iconClear);
        JLabel labelClear = new JLabel("Clear");
        labelClear.setFont(new Font("Tahoma", 1, 17));
        labelClear.setBounds(60, 0, 90, 50);
        labelClear.setForeground(Color.yellow);
        buttonClear.add(labelClear);
        //=========================
        buttonClear.setBackground(new Color(102, 255, 51));
        buttonClear.setBounds(190, 30, 150, 50);
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txt1.setText(null);
                txt2.setText(null);
                txt3.setText(null);
                txt4.setText(null);
                txt6.setText(null);
                label_hinhAnh.setIcon(null);
            }

        });
        pan_button.add(buttonClear);

        buttonnhapE = new JButton();
        //==============
        buttonnhapE.setLayout(null);
        ImageIcon imNhap = loadIcon("src/images/import.png",50,50);
        JLabel iconNhap = new JLabel(imNhap);
        iconNhap.setBounds(0, 0, 50, 50);
        buttonnhapE.add(iconNhap);
        JLabel labelNhap = new JLabel("Nhập EXCEL");
        labelNhap.setFont(new Font("Tahoma", 1, 15));
        labelNhap.setBounds(50, 0, 90, 50);
        labelNhap.setForeground(Color.yellow);
        buttonnhapE.add(labelNhap);
        //=========================
        buttonnhapE.setBackground(new Color(102, 255, 51));
        buttonnhapE.setBounds(190, 95, 150, 50);
        pan_button.add(buttonnhapE);

        buttonxuatE = new JButton();
        //==============
        buttonxuatE.setLayout(null);
        ImageIcon imXuat = loadIcon("src/images/export.png",50,50);
        JLabel iconXuat = new JLabel(imXuat);
        iconXuat.setBounds(0, 0, 50, 50);
        buttonxuatE.add(iconXuat);
        JLabel labelXuat = new JLabel("Xuất EXCEL");
        labelXuat.setFont(new Font("Tahoma", 1, 15));
        labelXuat.setBounds(50, 0, 90, 50);
        labelXuat.setForeground(Color.yellow);
        buttonxuatE.add(labelXuat);
        //=========================
        buttonxuatE.setBackground(new Color(255, 51, 255));
        buttonxuatE.setBounds(190, 160, 150, 50);
        buttonxuatE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ExportExcel ex = new ExportExcel();
            }

        });
        pan_button.add(buttonxuatE);

        pBook.add(pan_button);

        label_vien = new JLabel("------------------------------------------------------------------------Tìm kiếm thông tin-----------------------------------------------------------------------");
        label_vien.setFont(new Font("Tahoma", 1, 15));
        label_vien.setBounds(50, 315, 1050, 30);
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

                    TimKiemTen(ten);
                }
            }
        });
        pBook.add(txt_timkiem);
        button_timkiem = new JButton();
        button_timkiem.setIcon(new ImageIcon("src/images/bieutuongtimkiem.jpg"));
        button_timkiem.setBounds(330, 350, 40, 39);
        button_timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ten = txt_timkiem.getText();
                ten = ten.trim();//cắt các dấu cách ở đầu và cuối chuỗi.
                TimKiemTen(ten);
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
                    timkiemma(index);
                }
            }
        });
        pBook.add(txt_timkiemma);
        button_timkiemma = new JButton();
        button_timkiemma.setIcon(new ImageIcon("src/images/bieutuongtimkiem.jpg"));
        button_timkiemma.setBounds(630, 350, 40, 39);
        button_timkiemma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = Integer.parseInt(txt_timkiemma.getText());
                timkiemma(index);
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
        com_gia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println(com_gia.getItemAt(com_gia.getSelectedIndex()));
                String choice = (String) com_gia.getItemAt(com_gia.getSelectedIndex());
                //System.out.println(choice);
                switch(choice)
                {
                    case "Không" :
                        Doc();
                        break;
                    case "Dưới 100K" :
                        TimKiemGia(0,100000);
                        break;
                    case "Từ 100K - 300K" :
                        TimKiemGia(100000,300000);
                        break;
                    case "Trên 300K" :
                        TimKiemGia(300000,30000000);
                        break;
                    default:
                }
            }

        });
        
        pBook.add(com_gia);
        
        JLabel ngaybatdau = new JLabel("Ngày bắt đầu: ");
        ngaybatdau.setFont(new Font("Tahoma", 1, 15));
        ngaybatdau.setBounds(50, 395, 140, 30);
        pBook.add(ngaybatdau);
        JTextField text = new JTextField(20);
        text.setBounds(50, 425, 120, 30);
        text.setFont(new Font("Tahoma", 1, 15));
        pBook.add(text);
        JButton butNgaybatdau = new JButton(new ImageIcon("src/images/calendar.png"));
        butNgaybatdau.setBounds(170, 425, 40, 29);
        final JFrame f = new JFrame();
        butNgaybatdau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				text.setText(new DatePicker(f).setPickedDateYearMonthDate());
			}
		});
        pBook.add(butNgaybatdau);
        
        JLabel ngayketthuc = new JLabel("Ngày kết thúc: ");
        ngayketthuc.setFont(new Font("Tahoma", 1, 15));
        ngayketthuc.setBounds(220, 395, 140, 30);
        pBook.add(ngayketthuc);
        JTextField textketthuc = new JTextField(20);
        textketthuc.setBounds(220, 425, 120, 30);
        textketthuc.setFont(new Font("Tahoma", 1, 15));
        pBook.add(textketthuc);
        JButton butNgayketthuc = new JButton(new ImageIcon("src/images/calendar.png"));
        butNgayketthuc.setBounds(340, 425, 40, 29);
        final JFrame f1 = new JFrame();
        butNgayketthuc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
		textketthuc.setText(new DatePicker(f1).setPickedDateYearMonthDate());
            }
	});
        pBook.add(butNgayketthuc);
        JLabel laTim = new JLabel("Tìm: ");
        laTim.setFont(new Font("Tahoma", 1, 15));
        laTim.setBounds(390, 395, 140, 30);
        pBook.add(laTim);
        JButton btTim = new JButton(new ImageIcon("src/images/bieutuongtimkiem.jpg"));
        btTim.setBounds(390, 425, 40, 30);
        
        btTim.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae) {
                TimKiemDate(text.getText(), textketthuc.getText());
            }
	});
        pBook.add(btTim);
        TaoTable();

        return pBook;
    }
    public void kt()
    {
        
        Book_BUS bus = new Book_BUS();
        ArrayList<Book_DTO> arr = bus.Select_TheLoai();
        modelComTheLoai = new  DefaultComboBoxModel();
        for(Book_DTO dto : arr)
        {
           
            modelComTheLoai.addElement(dto.genre_name);
            //modelCom.addElement(dto.genre_id);
        }
        com_theloai = new JComboBox(modelComTheLoai);
        com_theloai.setBounds(120, 180, 170, 30);

    }
    public void TaoTable() {
        /*
        table.setModel(new DefaultTableModel(
                new Object[][]{
                    
                },
                new String[]{
                    "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá (VNĐ)", "Mã thể loại", "Ngày xuất bản", "Mã ID tác giả", "isbn"
                }
        ));
        */
        Doc();
        jscrollpane.setBounds(50, 470, 1005, 206);
        //pBook.add(jscrollpane);
        //JTableHeader tbh = table.getTableHeader();
        //tbh.setFont(new Font("Tahoma", 1, 15));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setBackground(new Color(153, 204, 255));
        table.getTableHeader().setFont(new Font("Tahoma", 1, 13));
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);//độ rộng của cột
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        //tbh.setForeground(Color.yellow);
        table.setSelectionBackground(new Color(255, 255, 0));//màu nền khi click chuột vào một row trên table
        table.setGridColor(new Color(102, 255, 51));
        
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = table.getSelectedRow();
                
                //JOptionPane.showMessageDialog(null, "row:"+i);
                txt1.setText(table.getModel().getValueAt(i, 0).toString());
                txt2.setText(table.getModel().getValueAt(i, 1).toString());
                txt3.setText(table.getModel().getValueAt(i, 2).toString());
                txt4.setText(table.getModel().getValueAt(i, 3).toString());
                //txt5.setText(table.getModel().getValueAt(i, 4).toString());
                com_theloai.setSelectedItem(table.getModel().getValueAt(i, 4).toString());
                txt6.setText(table.getModel().getValueAt(i, 5).toString());
                //txt7.setText(table.getModel().getValueAt(i, 6).toString());
                com_tacgia.setSelectedItem(table.getModel().getValueAt(i, 6).toString());
                
                ImageIcon iiconBook = loadIcon("src/images/"+table.getModel().getValueAt(i, 7).toString(), 290, 240);
                label_hinhAnh.setIcon(iiconBook);
                
                //txt1.setEditable(true);
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                //table.setSelectionBackground(new Color(254, 255, 0));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //table.setBackground(Color.red);
            }
        });
        pBook.add(jscrollpane);
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
        FrameHienThi_Book fr = new FrameHienThi_Book();
    }

    public void Doc() {
        Book_BUS bus = new Book_BUS();
        /*
        if (BUS.ds == null) {
            bus.showAll();
        }*/
        ArrayList<Book_DTO> arr = bus.showAll();
        Vector header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Số lượng");
        header.add("Đơn giá (VNĐ)");
        header.add("Tên thể loại");
        header.add("Ngày xuất bản");
        header.add("Tên tác giả");
        header.add("File ảnh");

        model = new DefaultTableModel(header, 0);

        for (Book_DTO dto : arr) {
            Vector row = new Vector();
            row.add(dto.book_id);
            row.add(dto.title);
            row.add(dto.availabel_quantity);
            row.add(dto.price);
            row.add(dto.genre_name);
            row.add(dto.publication_date);
            row.add(dto.author_firstname+" "+dto.author_lastname);
            row.add(dto.file_anh);
            model.addRow(row);

        }
        table.setModel(model);

    }
    
    public void Them() {
        
        
        if(txt2.getText().isEmpty()||txt3.getText().isEmpty()||txt4.getText().isEmpty()||txt6.getText().isEmpty()||file.getName().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin!");
        }
        else
        {
            int i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm","Alert",JOptionPane.YES_NO_OPTION);
            if(i==0)
            {
                Book_BUS bus = new Book_BUS();
                ArrayList<Book_DTO> dsTheloai = bus.Select_TheLoai();
                ArrayList<Book_DTO> dsTacgia = bus.Select_TacGia();
                int maTL,maTG,idTL=1,idTG=1;
                String tenTL,last_name,first_name;
                file.getAbsolutePath();//lấy đg dẫn
                //cắt ảnh bỏ qua thư mục
                file.renameTo(new File(/*"C:\\Users\\ACER\\Documents\\NetBeansProjects\\c\\src\\images\\"*/ "src/images/" + file.getName()));

                               for(Book_DTO book : dsTheloai)
                {
                    maTL = book.genre_id;
                    tenTL = book.genre_name;
                    if(tenTL.equals(com_theloai.getItemAt(com_theloai.getSelectedIndex())))
                    {
                        idTL = maTL;
                    }
                }

                for(Book_DTO book : dsTacgia)
                {
                    maTG = book.author_id;
                    first_name = book.author_firstname;
                    last_name = book.author_lastname;
                    if((first_name+" "+last_name).equals(com_tacgia.getItemAt(com_tacgia.getSelectedIndex())))
                    {
                        idTG = maTG;
                    }
                }
                Book_DTO dto = new Book_DTO();

                dto.title = txt2.getText();
                dto.availabel_quantity = Integer.parseInt(txt3.getText());
                dto.price = Integer.parseInt(txt4.getText());
                //dto.genre_id = Integer.parseInt(txt5.getText());
                dto.genre_id = idTL;
                dto.publication_date = txt6.getText();
                //dto.author_id = Integer.parseInt(txt7.getText());
                dto.author_id = idTG;
                dto.file_anh = file.getName();
                bus.Them(dto);

                Doc();
            }
        }
    }
    public void Sua() {
        Book_BUS bus = new Book_BUS();
        ArrayList<Book_DTO> dsTheloai = bus.Select_TheLoai();
        ArrayList<Book_DTO> dsTacgia = bus.Select_TacGia();
        int maTL,maTG,idTL=1,idTG=0;
        String tenTL,last_name,first_name;
        file.getAbsolutePath();//lấy đg dẫn
        //cắt ảnh bỏ qua thư mục
        file.renameTo(new File("C:\\Users\\ACER\\Documents\\NetBeansProjects\\c\\src\\images\\" + file.getName()));
        for(Book_DTO book : dsTheloai)
        {
            maTL = book.genre_id;
            tenTL = book.genre_name;
            if(tenTL.equals(com_theloai.getItemAt(com_theloai.getSelectedIndex())))
            {
                idTL = maTL;
            }
        }
        for(Book_DTO book : dsTacgia)
        {
            maTG = book.author_id;
            first_name = book.author_firstname;
            last_name = book.author_lastname;
            if((first_name+" "+last_name).equals(com_tacgia.getItemAt(com_tacgia.getSelectedIndex())))
            {
                idTG = maTG;
            }
        }
        Book_DTO dto = new Book_DTO();
        dto.book_id = Integer.parseInt(txt1.getText());
        dto.title = txt2.getText();
        dto.availabel_quantity = Integer.parseInt(txt3.getText());
        dto.price = Integer.parseInt(txt4.getText());
        dto.genre_id = idTL;
        dto.publication_date = txt6.getText();
        dto.author_id = idTG;
        dto.file_anh = file.getName();
        bus.Sua(dto);
        
        Doc();
    }

    
    public void Xoa() {
        String id = txt1.getText();
        Book_BUS bus = new Book_BUS();
        bus.Xoa(id);
        Doc();
    }
    
    public void TimKiemTen(String ten)
    {
        if(ten.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Chưa nhập giá trị cần tìm!");
        }
        else
        {
            Book_BUS bus = new Book_BUS();
            ArrayList<Book_DTO> arr = bus.showAll();
            if (arr == null) {
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
            header.add("File ảnh");

            model = new DefaultTableModel(header, 0);
            for (Book_DTO dto : arr) 
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
                    row.add(dto.file_anh);
                    model.addRow(row);
                }
            }
            table.setModel(model);
        }
        
    }
    
    public void timkiemma(int ma)
    {
        Book_BUS bus = new Book_BUS();
        ArrayList<Book_DTO> arr = bus.showAll();
        if (arr == null) {
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
        header.add("File ảnh");

        model = new DefaultTableModel(header, 0);
        for (Book_DTO dto : arr) 
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
                row.add(dto.file_anh);
                model.addRow(row);
            }
        }
        table.setModel(model);
    }
   
    public void TimKiemGia(int gia1, int gia2)
    {
        Book_BUS bus = new Book_BUS();
        ArrayList<Book_DTO> arr = bus.showAll();
        if (arr == null) {
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
        header.add("File ảnh");

        model = new DefaultTableModel(header, 0);
        for (Book_DTO dto : arr) 
        {
            if(dto.price>=gia1 && dto.price<gia2)
            {
                Vector row = new Vector();
                row.add(dto.book_id);
                row.add(dto.title);
                row.add(dto.availabel_quantity);
                row.add(dto.price);
                row.add(dto.genre_name);
                row.add(dto.publication_date);
                row.add(dto.author_firstname+" "+dto.author_lastname);
                row.add(dto.file_anh);
                model.addRow(row);
            }
        }
        table.setModel(model);
    }
   
    
    public void TimKiemDate(String day1, String day2)
    {
        if(day1.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Chưa nhập giá trị cần tìm!");
        }
        else
        {
            Book_BUS bus = new Book_BUS();
            /*
            if (BUS.ds == null) {
                bus.showAll();
            }*/
            ArrayList<Book_DTO> arr = bus.TimKiemDate(day1, day2);
            Vector header = new Vector();
            header.add("Mã sản phẩm");
            header.add("Tên sản phẩm");
            header.add("Số lượng");
            header.add("Đơn giá (VNĐ)");
            header.add("Tên thể loại");
            header.add("Ngày xuất bản");
            header.add("Tên tác giả");
            header.add("File ảnh");

            model = new DefaultTableModel(header, 0);

            for (Book_DTO dto : arr) {
                Vector row = new Vector();
                row.add(dto.book_id);
                row.add(dto.title);
                row.add(dto.availabel_quantity);
                row.add(dto.price);
                row.add(dto.genre_name);
                row.add(dto.publication_date);
                row.add(dto.author_firstname+" "+dto.author_lastname);
                row.add(dto.file_anh);
                model.addRow(row);

            }
            table.setModel(model);
        }
    }
}
