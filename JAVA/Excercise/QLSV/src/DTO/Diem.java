/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Tik
 */
public class Diem {
    private int mssv;
    private int maMonHoc;
    private float diemLan1;
    private float diemLan2;

    public Diem() {
    }

    public Diem(int mssv, int maMonHoc, float diemLan1, float diemLan2) {
        this.mssv = mssv;
        this.maMonHoc = maMonHoc;
        this.diemLan1 = diemLan1;
        this.diemLan2 = diemLan2;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public int getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(int maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public float getDiemLan1() {
        return diemLan1;
    }

    public void setDiemLan1(float diemLan1) {
        this.diemLan1 = diemLan1;
    }

    public float getDiemLan2() {
        return diemLan2;
    }

    public void setDiemLan2(float diemLan2) {
        this.diemLan2 = diemLan2;
    }
    
}
