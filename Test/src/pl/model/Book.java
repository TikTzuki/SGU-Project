package pl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity @Table(name = "books")
public class Book {
    @Id private String isbn;
    private String title;
    private int year;
    // default constructor, required for entity classes
    public Book(){
    }
    public Book( String isbn, String title, int year){
        this.setIsbn( isbn);
        this.setTitle( title);
        this.setYear( year);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    // CRUD data management methods
    public static void add( EntityManager em, UserTransaction ut, String isbn, String title, int year) throws Exception{
        ut.begin();
        Book book = new Book(isbn, title, year);
        em.persist( book);
        ut.commit();
    }
    public static List<Book> retrieveAll(EntityManager em){
        Query query = em.createQuery("SELECT b FROM Book b", Book.class);
        List<Book> books = query.getResultList();
        return books;
    }
    public static Book retrieve(){}
    public static void update( EntityManager em, UserTransaction ut, String isbn, String title, int year) throws Exception{
        ut.begin();
        Book book = em.find( Book.class, isbn);
        if( !title.equals( book.getTitle())) book.setTitle( title);
        if( year != book.getYear()) book.setYear(year);
        ut.commit();
    }
    public static void destroy(EntityManager em, UserTransction ut, String isbn) throws Exception{
        ut.begin();
        Book book = em.find( Book.class, isbn);
        em.remove( book );
        ut.commit();
    }
    public static void clearData(EntityManager em, UserTransaction ut) throws Exception{
        ut.begin();
        Query deleteStatement = em.createQuery("DELETE FROM Book");
        deleteStatement.executeUpdate();
        ut.commit();
    }
    public static void createTestData(EntityManager em, UserTransaction ut) throws Exception{
        Book book = null;
        Book.clearData( em, ut);
        ut.begin();
        book = new Book("0006134654", "weaving", 2000);
        em.persist( book );
        book = new Book("1236134654", "weaving 2", 2000);
        em.persist( book );
        ut.commit();
    }
}