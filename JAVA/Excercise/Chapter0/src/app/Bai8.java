package app;

import java.util.Scanner;

public class Bai8 {
    static mangA arr = new mangA();

    public static void Run() {
        Scanner scan = new Scanner(System.in);
        Bai8.MenuOption();
        int key = Integer.parseInt(scan.nextLine());

        switch (key) {
            case 0:
                break;
            case 1:
                Bai8.CauA();
                Bai8.Run();
                break;
            case 2:
                Bai8.CauB();
                Bai8.Run();
                break;
            case 3:
                Bai8.CauC();
                Bai8.Run();
                break;
            case 4:
                Bai8.CauD();
                Bai8.Run();
                break;
            case 5:
                Bai8.arr.themPhanTu();
                Bai8.Run();
                break;
            case 6:
                Bai8.arr.xoaPhanTu();
                Bai8.Run();
                break;
            case 7:
                Bai8.arr.timKiem();
                Bai8.Run();
                break;
            case 8:
                arr.nhap();
                Bai8.Run();
                break;
            default:
                break;
        }

    }

    public static void MenuOption() {
        System.out.println(
                "\nChon mot so (ban nen chon so 8 de nhap mang truoc): \n1.Tong cac phan tu cua mang A. \n2.Tong cac phan tu chan cua mang A. \n3.Tong cac phan tu le cua mang A. \n4.Tong cac phan tu la so nguyen to cua mang A. \n5.Them phan tu 6.Xoa phan tu. \n7.Tim kiem phan tu. \n8.Nhap mang A. \n0.Thoat.");
    }

    public static void CauA() {
        int sum = 0;
        for (int i = 0; i < arr.getN(); i++) {
            System.out.print(arr.getA()[i] + ", ");
            sum += arr.getA()[i];
        }
        System.out.println("Tong cac phan tu = " + sum);
    }

    public static void CauB() {
        int sum = 0;
        for (int i = 0; i < arr.getN(); i++) {
            if (arr.getA()[i] % 2 == 0) {
                System.out.print(arr.getA()[i] + ", ");
                sum += arr.getA()[i];
            }
        }
        System.out.println("\nTong cac so chan <= N = " + sum);
    }

    public static void CauC() {
        int sum = 0;
        for (int i = 0; i < arr.getN(); i++) {
            if (arr.getA()[i] % 2 != 0) {
                System.out.print(arr.getA()[i] + ", ");
                sum += arr.getA()[i];
            }
        }
        System.out.println("\nTong cac so le <= N = " + sum);
    }

    public static void CauD() {
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < arr.getN(); i++) {
            for (int j = 2; j < i; j++) {
                if (arr.getA()[i] % j == 0) {
                    flag = false;
                }
            }
            if (flag == true) {
                sum += arr.getA()[i];
                System.out.print(arr.getA()[i] + ", ");
            }
            flag = true;
        }
        System.out.println("\nTong cac so nguyen to <= N = " + sum);
    }
}