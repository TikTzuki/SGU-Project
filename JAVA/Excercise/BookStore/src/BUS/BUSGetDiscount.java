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
}
