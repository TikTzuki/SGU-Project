package app;

import java.util.Scanner;

public class Bai9 {
    static String mess;
    public static void Run() {
        Scanner scan = new Scanner(System.in);
        Bai9.MenuOption();
        int key = Integer.parseInt(scan.nextLine());
        switch (key) {
            case 0:
                break;
            case 1:
                Bai9.CauA();
                Bai9.Run();
                break;
            case 2:
                Bai9.CauB();
                Bai9.Run();
                break;
            case 3:
                Bai9.CauC();
                Bai9.Run();
                break;
            case 4:
                Bai9.CauD();
                Bai9.Run();
                break;
            case 5:
                Bai9.CauE();
                Bai9.Run();
                break;
            case 6:
                System.out.print("Nhap chuoi: ");
                mess = scan.nextLine();
                Bai9.Run();
                break;
            default:
                break;
        }


    }
    public static void MenuOption(){
        System.out.println("\nChon mot so (ban nen chon so 6 de nhap chuoi truoc): \n1.Da dai chuoi. \n2.Chuan hoa chuoi. \n3.So tu cua chuoi. \n4.Lay ra k ky tu o dau va duoi chuoi. \n5.Lay ra chuoi con \n6.Nhap chuoi. \n0.Thoat.");
    }
    public static void CauA(){
        System.out.println("Do dai chuoi =" + mess.length());
    }
    public static void CauB(){
        mess = mess.trim();
        mess = mess.replaceAll("\\s+", " ");
        System.out.println("Chuoi da chuan hoa:" + mess);
    }
    public static void CauC(){
        mess = mess.trim();
        mess = mess.replaceAll("\\s+", " ");
        int begin = 0, end, count = 0, i;
        for (i = 0; i < mess.length(); i++) {
            if (mess.charAt(i) == ' ') {
                count++;
                end = i;
                String child = mess.substring(begin, end);
                begin = end + 1;
                System.out.println(child);
            }
        }
        end = i;
        System.out.println(mess.substring(begin, end));

        System.out.println("so tu cua chuoi la: " + (count + 1));
    }
    public static void CauD(){
        Scanner scan = new Scanner(System.in);
        int i=0;
        System.out.println("Nhap k");
        int k = Integer.parseInt(scan.nextLine());
        System.out.println("k k‎ý tự bên trái của s: " + mess.substring(0, k - 1));
        for (i = 0; i < mess.length(); i++) {
        }
        System.out.println("k k‎ý tự bên phải của s: " + mess.substring(i - k, i));
    }
    public static void CauE(){
        Scanner scan = new Scanner(System.in);
        int k;
        System.out.println("Nhap k");
        k = Integer.parseInt(scan.nextLine());
        System.out.println("Nhap n");
        int n = Integer.parseInt(scan.nextLine());
        System.out.println("n ky tu ke tu vi tri cua k: " + mess.substring(k, k + n));
    }
}