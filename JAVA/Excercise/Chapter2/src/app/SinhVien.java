package app;

import java.util.Scanner;

public class SinhVien {
    private String mssv;
    private String ten;
    private String lop;
    private String diemMon1;
    private String diemMon2;
    private String diemMon3;
    Scanner scan  = new Scanner(System.in);

    public SinhVien() {
    }

    public SinhVien(String mssv, String ten, String lop, String diemMon1, String diemMon2, String diemMon3) {
        this.mssv = mssv;
        this.ten = ten;
        this.lop = lop;
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
        this.diemMon3 = diemMon3;
    }
    public void nhapSinhVien(){
        System.out.print("Enter mssv: ");
        this.mssv = scan.nextLine();
        System.out.print("Enter ten: ");
        this.ten = scan.nextLine();
        System.out.print("Enter lop: ");
        this.lop = scan.nextLine();
        System.out.print("Enter diemMon1: ");
        this.diemMon1 = scan.nextLine();
        System.out.print("Enter diemMon2: ");
        this.diemMon2 = scan.nextLine();
        System.out.print("Enter diemMon3: ");
        this.diemMon3 = scan.nextLine();
    }
    public String getmssv() {
        return mssv;
    }

    public void setmssv(String mssv) {
        this.mssv = mssv;
    }

    public String getten() {
        return ten;
    }

    public void setten(String ten) {
        this.ten = ten;
    }

    public String getlop() {
        return lop;
    }

    public void setlop(String lop) {
        this.lop = lop;
    }

    public String getdiemMon1() {
        return diemMon1;
    }

    public void setdiemMon1(String diemMon1) {
        this.diemMon1 = diemMon1;
    }

    public String getdiemMon2() {
        return diemMon2;
    }

    public void setdiemMon2(String diemMon2) {
        this.diemMon2 = diemMon2;
    }

    public String getdiemMon3() {
        return diemMon3;
    }

    public void setdiemMon3(String diemMon3) {
        this.diemMon3 = diemMon3;
    }

    @Override
    public String toString() {
        return "SinhVien [mssv=" + mssv + ", ten=" + ten + ", lop=" + lop + ", diemMon1=" + diemMon1
                + ", diemMon2=" + diemMon2 + ", diemMon3=" + diemMon3 + "]";
    }
    
    

}