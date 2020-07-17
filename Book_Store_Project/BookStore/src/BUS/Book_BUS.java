package BUS;

import DAO.Book_DAO;
import DTO.Book_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Book_BUS {
    ArrayList<Book_DTO> ds;

    public Book_BUS() {
    }
    
    
    
    public ArrayList showAll()
    {
        //ArrayList<Book_DTO> ds = null;
        Book_DAO dao = new Book_DAO();
        if(ds == null)
        {
            ds = new ArrayList<Book_DTO>();
        }
        ds = dao.showAll();
        return ds;
    }
    
    
    
    public void Them(Book_DTO dto)
    {
        /*
        String soLuong = String.valueOf(dto.availabel_quantity);
        String gia = String.valueOf(dto.price);
        if(dto.title.isEmpty()|| soLuong.isEmpty()||gia.isEmpty()||dto.publication_date.isEmpty()||dto.file_anh.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ dữ liệu!");
        }
        else
        {
            Book_DAO dao = new Book_DAO();
            dao.Them(dto);
            ds.add(dto);
        }*/
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
    public ArrayList TimKiemDate(String day1, String day2)
    {
        Book_DAO dao = new Book_DAO();
        if(ds == null)
        {
            ds = new ArrayList<Book_DTO>();
        }
        ds = dao.TimKiemDate(day1, day2);
        return ds;
    }

    
    public void ThemTheLoai(Book_DTO dto)
    {
        Book_DAO dao = new Book_DAO();
        dao.ThemTheLoai(dto);
        //ds.add(dto);
    }
    public void SuaTheLoai(Book_DTO dto)
    {
        Book_DAO dao = new Book_DAO();
        dao.SuaTheLoai(dto);
        //ds.add(dto);
    }
    public void XoaTheLoai(int id)
    {
        Book_DAO dao = new Book_DAO();
        dao.XoaTheLoai(id);
        //ds.add(dto);
    }
    public ArrayList Select_TheLoai()
    {
        //ArrayList<Book_DTO> ds = null;
        Book_DAO dao = new Book_DAO();
        if(ds == null)
        {
            ds = new ArrayList<Book_DTO>();
        }
        ds = dao.Select_TheLoai();
        return ds;
    }
    
    public ArrayList Select_TacGia()
    {
        //ArrayList<Book_DTO> ds = null;
        Book_DAO dao = new Book_DAO();
        if(ds == null)
        {
            ds = new ArrayList<Book_DTO>();
        }
        ds = dao.Select_TacGia();
        return ds;
    }
    
    public void ThemTacGia(Book_DTO dto)
    {
        Book_DAO dao = new Book_DAO();
        dao.ThemTacGia(dto);
        //ds.add(dto);
    }
    public void SuaTacGia(Book_DTO dto)
    {
        Book_DAO dao = new Book_DAO();
        dao.SuaTacGia(dto);
        //ds.add(dto);
    }
}
