/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConnectionUnit;
import DTO.Discount_detail;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author ACER
 */
public class BUSGetDiscount_detail {
    ConnectionUnit connect;

    public BUSGetDiscount_detail() {
        connect = DAO.DAO.getDAO();
    }

    public ArrayList<Discount_detail> getDiscount_detail(String condition, String orderBy) throws Exception {
        ResultSet result = connect.Select("discount_detail", condition, orderBy);
        ArrayList<Discount_detail> discount_detailList = new ArrayList<>();
        while (result.next()) {
            Discount_detail discount_detail = new Discount_detail();
            discount_detail.setDiscount_id(result.getInt("discount_id"));
            discount_detail.setBook_id(result.getInt("book_id"));
            discount_detail.setPercent(result.getInt("percent"));
            discount_detail.setStatus(result.getInt("status"));
            discount_detailList.add(discount_detail);
        }
        return discount_detailList;
    }

    public ArrayList<Discount_detail> getDiscount_detail(String condition) throws Exception {
        return this.getDiscount_detail(condition, null);
    }

    public ArrayList<Discount_detail> getDiscount_detail() throws Exception {
        return this.getDiscount_detail(null);
    }
    
    // Them, Sua, Xoa
    public void inserts(Discount_detail discount_detail) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("discount_id", discount_detail.getDiscount_id());
        map.put("book_id", discount_detail.getBook_id());
        map.put("percent", discount_detail.getPercent());
        map.put("status", discount_detail.getStatus());
        this.connect.Insert("discount_detail", map);
    }

    public void inserts(HashSet<Discount_detail> discount_detailList) throws Exception {
        for (Discount_detail discount_detail : discount_detailList) {
            inserts(discount_detail);
        }
    }

    public void updates(Discount_detail discount_detail) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("discount_id", discount_detail.getDiscount_id());
        map.put("book_id", discount_detail.getBook_id());
        map.put("percent", discount_detail.getPercent());
        map.put("status", discount_detail.getStatus());
        this.connect.Update("discount_detail", map, "discount_id=" + discount_detail.getDiscount_id()+" AND book_id="+discount_detail.getBook_id());
    }

    public void updates(HashSet<Discount_detail> discount_detailList) throws Exception{
        for(Discount_detail Discount_detail:discount_detailList){
            updates(Discount_detail);
        }
    }
    
    public void deletes(Discount_detail discount_detail) throws Exception{
        this.connect.Delete("discount_detail", "discount_id="+discount_detail.getDiscount_id()+" AND book_id="+discount_detail.getBook_id());
    }
    
    public void deletes(HashSet<Discount_detail> discount_detailList) throws Exception{
        for(Discount_detail discount_detail:discount_detailList){
            deletes(discount_detail);
        }
    }
    
}
