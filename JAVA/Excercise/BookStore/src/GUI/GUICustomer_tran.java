/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BUSCustomer_tran;
import DTO.Customer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author Admin
 */
public class GUICustomer_tran extends JFrame
{
    private BUSCustomer_tran BUSCus = new BUSCustomer_tran();
    
    JPanel p9, pInfo, pFunction, pContent, pTable, pAdd, pEdit, pDel, pClean, pImp, pExp, pLoad, pSearch, pBack, pOK;
    JLabel lbContent, lbFunction, lbCustomer_ID, lbFirst_Name, lbLast_Name, lbEmail, 
            lbPhone_Number, lbAddress, lbLoad, lbAdd, lbEdit, lbDel, lbImp, lbExp, lbSearch, lbBack, lbOK;
    JTextField txtCustomer_ID, txtFirst_Name, txtLast_Name, txtEmail, txtPhone_Number, txtAddress, txtSearch;
    
    DefaultComboBoxModel comboxName ;
    JComboBox comboxSearch;
    DefaultTableModel model = new DefaultTableModel();
    JTable tblCustomer = new JTable(model);
    JScrollPane jScroll = new JScrollPane(tblCustomer);
    
    static Color normal = new Color(152, 208, 185);
    static Color hover = new Color(220,216,0);
    static Font fontFunc = new Font(Font.SERIF, 0, 20);
    
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    
    public GUICustomer_tran() 
    {
        /*
        setSize(1000,700);
        setLayout(new BorderLayout(3, 3));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
        
        setVisible(true);
        */
    }
    
