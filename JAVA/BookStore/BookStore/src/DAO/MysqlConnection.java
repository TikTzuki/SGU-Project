/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tik
 */
public class MysqlConnection {
    String host ="";
    String userName = "";
    String password="";
    String database = "";
    
    Connection connect=null;
    Statement st = null;
    ResultSet rs = null;

    public MysqlConnection(String Host, String UserName, String Password, String Database) {
        this.host = Host;
        this.userName = UserName;
        this.password = Password;
        this.database = Database;
        
        try {
            connect = getConnect();
        } catch (Exception ex) {
            Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void driverTest() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnect() throws Exception {
        if (this.connect == null) {
            //driverTest();
            String url = "jdbc:mysql://" + this.host + ":3306/" + this.database + "?useUnicode=true&characterEncoding=UTF-8";
            try {
                this.connect = DriverManager.getConnection(url, this.userName, this.password);
                System.out.println("Connect success");
            } catch (Exception e) {
                throw new Exception("cant connect: " + url);
            }
        }
        return this.connect;
    }
    
    protected Statement getStatement() throws Exception {
        //Kiểm tra statement đã null hoặc đã đóng
        if (this.st == null ? true : this.st.isClosed()) {
            //Khởi tạo 1 statement mới
            this.st = this.getConnect().createStatement();
        }
        return this.st;
    }
    
    public ResultSet executeQuery(String query) throws Exception {
        try{
            this.rs = getStatement().executeQuery(query);
        } catch(Exception e){
            throw new Exception("erro: " + e.getMessage());
        }
        return this.rs;
    }

    public int executeUpdate(String query) throws Exception {
        int res = Integer.MIN_VALUE;
        try {
            res = getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            this.Close();
        }
        return res;
    }

    public void Close() throws SQLException {
        //Neu result chua dong. Dong result
        if (this.rs != null && !this.rs.isClosed()) {
            this.rs.close();
            this.rs = null;
        }
        //Neu statement chua dong. Đóng statement
        if (this.st != null && !this.st.isClosed()) {
            this.st.close();
            this.st = null;
        }
        //Neu connection chua dong. Dong connection
        if (this.connect != null && !this.connect.isClosed()) {
            this.connect.close();
            this.connect = null;
        }
    }
    //TEST
    /*
    public static void main(String[] args) throws Exception {
        MysqlConnection conn = new MysqlConnection("127.0.0.1", "root", "", "book_store");
        conn.getConnect();
    }*/
}
