package zad1.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Circle")
public class Circle extends Shape {
    private final String type = "Circle";
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    //konstruktor bezagrumentowy dla Jacksona
    public Circle() {
        this.radius = 0.0;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.pow((Math.PI * radius), 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
