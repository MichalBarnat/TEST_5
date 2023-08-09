package zad1.model;

import java.util.concurrent.ConcurrentHashMap;

public class ShapeFactory {
    private final ConcurrentHashMap<String, Square> squareCache;
    private final ConcurrentHashMap<String, Rectangle> rectangleCache;
    private final ConcurrentHashMap<String, Circle> circleCache;

    public ShapeFactory() {
        squareCache = new ConcurrentHashMap<>();
        rectangleCache = new ConcurrentHashMap<>();
        circleCache = new ConcurrentHashMap<>();
    }

    public Square createSquare(int side) {
        String key = "Square" + side;
        if (squareCache.containsKey(key)) {
            return squareCache.get(key);
        } else {
            Square square = new Square(side);
            squareCache.put(key, square);
            return square;
        }
    }

    public Rectangle createRectangle(int length, int width) {
        //POPRAWIONE:
        String key = "Rectangle" + "l"+ length + "w" + width;
        if (rectangleCache.containsKey(key)) {
            return rectangleCache.get(key);
        } else {
            Rectangle rectangle = new Rectangle(length, width);
            rectangleCache.put(key, rectangle);
            return rectangle;
        }
    }

    public Circle createCircle(int radius) {
        String key = "Circle" + radius;
        if (circleCache.containsKey(key)) {
            return circleCache.get(key);
        } else {
            Circle circle = new Circle(radius);
            circleCache.put(key, circle);
            return circle;
        }
    }

    public ConcurrentHashMap<String, Square> getSquareCache() {
        return squareCache;
    }

    public ConcurrentHashMap<String, Rectangle> getRectangleCache() {
        return rectangleCache;
    }

    public ConcurrentHashMap<String, Circle> getCircleCache() {
        return circleCache;
    }
}
