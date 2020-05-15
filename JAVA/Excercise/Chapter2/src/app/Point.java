package app;

import java.util.Scanner;

public class Point {
    private double x;
    private double y;
    Scanner scan = new Scanner(System.in);

    public void InitPoint() {
        System.out.println("Enter x");
        this.x = Integer.parseInt(scan.nextLine());
        System.out.println("Enter y");
        this.y = Integer.parseInt(scan.nextLine());
    }

    public void MovePoint(double x, double y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}