package org.example.task_2;

public class Rectangle {

    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() throws Exception {
        if (this.height <= 0 || this.width <= 0) {
            throw new IllegalArgumentException("Height or width in rectangle can`t be 0 or less");
        }
        return this.width*this.height;
    }

    public double perimeter() throws Exception {
        if (this.height <= 0 || this.width <= 0) {
            throw new IllegalArgumentException("Height or width in rectangle can`t be 0 or less");
        }
        return this.height + this.width + this.height + this.width;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
