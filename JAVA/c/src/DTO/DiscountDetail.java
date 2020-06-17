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
public class DiscountDetail {
    private int book_id;
    private int discount_id;
    private int percent;

    public DiscountDetail() {
    }

    public DiscountDetail(int book_id, int discount_id, int percent) {
        this.book_id = book_id;
        this.discount_id = discount_id;
        this.percent = percent;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
    
}
