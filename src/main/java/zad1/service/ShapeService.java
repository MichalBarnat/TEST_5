package zad1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
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
                .orElse(null);

    }

    public static <T extends Shape> T findShapeWithLargestPerimeterOfType(List<Shape> list, Class<T> shapeType) {
//        List<T> shapes = new ArrayList<>();
//        for (Shape shape : list) {
//            if (shapeType.isInstance(shape)) {
//                shapes.add(shapeType.cast(shape));
//            }
//        }
//
//        return shapes.stream()
//                .max(Comparator.comparing(Shape::getPerimeter))
//                .orElse(null);
        // DO POPRAWY

        return Optional.ofNullable(list)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(shapeType::isInstance)
                .map(shapeType::cast)
                .max(Comparator.comparing(Shape::getPerimeter))
                .orElse(null);
    }

    public static void exportToJSON(List<Shape> list, String path) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            Gson gson = new Gson();
            String ss = gson.toJson(list);
            fileWriter.write(ss);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Shape> importFromJSON(String path) {
//        try {
//            Gson gson = new Gson();
//            String json = new String(Files.readAllBytes(Paths.get(path)));
//            JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
//
//            List<Shape> shapes = new ArrayList<>();
//
//            for (JsonElement jsonElement : jsonArray) {
//                JsonObject jsonObject = jsonElement.getAsJsonObject();
//                String type = jsonObject.get("type").getAsString();
//
//                Shape shape;
//
//                switch (type) {
//                    case "Circle":
//                        shape = gson.fromJson(jsonObject, Circle.class);
//                        break;
//                    case "Rectangle":
//                        shape = gson.fromJson(jsonObject, Rectangle.class);
//                        break;
//                    case "Square":
//                        shape = gson.fromJson(jsonObject, Square.class);
//                        break;
//                    default:
//                        throw new IllegalArgumentException("Unknown shape type: " + type);
//                }
//
//                shapes.add(shape);
//            }
//
//            return shapes;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
        // DO POPRAWY

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