    public JPanel init()
    {
/*-------------------------------------------------------------------------------- 
**********************************Panel Info**************************************
----------------------------------------------------------------------------------*/
        pInfo = new JPanel();
        pInfo.setPreferredSize(new Dimension(150, 200));
        pInfo.setBackground(new Color(255, 218, 185));
        pInfo.setLayout(null);
        
        JLabel lbTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG");
        lbTitle.setBounds(100, 5, 500, 40);
        lbTitle.setForeground(Color.blue);
        lbTitle.setFont(new Font(Font.SERIF, 1, 30));
        lbTitle.setHorizontalAlignment(JLabel.CENTER);
        
        lbCustomer_ID = new JLabel("ID Khách Hàng:");
        lbCustomer_ID.setBounds(50, 50, 100, 20);
        lbFirst_Name = new JLabel("Họ:");
        lbFirst_Name.setBounds(50, 90, 150, 20);
        lbLast_Name = new JLabel("Tên:");
        lbLast_Name.setBounds(380, 90, 150, 20);
        lbEmail = new JLabel("Email:");
        lbEmail.setBounds(50, 130, 150, 20);
        lbPhone_Number = new JLabel("Số điện thoại:");
        lbPhone_Number.setBounds(380, 130, 100, 20);
        lbAddress = new JLabel("Địa chỉ:");
        lbAddress.setBounds(50, 170, 150, 20);
        
        txtCustomer_ID = new JTextField();
        txtCustomer_ID.setBounds(150, 50, 100, 30);
        txtCustomer_ID.setEditable(false);
        
        txtFirst_Name = new JTextField();
        txtFirst_Name.setBounds(150, 90, 200, 30);
        txtFirst_Name.addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    if(txtFirst_Name.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập họ");
                        return;
                    }
                    else
                        txtLast_Name.requestFocus();
            }
        });
        
        txtLast_Name = new JTextField();
        txtLast_Name.setBounds(530, 90, 100, 30);
        txtLast_Name.addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    if(txtLast_Name.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập tên");
                        return;
                    }
                    else
                        txtEmail.requestFocus();
            }
        });
        
        txtEmail = new JTextField();
        txtEmail.setBounds(150, 130, 200, 30);
        txtEmail.addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {   
                    if(txtEmail.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập Email");
                        return;
                    }
                    else
                    {
                        String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
                        if(!Pattern.matches(EMAIL_PATTERN, txtEmail.getText()))
                        {
                            JOptionPane.showMessageDialog(null, "Email không đúng. Vui lòng nhập lại (Vd: abc12@gmail.com)");
                        }
                        else
                        {
                        txtPhone_Number.requestFocus();
                        }
                    }
                }
            }
        });
        
        
        txtPhone_Number = new JTextField();
        txtPhone_Number.setBounds(530, 130, 100, 30);
        txtPhone_Number.addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    if(txtPhone_Number.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập Số điện thoại");
                        return;
                    }
                    else
                    {
                        String PHONENUMBER_PATTERN = "[0]\\d{9}";
                        if(Pattern.matches(PHONENUMBER_PATTERN, txtPhone_Number.getText()) && txtPhone_Number.getText().length() == 10)
                        {
                            txtAddress.requestFocus();
                        }
                        else
                        {   
                            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ. Vui lòng nhập: 0xxx...");
                        }
                    }
                    
                }
            }
        });
        
        txtAddress = new JTextField();
        txtAddress.setBounds(150, 170, 200, 30);
        
                                              
        ImageIcon iconLoad = loadIcon("src/images/iconLoad.png", 20, 20);       //btnLoad
        pLoad = new JPanel();  
        pLoad.setBounds(0, 0, 40, 30);
        pLoad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pLoad.setBackground(normal);
        lbLoad = new JLabel();
        lbLoad.setBounds(0, 0, 40, 30);
        lbLoad.setIcon(iconLoad);
        pLoad.add(lbLoad);
        pLoad.addMouseListener(new MouseAdapter()                               
        {
            @Override
            public void mouseClicked(MouseEvent me) {
                ShowAll();
            }

            @Override
            public void mouseEntered(MouseEvent me) 
            {
                pLoad.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                pLoad.setBackground(normal);
            }
        });
        
        ImageIcon iconSearch = loadIcon("src/images/iconSearch.png", 20, 20);   //btnSearch
        pSearch = new JPanel();                                                 
        pSearch.setBackground(normal);
        pSearch.setBounds(380, 170, 40, 30);
        pSearch.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lbSearch = new JLabel();
        lbSearch.setBounds(0, 0, 40, 30);
        lbSearch.setForeground(Color.white);
        lbSearch.setIcon(iconSearch);
        pSearch.add(lbSearch);
        pSearch.addMouseListener(new MouseAdapter()                               
        {
            @Override
            public void mouseClicked(MouseEvent me) 
            {
                ArrayList<Customer> arrCus = new ArrayList<>();
                if(txtSearch.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Nhập dữ liệu vào ô tìm");
                    return;
                }
                else
                {
                    String text = txtSearch.getText().trim();
                    if(comboxSearch.getSelectedIndex() == 1)
                    {
                        for(Customer DTOCustomer : arrCus )
                        {
                            
                        }
                    }
                }
                
            }

            @Override
            public void mouseEntered(MouseEvent me) 
            {
                pSearch.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                pSearch.setBackground(normal);
            }
        });
        
        comboxName = new DefaultComboBoxModel();
        comboxName.addElement("ID");
        comboxName.addElement("Họ");
        comboxName.addElement("Tên");
        comboxName.addElement("Số điện thoại");

        comboxSearch = new JComboBox(comboxName);
        comboxSearch.setSelectedIndex(0);
        comboxSearch.setBounds(420, 170, 100, 30);
        comboxSearch.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                txtSearch.setVisible(true);
            }
        });

        txtSearch = new JTextField();
        txtSearch.setBounds(530, 170, 100, 30);
        txtSearch.setVisible(false);
        
        
        pInfo.add(lbTitle);
        pInfo.add(pLoad);
        pInfo.add(pSearch);
        pInfo.add(comboxSearch);
        pInfo.add(txtSearch);
        pInfo.add(lbCustomer_ID);
        pInfo.add(txtCustomer_ID);
        pInfo.add(lbFirst_Name);
        pInfo.add(txtFirst_Name);
        pInfo.add(lbLast_Name);
        pInfo.add(txtLast_Name);
        pInfo.add(lbEmail);
        pInfo.add(txtEmail);
        pInfo.add(lbPhone_Number);
        pInfo.add(txtPhone_Number);
        pInfo.add(lbAddress);
        pInfo.add(txtAddress);
        
        
