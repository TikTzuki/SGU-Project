package app;

import java.util.Scanner;

public class soNguyen {
    private int n;
    Scanner scan = new Scanner(System.in);

    public soNguyen() {
    }

    public soNguyen(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void nhap() {
        System.out.print("Nhap n:");
        this.n = Integer.parseInt(scan.nextLine());
    }

    public void nhap(int n) {
        setN(n);
    }

    public int tong(soNguyen n1) {
        int tong = this.n + n1.getN();
        return tong;
    }

    public int hieu(soNguyen n1) {
        int hieu = this.n - n1.getN();
        return hieu;
    }

    public int tich(soNguyen n1) {
        int tich = this.n * n1.getN();
        return tich;
    }

    public int thuong(soNguyen n1) {
        int thuong = this.n / n1.getN();
        return thuong;
    }

    public boolean ktChan() {
        if (this.n % 2 == 0)
            return true;
        return false;
    }

    public boolean ktDuong() {
        if (this.n > 0)
            return true;
        return false;
    }

    public boolean ktSoNguyenTo() {
        for (int i = 2; i < this.n; i++) {
            if (this.n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "soNguyen [n=" + n + "]";
    }

}