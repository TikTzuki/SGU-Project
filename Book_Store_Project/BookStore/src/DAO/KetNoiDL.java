/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class KetNoiDL {
    private final String url = "jdbc:mysql://localhost:3306/book_store"+"?useUnicode=true&characterEncoding=UTF-8";
    private final String userName = "root";
    private final String passWord = "";

    public KetNoiDL() {
    }
    
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


}
