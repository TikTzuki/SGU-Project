/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ACER
 */
public class Discount_detail {
    private int discount_id;
    private int book_id;
    private int percent;
    private int status;
    
    public Discount_detail() {
    }

    public Discount_detail(int discount_id, int book_id, int persent, int status) {
        this.discount_id = discount_id;
        this.book_id = book_id;
        this.percent = persent;
         this.status = status;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int persent) {
        this.percent = persent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

    
    
}
