package app;

import java.util.Scanner;

public class hinhTron {
    private double r;
    Scanner scan = new Scanner(System.in);

    public hinhTron(double r) {
        this.r = r;
    }

    public hinhTron() {
    }

    public void nhap() {
        System.out.print("Nhap ban kinh: ");
        this.r = Integer.parseInt(scan.nextLine());
    }

    public double tinhChuVi() {
        return r * 2 * Math.PI;
    }

    public double tinhDienTich() {
        return r * r * Math.PI;
    }

    @Override
    public String toString() {
        return "hinhTron [r=" + r + "]";
    }

}