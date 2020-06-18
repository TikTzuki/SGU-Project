/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConnectionUnit;
import DTO.Author;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Tik
 */
public class BUSGetAuthor {
    ConnectionUnit connect;

    public BUSGetAuthor() {
        connect = DAO.DAO.getDAO();
    }

    public ArrayList<Author> getAuthor(String condition, String orderBy) throws Exception {
        ResultSet result = connect.Select("author", condition, orderBy);
        ArrayList<Author> authorList = new ArrayList<>();
        while (result.next()) {
            Author author = new Author();
            author.setAuthor_id(result.getInt("author_id"));
            author.setFirst_name(result.getString("first_name"));
            author.setLast_name(result.getString("last_name"));
            author.setPhone_number(result.getString("phone_number"));
            author.setEmail("email");
            authorList.add(author);
        }
        return authorList;
    }

    public ArrayList<Author> getAuthor(String condition) throws Exception {
        return this.getAuthor(condition, null);
    }

    public ArrayList<Author> getAuthor() throws Exception {
        return this.getAuthor(null);
    }
    public ResultSet getTopAuthorSelled(int top, String startDate, String endDate) throws Exception{
        String query = "SELECT author.first_name as first_name, author.last_name as last_name, SUM(order_item.quantity) as quantity "
                + "FROM author, order_item, book_order, book "
                + "WHERE author.author_id=book.author_id AND book.book_id=order_item.book_id AND order_item.order_id=book_order.order_id AND book_order.order_date BETWEEN '"+startDate+"' AND '"+endDate+"' GROUP BY author.author_id ORDER BY SUM(order_item.quantity) DESC LIMIT 0,"+top;
        return this.connect.execute(query);
    }
    public Author getAuthorByBookId(int book_id) throws Exception{
        ResultSet result = connect.Select("author,book", "author.author_id=book.author_id and book_id="+book_id);
        Author author = new Author();
        while(result.next()){
            author.setAuthor_id(result.getInt("author_id"));
            author.setFirst_name(result.getString("first_name"));
            author.setLast_name(result.getString("last_name"));
            author.setPhone_number(result.getString("phone_number"));
            author.setEmail(result.getString("email"));
        }
        return author;
    }
    public String getAuthorNameById(int authorId) throws Exception{
        ResultSet result = connect.Select("author", "author_id="+authorId);
        Author author = new Author();
        while(result.next()){
            author.setAuthor_id(result.getInt("author_id"));
            author.setFirst_name(result.getString("first_name"));
            author.setLast_name(result.getString("last_name"));
            author.setPhone_number(result.getString("phone_number"));
            author.setEmail(result.getString("email"));
        }
        return author.getFirst_name()+" "+author.getLast_name();
    }
    public ArrayList<Author> getAuthorBySearchLikeIdName(String nameOrId) throws Exception{
        return this.getAuthor(" author_id LIKE '%"+nameOrId+"%' OR first_name LIKE '%"+nameOrId+"%' OR last_name LIKE '%"+nameOrId+"%' ");
    }
}
