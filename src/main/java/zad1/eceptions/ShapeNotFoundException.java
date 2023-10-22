package zad1.eceptions;

public class ShapeNotFoundException extends RuntimeException {
    public ShapeNotFoundException() {
    }

    public ShapeNotFoundException(String message) {
        super(message);
    }
}
