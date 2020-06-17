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
}
