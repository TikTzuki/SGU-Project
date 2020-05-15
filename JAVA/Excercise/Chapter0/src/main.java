import java.util.Scanner;

import app.Bai1;
import app.Bai2;
import app.Bai3;
import app.Bai4;
import app.Bai5;
import app.Bai6;
import app.Bai7;
import app.Bai8;
import app.Bai9;

public class main {
    public static void main(String[] args) {
        main.Menu();
    }

    public static void Menu() {
        Scanner scan = new Scanner(System.in);
        main.MenuOption();
        int key = Integer.parseInt(scan.nextLine());
        switch (key) {
            case 0:
                break;
            case 1:
                Bai1.Run();
                main.Menu();
            case 2:
                Bai2.Run();
                main.Menu();
            case 3:
                Bai3.Run();
                main.Menu();
            case 4:
                Bai4.Run();
                main.Menu();
            case 5:
                Bai5.Run();
                main.Menu();
            case 6:
                Bai6.Run();
                main.Menu();
            case 7:
                Bai7.Run();
                main.Menu();
            case 8:
                Bai8.Run();
                main.Menu();
            case 9:
                Bai9.Run();
                main.Menu();
            default:
                main.Menu();
        }
    }

    public static void MenuOption() {
        System.out.println(
                "\nChon 1 so: \n1.Tong hai so. \n2.Tinh chu vi & dien tich hinh tam giac. \n3.Tinh chu vi & dien tich hinh tron. \n4.Kiem tra so chan hoac le. \n5.Kiem tra so am duong. \n6.Kiem tra so nguyen to. \n7.Tong cac so nho hon N (co dieu kien). \n8.Thao tac voi mang a. \n9.Thao tac voi chuoi. \n0.Thoat");
    }
}
