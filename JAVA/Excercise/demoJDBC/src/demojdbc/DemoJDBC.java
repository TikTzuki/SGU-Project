/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tik
 */
public class DemoJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
 /*
        Connection connect = null;
        Statement st = null;
        ResultSet rs = null;
        connect =  DriverManager.getConnection("jdbc:mysql://localhost:3360/java_sv", "root", "Ld201199");
        rs.getStatement().executeQuery("Select * From sinh_vien");
        System.out.println(rs);
        */
        connection conn = new connection("localhost", "root", "Ld201199", "java_sv");
        conn.getConnect();
        ResultSet result = conn.executeQuery("Select * from sinh_vien");
        //System.out.println(result.getString("mssv"));
        
        
        while(result.next()){
            int id = result.getInt(1);
            String ho = result.getString(2);
            String ten = result.getString(3);
            String lop = result.getString(4);
            String ngay_sinh = result.getString(5);
            String gioi_tinh = result.getString(6);
            String dia_chi = result.getString(7);
            System.out.println(id+ho+ten+lop);
        }
        conn.Close();
        /*
        result = connect.excuteQuery("Select * from 'sinh_vien' where id=1");
        System.out.println(result);*/
    }
    
}
