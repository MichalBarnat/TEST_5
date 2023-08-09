package zad1.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Square")
public class Square extends Shape {
    private final String type = "Square";
    private final double side;

    Square(double side) {
        this.side = side;
    }

    //konstruktor bezagrumentowy dla Jacksona
    public Square() {
        this.side = 0.0;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
