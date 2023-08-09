package zad1.service;

import org.junit.Before;
import org.junit.Test;
import zad1.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    @Test
    public void shouldExportCorrectJsonFormat() {
        List<Shape> list = new ArrayList<>(Arrays.asList(c1, sq1));
        String testJsonFormat = "test_jsonformat.json";
        String jsonFormat =  "";
        String expectedFormat = "[{\"type\":\"Circle\",\"radius\":5.0},{\"type\":\"Square\",\"side\":22.0}]";
        ShapeService.exportToJSON(list, testJsonFormat);
        try(BufferedReader reader = new BufferedReader(new FileReader(testJsonFormat))) {
            jsonFormat = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expectedFormat, jsonFormat);

        File testFile = new File(testJsonFormat);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testExportAndImportJSON() {
        String testFilePath = "test_json.json";

        ShapeService.exportToJSON(shapes, testFilePath);

        List<Shape> importedShapes = ShapeService.importFromJSON(testFilePath);

        assertEquals(shapes.size(), importedShapes.size());

        for (int i = 0; i < shapes.size(); i++) {
            Shape originalShape = shapes.get(i);
            Shape importedShape = importedShapes.get(i);

            assertEquals(originalShape.getClass(), importedShape.getClass());

            if (originalShape instanceof Circle) {
                assertEquals(((Circle) originalShape).getRadius(), ((Circle) importedShape).getRadius(), 0.0001);
            } else if (originalShape instanceof Rectangle) {
                assertEquals(((Rectangle) originalShape).getWidth(), ((Rectangle) importedShape).getWidth(), 0.0001);
                assertEquals(((Rectangle) originalShape).getLength(), ((Rectangle) importedShape).getLength(), 0.0001);
            } else if (originalShape instanceof Square) {
                assertEquals(((Square) originalShape).getSide(), ((Square) importedShape).getSide(), 0.0001);
            }
        }


        File testFile = new File(testFilePath);
        if (testFile.exists()) {
            testFile.delete();
        }
    }
}