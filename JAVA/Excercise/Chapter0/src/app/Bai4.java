package app;

import java.util.Scanner;

public class Bai4 {
    public static void Run() {
        soNguyen num = new soNguyen();
        num.nhap();
        if (num.getN() == 0) {
            System.out.println("Num is 0");
        }
        if (num.ktChan()) {
            System.out.println("N la so chan");
        } else {
            System.out.println("N la so le");
        }
    }
}