/*-------------------------------------------------------------------------------- 
**********************************Panel Function**************************************
----------------------------------------------------------------------------------*/      
        pFunction = new JPanel();
        pFunction.setPreferredSize(new Dimension(340, 200));
        pFunction.setLayout(null);
        pFunction.setBackground(new Color(255, 218, 185));
        
        Dimension setSizeLabel = new Dimension(150, 40);
        
        pAdd = new JPanel();                                                    
        pAdd.setBackground(normal);
        pAdd.setBounds(20, 30, 150, 50);
        pAdd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon iconAdd = loadIcon("src/images/iconAdd.png", 40, 40);         
        lbAdd = new JLabel("Thêm");
        lbAdd.setPreferredSize(setSizeLabel);
        lbAdd.setForeground(Color.white);
        lbAdd.setFont(fontFunc);
        lbAdd.setIcon(iconAdd);
        pAdd.add(lbAdd);
        
        pEdit = new JPanel();                                                   
        pEdit.setBackground(normal);
        pEdit.setBounds(20, 90, 150, 50);
        pEdit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon iconEdit = loadIcon("src/images/iconEdit.png", 40, 40);  
        lbEdit = new JLabel("Sửa");
        lbEdit.setPreferredSize(setSizeLabel);
        lbEdit.setForeground(Color.white);
        lbEdit.setFont(fontFunc);
        lbEdit.setIcon(iconEdit);
        pEdit.add(lbEdit);
        
        pDel = new JPanel();                                                    //btnDel
        pDel.setBackground(normal);
        pDel.setBounds(20, 150, 150, 50);
        pDel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon iconDel = loadIcon("src/images/iconDel.png", 40, 40);
        lbDel = new JLabel("Xóa");
        lbDel.setPreferredSize(setSizeLabel);
        lbDel.setForeground(Color.white);
        lbDel.setFont(fontFunc);
        lbDel.setIcon(iconDel);
        pDel.add(lbDel);
        
        
        pOK = new JPanel();                                                    
        pOK.setBackground(normal);
        pOK.setBounds(20, 50, 150, 50);
        pOK.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon iconTick = loadIcon("src/images/iconTick.png", 40, 40);
        lbOK = new JLabel("Xác nhận");
        lbOK.setPreferredSize(setSizeLabel);
        lbOK.setForeground(Color.white);
        lbOK.setFont(fontFunc);
        lbOK.setIcon(iconTick);
        pOK.add(lbOK);
        pOK.setVisible(false);
        
        pBack = new JPanel();                                                    
        pBack.setBackground(normal);
        pBack.setBounds(20, 110, 150, 50);
        pBack.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon iconBack = loadIcon("src/images/iconBack.png", 40, 40);
        lbBack = new JLabel("Back");
        lbBack.setPreferredSize(setSizeLabel);
        lbBack.setForeground(Color.white);
        lbBack.setFont(fontFunc);
        lbBack.setIcon(iconBack);
        pBack.add(lbBack);
        pBack.setVisible(false);
        
        pImp = new JPanel();                                                    
        pImp.setBackground(normal);
        pImp.setBounds(180, 50, 150, 50);
        pImp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon iconImp = loadIcon("src/images/iconImport.png", 40, 40);
        lbImp = new JLabel("Nhập Excel");
        lbImp.setPreferredSize(setSizeLabel);
        lbImp.setForeground(Color.white);
        lbImp.setFont(fontFunc);
        lbImp.setIcon(iconImp);
        pImp.add(lbImp);
        pImp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) 
            {
                //setTextNull();
            }

            @Override
            public void mouseEntered(MouseEvent me)
            {
                pImp.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                pImp.setBackground(normal);
            }
        });
        
        pExp = new JPanel();                                                    //btnExportExcel
        pExp.setBackground(normal);
        pExp.setBounds(180, 110, 150, 50);
        pExp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ImageIcon iconExp = loadIcon("src/images/iconExport.png", 40, 40);
        lbExp = new JLabel("Xuất Excel");
        lbExp.setPreferredSize(setSizeLabel);
        lbExp.setForeground(Color.white);
        lbExp.setFont(fontFunc);
        lbExp.setIcon(iconExp);
        pExp.add(lbExp);
        pExp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) 
            {
                //setTextNull();
            }

            @Override
            public void mouseEntered(MouseEvent me)
            {
                pExp.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                pExp.setBackground(normal);
            }
        });
    //--------------------------mouse button---------------------------    
        pAdd.addMouseListener(new MouseAdapter()                   //btnAdd            
        {
            @Override
            public void mouseClicked(MouseEvent me) 
            {
                EditOrAdd = true;
                setTextNull();
                
                pAdd.setVisible(false);
                pEdit.setVisible(false);
                pDel.setVisible(false);
                
                pOK.setVisible(true);
                pBack.setVisible(true);
                
                tblCustomer.setEnabled(false);
                
            }

            @Override
            public void mouseEntered(MouseEvent me) 
            {
                pAdd.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                pAdd.setBackground(normal);
            }
        });
        
        pEdit.addMouseListener(new MouseAdapter()                  //btnEdit
        {
            @Override
            public void mouseClicked(MouseEvent me) 
            {
                if(txtCustomer_ID.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần sửa!");
                    return;
                }
                
                EditOrAdd = false;
                
                pAdd.setVisible(false);
                pEdit.setVisible(false);
                pDel.setVisible(false);
                
                pOK.setVisible(true);
                pBack.setVisible(true);
                
                tblCustomer.setEnabled(false);
            }
            @Override
            public void mouseEntered(MouseEvent me) 
            {
                pEdit.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                pEdit.setBackground(normal);
            }
        });
        
        pDel.addMouseListener(new MouseAdapter()                   //btnDel
        {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(txtCustomer_ID.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần xóa!");
                    return;
                }
                
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa ID Khách Hàng " + txtCustomer_ID.getText(),"Alert",JOptionPane.YES_NO_OPTION);
                if(i == 0)
                {
                    BUSCus.del(Integer.parseInt(txtCustomer_ID.getText()));
                    setTextNull();
                    ShowAll();
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent me)
            {
                pDel.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                pDel.setBackground(normal);
            }
        });
        
        pOK.addMouseListener(new MouseAdapter()                    //btnOK gồm add và eidt
        {
            @Override
            public void mouseClicked(MouseEvent me) 
            {
                if(EditOrAdd)
                {
                    int i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm khách hàng","",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        while(txtFirst_Name.getText().isEmpty() || txtLast_Name.getText().isEmpty() || txtEmail.getText().isEmpty()
                                || txtPhone_Number.getText().isEmpty() || txtAddress.getText().isEmpty())
                        {
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                            return;
                        }
                        
                        if(!txtEmail.getText().isEmpty())
                        {
                            String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
                            if(!Pattern.matches(EMAIL_PATTERN, txtEmail.getText()))
                            {
                                JOptionPane.showMessageDialog(null, "Email không đúng. Vui lòng nhập lại (Vd: abc12@gmail.com)");
                                return;
                            }
                        }

                        if(!txtPhone_Number.getText().isEmpty())
                        {
                            String PHONENUMBER_PATTERN = "[0]\\d{9}";
                            if(Pattern.matches(PHONENUMBER_PATTERN, txtPhone_Number.getText()) && txtPhone_Number.getText().length() == 10)
                            {
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Số điện thoại không đúng. Vui lòng nhập lại (Vd: 0xxx...)");
                                return;
                            }
                        }
                        
                        Customer DTOCus = new Customer();
                        DTOCus.setFirst_name(txtFirst_Name.getText());
                        DTOCus.setLast_name(txtLast_Name.getText());
                        DTOCus.setEmail(txtEmail.getText());
                        DTOCus.setPhone_number(txtPhone_Number.getText());
                        DTOCus.setAddress(txtAddress.getText());
                        
                        BUSCus.add(DTOCus);
                        ShowAll();
                        setTextNull();
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                   }
                }
                else
                {
                    int i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa khách hàng "+txtCustomer_ID.getText(),"",JOptionPane.YES_NO_OPTION);
                    if(i == 0)
                    {
                        while(txtFirst_Name.getText().equals("") || txtLast_Name.getText().equals("") || txtEmail.getText().equals("")
                                || txtPhone_Number.getText().equals("") || txtAddress.getText().equals(""))
                        {
                            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                            return;
                        }

                        if(!txtEmail.getText().isEmpty())
                        {
                            String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
                            if(!Pattern.matches(EMAIL_PATTERN, txtEmail.getText()))
                            {
                                JOptionPane.showMessageDialog(null, "Email không đúng. Vui lòng nhập lại (Vd: abc12@gmail.com)");
                                return;
                            }
                        }

                        if(!txtPhone_Number.getText().isEmpty())
                        {
                            String PHONENUMBER_PATTERN = "^0+\\d{9}$";
                            if(!Pattern.matches(PHONENUMBER_PATTERN, txtPhone_Number.getText()))
                            {
                                JOptionPane.showMessageDialog(null, "Số điện thoại không đúng. Vui lòng nhập lại (Vd: 0xxx...)");
                                return;
                            }
                        }
                        
                        Customer DTOCus = new Customer();
                        DTOCus.setCustomer_id(Integer.parseInt(txtCustomer_ID.getText()));
                        DTOCus.setFirst_name(txtFirst_Name.getText());
                        DTOCus.setLast_name(txtLast_Name.getText());
                        DTOCus.setEmail(txtEmail.getText());
                        DTOCus.setPhone_number(txtPhone_Number.getText());
                        DTOCus.setAddress(txtAddress.getText());
                        
                        
                        BUSCus.edit(DTOCus);
                        ShowAll();
                        setTextNull();
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent me)
            {
                pOK.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                pOK.setBackground(normal);
            }
        });
        
        pBack.addMouseListener(new MouseAdapter()                  //btnBack
        {
            @Override
            public void mouseClicked(MouseEvent me) 
            {
                setTextNull();
                
                pAdd.setVisible(true);
                pEdit.setVisible(true);
                pDel.setVisible(true);
                
                pOK.setVisible(false);
                pBack.setVisible(false);
                
                tblCustomer.setEnabled(true);
            }

            @Override
            public void mouseEntered(MouseEvent me)
            {
                pBack.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent me) 
            {
                pBack.setBackground(normal);
            }
        });
        
       
        pFunction.add(pAdd);
        pFunction.add(pImp);
        pFunction.add(pEdit);
        pFunction.add(pExp);
        pFunction.add(pDel);
        pFunction.add(pOK);
        pFunction.add(pBack);
        
       
