/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConnectionUnit;
import DTO.DiscountDetail;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class BUSGetDiscountDetail {
    ConnectionUnit connect;
    public BUSGetDiscountDetail(){
        connect = DAO.DAO.getDAO();
    }
    public ArrayList<DiscountDetail> getDiscountDetails(String condition, String orderBy) throws Exception{
        ResultSet result = connect.Select("discount_detail",condition,orderBy);
        ArrayList discountDetailList = new ArrayList<>();
        while(result.next()){
            DiscountDetail discountDetail = new DiscountDetail();
            discountDetail.setDiscount_id(result.getInt("discount_id"));
            discountDetail.setBook_id(result.getInt("book_id"));
            discountDetail.setPercent(result.getInt("percent"));
            discountDetailList.add(discountDetail);
        }
        return discountDetailList;
    }
    public ArrayList<DiscountDetail> getDiscountDetails(String condition) throws Exception{
        return getDiscountDetails(condition,null);
    }
    public ArrayList<DiscountDetail> getDiscountDetails() throws Exception{
        return getDiscountDetails(null);
    }
    public ArrayList<DiscountDetail> getDiscountDetailsById(int discountId) throws Exception{
        return this.getDiscountDetails("discount_id="+discountId);
    }
}
