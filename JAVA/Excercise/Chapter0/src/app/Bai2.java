package app;

import java.util.Scanner;

public class Bai2 {

    public static void Run() {
        hinhChuNhat recTangle = new hinhChuNhat();
        recTangle.nhap();
        System.out.println("Chi vi " + recTangle.tinhChuVi());
        System.out.println("Dien tich: " + recTangle.tinhDienTich());
    }
}