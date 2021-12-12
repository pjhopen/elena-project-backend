package com.oakhill.elena.util;

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
}
