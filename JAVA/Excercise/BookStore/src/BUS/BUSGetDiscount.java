/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConnectionUnit;
import DTO.Book;
import DTO.Discount;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author root
 */
public class BUSGetDiscount {
    ConnectionUnit connect;
    public BUSGetDiscount (){
        connect = DAO.DAO.getDAO();
    }
    public ArrayList<Discount> getDiscount(String condition, String orderBy) throws Exception {
        ResultSet result = connect.Select("discount", condition, orderBy);
        ArrayList<Discount> discountList = new ArrayList<>();
        while (result.next()) {
            Discount discount = new Discount();
            discount.setDiscount_id(result.getInt("discount_id"));
            discount.setDiscount_name(result.getString("discount_name"));
            discount.setDiscount_type(result.getInt("discount_type"));
            discount.setStart_date(result.getString("start_date"));
            discount.setEnd_date(result.getString("end_date"));
	discount.setStatus(result.getInt("status"));
            discountList.add(discount);
        }
        return discountList;
    }

    public ArrayList<Discount> getDiscount(String condition) throws Exception {
        return this.getDiscount(condition, null);
    }

    public ArrayList<Discount> getDiscount() throws Exception {
        return this.getDiscount(null);
    }
    
    public Discount getDiscountByNameNType(String discountName, String discountType) throws Exception{
        ArrayList<Discount> disList = getDiscount("discount_name='"+discountName+"' AND discount_type<="+discountType , "discount_type DESC");
        if(!disList.isEmpty()){
        return disList.get(0);
        }
        Discount temp = new Discount();
        temp.setDiscount_id(-1);
        return temp;
    }
    
    public Discount getDiscountBtId(int discountId) throws Exception{
        ArrayList<Discount> discountList = new ArrayList<>();
        discountList = this.getDiscount("discount_id="+discountId);
        return discountList.get(0);
    }
    public ArrayList<Discount> getDiscountBySearchLikeIdNameType(String nameOrId) throws Exception{
        return this.getDiscount(" discount_id LIKE '%"+nameOrId+"%' OR discount_name LIKE '%"+nameOrId+"%' OR discount_type LIKE '%"+nameOrId+"%' ");
    }
    // Them, Sua, Xoa NINH
    public void inserts(Discount discount) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("discount_id", discount.getDiscount_id());
        map.put("discount_name", discount.getDiscount_name());
        map.put("discount_type", discount.getDiscount_type());
        map.put("start_date", discount.getStart_date());
        map.put("end_date", discount.getEnd_date());
        map.put("status", discount.getStatus());
        this.connect.Insert("discount", map);
    }

    public void inserts(HashSet<Discount> discountList) throws Exception {
        for (Discount discount : discountList) {
            inserts(discount);
        }
    }

    public void updates(Discount discount) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("discount_id", discount.getDiscount_id());
        map.put("discount_name", discount.getDiscount_name());
        map.put("discount_type", discount.getDiscount_type());
        map.put("start_date", discount.getStart_date());
        map.put("end_date", discount.getEnd_date());
        map.put("status", discount.getStatus());
        this.connect.Update("discount", map, "discount_id=" + discount.getDiscount_id());
    }

    public void updates(HashSet<Discount> discountList) throws Exception {
        for (Discount Discount : discountList) {
            updates(Discount);
        }
    }

    public void deletes(Discount discount) throws Exception {
        this.connect.Delete("discount", "discount_id=" + discount.getDiscount_id());
    }

    public void deletes(HashSet<Discount> discountList) throws Exception {
        for (Discount discount : discountList) {
            deletes(discount);
        }
    }

    public int getLastDiscount(String condition, String orderBy) throws Exception {
        ResultSet result = this.connect.execute("select max(discount_id) from discount");
        while(result.next())
        {
            return result.getInt("max(discount_id)");
        }
        return 0;
    }
    public int getLastDiscount(String condition) throws Exception {
        return this.getLastDiscount(condition, null);
    }

    public int getLastDiscount() throws Exception {
        return this.getLastDiscount(null);
    }
	//END Them, Sua, Xoa NINH
}
