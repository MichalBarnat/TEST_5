package zad1.service;

import org.junit.Before;
import org.junit.Test;
import zad1.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ShapeServiceTest {

    private ShapeFactory shapeFactory;
    private Circle c1;
    private Circle c2;
    private Rectangle r1;
    private Rectangle r2;
    private Square sq1;
    private Square sq2;
    private List<Shape> shapes;

    @Before
    public void init() {
        shapeFactory = new ShapeFactory();
        c1 = shapeFactory.createCircle(5);
        c2 = shapeFactory.createCircle(5);
        r1 = shapeFactory.createRectangle(5, 2);
        r2 = shapeFactory.createRectangle(10, 20);
        sq1 = shapeFactory.createSquare(22);
        sq2 = shapeFactory.createSquare(222);
        shapes = new ArrayList<>(Arrays.asList(c1, c2, r1, r2, sq1, sq2));
    }

    @Test
    public void shouldReturnShapeWithLargestArea() {
        assertEquals(sq2, ShapeService.ShapeWithLargestArea(shapes));
    }

    @Test
    public void shouldReturnRectangleWithLargestPerimeter() {
        assertEquals(r2, ShapeService.findShapeWithLargestPerimeterOfType(shapes, Rectangle.class));
    }

}