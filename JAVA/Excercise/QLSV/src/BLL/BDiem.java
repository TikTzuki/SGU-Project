/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.MyConnectUnit;
import DAO.MyDBConnection;
import DTO.Diem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Tik
 */
public class BDiem {

    MyConnectUnit connect;

    public BDiem() {
        this.connect = DAO.DAO.getDAO();
    }

    public ArrayList<Diem> getDiems(String condition, String OrderBy) throws Exception {
        ResultSet result = this.connect.Select("diem", condition, OrderBy);
        ArrayList<Diem> listDiem = new ArrayList<Diem>();
        while (result.next()) {
            Diem diem = new Diem();
            diem.setMssv(result.getInt("mssv"));
            diem.setMaMonHoc(result.getInt("ma_mh"));
            diem.setDiemLan1(result.getFloat("diem_lan1"));
            diem.setDiemLan2(result.getFloat("diem_lan2"));
            listDiem.add(diem);
        }
        return listDiem;
    }

    public ArrayList<Diem> getDiems(String condition) throws Exception  {
        return getDiems(condition, null);
    }

    public ArrayList<Diem> getDiems() throws Exception {
        return getDiems(null);
    }

    public ArrayList<Diem> getByMSSV(int idMssv) throws Exception{
        ArrayList<Diem> listDiem = this.getDiems("mssv =" + idMssv);
        if (listDiem.size() > 0) {
            return listDiem;
        }
        return null;
    }

    public ArrayList<Diem> getByMaMH(int idMaMonHoc) throws Exception  {
        ArrayList<Diem> listDiem = this.getDiems("mssv =" + idMaMonHoc);
        if (listDiem.size() > 0) {
            return listDiem;
        }
        return null;
    }

    public ArrayList<Diem> getById(int idMssv, int idMaMonHoc) throws Exception {
        ArrayList<Diem> listDiem = this.getDiems("mssv =" + idMaMonHoc + "and ma_mh =" + idMaMonHoc);
        if (listDiem.size() > 0) {
            return listDiem;
        }
        return null;
    }

    public void Inserts(Diem diem) throws Exception{
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("mssv", diem.getMssv());
        map.put("ma_mh", diem.getMaMonHoc());
        map.put("diem_lan1", diem.getDiemLan1());
        map.put("diem_lan2", diem.getDiemLan2());
        this.connect.Insert("diem", map);
    }

    public void Inserts(HashSet<Diem> listDiem) throws Exception{
        for (Diem diem : listDiem) {
            this.Inserts(diem);
        }
    }

    public void Updates(Diem diem) throws Exception{
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("diem_lan1", diem.getDiemLan1());
        map.put("diem_lan2", diem.getDiemLan2());
        this.connect.Update("diem", map, "mssv=" + diem.getMssv() + "and ma_mh=" + diem.getMaMonHoc());
    }

    public void Updates(HashSet<Diem> listDiem) throws Exception {
        for (Diem diem : listDiem) {
            this.Updates(diem);
        }
    }

    public void Delete(Diem diem) throws Exception  {
        this.connect.Delete("sinh_vien", "mssv=" + diem.getMssv() + "and ma_mh =" + diem.getMaMonHoc());
    }

    public void Deletes(HashSet<Diem> listDiem) throws Exception {
        for (Diem diem : listDiem) {
            this.Delete(diem);
        }
    }
}
