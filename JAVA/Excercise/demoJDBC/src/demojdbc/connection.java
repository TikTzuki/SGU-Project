/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojdbc;

import java.sql.*;

/**
 *
 * @author Tik
 */
public class connection {
    String host ="";
    String userName = "";
    String password="";
    String database = "";
    
    Connection connect=null;
    Statement st = null;
    ResultSet rs = null;

    public connection(String Host, String UserName, String Password, String Database) {
        this.host = Host;
        this.userName = UserName;
        this.password = Password;
        this.database = Database;
    }
    
    protected void driverTest() throws Exception{
        try{
            Class.forName("org.gjt.mn.mysql.Driver");
        } catch(ClassNotFoundException e){
            throw new Exception("JDBC Driver not found");
        }
    }
    
    protected Connection getConnect() throws Exception {
        if (this.connect == null) {
            //driverTest();
            String url = "jdbc:mysql://" + this.host + ":3306/" + this.database;
            try {
                this.connect = DriverManager.getConnection(url, this.userName, this.password);
                System.out.println("Connect success");
            } catch (SQLException e) {
                throw new Exception("cant connect" + url);
            }
        }
        return this.connect;
    }
    
    protected Statement getStatement() throws Exception{
        if(this.st==null?true:this.st.isClosed()){
            this.st = this.getConnect().createStatement();
        }
        return this.st;
    }
    
    public ResultSet executeQuery(String query) throws Exception {
        try{
            this.rs = getStatement().executeQuery(query);
        } catch(Exception e){
            
        }
        return this.rs;
    }

    public int executeUpdate(String query) throws Exception {
        int res = Integer.MIN_VALUE;
        try {
            res = getStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
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

    
    
}
    