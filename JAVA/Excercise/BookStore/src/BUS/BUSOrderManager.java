/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConnectionUnit;
import DTO.Order;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Tik
 */
public class BUSOrderManager {

    ConnectionUnit connect;

    public BUSOrderManager() {
        connect = DAO.DAO.getDAO();
    }

    public ArrayList<Order> getOrder(String condition, String orderBy) throws Exception {
        ResultSet result = connect.Select("order", condition, orderBy);
        ArrayList<Order> orderList = new ArrayList<>();
        while (result.next()) {
            Order order = new Order();
            order.setOrder_id(result.getInt("order_id"));
            order.setStaff_id(result.getInt("staff_id"));
            order.setDiscount_id(result.getInt("discount_id"));
            order.setCustomer_id(result.getInt("customer_id"));
            order.setOrder_date(result.getString("order_date"));
            order.setTotal(result.getInt("total"));
            orderList.add(order);
        }
        return orderList;
    }

    public ArrayList<Order> getOrder(String condition) throws Exception {
        return this.getOrder(condition, null);
    }

    public ArrayList<Order> getOrder() throws Exception {
        return this.getOrder(null);
    }

    public void inserts(Order order) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("order_id", order.getOrder_id());
        map.put("staff_id", order.getStaff_id());
        map.put("discount_id", order.getDiscount_id());
        map.put("customer_id", order.getCustomer_id());
        map.put("order_date", order.getOrder_date());
        map.put("total", order.getTotal());
        this.connect.Insert("order", map);
    }

    public void inserts(HashSet<Order> orderList) throws Exception {
        for (Order order : orderList) {
            inserts(order);
        }
    }

    public void updates(Order order) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("staff_id", order.getStaff_id());
        map.put("discount_id", order.getDiscount_id());
        map.put("customer_id", order.getCustomer_id());
        map.put("order_date", order.getOrder_date());
        map.put("total", order.getTotal());
        this.connect.Update("order", map, "order_id=" + order.getOrder_id());
    }

    public void updates(HashSet<Order> orderList) throws Exception{
        for(Order order:orderList){
            updates(order);
        }
    }
    
    public void deletes(Order order) throws Exception{
        this.connect.Delete("order", "order_id="+order.getOrder_id());
    }
    
    public void deletes(HashSet<Order> orderList) throws Exception{
        for(Order order:orderList){
            deletes(order);
        }
    }
    
}
