package zad1.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Rectangle")
public class Rectangle extends Shape {
    private final String type = "Rectangle";
    private final double width;
    private final double length;

    Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    //konstruktor bezagrumentowy dla Jacksona
    public Rectangle() {
        this.width = 0.0;
        this.length = 0.0;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }


    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return (width * 2) + (length * 2);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
