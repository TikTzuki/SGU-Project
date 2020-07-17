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
private int status;

    public DiscountDetail() {
    }

    public DiscountDetail(int book_id, int discount_id, int percent, int status) {
        this.book_id = book_id;
        this.discount_id = discount_id;
        this.percent = percent;
this.status = status;
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
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DiscountDetail{" + "book_id=" + book_id + ", discount_id=" + discount_id + ", percent=" + percent + '}';
    }
    
}
