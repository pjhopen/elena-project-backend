package com.oakhill.elena.mapper;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import com.oakhill.elena.configuration.OpenStreetServiceConfig;
import com.oakhill.elena.model.RequestData;
import com.oakhill.elena.util.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * OpenRouteServiceMapper
 */

@Component
public class OpenRouteServiceMapper {

    @Autowired
    OpenStreetServiceConfig openStreetServiceConfig;

    public JsonObject queryShortestPathWithWeight() {

        Client client = ClientBuilder.newClient();

        Entity<String> payload = Entity.json(
                "{\"coordinates\":[[8.681495,49.41461],[8.686507,49.41943]],\"alternative_routes\":{\"target_count\":3,\"weight_factor\":1.4}}");

        //
        Response response = client.target("https://api.openrouteservice.org/v2/directions/foot-walking/geojson")
                .request()
                .header("Authorization", openStreetServiceConfig.getApi_key())
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .header("Content-Type", "application/json; charset=utf-8")
                .post(payload);

        JsonReader jsonReader = Json.createReader(new StringReader(response.readEntity(String.class)));
        JsonObject responseBody = jsonReader.readObject();

        // Map<String, List<String>> map = response.readEntity(new
        // GenericType<Map<String, List<String>>>() { });
        // List<String> values = map.get("features");

        return responseBody;
    }

    public JsonObject queryShortestPath(RequestData reqData) {
        JsonArray coordinates = Converters.startEndToJsonArray(reqData.getStart(), reqData.getEnd());
        JsonObject requestBody = Json.createObjectBuilder().add("coordinates", coordinates).build();

        Client client = ClientBuilder.newClient();

        Entity<String> payload = Entity.json(requestBody.toString());

        //
        Response response = client.target("https://api.openrouteservice.org/v2/directions/foot-walking/geojson")
                .request()
                .header("Authorization", openStreetServiceConfig.getApi_key())
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .header("Content-Type", "application/json; charset=utf-8")
                .post(payload);

        JsonReader jsonReader = Json.createReader(new StringReader(response.readEntity(String.class)));
        JsonObject responseBody = jsonReader.readObject();

        // Map<String, List<String>> map = response.readEntity(new
        // GenericType<Map<String, List<String>>>() { });
        // List<String> values = map.get("features");

        return responseBody;
    }

    public JsonObject queryShortestPathWithElevation(RequestData reqData) {
        JsonArray coordinates = Converters.startEndToJsonArray(reqData.getStart(), reqData.getEnd());
        JsonObject requestBody = Json.createObjectBuilder()
                                    .add("coordinates", coordinates)
                                    .add("alternative_routes", Json.createObjectBuilder().add("target_count", 3).add("weight_factor", reqData.getWeight()).build())
                                    .add("elevation", true).build();



        Client client = ClientBuilder.newClient();

        Entity<String> payload = Entity.json(requestBody.toString());

        //
        Response response = client.target("https://api.openrouteservice.org/v2/directions/driving-car/geojson")
                .request()
                .header("Authorization", openStreetServiceConfig.getApi_key())
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .header("Content-Type", "application/json; charset=utf-8")
                .post(payload);
                
        JsonReader jsonReader = Json.createReader(new StringReader(response.readEntity(String.class)));
        JsonObject responseBody = jsonReader.readObject();

        // Map<String, List<String>> map = response.readEntity(new
        // GenericType<Map<String, List<String>>>() { });
        // List<String> values = map.get("features");

        return responseBody;
    }
}