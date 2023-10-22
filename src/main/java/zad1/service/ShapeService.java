package zad1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import zad1.eceptions.ShapeNotFoundException;
import zad1.model.Shape;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ShapeService {

    public static Shape ShapeWithLargestArea(List<Shape> list) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Shape::getArea))
                .orElseThrow(() -> new ShapeNotFoundException("Shape not found!"));

    }

    public static <T extends Shape> T findShapeWithLargestPerimeterOfType(List<Shape> list, Class<T> shapeType) {
        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(shapeType::isInstance)
                .map(shapeType::cast)
                .max(Comparator.comparing(Shape::getPerimeter))
                .orElseThrow(() -> new ShapeNotFoundException("Shape not found!"));
    }

    public static void exportToJSON(List<Shape> list, String path) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            Gson gson = new Gson();
            String json = gson.toJson(list);
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Shape> importFromJSON(String path) {
        List<Shape> shapes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String json = reader.readLine();
            ObjectMapper objectMapper = new ObjectMapper();
            shapes = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Shape.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shapes;
    }

}
