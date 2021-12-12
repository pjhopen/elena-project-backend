package com.oakhill.elena.util;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

public class Converters {
    public static double[][] geometryToPath(JsonObject geometry) {
        JsonArray coordinates = geometry.getJsonArray("coordinates");
        double[][] coords = new double[coordinates.size()][2];
        for (int i = 0; i < coordinates.size(); i++) {
            JsonArray longLatPair =coordinates.getJsonArray(i);
            double longitude = longLatPair.getJsonNumber(0).doubleValue();
            double latitude = longLatPair.getJsonNumber(1).doubleValue();
            coords[i] = new double[]{longitude, latitude};
        }
        return coords;
    }

    public static JsonArray startEndToJsonArray(double[] start, double[] end) {
        JsonArray startJson = Json.createArrayBuilder().add(start[0]).add(start[1]).build();
        JsonArray endJson = Json.createArrayBuilder().add(end[0]).add(end[1]).build();
        JsonArray coordinates = Json.createArrayBuilder().add(startJson).add(endJson).build();
        return coordinates;
    }

    public static void main(String[] args) {
        System.out.println(startEndToJsonArray(new double[]{1.1, 2.1}, new double[]{2.1, 2.2}).toString()); 
    }
}
