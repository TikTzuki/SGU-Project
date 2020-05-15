/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import BLL.BSinhVien;
import java.util.HashSet;

/**
 *
 * @author Tik
 */
public class SinhVien {
    private int mssv;
    private String ho;
    private String ten;

    public SinhVien() {
    }

    public SinhVien(int mssv, String ho, String ten) {
        this.mssv = mssv;
        this.ho = ho;
        this.ten = ten;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    /*
    public HashSet<SinhVien> getSinhViens(){
        BSinhVien bsinhvien = new BSinhVien();
        listSinhVien = bsinhvien.getSinhViens("MaLop =" + this.maLop);
        return listSinhVien;
    }
    */

    @Override
    public String toString() {
        return "SinhVien{" + "mssv=" + mssv + ", ho=" + ho + ", ten=" + ten + '}';
    }
    
}
