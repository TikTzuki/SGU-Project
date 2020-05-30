/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.ConnectionUnit;
import DTO.Book;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 *
 * @author Tik
 */
public class BUSGetBook {
    ConnectionUnit connect;

    public BUSGetBook() {
        connect = DAO.DAO.getDAO();
    }

    public ArrayList<Book> getBook(String condition, String orderBy) throws Exception {
        ResultSet result = connect.Select("book", condition, orderBy);
        ArrayList<Book> bookList = new ArrayList<>();
        while (result.next()) {
            Book book = new Book();
            book.setBook_id(result.getInt("book_id"));
            book.setAuthor_id(result.getInt("author_id"));
            book.setGenre_id(result.getInt("genre_id"));
            book.setTitle(result.getString("title"));
            book.setIsbn(result.getString("isbn"));
            book.setPublication_date(result.getString("publication_date"));
            book.setPrice(result.getInt("price"));
            book.setAvailable_quantity(result.getInt("available_quantity"));
            bookList.add(book);
        }
        return bookList;
    }

    public ArrayList<Book> getBook(String condition) throws Exception {
        return this.getBook(condition, null);
    }

    public ArrayList<Book> getBook() throws Exception {
        return this.getBook(null);
    }
    
    public Book getBookById(int bookId) throws Exception{
        ArrayList<Book> bookList = this.getBook("book_id="+bookId);
        return bookList.get(0);
    }
    public String getBookTitleById(int bookId) throws Exception{
        return this.getBookById(bookId).getTitle();
    }
}
