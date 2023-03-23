package org.example.task_2;

public class Rectangle {

    public Rectangle() {}

    public double area(double width, double height) throws Exception {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Height or width in rectangle can`t be 0 or less");
        }
        return width*height;
    }

    public double perimeter(double width, double height) throws Exception {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Height or width in rectangle can`t be 0 or less");
        }
        return height + width + height + width;
    }
}
