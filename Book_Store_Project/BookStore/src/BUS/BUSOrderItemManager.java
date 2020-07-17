/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConnectionUnit;
import DTO.Order;
import DTO.OrderItem;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Tik Tzuki
 */
public class BUSOrderItemManager {
    ConnectionUnit connect;
    public BUSOrderItemManager(){
        connect = DAO.DAO.getDAO();
    }
    public ArrayList<OrderItem> getOrderItem(String condition, String orderBy) throws Exception {
        ResultSet result = connect.Select("order_item", condition, orderBy);
        ArrayList<OrderItem> orderItemList = new ArrayList<>();
        while (result.next()) {
            OrderItem order = new OrderItem();
            order.setOrder_id(result.getInt("order_id"));
            order.setBook_id(result.getInt("book_id"));
            order.setQuantity(result.getInt("quantity"));
            order.setPrice(result.getInt("price"));
            orderItemList.add(order);
        }
        return orderItemList;
    }

    public ArrayList<OrderItem> getOrderItem(String condition) throws Exception {
        return this.getOrderItem(condition, null);
    }

    public ArrayList<OrderItem> getOrderItem() throws Exception {
        return this.getOrderItem(null);
    }

    public void inserts(OrderItem orderItem) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //map.put("order_id", "NULL");
        map.put("order_id", orderItem.getOrder_id());
        map.put("book_id", orderItem.getBook_id());
        map.put("quantity", orderItem.getQuantity());
        map.put("price", orderItem.getPrice());
        this.connect.Insert("order_item", map);
    }

    public void inserts(HashSet<OrderItem> orderItemList) throws Exception {
        for (OrderItem orderItem : orderItemList) {
            inserts(orderItem);
        }
    }

    public void updates(OrderItem orderItem) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("order_id", orderItem.getOrder_id());
        map.put("book_id", orderItem.getBook_id());
        map.put("quantity", orderItem.getQuantity());
        map.put("price", orderItem.getPrice());
        this.connect.Update("order_item", map, "order_id=" + orderItem.getOrder_id() + " AND book_id="+orderItem.getBook_id());
    }

    public void updates(HashSet<OrderItem> orderItemList) throws Exception{
        for(OrderItem orderItem:orderItemList){
            updates(orderItem);
        }
    }
    
    public void deletes(OrderItem orderItem) throws Exception{
        this.connect.Delete("order_item", "order_id="+orderItem.getOrder_id()+" AND book_id="+orderItem.getBook_id());
    }
    
    public void deletes(HashSet<OrderItem> orderItemList) throws Exception{
        for(OrderItem orderItem:orderItemList){
            deletes(orderItem);
        }
    }
    public ArrayList<OrderItem> getOrderItemById(int id) throws Exception{
        return this.getOrderItem("order_id="+id);
    }
}
