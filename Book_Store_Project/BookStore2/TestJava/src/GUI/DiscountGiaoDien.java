/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BUSGetDiscount;
import BUS.BUSGetDiscount_detail;
import DTO.Discount;
import DTO.Discount_detail;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class DiscountGiaoDien extends JPanel implements ActionListener {

    JTable table = new JTable();
    DefaultTableModel modelTableBook;
    JScrollPane jscrollpane = new JScrollPane(table);
    String[] s = {"id", "name", "type", "start_date", "end_date"};

    JPanel p1, p2, p3, p4, p5, p8, p9;
    JFrame p6, p7, F1;
    JLabel tieuDe, chucNang, id, txtId, name, type, start_date, end_date, status, book_id, percent, tieuDeBangDiscount, tieuDeBangDetail,
            tieuDeTimKiem, timKiemP6, ChonId_Detail, NhapBookId_Detail, NhapPercent_Detail, panelTimKiem_id, panelTimKiem_name, panelTimKiem_type,
            panelTimKiem_start_date, panelTimKiem_end_date, panelChonXoa;
    JTextField txtName, txtType, txtStart_date, txtEnd_date, txtStatus, txtBook_id, txtPercent, txtTimKiemP6, txtNhapId_Detail,
            txtBook_id_Detail, txtPercent_Detail, txtTimKiem_name, txtTimKiem_type, txtTimKiem_start_date, txtTimKiem_end_date;
    JButton btThem, btXoa, btSua, btClear, btTimKiemId, btTimKiem_Oke, btTatTimKiem, btThemDetail, btThemDetail_Oke, btTimKiemALL,
            btXoaDiscount, btXoaDiscount_detail;

    //tabelDetail
    JTable tableDetail = new JTable();
    DefaultTableModel modelTableDetail;
    JScrollPane jscrollpaneDetail = new JScrollPane(tableDetail);
    //String[] f = {"id", "book_id", "percent"};
    JTable arrayAllTable[] = {table,tableDetail};
    public DiscountGiaoDien() {
        //setTitle("Discount");
        //setSize(1100, 700);
        //setLayout(null);
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //TaoLabel();
        //TaoTable();

        //setVisible(true);
    }
    
    public JPanel init(){
        this.setPreferredSize(new Dimension(1110,700));
        this.setBackground(Cl.colorBackground);
        this.setBorder(Cl.blueLine);
        setSize(1100, 700);
        setLayout(null);
        TaoLabel();
        TaoTable();
        return this;
    }
    /*
    public static void main(String[] args) {
        try {
            new DiscountGiaoDien();

        } catch (Exception ex) {
            Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    public void TaoLabel() {
        p1 = new JPanel();
        p1.setBackground(Cl.colorBackground);
        p1.setBounds(3, 3, 1100, 400);
        p1.setLayout(null);
        //p1.setBackground(Color.white);
        this.add(p1);
        

        p2 = new JPanel();
        p2.setBackground(Cl.colorBackground);
        p2.setBounds(-10, 60, 420, 340);
        GridLayout layout2 = new GridLayout(7, 2);
        layout2.setHgap(-20);
        layout2.setVgap(10);
        p2.setLayout(layout2);
        p1.add(p2);

        p3 = new JPanel();
        p3.setBackground(Cl.colorBackground);
        p3.setBounds(3, 3, 0, 0);
        this.add(p3);

        p4 = new JPanel();
        p4.setBackground(Cl.colorBackground);
        p4.setBounds(490, -20, 200, 480);
        //p4.setLayout(new FlowLayout(FlowLayout.CENTER)); // Layout xếp theo hàng ngang, nếu k đủ thì xuống dòng\
        FlowLayout layout1 = new FlowLayout(); // Flow layout có căn chỉnh khoảng cách giứa các thành phần
        layout1.setHgap(0);        // chiều ngang      
        layout1.setVgap(25);         // chiều dọc
        p4.setLayout(layout1);
        p1.add(p4);

        p5 = new JPanel();
        p5.setBackground(Cl.colorBackground);
        p5.setBounds(3, 445, 1100, 245);
        p5.setLayout(null);
        this.add(p5);

        p9 = new JPanel();
        p9.setBackground(Cl.colorBackground);
        p9.setBounds(750, 60, 300, 275);
        GridLayout layout9 = new GridLayout(5, 2);
        layout9.setHgap(-10);
        layout9.setVgap(20);
        p9.setLayout(layout9);
        p1.add(p9);

        //label
        tieuDe = new JLabel("Thông Tin Khuyến Mãi");
        tieuDe.setBounds(110, 0, 300, 40);
        tieuDe.setFont(Cl.fontContentXXLB); // chỉnh kích thước cho Label
        tieuDe.setForeground(Cl.colorBlue);
        p1.add(tieuDe);

        chucNang = new JLabel("Chức Năng");
        chucNang.setFont(Cl.fontContentXXLB); // chỉnh kích thước cho Label
        chucNang.setForeground(Cl.colorBlue);
        p4.add(chucNang);

        tieuDeTimKiem = new JLabel("- Tìm Kiếm -");
        tieuDeTimKiem.setBounds(830, 0, 300, 40);
        tieuDeTimKiem.setFont(Cl.fontContentXXLB); // chỉnh kích thước cho Label
        tieuDeTimKiem.setForeground(Cl.colorBlue);
        p1.add(tieuDeTimKiem);

        name = new JLabel("Tên: ");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(Cl.fontContentXL);
        name.setForeground(Cl.colorBlue);

        type = new JLabel("Thể loại: ");
        type.setHorizontalAlignment(JLabel.CENTER);
        type.setFont(Cl.fontContentXL);
        type.setForeground(Cl.colorBlue);

        start_date = new JLabel("Ngày bắt đầu: ");
        start_date.setHorizontalAlignment(JLabel.CENTER);
        start_date.setFont(Cl.fontContentXL);
        start_date.setForeground(Cl.colorBlue);

        end_date = new JLabel("Ngày kết thúc: ");
        end_date.setHorizontalAlignment(JLabel.CENTER);
        end_date.setFont(Cl.fontContentXL);
        end_date.setForeground(Cl.colorBlue);

        status = new JLabel("Status: ");
        status.setHorizontalAlignment(JLabel.CENTER);
        status.setFont(Cl.fontContentXL);
        status.setForeground(Cl.colorBlue);

        book_id = new JLabel("Mã sách: ");
        book_id.setHorizontalAlignment(JLabel.CENTER);
        book_id.setFont(Cl.fontContentXL);
        book_id.setForeground(Cl.colorBlue);

        percent = new JLabel("Phần trăm: ");
        percent.setHorizontalAlignment(JLabel.CENTER);
        percent.setFont(Cl.fontContentXL);
        percent.setForeground(Cl.colorBlue);

        //txt
        txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(130, 30));
        txtName.setBorder(Cl.whiteLineS);

        txtType = new JTextField();
        txtType.setPreferredSize(new Dimension(130, 30));
        txtType.setBorder(Cl.whiteLineS);

        txtStart_date = new JTextField();
        txtStart_date.setPreferredSize(new Dimension(130, 30));
        txtStart_date.setBorder(Cl.whiteLineS);

        txtEnd_date = new JTextField();
        txtEnd_date.setPreferredSize(new Dimension(130, 30));
        txtEnd_date.setBorder(Cl.whiteLineS);

        txtStatus = new JTextField();
        txtStatus.setPreferredSize(new Dimension(130, 30));
        txtStatus.setBorder(Cl.whiteLineS);

        txtBook_id = new JTextField();
        txtBook_id.setPreferredSize(new Dimension(130, 30));
        txtBook_id.setBorder(Cl.whiteLineS);

        txtPercent = new JTextField();
        txtPercent.setPreferredSize(new Dimension(130, 30));
        txtPercent.setBorder(Cl.whiteLineS);

        p2.add(name);
        p2.add(txtName);
        p2.add(type);
        p2.add(txtType);
        p2.add(start_date);
        p2.add(txtStart_date);
        p2.add(end_date);
        p2.add(txtEnd_date);
        p2.add(book_id);
        p2.add(txtBook_id);
        p2.add(percent);
        p2.add(txtPercent);
        p2.add(status);
        p2.add(txtStatus);

        //button
        btClear = new JButton("Xuất Dữ Liệu");
        btClear.setPreferredSize(new Dimension(180, 45));
        btClear.setFont(Cl.fontContentXL);
        btClear.setBackground(Cl.colorBackground);
        btClear.setBorder(Cl.greenLine);
        btClear.setForeground(Cl.colorGreen);
        btClear.setActionCommand("buttonXuatDuLieu");
        btClear.addActionListener(this);

        btThem = new JButton("Thêm");
        btThem.setPreferredSize(new Dimension(180, 45));
        btThem.setFont(Cl.fontContentXL);
        btThem.setBackground(Cl.colorBackground);
        btThem.setBorder(Cl.blueLine);
        btThem.setForeground(Cl.colorBlue);
        btThem.setActionCommand("buttonThem");
        btThem.addActionListener(this);

        btSua = new JButton("Sửa");
        btSua.setPreferredSize(new Dimension(180, 45));
        btSua.setFont(Cl.fontContentXL);
        btSua.setBackground(Cl.colorBackground);
        btSua.setBorder(Cl.blueLine);
        btSua.setForeground(Cl.colorBlue);
        btSua.setActionCommand("buttonSua");
        btSua.addActionListener(this);

        btXoa = new JButton("Xóa");
        btXoa.setPreferredSize(new Dimension(180, 45));
        btXoa.setFont(Cl.fontContentXL);
        btXoa.setBackground(Cl.colorBackground);
        btXoa.setBorder(Cl.blueLine);
        btXoa.setForeground(Cl.colorBlue);
        btXoa.setActionCommand("buttonXoa");
        btXoa.addActionListener(this);

        btThemDetail = new JButton("Thêm chi tiết");
        btThemDetail.setPreferredSize(new Dimension(180, 45));
        btThemDetail.setFont(Cl.fontContentXL);
        btThemDetail.setBackground(Cl.colorBackground);
        btThemDetail.setBorder(Cl.blueLine);
        btThemDetail.setForeground(Cl.colorBlue);
        btThemDetail.setActionCommand("buttonThemDetail");
        btThemDetail.addActionListener(this);

        p4.add(btClear);
        p4.add(btThem);
        p4.add(btSua);
        p4.add(btXoa);
        p4.add(btThemDetail);

        //p5
        tieuDeBangDiscount = new JLabel("Thông Tin Khuyến Mãi ");
        tieuDeBangDiscount.setBounds(230, 0, 400, 50);
        tieuDeBangDiscount.setFont(Cl.fontContentXXLB);
        tieuDeBangDiscount.setForeground(Cl.colorBlue);
        p5.add(tieuDeBangDiscount);

        tieuDeBangDetail = new JLabel("");
        tieuDeBangDetail.setBounds(780, 0, 400, 50);
        tieuDeBangDetail.setFont(Cl.fontContentXXLB);
        tieuDeBangDetail.setForeground(Cl.colorBlue);
        p5.add(tieuDeBangDetail);

        //p9
        panelTimKiem_id = new JLabel("Theo mã: ");
        panelTimKiem_id.setHorizontalAlignment(JLabel.CENTER);
        panelTimKiem_id.setFont(new Font("Helvetica", Font.PLAIN, 18));

        panelTimKiem_name = new JLabel("Theo tên: ");
        panelTimKiem_name.setHorizontalAlignment(JLabel.CENTER);
        panelTimKiem_name.setFont(new Font("Helvetica", Font.PLAIN, 18));

        panelTimKiem_type = new JLabel("Theo thể loại: ");
        panelTimKiem_type.setHorizontalAlignment(JLabel.CENTER);
        panelTimKiem_type.setFont(new Font("Helvetica", Font.PLAIN, 18));

        panelTimKiem_start_date = new JLabel("Ngày bắt đầu: ");
        panelTimKiem_start_date.setHorizontalAlignment(JLabel.CENTER);
        panelTimKiem_start_date.setFont(new Font("Helvetica", Font.PLAIN, 18));

        panelTimKiem_end_date = new JLabel("Ngày kết thúc: ");
        panelTimKiem_end_date.setHorizontalAlignment(JLabel.CENTER);
        panelTimKiem_end_date.setFont(new Font("Helvetica", Font.PLAIN, 18));
        
        // ADD BY TIK
        JLabel lblSearch[] = {panelTimKiem_id, panelTimKiem_name, panelTimKiem_type,panelTimKiem_start_date,  panelTimKiem_end_date};
        for(int i=0; i<lblSearch.length; i++){
            lblSearch[i].setForeground(Cl.colorBlue);
            lblSearch[i].setFont(Cl.fontContentXL);
        }//

        txtTimKiem_name = new JTextField();
        txtTimKiem_name.setPreferredSize(new Dimension(130, 30));

        txtTimKiem_type = new JTextField();
        txtTimKiem_type.setPreferredSize(new Dimension(130, 30));

        txtTimKiem_start_date = new JTextField();
        txtTimKiem_start_date.setPreferredSize(new Dimension(130, 30));

        txtTimKiem_end_date = new JTextField();
        txtTimKiem_end_date.setPreferredSize(new Dimension(130, 30));

        btTimKiemId = new JButton("Tìm Mã");
        btTimKiemId.setPreferredSize(new Dimension(180, 45));
        btTimKiemId.setBackground(Cl.colorBackground);
        btTimKiemId.setForeground(Cl.colorBlue);
        btTimKiemId.setBorder(Cl.blueLine);
        btTimKiemId.setFont(Cl.fontContentXXL);
        btTimKiemId.setActionCommand("buttonTimKiem");
        btTimKiemId.addActionListener(this);

        p9.add(panelTimKiem_id);
        p9.add(btTimKiemId);
        p9.add(panelTimKiem_name);
        p9.add(txtTimKiem_name);
        p9.add(panelTimKiem_type);
        p9.add(txtTimKiem_type);
        p9.add(panelTimKiem_start_date);
        p9.add(txtTimKiem_start_date);
        p9.add(panelTimKiem_end_date);
        p9.add(txtTimKiem_end_date);

        btTimKiemALL = new JButton("Tìm Kiếm");
        btTimKiemALL.setBounds(830, 355, 180, 45);
        btTimKiemALL.setForeground(Cl.colorBlue);
        btTimKiemALL.setBackground(Cl.colorBackground);
        btTimKiemALL.setFont(Cl.fontContentXXL);
        btTimKiemALL.setBorder(Cl.blueLine);
        btTimKiemALL.setActionCommand("buttonTimKiemALL");
        btTimKiemALL.addActionListener(this);
        p1.add(btTimKiemALL);
        showColorTable(arrayAllTable);
    }

    int idPhanTuClick;

    public void TaoTable() {
        BUSGetDiscount busDiscount = new BUSGetDiscount();
        ArrayList<Discount> discountList = new ArrayList<>();
        try {
            discountList = busDiscount.getDiscount("status=1");  // dk status =1 moi xuat du lieu hang do
        } catch (Exception ex) {
            Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
        }

        modelTableBook = new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},},
                new String[]{
                    "Mã khuyến mãi", "Tên", "Thể loại", "Ngày bắt đầu", "Ngày kết thúc"
                });
        modelTableBook.setRowCount(0); // Cho mất các ô trống trong table
        table.setModel(modelTableBook);
        for (Discount discount : discountList) {
            modelTableBook.addRow(
                    new Object[]{
                        discount.getDiscount_id(),
                        discount.getDiscount_name(),
                        discount.getDiscount_type(),
                        discount.getStart_date(),
                        discount.getEnd_date(),
                        discount.getStatus(),}
            );
        }

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = table.getSelectedRow();

                txtName.setText(modelTableBook.getValueAt(i, 1).toString());
                txtType.setText(modelTableBook.getValueAt(i, 2).toString());
                txtStart_date.setText(modelTableBook.getValueAt(i, 3).toString());
                txtEnd_date.setText(modelTableBook.getValueAt(i, 4).toString());
                //txtStatus.setText(modelTableBook.getValueAt(i, 5).toString());

                idPhanTuClick = Integer.parseInt(modelTableBook.getValueAt(i, 0).toString());
                TaoTableDetail();  // Khi click mới cho hiện tableDetail này

                tieuDeBangDetail.setText("Chi Tiết Khuyến Mãi");
            }
        });
        jscrollpane.setBounds(10, 55, 710, 150);
        p5.add(jscrollpane);
        //table.getTableHeader().setBackground(Color.CYAN);
    }

    public void TaoTableDetail() {
        BUSGetDiscount_detail busDiscount_detail = new BUSGetDiscount_detail();
        ArrayList<Discount_detail> discount_detailList = new ArrayList<>();

        try {
            discount_detailList = busDiscount_detail.getDiscount_detail("discount_id=" + idPhanTuClick);
            //System.out.println(""+idPhanTuClick);
        } catch (Exception ex) {
            Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
        }

        modelTableDetail = new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},},
                new String[]{
                    "Mã khuyến mãi", "Tên sách", "Phần trăm", "Status"
                });
        modelTableDetail.setRowCount(0); // Cho mất các ô trống trong table
        tableDetail.setModel(modelTableDetail);
        for (Discount_detail discount_detail : discount_detailList) {
            modelTableDetail.addRow(
                    new Object[]{
                        discount_detail.getDiscount_id(),
                        discount_detail.getBook_id(),
                        discount_detail.getPercent(),
                        discount_detail.getStatus(),}
            );
        }

        tableDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = tableDetail.getSelectedRow();
                txtBook_id.setText(modelTableDetail.getValueAt(i, 1).toString());
                txtPercent.setText(modelTableDetail.getValueAt(i, 2).toString());
                txtStatus.setText(modelTableDetail.getValueAt(i, 3).toString());
            }
        });

        txtBook_id.setText(modelTableDetail.getValueAt(0, 1).toString());
        txtPercent.setText(modelTableDetail.getValueAt(0, 2).toString());
        txtStatus.setText(modelTableDetail.getValueAt(0, 3).toString());

        jscrollpaneDetail.setBounds(740, 55, 330, 150);
        p5.add(jscrollpaneDetail);
        //tableDetail.getTableHeader().setBackground(Color.CYAN);
    }

    //int dem = 1;
    @Override
    public void actionPerformed(ActionEvent ae) {
        if ("buttonXuatDuLieu".equals(ae.getActionCommand())) {
            TaoTable();
        }
        if ("buttonThem".equals(ae.getActionCommand())) {
            if (txtName.getText().equals("") || txtType.getText().equals("") || txtStart_date.getText().equals("")
                    || txtEnd_date.getText().equals("") || txtStatus.getText().equals("") || txtBook_id.getText().equals("")
                    || txtPercent.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập đầy đủ thông tin");
            } /*if(txtType.getText().equals(Integer.parseInt(txtType.getText())))
            {
                JOptionPane.showMessageDialog(this, "Thể loại phải là dạng số");
            }*/ else {
                BUSGetDiscount BUSThem = new BUSGetDiscount();
                BUSGetDiscount_detail BUSThemDetail = new BUSGetDiscount_detail();

                try {
                    Discount discount = new Discount();
                    discount.setDiscount_name(txtName.getText());
                    discount.setDiscount_type(Integer.parseInt(txtType.getText()));
                    discount.setStart_date(txtStart_date.getText());
                    discount.setEnd_date(txtEnd_date.getText());
                    discount.setStatus(1);
                    BUSThem.inserts(discount);

                    int idDiscount = BUSThem.getLastDiscount();
                    Discount_detail discount_detail = new Discount_detail();
                    discount_detail.setDiscount_id(idDiscount);
                    discount_detail.setBook_id(Integer.parseInt(txtBook_id.getText()));
                    discount_detail.setPercent(Integer.parseInt(txtPercent.getText()));
                    discount_detail.setStatus(1);
                    BUSThemDetail.inserts(discount_detail);

                } catch (Exception ex) {
                    Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                }

                TaoTable();   // gọi lại hàm TaoTable để update lại cái table mới

                txtName.setText(null);
                txtType.setText(null);
                txtStart_date.setText(null);
                txtEnd_date.setText(null);
                txtStatus.setText(null);

                TaoTableDetail();         // có cái này mới tạo Discount_Detail được
                txtBook_id.setText(null);
                txtPercent.setText(null);
                txtStatus.setText(null);
            }
            //Thêm cột cho tableDetail
            //if(txtName.getText().equal)
        }

        if ("buttonXoa".equals(ae.getActionCommand())) {
            F1 = new JFrame();
            F1.setSize(480, 160);
            F1.setTitle("Xóa dữ liệu");
            F1.setLayout(null);
            F1.setBackground(Color.WHITE);
            F1.setLocationRelativeTo(null);
            F1.setVisible(true);

            panelChonXoa = new JLabel("Bạn muốn xóa luôn Discount hay chỉ xóa Detail ?");
            panelChonXoa.setBounds(40, 00, 400, 50);
            panelChonXoa.setFont(new Font("Helvetica", Font.PLAIN, 18));
            F1.add(panelChonXoa);

            btXoaDiscount = new JButton("Xóa Discount");
            btXoaDiscount.setForeground(Color.white);
            btXoaDiscount.setBounds(70, 60, 110, 30);
            btXoaDiscount.setBackground(Color.red);
            btXoaDiscount.setActionCommand("buttonXoaDiscount");
            btXoaDiscount.addActionListener(this);
            F1.add(btXoaDiscount);

            btXoaDiscount_detail = new JButton("Xóa Detail");
            btXoaDiscount_detail.setBounds(250, 60, 110, 30);
            btXoaDiscount_detail.setActionCommand("buttonXoaDiscount_detail");
            btXoaDiscount_detail.addActionListener(this);
            F1.add(btXoaDiscount_detail);

        }
        if ("buttonXoaDiscount".equals(ae.getActionCommand())) {
            BUSGetDiscount busDiscount = new BUSGetDiscount();
            BUSGetDiscount_detail busDiscount_detail = new BUSGetDiscount_detail();
            int i = table.getSelectedRow();
            int idPhanTuCanXoa = Integer.parseInt(modelTableBook.getValueAt(i, 0).toString());
            try {
                ArrayList<Discount> discountListTemp = busDiscount.getDiscount("discount_id=" + idPhanTuCanXoa);  // tạo 1 arraylist mới để lưu quyển sách vào 
                Discount discountTemp = discountListTemp.get(0);  // gọi phần tử thứ 0 trong arraylist mới tạo ra, là quyển sách trên
                discountTemp.setStatus(0);
                busDiscount.updates(discountTemp);

                ArrayList<Discount_detail> discount_detailListTemp = busDiscount_detail.getDiscount_detail("discount_id=" + idPhanTuCanXoa);
                Discount_detail discount_detailTemp = discount_detailListTemp.get(0);
                discount_detailTemp.setStatus(0);
                busDiscount_detail.updates(discount_detailTemp);
            } catch (Exception ex) {
                Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
            }
            modelTableBook.removeRow(i);
            table.setModel(modelTableBook);

            txtName.setText(null);
            txtType.setText(null);
            txtStart_date.setText(null);
            txtEnd_date.setText(null);
            txtStatus.setText(null);

            /*int size = modelTableDetail.getRowCount();   
            for(int k=0; k<=size; k++)
                modelTableDetail.removeRow(k);        // Xóa từng hàng trong table*/
            modelTableDetail.setRowCount(0);
            tableDetail.setModel(modelTableDetail);

            txtBook_id.setText(null);
            txtPercent.setText(null);
            txtStatus.setText(null);

            F1.dispose();
        }
        if ("buttonXoaDiscount_detail".equals(ae.getActionCommand())) {
            BUSGetDiscount_detail busDiscount_detail = new BUSGetDiscount_detail();
            int i = tableDetail.getSelectedRow();
            int idSach = Integer.parseInt(modelTableDetail.getValueAt(i, 1).toString());
            int idDiscount = Integer.parseInt(modelTableDetail.getValueAt(i, 0).toString());
            try {
                ArrayList<Discount_detail> discount_detailListTemp = busDiscount_detail.getDiscount_detail(" discount_id=" + idDiscount + " and book_id=" + idSach);
                Discount_detail discount_detailTemp = discount_detailListTemp.get(0);
                discount_detailTemp.setStatus(0);
                busDiscount_detail.updates(discount_detailTemp);
            } catch (Exception ex) {
                Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtBook_id.setText(null);
            txtPercent.setText(null);
            txtStatus.setText(null);

            //modelTableDetail.removeRow(i);
            //tableDetail.setModel(modelTableDetail);

            TaoTableDetail();
            F1.dispose();
        }
        if ("buttonSua".equals(ae.getActionCommand())) {
            BUSGetDiscount busDiscount = new BUSGetDiscount();
            BUSGetDiscount_detail busDiscount_detail = new BUSGetDiscount_detail();

            int i = table.getSelectedRow();
            int idPhanTuCanSua = Integer.parseInt(modelTableBook.getValueAt(i, 0).toString());

            try {
                ArrayList<Discount> discountListTemp = busDiscount.getDiscount("discount_id=" + idPhanTuCanSua);
                Discount discountTemp = discountListTemp.get(0);

                discountTemp.setDiscount_name(txtName.getText());
                discountTemp.setDiscount_type(Integer.parseInt(txtType.getText()));   // vì Price là dạng int
                discountTemp.setStart_date(txtStart_date.getText());
                discountTemp.setStart_date(txtEnd_date.getText());
                busDiscount.updates(discountTemp);
            } catch (Exception ex) {
                Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
            }

            int j = tableDetail.getSelectedRow();
            if (j >= 0) {
                int idDiscountSua = Integer.parseInt(modelTableDetail.getValueAt(j, 0).toString());
                int idSach = Integer.parseInt(modelTableDetail.getValueAt(j, 1).toString());
                System.out.print(idDiscountSua);
                System.out.print(idSach);
                try {
                    ArrayList<Discount_detail> discount_detailListTemp = busDiscount_detail.getDiscount_detail(" discount_id=" + idDiscountSua + " and book_id=" + idSach);
                    Discount_detail discount_detailTemp = discount_detailListTemp.get(0);

                    discount_detailTemp.setBook_id(Integer.parseInt(txtBook_id.getText()));
                    discount_detailTemp.setPercent(Integer.parseInt(txtPercent.getText()));
                    discount_detailTemp.setStatus(Integer.parseInt(txtStatus.getText()));
                    busDiscount_detail.updates(discount_detailTemp);
                } catch (Exception ex) {
                    Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                }
                modelTableDetail.setValueAt(txtBook_id.getText(), j, 1);
                modelTableDetail.setValueAt(txtPercent.getText(), j, 2);
                tableDetail.setModel(modelTableDetail);
            }
            //if (i >= 0) {
            modelTableBook.setValueAt(txtName.getText(), i, 1);
            modelTableBook.setValueAt(txtType.getText(), i, 2);
            modelTableBook.setValueAt(txtStart_date.getText(), i, 3);
            modelTableBook.setValueAt(txtEnd_date.getText(), i, 4);
            table.setModel(modelTableBook);

            txtName.setText(null);
            txtType.setText(null);
            txtStart_date.setText(null);
            txtEnd_date.setText(null);
            
            txtBook_id.setText(null);
            txtPercent.setText(null);
            txtStatus.setText(null);

            TaoTable();
            TaoTableDetail();
            //}
        }

        if ("buttonTimKiem".equals(ae.getActionCommand())) {
            p6 = new JFrame();
            p6.setSize(355, 220);
            p6.setTitle("Tìm Kiếm");
            p6.setLayout(null);
            p6.setBackground(Color.WHITE);
            p6.setLocationRelativeTo(null);
            p6.setVisible(true);

            timKiemP6 = new JLabel("Nhập mã khuyến mãi:");
            timKiemP6.setBounds(40, 00, 200, 50);
            timKiemP6.setFont(new Font("Helvetica", Font.PLAIN, 18));
            p6.add(timKiemP6);

            txtTimKiemP6 = new JTextField();
            txtTimKiemP6.setBounds(40, 50, 260, 50);
            txtTimKiemP6.setPreferredSize(new Dimension(130, 30));
            p6.add(txtTimKiemP6);

            btTimKiem_Oke = new JButton("Oke");
            btTimKiem_Oke.setBounds(115, 120, 110, 30);
            btTimKiem_Oke.setActionCommand("buttonTimKiem_Oke");
            btTimKiem_Oke.addActionListener(this);
            p6.add(btTimKiem_Oke);
        }

        if ("buttonTimKiem_Oke".equals(ae.getActionCommand())) {
            TaoTable();  // Để load lại tableDiscount ban đầu
            int idCanTim = 0;
            if (txtTimKiemP6.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Mã");
            } else {
                idCanTim = Integer.parseInt(txtTimKiemP6.getText());
            }
            if (idCanTim != 0) {
                BUSGetDiscount busDiscount = new BUSGetDiscount();
                ArrayList<Discount> discountList = new ArrayList<>();
                try {
                    discountList = busDiscount.getDiscount("status=1 and discount_id=" + idCanTim);
                } catch (Exception ex) {
                    Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                }

                modelTableBook = new DefaultTableModel(
                        new Object[][]{
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},},
                        new String[]{
                            "Mã khuyến mãi", "Tên", "Loại", "Ngày bắt đầu", "Ngày kết thúc"
                        });
                modelTableBook.setRowCount(0); // Cho mất các ô trống trong table
                table.setModel(modelTableBook);
                for (Discount discount : discountList) {
                    modelTableBook.addRow(
                            new Object[]{
                                discount.getDiscount_id(),
                                discount.getDiscount_name(),
                                discount.getDiscount_type(),
                                discount.getStart_date(),
                                discount.getEnd_date(),
                                discount.getStatus(),}
                    );
                }

                table.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int i = table.getSelectedRow();
                        //JOptionPane.showMessageDialog(null, "row:"+i);
                        //Book book = new Book();
                        //sv = dssv.get(i);

                        txtName.setText(modelTableBook.getValueAt(i, 1).toString());
                        txtType.setText(modelTableBook.getValueAt(i, 2).toString());
                        txtStart_date.setText(modelTableBook.getValueAt(i, 3).toString());
                        txtEnd_date.setText(modelTableBook.getValueAt(i, 4).toString());
                        //txtStatus.setText(modelTableBook.getValueAt(i, 5).toString());

                        idPhanTuClick = Integer.parseInt(modelTableBook.getValueAt(i, 0).toString());
                        TaoTableDetail();  // Khi click mới cho hiện tableDetail này

                        tieuDeBangDetail.setText("Chi Tiết Khuyến Mãi");
                    }
                });
                jscrollpane.setBounds(10, 55, 710, 150);
                p5.add(jscrollpane);
                //table.getTableHeader().setBackground(Color.CYAN);

                p6.dispose();  // để tắt frame hoặc dialog
            }
            //p6.dispose();
        }
        if ("buttonThemDetail".equals(ae.getActionCommand())) {
            p7 = new JFrame();
            p7.setSize(500, 290);
            p7.setTitle("Thêm Detail");
            p7.setLayout(null);
            p7.setBackground(Color.WHITE);
            p7.setLocationRelativeTo(null);
            p7.setVisible(true);

            p8 = new JPanel();
            p8.setBounds(40, 20, 400, 150);
            GridLayout layout8 = new GridLayout(3, 2);
            layout8.setHgap(-50);
            layout8.setVgap(25);
            p8.setLayout(layout8);
            p7.add(p8);

            ChonId_Detail = new JLabel("Nhập mã khuyến mãi:");
            ChonId_Detail.setBounds(40, 00, 200, 50);
            ChonId_Detail.setFont(new Font("Helvetica", Font.PLAIN, 18));

            NhapBookId_Detail = new JLabel("Nhập mã sách:");
            NhapBookId_Detail.setBounds(40, 100, 200, 50);
            NhapBookId_Detail.setFont(new Font("Helvetica", Font.PLAIN, 18));

            NhapPercent_Detail = new JLabel("Nhập phần trăm:");
            NhapPercent_Detail.setBounds(40, 200, 200, 50);
            NhapPercent_Detail.setFont(new Font("Helvetica", Font.PLAIN, 18));

            txtNhapId_Detail = new JTextField();
            txtNhapId_Detail.setBounds(150, 0, 260, 30);
            txtNhapId_Detail.setPreferredSize(new Dimension(130, 30));

            txtBook_id_Detail = new JTextField("*Không được trùng");
            txtBook_id_Detail.setBounds(150, 100, 260, 30);
            txtBook_id_Detail.setPreferredSize(new Dimension(130, 50));

            txtPercent_Detail = new JTextField();
            txtPercent_Detail.setBounds(150, 150, 260, 30);
            txtPercent_Detail.setPreferredSize(new Dimension(130, 50));

            btThemDetail_Oke = new JButton("Oke");
            btThemDetail_Oke.setBounds(175, 200, 110, 30);
            btThemDetail_Oke.setActionCommand("buttonThemDetail_Oke");
            btThemDetail_Oke.addActionListener(this);
            p7.add(btThemDetail_Oke);

            p8.add(ChonId_Detail);
            p8.add(txtNhapId_Detail);
            p8.add(NhapBookId_Detail);
            p8.add(txtBook_id_Detail);
            p8.add(NhapPercent_Detail);
            p8.add(txtPercent_Detail);
        }
        if ("buttonThemDetail_Oke".equals(ae.getActionCommand())) {
            int status = 1;
            if (txtBook_id_Detail.getText().equals("") || txtPercent_Detail.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Các thông tin không được để trống");
            } else {
                BUSGetDiscount_detail BUSThemDetail = new BUSGetDiscount_detail();
                try {
                    Discount_detail discount_detail = new Discount_detail();
                    discount_detail.setDiscount_id(Integer.parseInt(txtNhapId_Detail.getText()));
                    discount_detail.setBook_id(Integer.parseInt(txtBook_id_Detail.getText()));
                    discount_detail.setPercent(Integer.parseInt(txtPercent_Detail.getText()));
                    discount_detail.setStatus(status);
                    BUSThemDetail.inserts(discount_detail);

                } catch (Exception ex) {
                    Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                }

                int i=tableDetail.getSelectedRowCount();
                if(i>=0)
                    TaoTableDetail();
                txtBook_id_Detail.setText(null);
                txtPercent_Detail.setText(null);
                txtBook_id.setText(null);
                txtPercent.setText(null);
                txtStatus.setText(null);
            }
            p7.dispose();
        }
        if ("buttonTimKiemALL".equals(ae.getActionCommand())) {
            TaoTable();  // Để load lại tableDiscount ban đầu

            //int nameCanTim;
            //nameCanTim = Integer.parseInt(txtTimKiem_name.getText());
            /*
            SELECT * FROM discount 
            WHERE discount_id='' AND discount.discount_name='' AND discount.discount_type='' 
            AND discount.start_date>='' AND discount.end_date>='';
             */
            String condition = " status=1 ";
            String nameCanTim = txtTimKiem_name.getText();

            String start_dateCanTim = txtTimKiem_start_date.getText();
            String end_dateCanTim = txtTimKiem_end_date.getText();

            if (!nameCanTim.equals("") && !nameCanTim.equals(null)) {
                condition += " AND discount_name LIKE '%" + nameCanTim + "%' ";
            }
            if (!txtTimKiem_type.getText().equals("") && !txtTimKiem_type.getText().equals("null")) {
                int typeCanTim = Integer.parseInt(txtTimKiem_type.getText().toString());
                condition += " AND discount_type = '" + typeCanTim + "' ";
            }
            if (!start_dateCanTim.equals("") && !start_dateCanTim.equals(null)) {
                condition += " AND start_date >= '" + start_dateCanTim + "' ";
            }
            if (!end_dateCanTim.equals("") && !end_dateCanTim.equals(null)) {
                condition += " AND end_date <='" + end_dateCanTim + "' ";
            }
            nameCanTim = String.valueOf(txtTimKiem_name.getText());

            //if (txtTimKiem_type.getText().equals("") && txtTimKiem_start_date.getText().equals("") && txtTimKiem_end_date.getText().equals("")) {
            BUSGetDiscount busDiscount = new BUSGetDiscount();
            ArrayList<Discount> discountList = new ArrayList<>();
            try {
                discountList = busDiscount.getDiscount(condition);
            } catch (Exception ex) {
                Logger.getLogger(DiscountGiaoDien.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.print(discountList);
            modelTableBook = new DefaultTableModel(
                    new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},},
                    new String[]{
                        "Mã khuyến mãi", "Tên", "Thể loại", "Ngày bắt đầu", "Ngày kết thúc"
                    });
            modelTableBook.setRowCount(0); // Cho mất các ô trống trong table
            table.setModel(modelTableBook);
            for (Discount discount : discountList) {
                modelTableBook.addRow(
                        new Object[]{
                            discount.getDiscount_id(),
                            discount.getDiscount_name(),
                            discount.getDiscount_type(),
                            discount.getStart_date(),
                            discount.getEnd_date(),
                            discount.getStatus(),}
                );
            }

            table.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int i = table.getSelectedRow();
                    //JOptionPane.showMessageDialog(null, "row:"+i);
                    //Book book = new Book();
                    //sv = dssv.get(i);

                    txtName.setText(modelTableBook.getValueAt(i, 1).toString());
                    txtType.setText(modelTableBook.getValueAt(i, 2).toString());
                    txtStart_date.setText(modelTableBook.getValueAt(i, 3).toString());
                    txtEnd_date.setText(modelTableBook.getValueAt(i, 4).toString());
                    //txtStatus.setText(modelTableBook.getValueAt(i, 5).toString());

                    idPhanTuClick = Integer.parseInt(modelTableBook.getValueAt(i, 0).toString());
                    TaoTableDetail();  // Khi click mới cho hiện tableDetail này

                    tieuDeBangDetail.setText("Chi Tiết Khuyến Mãi");
                }
            });
            jscrollpane.setBounds(10, 55, 710, 150);
            p5.add(jscrollpane);
            table.getTableHeader().setBackground(Color.CYAN);

            //}
        }
        /*int size = modelTableBook.getRowCount();
            String a = txtTimKiemP6.getText();
            System.out.println(a);
            //p6.setBounds(0, 0, 0, 0);
            for (int i = 0; i < size; i++) {
                if (table.getModel().getValueAt(i, 0).toString().equals(a)) {
                    //txtMaSV.setText(table.getModel().getValueAt(i, 0).toString());
                    txtName.setText("" + table.getModel().getValueAt(i, 1));
                    txtType.setText("" + table.getModel().getValueAt(i, 2));
                    txtStart_date.setText("" + table.getModel().getValueAt(i, 3));
                    txtEnd_date.setText("" + table.getModel().getValueAt(i, 4));
                    txtStatus.setText("" + table.getModel().getValueAt(i, 5));
                    //txtBook_id.setText("" + tableDetail.getModel().getValueAt(i, 1));
                    //txtPercent.setText("" + tableDetail.getModel().getValueAt(i, 2));
                    JOptionPane.showMessageDialog(this, "Đã tìm thấy!");
                    txtTimKiemP6.setText(null);
                    p6.dispose();
                }
                p6.dispose();*/
 /*if ("buttonClear".equals(ae.getActionCommand())) {
            model.setRowCount(0);
            dssv.clear();          // clear tất cả dữ liệu trong arraylist
            
            table.setModel(model);
            dem = 1;   // reset lại STT
            
            /*final JOptionPane optionPane = new JOptionPane(
                    "Bạn có chắc muốn xóa hết dữ liệu?",
                    JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.YES_NO_OPTION);
                    
            txtMSSV.setText(null);
            txtTen.setText(null);
            txtLop.setText(null);
        }*/
 /*if("buttonSapXep".equals(ae.getActionCommand()))
        {
            //String[] fruits = new String[] { "Pineapple", "Apple", "Orange", "Banana" };
 
        // Sử dụng phương thức tĩnh của lớp Arrays để sắp xếp.
        // Arrays.sort(Object[])
            Arrays.sort(s);

            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
            }
            //table.getRowSorter().toggleSortOrder(0);
        }*/
 /*String idCanTim = null;
                //idCanTim = String.valueOf(modelTableBook.getRowCount()-1);
                //txtA.setText(idCanTim.toString());
                for(int j=0;j<modelTableBook.getRowCount()-1;j++)
                {
                    idCanTim = String.valueOf(modelTableBook.getValueAt(j, 0).toString());
                }*/
    }
    
    public JTable[] showColorTable(JTable TableArray[]){
        for(int i=0; i<TableArray.length; i++){
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
}
