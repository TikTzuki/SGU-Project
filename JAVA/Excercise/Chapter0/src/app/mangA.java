package app;

import java.util.Scanner;

public class mangA {
    private int N;
    private int a[] = new int[50];
    Scanner scan = new Scanner(System.in);

    public mangA() {
    }

    public void nhap() {
        System.out.println("Nhap N ");
        this.N = Integer.parseInt(scan.nextLine());
        if (N <= 0) {
            System.out.println("Wrong input");
        }
        for (int i = 0; i < N; i++) {
            System.out.print("Array[" + i + "]=");
            this.a[i] = Integer.parseInt(scan.nextLine());
        }
    }

    public void themPhanTu() {
        System.out.println("Nhap phan tu can chen vao mang:");
        int num = Integer.parseInt(scan.nextLine());
        this.a[this.N] = num;
        N++;
        System.out.println("Nhap thanh cong, chieu dai hien tai cua mang = " + N);
    }

    public void themPhanTu(int num) {
        this.a[this.N] = num;
        N++;
        System.out.println("Nhap thanh cong, chieu dai hien tai cua mang = " + N);
    }

    public boolean xoaPhanTu(int index) {
        if (index >= this.N)
            return false;
        for (int i = index; i < N; i++) {
            this.a[i] = a[i + 1];
        }
        this.N--;
        return true;
    }

    public boolean xoaPhanTu() {
        System.out.println("Nhap index cua phan tu can xoa, index < " + N);
        int index = Integer.parseInt(scan.nextLine());
        if (index >= this.N)
            return false;
        for (int i = index; i < N; i++) {
            this.a[i] = a[i + 1];
        }
        this.N--;
        return true;
    }

    public int timKiem() {
        System.out.println("Nhap so x can tim trong mang:");
        int num = Integer.parseInt(scan.nextLine()), i;
        for (i = 0; i < this.N; i++) {
            if (this.a[i] == num) {
                System.out.println("Da tim thay phan tu = x o vi tri = " + i);
            }
        }
        return i;
    }

    public int timKiem(int num) {
        int i;
        for (i = 0; i < this.N; i++) {
            if (this.a[i] == num) {
                System.out.println("Da tim thay phan tu = x o vi tri = " + i);
            }
        }
        return i;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

}