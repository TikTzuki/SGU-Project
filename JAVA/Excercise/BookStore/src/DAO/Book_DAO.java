/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Book_DTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Book_DAO {
    private final String url = "jdbc:mysql://localhost:3306/bansach"+"?useUnicode=true&characterEncoding=UTF-8";
    private final String userName = "root";
    private final String passWord = "";
    //Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public Connection KetNoi()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                return DriverManager.getConnection(url, userName, passWord);
            } catch (SQLException ex) {
                Logger.getLogger(Book_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Book_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    Connection con = KetNoi();
        
    public ArrayList showAll()
    {
        ArrayList ds = new ArrayList<Book_DTO>();
        try {
            String qry = "select book.book_id,book.title,book.available_quantity,book.price,genre.name,book.publication_date,author.first_name,author.last_name from book,genre,author where book.genre_id=genre.genre_id and book.author_id=author.author_id";
            st = con.createStatement();
            rs = st.executeQuery(qry);
            
            
            
            while(rs.next())
            {
                Book_DTO dto = new Book_DTO();
                dto.book_id= rs.getInt(1);
                dto.title = rs.getString(2);
                dto.availabel_quantity = rs.getInt(3);
                dto.price = rs.getInt(4);
                dto.genre_name = rs.getString(5);
                dto.publication_date = rs.getString(6);
                dto.author_firstname = rs.getString(7);
                dto.author_lastname = rs.getString(8);
                ds.add(dto);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dữ liệu rỗng.");
        }
        
        return ds;
    }
    
    public void Them(Book_DTO dto)
    {
        
        try {
            String qry = "INSERT INTO `book`(`title`, `available_quantity`, `price`, `genre_id`, `publication_date`, `author_id`,`isbn`) VALUES (";
            qry = qry + "'"+dto.title+"','"+dto.availabel_quantity+"','"+dto.price+"','"+dto.genre_id+"','"+dto.publication_date+"','"+dto.author_id+"','')";
            //qry = "INSERT INTO `book`(`title`, `available_quantity`, `price`, `genre_id`, `publication_date`, `author_id`) VALUES ( 'PHP','20','70000','1','2019-09-02','2')";
            System.out.println(qry);
            st = con.createStatement();
            st.executeUpdate(qry);
            JOptionPane.showMessageDialog(null, "Thêm thành công.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại.");
        }
            
        
    }
    
    public void Sua(Book_DTO dto)
    {
        try {
            String qry = "UPDATE `book` SET `title`='"+dto.title+"',`available_quantity`='"+dto.availabel_quantity+"',`price`='"+dto.price+"',`genre_id`='"+dto.genre_id+"',`publication_date`='"+dto.publication_date+"',`author_id`='"+dto.author_id+"',`isbn`='' WHERE `book_id`='"+dto.book_id+"'";
            //UPDATE `book` SET `title`='SAY HELLO',`available_quantity`='20',`price`='20000',`genre_id`='2',`publication_date`='2019-02-01',`author_id`='1',`isbn`='' WHERE `book_id`='13'
            System.out.println(qry);
            st = con.createStatement();
            st.executeUpdate(qry);
            JOptionPane.showMessageDialog(null, "Đã sửa thành công.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại.");
        }
    }
    
    public void Xoa(String ma)
    {
        try{
            String qry = "delete from book where book_id = "+ma;
            st = con.createStatement();
            st.executeUpdate(qry);
            JOptionPane.showMessageDialog(null, "Đã Xóa thành công.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại.");
        }
    }
    
    public ArrayList TimKiemMa(int ma)
    {
        ArrayList dssv = new ArrayList<Book_DTO>();
        try {
            String qry = "select book_id from book where book_id = '"+ma+"'";
            st = con.createStatement();
            rs = st.executeQuery(qry);
            Book_DTO dto = new Book_DTO();
            while(rs.next())
            {
                dto.book_id= rs.getInt(1);
                dto.title = rs.getString(2);
                dto.availabel_quantity = rs.getInt(3);
                dto.price = rs.getInt(4);
                dto.genre_id = rs.getInt(5);
                dto.publication_date = rs.getString(6);
                dto.author_id = rs.getInt(7);
                dssv.add(dto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả.");
        }
        return dssv;
    }
    
    public ArrayList TimKiemTen(String ten)
    {
        ArrayList dssv = new ArrayList<Book_DTO>();
        try {
            String qry = "select title from book where title = '"+ten+"'";
            st = con.createStatement();
            rs = st.executeQuery(qry);
            Book_DTO dto = new Book_DTO();
            while(rs.next())
            {
                dto.book_id= rs.getInt(1);
                dto.title = rs.getString(2);
                dto.availabel_quantity = rs.getInt(3);
                dto.price = rs.getInt(4);
                dto.genre_id = rs.getInt(5);
                dto.publication_date = rs.getString(6);
                dto.author_id = rs.getInt(7);
                dssv.add(dto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả.");
        }
        return dssv;
    }
    
    public ArrayList TimKiemGia(int gia)
    {
        ArrayList dssv = new ArrayList<Book_DTO>();
        try {
            String qry = "";
            if(gia < 100000)
            {
                qry = "select price from book where price < '"+gia+"'";
            }
            else
            {
                if(gia >= 100000 && gia <= 300000)
                {
                    qry = "select price from book where price >= '"+gia+"' and price <= '"+gia+"'";
                }
                else
                    qry = "select price from book where price > '"+gia+"'";
            }
            st = con.createStatement();
            rs = st.executeQuery(qry);
            Book_DTO dto = new Book_DTO();
            while(rs.next())
            {
                
                dto.book_id= rs.getInt(1);
                dto.title = rs.getString(2);
                dto.availabel_quantity = rs.getInt(3);
                dto.price = rs.getInt(4);
                dto.genre_id = rs.getInt(5);
                dto.publication_date = rs.getString(6);
                dto.author_id = rs.getInt(7);
                dssv.add(dto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả.");
        }
        return dssv;
    }
    
    
}