/*-------------------------------------------------------------------------------- 
**********************************Panel Table**************************************
----------------------------------------------------------------------------------*/
        pTable = new JPanel();
        pTable.setPreferredSize(new Dimension(0, 430));
        pTable.setBackground(new Color(255, 218, 185));
       
        JTableHeader jHeader = tblCustomer.getTableHeader();
        jHeader.setBackground(new Color(0, 125, 0));
        jHeader.setForeground(Color.white);
        tblCustomer.setRowHeight(25);
        tblCustomer.setSelectionBackground(Color.yellow);
        tblCustomer.setFillsViewportHeight(true);
        
        ShowAll();
        
        tblCustomer.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblCustomer.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblCustomer.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblCustomer.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblCustomer.getColumnModel().getColumn(4).setPreferredWidth(40);
        tblCustomer.getColumnModel().getColumn(5).setPreferredWidth(150);
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = tblCustomer.getSelectedRow();
                txtCustomer_ID.setText(tblCustomer.getModel().getValueAt(i, 0).toString());
                txtFirst_Name.setText(tblCustomer.getModel().getValueAt(i, 1).toString());
                txtLast_Name.setText(tblCustomer.getModel().getValueAt(i, 2).toString());
                txtEmail.setText(tblCustomer.getModel().getValueAt(i, 3).toString());
                txtPhone_Number.setText(tblCustomer.getModel().getValueAt(i, 4).toString());
                txtAddress.setText(tblCustomer.getModel().getValueAt(i, 5).toString());
            }
        }); 
        
        jScroll.setPreferredSize(new Dimension(900, 300));
        pTable.add(jScroll);
        
        
        
        add(pInfo, BorderLayout.CENTER); 
        add(pFunction, BorderLayout.EAST); 
        add(pTable, BorderLayout.SOUTH); 
        
        JPanel bg = new JPanel(new BorderLayout(3, 3));
        bg.setSize(1000,700);
        bg.setPreferredSize(new Dimension(1100,700));
        bg.add(pInfo, BorderLayout.CENTER);
        bg.add(pFunction, BorderLayout.EAST);
        bg.add(pTable, BorderLayout.SOUTH); 
        return bg;
    }
