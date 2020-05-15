package app;

import java.util.Scanner;

public class Bai6 {
    public static void Run() {
        soNguyen num = new soNguyen();
        num.nhap();
        if (num.getN() <= 0) {
            System.out.println("Nhap sai.");
        }
        if (num.ktSoNguyenTo()) {
            System.out.println("N la so nguyen to.");
        } else {
            System.out.println("N khong la so nguyen to.");
        }
    }
}