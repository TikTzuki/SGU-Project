package BUS;

import DAO.Book_DAO;
import DTO.Book_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Book_BUS {
    static ArrayList<Book_DTO> ds;

    public Book_BUS() {
    }
    
    
    
    public void showAll()
    {
        Book_DAO dao = new Book_DAO();
        if(ds == null)
        {
            ds = new ArrayList<Book_DTO>();
        }
        ds = dao.showAll();
    }
    
    public void Them(Book_DTO dto)
    {
        /*
        //FrameHienThi gui = new FrameHienThi();
        if(dto.book_id == null || dto.title == null || dto.availabel_quantity==null || dto.price==null || dto.genre_id==null || dto.publication_date==null || dto.author_id==null)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
        }
        //dto.book_id = gui.;
        */
        Book_DAO dao = new Book_DAO();
        dao.Them(dto);
        ds.add(dto);
    }
    
    public void Xoa(String ma)
    {
        Book_DAO dao = new Book_DAO();
        dao.Xoa(ma);
    }
    
    public void Sua(Book_DTO dto)
    {
        Book_DAO dao = new Book_DAO();
        dao.Sua(dto);
    }
    
    public void TimKiemMa(int ma)
    {
        Book_DAO dao = new Book_DAO();
        
    }
}
