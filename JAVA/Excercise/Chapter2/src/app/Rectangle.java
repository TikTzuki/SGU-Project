package app;

import java.util.Scanner;

public class Rectangle {
    private double width;
    private double height;
    Scanner scan = new Scanner(System.in);

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
    }

    public void initRectangle() {
        System.out.print("Enter the width: ");
        this.width = Integer.parseInt(scan.nextLine());
        System.out.print("Enter the height: ");
        this.height = Integer.parseInt(scan.nextLine());
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle [height=" + height + ", scan=" + scan + "]";
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}