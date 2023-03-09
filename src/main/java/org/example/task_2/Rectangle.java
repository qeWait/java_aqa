package org.example.task_2;

public class Rectangle {

    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area(){
        return this.width*this.height;
    }

    public double perimeter(){
        return this.height + this.width + this.height + this.width;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
