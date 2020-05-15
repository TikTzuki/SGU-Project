/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv;

import BLL.BSinhVien;
import DAO.MyConnectUnit;
import DAO.MyDBConnection;
import DTO.SinhVien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
/**
 *
 * @author Tik
 */
public class QLSV {/*
    JPanel p = new JPanel();
    String[] a = {"Add","Del","Edit"};
    JButton[] b = new JButton[a.length];
    
    
    
    public QLSV(String title) throws SQLException, Exception{
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(p);
        setSize(500,400);
        for(int i=0; i<a.length; i++){
            b[i] = new JButton(a[i]);
            p.add(b[i]);
            b[i].addActionListener(this);
            setVisible(true);
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<a.length; i++){
            if(e.getSource()==b[i]) System.out.println(a[i]);
        }
    }*/
    public static void main(String[] args) throws Exception {
        BSinhVien bsv = new BSinhVien();
        
        /*
        ResultSet result = conn.Select(" sinh_vien ");
        while(result.next()){
            int id = result.getInt(1);
            String ho = result.getString(2);
            String ten = result.getString(3);
            String lop = result.getString(4);/*
            String ngay_sinh = result.getString(5);
            String gioi_tinh = result.getString(6);
            String dia_chi = result.getString(7);
            System.out.println("id=" + id + ", ho=" + ho  + ", ten=" + ten + ", lop=" +lop);
        }*/
        
        /*
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        //hashMap.put("mssv", "null");
        hashMap.put("ho", "Nguyen");
        hashMap.put("ten", "Nam");
        hashMap.put("lop", "DCT124");
        hashMap.put("ngay_sinh", "2000-5-5" );
        hashMap.put("gioi_tinh", "nam");
        hashMap.put("dia_chi", "345, Vo Van Kiet");
        conn.Insert("sinh_vien", hashMap);
        */
        
        /*
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("ho", "Nguyen");
        hashMap.put("ten", "Quan");
        hashMap.put("lop", "DCT124");
        hashMap.put("ngay_sinh", "2000-5-12");
        hashMap.put("gioi_tinh", "nam");
        hashMap.put("dia_chi", "345, Vo Van Kiet");
        conn.Update("sinh_vien", hashMap, "mssv = 4");
        */
        
        //conn.Delete("sinh_vien", "mssv = 4");
        HashSet<SinhVien> hashset = bsv.getSinhViens();
        for(SinhVien sv: hashset){
            System.out.println(sv.toString());
        }
       
    }


    
}
