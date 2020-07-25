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
public class Book_DTO {
    public String id;
    public String genre_name;
    public String author_firstname;
    public String author_lastname;
    public String sdt;
    public String email;
    public String file_anh;
    public int book_id;
    public int author_id;
    public int genre_id;
    public String title;
    public String isbn;
    public String publication_date;
    public int price;
    public int availabel_quantity;
    

    public Book_DTO() 
    {
        
    }

    public Book_DTO(int book_id, int author_id, int genre_id, String title, String isbn, String publication_date, int price, int availabel_quantity) {
        this.book_id = book_id;
        this.author_id = author_id;
        this.genre_id = genre_id;
        this.title = title;
        this.isbn = isbn;
        this.publication_date = publication_date;
        this.price = price;
        this.availabel_quantity = availabel_quantity;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailabel_quantity() {
        return availabel_quantity;
    }

    public void setAvailabel_quantity(int availabel_quantity) {
        this.availabel_quantity = availabel_quantity;
    }
    
}
