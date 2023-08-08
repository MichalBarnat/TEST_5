package zad1.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    private static List<Shape> extent = new ArrayList<>();

    public Shape() {
        extent.add(this);
    }

    public static List<Shape> getExtent() {
        return extent;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