/**************************************************************************
***************************************************************************
***************************************************************************/
    
    //-----------------------------copy bạn Long---------------------------------
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
    
    
    //---------------------------hàm show database------------------------------
    public void ShowAll()
    {
        ArrayList<Customer> arrCus = BUSCus.list();
        
        Vector header = new Vector();
        header.add("ID Khách Hàng");
        header.add("Họ");
        header.add("Tên");
        header.add("Email");
        header.add("Số điện thoại");
        header.add("Địa chỉ");
        
        model = new DefaultTableModel(header, 0);
        
        for(Customer dto : arrCus)
        {
            Vector row = new Vector();
            row.add(dto.getCustomer_id());
            row.add(dto.getFirst_name());
            row.add(dto.getLast_name());
            row.add(dto.getEmail());
            row.add(dto.getPhone_number());
            row.add(dto.getAddress());
            model.addRow(row);
        }
      
        tblCustomer.setModel(model);
    }
    
    public void setTextNull()
    {
        txtCustomer_ID.setText(null);
        txtFirst_Name.setText(null);
        txtLast_Name.setText(null);
        txtEmail.setText(null);
        txtPhone_Number.setText(null);
        txtAddress.setText(null);
    }
    
    public void outModel(DefaultTableModel model , ArrayList<Customer> cus) // Xuất ra Table từ ArrayList, của thầy
    {
        Vector data;
        model.setRowCount(0);
        for(Customer kh:cus)
        {
            data = new Vector();
            data.add(kh.getCustomer_id());
            data.add(kh.getFirst_name());
            data.add(kh.getLast_name());
            data.add(kh.getEmail());
            data.add(kh.getPhone_number());
            data.add(kh.getAddress());
            model.addRow(data);
        }
        tblCustomer.setModel(model);
    }
    
    public static void main(String[] args) 
    {
        new GUICustomer_tran();
    }
}
