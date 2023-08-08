package zad1;

import zad1.model.*;
import zad1.service.ShapeService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Circle c1 = shapeFactory.createCircle(5);
        Circle c2 = shapeFactory.createCircle(5);
        Circle c3 = shapeFactory.createCircle(6);
        System.out.println(c1 == c2);
        //Circle c4 = new Circle(5); error

        Rectangle r1 = shapeFactory.createRectangle(5, 2);
        Rectangle r2 = shapeFactory.createRectangle(10, 20);
        Square sq1 = shapeFactory.createSquare(22);
        Square sq2 = shapeFactory.createSquare(222);

        Shape largestArea = ShapeService.ShapeWithLargestArea(Shape.getExtent());
        System.out.println("Shape with largest area: " + largestArea);

        Rectangle rectangleWithLargestPerimeter = ShapeService.findShapeWithLargestPerimeterOfType(Shape.getExtent(), Rectangle.class);
        System.out.println("Rectangle with largest perimeter: " + rectangleWithLargestPerimeter);


        ShapeService.exportToJSON(Shape.getExtent(), "src/main/java/zad1/export.json");

        List<Shape> shapesFromJson = ShapeService.importFromJSON("src/main/java/zad1/export.json");


    }
}
