/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Tik
 */
public class Book {
    private int book_id;
    private int author_id;
    private int genre_id;
    private String title;
    private String isbn;
    private String publication_date;
    private int price;
    private int available_quantity;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Book() {
    }

    public Book(int book_id, int author_id, int genre_id, String title, String isbn, String publication_date, int price, int available_quantity) {
        this.book_id = book_id;
        this.author_id = author_id;
        this.genre_id = genre_id;
        this.title = title;
        this.isbn = isbn;
        this.publication_date = publication_date;
        this.price = price;
        this.available_quantity = available_quantity;
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

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    @Override
    public String toString() {
        return "Book{" + "book_id=" + book_id + ", author_id=" + author_id + ", genre_id=" + genre_id + ", title=" + title + ", isbn=" + isbn + ", publication_date=" + publication_date + ", price=" + price + ", available_quantity=" + available_quantity + '}';
    }
    
}
