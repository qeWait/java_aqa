package org.example.task_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter height of a rectangle (it can be like 11.3 or 10.0)");

        double height = scanner.nextDouble();

        System.out.println("Enter width of a rectangle (it can be like 11.3 or 10.0)");
        double width = scanner.nextDouble();

        Rectangle rectangle = new Rectangle();

        System.out.println("Rectangle area: " + rectangle.area(width, height));
        System.out.println("Rectangle perimeter: " + rectangle.perimeter(width, height));
    }

}
