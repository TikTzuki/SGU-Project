/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DAOCustomer_tran 
{
    private final MysqlConnection con;
    Statement st = null;
    ResultSet rs = null;

    public DAOCustomer_tran() 
    {
        con =  new MysqlConnection("localhost", "root", "", "book_store");
        
    }
    
    public ArrayList list() 
    {
        ArrayList arrCus = new ArrayList<Customer>();
        try {
            String qry = "SELECT * FROM customer";
            try {
                st = con.getStatement();
            } catch (Exception ex) {
                Logger.getLogger(DAOCustomer_tran.class.getName()).log(Level.SEVERE, null, ex);
            }
            rs = st.executeQuery(qry);
            
            while(rs.next())
            {
                Customer dtoCus = new Customer();
                dtoCus.setCustomer_id(rs.getInt(1)) ;
                dtoCus.setFirst_name(rs.getString(2));
                dtoCus.setLast_name(rs.getString(3)) ;
                dtoCus.setEmail(rs.getString(4));
                dtoCus.setPhone_number(rs.getString(5));
                dtoCus.setAddress(rs.getString(6)); 
                arrCus.add(dtoCus);
            }
            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "No database");
        }
        
        return arrCus;
    }
    
    public void add(Customer dtoCus) 
    {
       
        try {
          //String qry = String.format("INSERT INTO customer(first_name, last_name, email, phone_number, address) VALUES('%s','%s','%s','%s','%s')",
            //dtoCus.getFirst_name(), dtoCus.getLast_name(), dtoCus.getEmail(), dtoCus.getPhone_number(), dtoCus.getAddress());
            
            String qry = "INSERT INTO customer(first_name, last_name, email, phone_number, address) VALUES('"
                  + dtoCus.getFirst_name() + "','"+ dtoCus.getLast_name()+ "','" + dtoCus.getEmail()+ "','" + dtoCus.getPhone_number() + "','"+ dtoCus.getAddress() +"')";      
            System.out.println(qry);
            st = con.getStatement();
            st.executeUpdate(qry);
        } catch (Exception ex) {
            Logger.getLogger(DAOCustomer_tran.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void edit(Customer dtoCus)
    {
        try {
            String qry = "UPDATE customer SET first_name ='" + dtoCus.getFirst_name() + "', last_name ='" + dtoCus.getLast_name()
                    + "', email ='" + dtoCus.getEmail() +"', phone_number ='" + dtoCus.getPhone_number() + "', address = '"
                    + dtoCus.getAddress() + "' WHERE customer_id =" + dtoCus.getCustomer_id();
            System.out.println(qry);
            st = con.getStatement();
            st.executeUpdate(qry);
        } catch (Exception ex) {
            Logger.getLogger(DAOCustomer_tran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void del(int CusID)
    {
        try {
            String qry = String.format("DELETE FROM customer WHERE customer_id = %d", CusID);
            System.out.println(qry);
            st = con.getStatement();
            st.executeUpdate(qry);
        } catch (Exception ex) {
            Logger.getLogger(DAOCustomer_tran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
