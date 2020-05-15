package app;

import java.util.Scanner;

public class hinhChuNhat {
    private double dai;
    private double rong;
    Scanner scan = new Scanner(System.in);

    public hinhChuNhat() {
    }

    public hinhChuNhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public void nhap() {
        System.out.print("Nhap chieu dai");
        this.dai = Integer.parseInt(scan.nextLine());
        System.out.print("Nhap chieu rong");
        this.rong = Integer.parseInt(scan.nextLine());
    }

    public double tinhChuVi() {
        return (dai + rong) * 2;
    }

    public double tinhDienTich() {
        return (dai * rong);
    }

    @Override
    public String toString() {
        return "hinhChuNhat [dai=" + dai + ", rong=" + rong + "]";
    }

}