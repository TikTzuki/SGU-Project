package app;

import java.util.Scanner;

public class Bai5 {
    public static void Run() {
        soNguyen num = new soNguyen();
        num.nhap();
        if (num.getN() == 0) {
            System.out.println("N la so 0");
        }
        if (num.ktDuong()) {
            System.out.println("N la so duong");
        } else {
            System.out.println("N la so am");
        }
    }
}