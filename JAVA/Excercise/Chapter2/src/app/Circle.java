package app;

import java.util.Scanner;

public class Circle {
    private double radius;
    Scanner scan = new Scanner(System.in);

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public void InitCircle() {
        System.out.println("Enter the readius: ");
        this.radius = Integer.parseInt(scan.nextLine());
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getCircumference() {
        return radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }

}