/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.MyConnectUnit;
import DAO.MyDBConnection;
import DTO.SinhVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Tik
 */
public class BSinhVien {

    MyConnectUnit connect;

    public BSinhVien() throws SQLException, Exception {
        this.connect = DAO.DAO.getDAO();
        
    }

    public HashSet<SinhVien> getSinhViens(String condition, String OrderBy) throws Exception{
        ResultSet result = this.connect.Select("sinh_vien",condition,OrderBy);
        HashSet<SinhVien> listSinhVien = new HashSet<SinhVien>();
        while(result.next()){
            SinhVien sv = new SinhVien();
            sv.setMssv(result.getInt("mssv"));
            sv.setHo(result.getString("ho"));
            sv.setTen(result.getString("ten"));
            listSinhVien.add(sv);
        }
        return listSinhVien;
    }

    public HashSet<SinhVien> getSinhViens(String condition) throws Exception{
        return getSinhViens(condition, null);
    }

    public HashSet<SinhVien> getSinhViens() throws Exception {
        return getSinhViens(null);
    }

    public SinhVien getById(int id) throws Exception {
        HashSet<SinhVien> listSinhVien = this.getSinhViens("mssv ="+id);
        if(listSinhVien.size()>0)
            return listSinhVien.toArray(new SinhVien[listSinhVien.size()])[0];
        return null;
    }

    public void Inserts(SinhVien sv) throws Exception {
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("mssv", sv.getMssv());
        map.put("ho", sv.getHo());
        map.put("ten", sv.getTen());
        this.connect.Insert("sinh_vien", map);
    }

    public void Inserts(HashSet<SinhVien> listSinhVien) throws Exception  {
        for(SinhVien sv:listSinhVien)
            this.Inserts(sv);
    }
    
    
    public void Updates (SinhVien sv) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("ho", sv.getHo());
        map.put("ten", sv.getTen());
        this.connect.Update("sinh_vien",map,"mssv="+sv.getMssv());
    }
    public void Updates (HashSet<SinhVien> listSinhVien) throws Exception{
        for(SinhVien sv:listSinhVien)
            this.Updates(sv);
    }
    
    public void Delete(SinhVien sv) throws Exception  {
        this.connect.Delete("sinh_vien","mssv="+sv.getMssv());
    }

    public void Deletes(HashSet<SinhVien> listSinhVien) throws Exception {
        for(SinhVien sv:listSinhVien)
            this.Delete(sv);
    }
    
}
