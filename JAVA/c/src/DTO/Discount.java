/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author root
 */
public class Discount {
    private int discount_id;
    private String discount_name;
    private int discount_type;
    private String start_date;
    private String end_date;

    public Discount() {
    }

    public Discount(int discount_id, String discount_name, int discount_type, String start_date, String end_date) {
        this.discount_id = discount_id;
        this.discount_name = discount_name;
        this.discount_type = discount_type;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public String getDiscount_name() {
        return discount_name;
    }

    public void setDiscount_name(String discount_name) {
        this.discount_name = discount_name;
    }

    public int getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(int discount_type) {
        this.discount_type = discount_type;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
    
    
}
