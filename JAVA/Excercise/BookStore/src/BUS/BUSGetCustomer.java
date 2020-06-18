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
    public ResultSet getTopCustomerSelled(int top, String startDate, String endDate) throws Exception{
        String query = "SELECT customer.first_name as first_name, customer.last_name as last_name, SUM(order_item.quantity) as quantity "
                + "FROM book_order, order_item, customer "
                + "WHERE book_order.order_id=order_item.order_id AND book_order.customer_id=customer.customer_id AND book_order.order_date BETWEEN '"+startDate+"' AND '"+endDate+"' GROUP BY customer.customer_id ORDER BY SUM(order_item.quantity) LIMIT 0,"+top;
        return this.connect.execute(query);
    }
    public Customer getCustomerById(int customerId) throws Exception{
        return this.getCustomer(" customer_id="+customerId).get(0);
    }
    public ArrayList<Customer> getCustomerBySearchLikeIdName(String nameOrId) throws Exception{
        return this.getCustomer(" customer_id LIKE '%"+nameOrId+"%' OR first_name LIKE '%"+nameOrId+"%' OR last_name LIKE '%"+nameOrId+"%' ");
    }
}
