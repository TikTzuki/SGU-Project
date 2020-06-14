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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ResultSet result = connect.Select("book_order", condition, orderBy);
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
        //map.put("order_id", "NULL");
        map.put("staff_id", order.getStaff_id());
        map.put("discount_id", order.getDiscount_id());
        map.put("customer_id", order.getCustomer_id());
        map.put("order_date", order.getOrder_date());
        map.put("total", order.getTotal());
        connect.Insert("book_order", map);
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
        this.connect.Update("book_order", map, "order_id=" + order.getOrder_id());
    }

    public void updates(HashSet<Order> orderList) throws Exception{
        for(Order order:orderList){
            updates(order);
        }
    }
    
    public void deletes(Order order) throws Exception{
        this.connect.Delete("book_order", "order_id="+order.getOrder_id());
    }
    
    public void deletes(HashSet<Order> orderList) throws Exception{
        for(Order order:orderList){
            deletes(order);
        }
    }
    
    public int getLastOrderId() throws Exception{
        ResultSet result = this.connect.execute("SELECT MAX(order_id) FROM book_order");
        while(result.next()){
            return result.getInt("MAX(order_id)");
        }
        return 0;
    }
    
    public Order getOrderById(int orderId) throws Exception{
        return this.getOrder("order_id="+orderId).get(0);
    }
    
    public ArrayList<Order> getOrderBySearchLikeId(int orderId) throws Exception{
        return this.getOrder("order_id LIKE '%"+orderId+"%'");
    }
    
    public ArrayList<Order> searchOrder(String logic,String order, String customer, String staff, String book, String author, String discount, String dateBef, String dateAf) {
        ArrayList<Order> resultList = new ArrayList<>();
        try {
            String query = "SELECT * FROM book_order, order_item, customer WHERE  ";
            String condition = " book_order.order_id=order_item.order_id AND customer.customer_id=book_order.customer_id AND book_order.staff_id=staff.staff_id AND order_item.book_id=book.book_id  ";
            if (!order.equals("")) {
                condition += logic+" book_order.order_id=" + order + " ";
            }
            if (!customer.equals("")) {
                condition += logic+" ( customer.customer_id='" + customer +"' OR "+ createSearchConditonLike("customer.first_name", customer) + " OR "+ createSearchConditonLike("customer.last_name", customer) + " ) ";
            }
            if (!staff.equals("")) {
                condition += logic+" ( staff.staff_id='" + staff + "' OR "+createSearchConditonLike("staff.first_name", staff) + " OR " + createSearchConditonLike("staff.last_name", staff) + " ) ";
            }
            if (!book.equals("")) {
                condition += logic+" ( book.book_id='" + book + "' OR "+createSearchConditonLike("book.title", book) +" ) ";
            }
            if (!author.equals("")) {
                condition += logic+" ( book_order.author_id" + author + "' OR "+createSearchConditonLike("staff.first_name", author) + " OR " + createSearchConditonLike("staff.last_name", author) + " ) ";
            }
            if (!discount.equals("")) {
                condition += logic+" ( book_order.discount_id" + discount + " ) ";
            }
            if (!dateBef.equals("") && !dateAf.equals("")) {
                condition += logic+" ( order_date BETWEEN '" + dateBef + "' AND '" + dateAf + "' ) ";
            } else {
                if (!dateBef.equals("")) {
                    condition += logic+" ( order_date >='" + dateBef + "' ) ";
                }
                if (!dateAf.equals("")) {
                    condition += logic+" ( order_date <='" + dateAf + "' ) ";
                }
            }
            ResultSet result = this.connect.Select("book_order, order_item, customer, staff, book", condition+" GROUP BY book_order.order_id");
            
            while (result.next()) {
            Order temp = new Order();
            temp.setOrder_id(result.getInt("order_id"));
            temp.setStaff_id(result.getInt("staff_id"));
            temp.setDiscount_id(result.getInt("discount_id"));
            temp.setCustomer_id(result.getInt("customer_id"));
            temp.setOrder_date(result.getString("order_date"));
            temp.setTotal(result.getInt("total"));
            resultList.add(temp);
            }

        } catch (Exception ex) {
            Logger.getLogger(BUSOrderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultList;
    }
    public String createSearchConditonLike(String objectCompare, String paternCut){
        paternCut.trim();
        String paternArray[] = paternCut.split(" ");
        String result = "";
        for(String patern : paternArray){
             result += " OR "+ objectCompare +" LIKE '%"+ patern+"%' ";
        }
        result = result.substring(3);
        return result;
    }
}
