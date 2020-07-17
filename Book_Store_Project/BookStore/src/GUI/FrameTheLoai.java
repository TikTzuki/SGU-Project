/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Book_BUS;
import DTO.Book_DTO;
import DTO.Staff;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class FrameTheLoai extends JFrame{
    JLabel label_1,label_2,label_timkiemMa,label_timkiemTen;
    JTextField txt1,txt2,txt_timkiemMa,txt_timkiemTen;
    JButton buttonthem,buttonsua,buttonxoa,buttonshowall,button_timkiemMa, button_timkiemTen;
    JPanel pChinh;
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane jscrollpane = new JScrollPane(table);
    
    public FrameTheLoai() {
        
        setSize(500, 400);
        setLayout(null);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pan = init();
        add(pan);
        //Doc();
        setVisible(true);
        
    }

    public JPanel init()
    {
        pChinh = new JPanel();
        pChinh.setPreferredSize(new Dimension(500,400));
        pChinh.setBounds(0, 0, 500, 400);
        //pChinh.setBackground(new Color(204, 255, 255));
        pChinh.setLayout(null);
        pChinh.setBorder(Cl.blueLine);
        label_1 = new JLabel("Mã thể loại ");
        label_1.setBounds(20, 20, 80, 30);
        pChinh.add(label_1);
        label_2 = new JLabel("Tên thể loại ");
        label_2.setBounds(20, 60, 80, 30);
        pChinh.add(label_2);
        
        txt1 = new JTextField();
        txt1.setBounds(100, 20, 200, 30);
        txt1.setEditable(false);
        pChinh.add(txt1);
        
        txt2 = new JTextField();
        txt2.setBounds(100, 60, 200, 30);
        pChinh.add(txt2);
        
        JPanel pan_button = new JPanel();
        pan_button.setLayout(null);
        //pan_button.setBackground(new Color(204, 255, 255));
        pan_button.setBounds(320, 10, 160, 180);
        Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
        pan_button.setBorder(BorderFactory.createTitledBorder(blueBorder, "Chức năng", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        
        buttonshowall = new JButton();
        buttonshowall.setText("Danh sách");
        buttonshowall.setBackground(new Color(204, 204, 0));
        buttonshowall.setBounds(20, 20, 120, 30);
        buttonshowall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Doc();
            }

        });
        pan_button.add(buttonshowall);
        
        buttonthem = new JButton();
        buttonthem.setText("Thêm");
        buttonthem.setBackground(new Color(0, 255, 204));
        buttonthem.setBounds(20, 60, 120, 30);
        buttonthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ThemTheLoai();
            }

        });
        pan_button.add(buttonthem);
        buttonsua = new JButton();
        buttonsua.setText("Sửa");
        buttonsua.setBackground(new Color(255, 51, 51));
        buttonsua.setBounds(20, 100, 120, 30);
        buttonsua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SuaTheLoai();
            }

        });
        pan_button.add(buttonsua);
        buttonxoa = new JButton();
        buttonxoa.setText("Xóa");
        buttonxoa.setBackground(new Color(0, 204, 255));
        buttonxoa.setBounds(20, 140, 120, 30);
        buttonxoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int id = Integer.parseInt(txt1.getText());
                XoaTheLoai(id);
            }

        });
        pan_button.add(buttonxoa);
        
        pChinh.add(pan_button);
        
        JPanel pan_timkiem= new JPanel();
        pan_timkiem.setLayout(null);
        pan_timkiem.setBounds(20, 100, 300, 90);
        pan_timkiem.setBackground(new Color(255,204,204));
        Border blueBordertimkiem = BorderFactory.createLineBorder(Color.BLUE);
        pan_timkiem.setBorder(BorderFactory.createTitledBorder(blueBordertimkiem, "Tìm kiếm", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        
        label_timkiemMa = new JLabel();
        label_timkiemMa.setText("Tìm kiếm mã");
        label_timkiemMa.setFont(new Font("Tahoma", 1, 12));
        label_timkiemMa.setBounds(10, 15, 80, 30);
        pan_timkiem.add(label_timkiemMa);
        txt_timkiemMa = new JTextField("Nhập Mã...");
        txt_timkiemMa.setBounds(90, 15, 100, 31);
        txt_timkiemMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_timkiemMa.setText(null);
            }
        });
        txt_timkiemMa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    int ma = Integer.parseInt(txt_timkiemMa.getText());;
                
                    timkiemma(ma);
                }
            }
        });
        pan_timkiem.add(txt_timkiemMa);
        button_timkiemMa = new JButton();
        button_timkiemMa.setIcon(new ImageIcon("bieutuongtimkiem.jpg"));
        button_timkiemMa.setBounds(190, 15, 40, 30);
        button_timkiemMa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int ma = Integer.parseInt(txt_timkiemMa.getText());;
                
                timkiemma(ma);
            }

        });
        
        pan_timkiem.add(button_timkiemMa);

        label_timkiemTen = new JLabel();
        label_timkiemTen.setText("Tìm kiếm tên");
        label_timkiemTen.setFont(new Font("Tahoma", 1, 12));
        label_timkiemTen.setBounds(10, 51, 80, 30);
        pan_timkiem.add(label_timkiemTen);
        txt_timkiemTen = new JTextField("Nhập Tên thể loại...");
        txt_timkiemTen.setBounds(90, 51, 160, 31);
        txt_timkiemTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_timkiemTen.setText(null);
            }
        });
        txt_timkiemTen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    String ten = txt_timkiemTen.getText();
                    ten = ten.trim();//cắt các dấu cách ở đầu và cuối chuỗi.

                    TimKiemTen(ten);
                }
            }
        });
        pan_timkiem.add(txt_timkiemTen);
        button_timkiemTen = new JButton();
        button_timkiemTen.setIcon(new ImageIcon("bieutuongtimkiem.jpg"));
        button_timkiemTen.setBounds(250, 51, 40, 30);
        button_timkiemTen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ten = txt_timkiemTen.getText();
                ten = ten.trim();//cắt các dấu cách ở đầu và cuối chuỗi.
                
                TimKiemTen(ten);
            }

        });
        
        pan_timkiem.add(button_timkiemTen);
        
        pChinh.add(pan_timkiem);
        TaoTable();
        return pChinh;
    }
    public void TaoTable() {
        
        table.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null},
                },
                new String[]{
                    "Mã thể loại", "Tên thể loại"
                }
        ));
        
        Doc();
        jscrollpane.setBounds(20, 200, 460, 150);
        //pBook.add(jscrollpane);
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
            }
        });
        pChinh.add(jscrollpane);
    }
    public static void main(String[] args) {
        new FrameTheLoai();
    }
    
    public void Doc()
    {
        Book_BUS bus = new Book_BUS();
        /*
        if (BUS.ds == null) {
            bus.showAll();
        }*/
        ArrayList<Book_DTO> arr = bus.Select_TheLoai();
        Vector header = new Vector();
        header.add("Mã thể loại");
        header.add("Tên thể loại");

        model = new DefaultTableModel(header, 0);

        for (Book_DTO dto : arr) {
            Vector row = new Vector();
            row.add(dto.genre_id);
            row.add(dto.genre_name);
            model.addRow(row);

        }
        table.setModel(model);
    }
    //========Thêm
    public void ThemTheLoai()
    {
        Book_DTO dto = new Book_DTO();
        dto.genre_name = txt2.getText();
        Book_BUS bus = new Book_BUS();
        bus.ThemTheLoai(dto);
        Doc();
    }
    //Sửa
    public void SuaTheLoai()
    {
        Book_DTO dto = new Book_DTO();
        dto.genre_id = Integer.parseInt(txt1.getText());
        dto.genre_name = txt2.getText();
        Book_BUS bus = new Book_BUS();
        bus.SuaTheLoai(dto);
        Doc();
    }
    public void XoaTheLoai(int id)
    {
        //Book_DTO dto = new Book_DTO();
        //dto.genre_id = Integer.parseInt(txt1.getText());
        //dto.genre_name = txt2.getText();
        Book_BUS bus = new Book_BUS();
        bus.XoaTheLoai(id);
        Doc();
    }
    
    public void timkiemma(int ma)
    {
        Book_BUS bus = new Book_BUS();
        ArrayList<Book_DTO> arr = bus.Select_TheLoai();
        
        Vector header = new Vector();
        header.add("Mã thể loại");
        header.add("Tên thể loại");

        model = new DefaultTableModel(header, 0);
        for (Book_DTO dto : arr) 
        {
            if(dto.genre_id==ma)
            {
                Vector row = new Vector();
                row.add(dto.genre_id);
                row.add(dto.genre_name);
                model.addRow(row);
            }
        }
        table.setModel(model);
    }
    
    public void TimKiemTen(String ten)
    {
        Book_BUS bus = new Book_BUS();
        ArrayList<Book_DTO> arr = bus.Select_TheLoai();
        
        Vector header = new Vector();
        header.add("Mã thể loại");
        header.add("Tên thể loại");

        model = new DefaultTableModel(header, 0);
        for (Book_DTO dto : arr) 
        {
            //dto.title.startsWith(ten) : coi thử dto.title có bằng chuỗi tên ko.
            dto.genre_name = dto.genre_name.trim();
            int index = dto.genre_name.compareToIgnoreCase(ten);//nếu so sánh hai chuổi bằng nha thì trả về 0.
            if(index == 0)
            {
                Vector row = new Vector();
                row.add(dto.genre_id);
                row.add(dto.genre_name);
                model.addRow(row);
            }
        }
        table.setModel(model);
    }
}
