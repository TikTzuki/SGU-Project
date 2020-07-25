/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConnectionUnit;
import DTO.Genre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tik
 */
public class BUSGetGenre {
    ConnectionUnit connect;

    public BUSGetGenre() {
        connect = DAO.DAO.getDAO();
    }

    public ArrayList<Genre> getGenre(String condition, String orderBy) throws Exception {
        ResultSet result = connect.Select("genre", condition, orderBy);
        ArrayList<Genre> genreList = new ArrayList<>();
        while (result.next()) {
            Genre genre = new Genre();
            genre.setGenre_id(result.getInt("genre_id"));
            genre.setName(result.getString("name"));
            genreList.add(genre);
        }
        return genreList;
    }

    public ArrayList<Genre> getGenre(String condition) throws Exception {
        return this.getGenre(condition, null);
    }

    public ArrayList<Genre> getGenre() throws Exception {
        return this.getGenre(null);
    }
    public ResultSet getTopGenreSelled(int top, String startDate, String endDate) throws Exception{
        String query = "SELECT genre.name as genre_name, SUM(order_item.quantity) as quantity "
                + "FROM book_order, genre, book, order_item "
                + "WHERE book_order.order_id=order_item.order_id AND order_item.book_id=book.book_id AND book.genre_id=genre.genre_id AND book_order.order_date BETWEEN '"+startDate+"' AND '"+endDate+"' GROUP BY genre.genre_id ORDER BY SUM(order_item.quantity) DESC LIMIT 0,"+top;
        return this.connect.execute(query);
    }
    public Genre getGenreByBookId(int book_id) throws Exception{
        ResultSet result = connect.Select("genre,book", "book.genre_id=genre.genre_id and book_id="+book_id, null);
        Genre genre = new Genre();
        while(result.next()){
            genre = new Genre(result.getInt("genre_id"), result.getString("name"));
        }
        return genre;
    }
    
    public String getGenreNameByBookId(int book_id) throws Exception{
        ResultSet result = connect.Select("genre,book", "book.genre_id=genre.genre_id and book_id="+book_id, null);
        Genre genre = new Genre();
        while(result.next()){
            genre = new Genre(result.getInt("genre_id"), result.getString("name"));
        }
        return genre.getName();
    }
}
