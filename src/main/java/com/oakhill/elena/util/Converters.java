package com.oakhill.elena.util;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

public class Converters {
    public static List<double[]> geometryToPath(JsonObject geometry) {
        JsonArray coordinates = geometry.getJsonArray("coordinates");
        List<double[]> coords = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            JsonArray longLatPair =coordinates.getJsonArray(i);
            double longitude = longLatPair.getJsonNumber(0).doubleValue();
            double latitude = longLatPair.getJsonNumber(1).doubleValue();
            coords.add(new double[]{longitude, latitude});
        }
        return coords;
    }

    public static List<double[]> geometryToPathWithElevation(JsonObject geometry) {
        JsonArray coordinates = geometry.getJsonArray("coordinates");
        List<double[]> coords = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            JsonArray longLatPair =coordinates.getJsonArray(i);
            double longitude = longLatPair.getJsonNumber(0).doubleValue();
            double latitude = longLatPair.getJsonNumber(1).doubleValue();
            double elevation = longLatPair.getJsonNumber(2).doubleValue();
            coords.add(new double[]{longitude, latitude, elevation});
        }
        return coords;
    }

    public static JsonArray startEndToJsonArray(double[] start, double[] end) {
        JsonArray startJson = Json.createArrayBuilder().add(start[0]).add(start[1]).build();
        JsonArray endJson = Json.createArrayBuilder().add(end[0]).add(end[1]).build();
        JsonArray coordinates = Json.createArrayBuilder().add(startJson).add(endJson).build();
        return coordinates;
    }
}
