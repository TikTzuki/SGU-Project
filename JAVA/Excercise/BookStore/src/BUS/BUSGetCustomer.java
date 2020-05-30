package BUS;

import DAO.ConnectionUnit;
import DTO.Customer;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tik Tzuki
 */
public class BUSGetCustomer {
    ConnectionUnit connect;
    public BUSGetCustomer(){
        connect = DAO.DAO.getDAO();
    }
    public ArrayList<Customer> getCustomer(String condition, String orderBy) throws Exception{
        ResultSet result = connect.Select("customer", condition, orderBy);
        ArrayList<Customer> listCustomer = new ArrayList<>();
        while(result.next()){
            Customer cus = new Customer();
            cus.setCustomer_id(result.getInt("customer_id"));
            cus.setFirst_name(result.getString("first_name"));
            cus.setLast_name(result.getString("last_name"));
            cus.setAddress(result.getString("address"));
            cus.setEmail(result.getString("email"));
            cus.setPhone_number(result.getString("phone_number"));
            listCustomer.add(cus);
        }
        return listCustomer;
    }
    public ArrayList<Customer> getCustomer(String condition) throws Exception{
        return this.getCustomer(condition, null);
    }
    public ArrayList<Customer> getCustomer() throws Exception{
        return this.getCustomer(null, null);
    }
    public Customer getCustomerById(int customerId) throws Exception{
        return this.getCustomer(" customer_id="+customerId).get(0);
    }
}
