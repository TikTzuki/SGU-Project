package app;

import app.soNguyen;
import java.util.Scanner;

public class Bai1 {
    public static void Run() {
        Scanner scan = new Scanner(System.in);
        soNguyen n1 = new soNguyen(), n2 = new soNguyen();
        n1.nhap();
        n2.nhap();

        System.out.println("num1 + num2 =" + (n1.tong(n2)));
        System.out.println("num1 - num2 =" + (n1.hieu(n2)));
        System.out.println("num1 * num2 =" + (n1.tich(n2)));
        System.out.println("num1 / num2 =" + (n1.thuong(n2)));
    }
}