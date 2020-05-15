package app;

import java.util.Scanner;

public class Bai7 {
    private static double sum = 0;
    private static soNguyen num = new soNguyen();
    static Scanner scan = new Scanner(System.in);

    public static void Run() {
        Bai7.MenuOption();
        int key = Integer.parseInt(scan.nextLine());
        switch (key) {
            case 0:
                break;
            case 1:
                Bai7.CauA();
                Bai7.Run();
                break;
            case 2:
                Bai7.CauB();
                Bai7.Run();
                break;
            case 3:
                Bai7.CauC();
                Bai7.Run();
                break;
            case 4:
                Bai7.CauD();
                Bai7.Run();
                break;
            default:
                break;
        }
    }

    public static void MenuOption() {
        System.out.println(
                "\nChon mot so: \n1.Tong cac so < N. \n2.Tong cac so chan <= N. \n3.Tong cac so le <=N. \n4.Tong cac so nguyen to < N. \n0.Thoat");
    }

    public static void CauA() {
        // a
        num.nhap();
        while (num.getN() < 0) {
            System.out.println("Nhap sai. Can nhap lai n:");
            num.nhap();
        }
        for (int i = 0; i <= num.getN(); i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println("\nTong cac so so < N = " + sum);
    }

    public static void CauB() {
        // b
        num.nhap();
        while (num.getN() < 0) {
            System.out.println("Nhap sai. Can nhap lai n:");
            num.nhap();
        }
        sum = 0;
        for (int i = 1; i <= num.getN(); i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println("\nTong cac so chan <= N = " + sum);
    }

    public static void CauC() {
        // c
        num.nhap();
        while (num.getN() < 0) {
            System.out.println("Nhap sai. Can nhap lai n:");
            num.nhap();
        }
        sum = 0;
        for (int i = 1; i <= num.getN(); i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println("\nTong cac so le <= N = " + sum);
    }

    public static void CauD() {
        // d
        num.nhap();
        while (num.getN() < 0) {
            System.out.println("Nhap sai. Can nhap lai n:");
            num.nhap();
        }
        sum = 0;
        boolean flag = true;
        for (int i = 2; i <= num.getN(); i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag == true) {
                sum += i;
                System.out.print(i + " ");
            }
            flag = true;
        }
        System.out.println("\nTong cac so nguyen to <= N = " + sum);
    }
}