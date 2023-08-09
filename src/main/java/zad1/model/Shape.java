package zad1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "Circle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "Rectangle"),
        @JsonSubTypes.Type(value = Square.class, name = "Square")
})
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
