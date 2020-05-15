package app;

import java.util.Scanner;

public class Bai3 {
    public static void Run() {
        hinhTron circle = new hinhTron();
        circle.nhap();
        System.out.println("Chu vi :" + circle.tinhChuVi());
        System.out.println("Dien tich :" + circle.tinhDienTich());
    }
}