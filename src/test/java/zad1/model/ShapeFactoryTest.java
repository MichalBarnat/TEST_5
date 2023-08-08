package zad1.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeFactoryTest {

    ShapeFactory shapeFactory = new ShapeFactory();

    @Test
    public void shouldNotCreateNewInstanceOfTheSameSquare() {
        assertEquals(shapeFactory.createSquare(5), shapeFactory.createSquare(5));
    }

    @Test
    public void shouldNotCreateNewInstanceOfTheSameRectangle() {
        assertEquals(shapeFactory.createRectangle(10, 20), shapeFactory.createRectangle(10, 20));
    }

    @Test
    public void shouldNotCreateNewInstanceOfTheSameCircle() {
        assertEquals(shapeFactory.createCircle(2), shapeFactory.createCircle(2));
    }

}