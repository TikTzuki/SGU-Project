/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.MyConnectUnit;
import DTO.MonHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Tik
 */
public class BMonHoc {

    MyConnectUnit connect;

    public BMonHoc() throws SQLException, Exception {
        this.connect = DAO.DAO.getDAO();

    }

    public HashSet<MonHoc> getMonHocs(String condition, String OrderBy) throws Exception {
        ResultSet result = this.connect.Select("mon_hoc", condition, OrderBy);
        HashSet<MonHoc> listMonHoc = new HashSet<MonHoc>();
        while (result.next()) {
            MonHoc monHoc = new MonHoc();
            monHoc.setMaMonHoc(result.getInt("id_mh"));
            monHoc.setTenMonHoc(result.getString("ten_mh"));
            monHoc.setSoTinChi(result.getInt("so_tin_chi"));
            listMonHoc.add(monHoc);
        }
        return listMonHoc;
    }

    public HashSet<MonHoc> getMonHocs(String condition) throws Exception {
        return getMonHocs(condition, null);
    }

    public HashSet<MonHoc> getMonHocs() throws Exception {
        return getMonHocs(null);
    }

    public MonHoc getById(int id) throws Exception {
        HashSet<MonHoc> listMonHoc = this.getMonHocs(" ma_mh = " + id);
        if (listMonHoc.size() > 0) {
            return listMonHoc.toArray(new MonHoc[listMonHoc.size()])[0];
        }
        return null;
    }

    public void Inserts(MonHoc monHoc) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("ma_mh", monHoc.getMaMonHoc());
        map.put("ten_mh", monHoc.getTenMonHoc());
        map.put("so_tin_chi", monHoc.getSoTinChi());
        this.connect.Insert(" ma_mh ", map);
    }

    public void Inserts(HashSet<MonHoc> listMonHoc) throws Exception {
        for (MonHoc monHoc : listMonHoc) {
            this.Inserts(monHoc);
        }
    }

    public void Updates(MonHoc monHoc) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("ten_mh", monHoc.getTenMonHoc());
        map.put("so_tin_chi", monHoc.getSoTinChi());
        this.connect.Update(" mon_hoc ", map, "ma_mh =" + monHoc.getMaMonHoc());
    }

    public void Updates(HashSet<MonHoc> listMonHoc) throws Exception {
        for (MonHoc monHoc : listMonHoc) {
            this.Updates(monHoc);
        }
    }

    public void Delete(MonHoc monHoc) throws Exception {
        this.connect.Delete("mon_hoc", "ma_mh=" + monHoc.getMaMonHoc());
    }

    public void Deletes(HashSet<MonHoc> listMonHoc) throws Exception {
        for (MonHoc monHoc : listMonHoc) {
            this.Delete(monHoc);
        }
    }
}
