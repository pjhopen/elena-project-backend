package com.oakhill.elena.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.json.JsonArray;
import javax.json.JsonObject;

import com.oakhill.elena.mapper.OpenRouteServiceMapper;
import com.oakhill.elena.model.Path;
import com.oakhill.elena.model.RequestData;
import com.oakhill.elena.service.intf.PathFinderService;
import com.oakhill.elena.util.Converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathFinderServiceImpl implements PathFinderService {

    @Autowired
    OpenRouteServiceMapper openRouteServiceMapper;

    public Path get2dShortestPathSerive(RequestData reqData) {
        JsonObject resBody = openRouteServiceMapper.queryShortestPath(reqData);
        JsonArray features = resBody.getJsonArray("features");
        List<double[]> routes = new ArrayList<>();
        for (int i = 0; i < features.size(); i++) {
            JsonObject f = features.getJsonObject(i);
            JsonObject geometry = f.getJsonObject("geometry");
            routes = Converters.geometryToPath(geometry);
        }
        return new Path(routes);
        
    }

    @Override
    public Path getElenaPathWithWeight(RequestData reqData) {
        JsonObject resBody = openRouteServiceMapper.queryShortestPathWithElevation(reqData);
        JsonArray features = resBody.getJsonArray("features");
        List<List<double[]>> routes = new ArrayList<>();
        // List<Double> elevationSum = new ArrayList<>();
        SortedMap<Double, Integer> elevationSum = new TreeMap<>();
        for (int i = 0; i < features.size(); i++) {
            JsonObject f = features.getJsonObject(i);
            JsonObject geometry = f.getJsonObject("geometry");
            List<double[]> r = Converters.geometryToPathWithElevation(geometry);
            routes.add(r);
            double curElevationSum = 0.0;
            double[] temp = r.get(0);
            for (int j = 1; j < r.size(); j++) {
                curElevationSum+=Math.abs(r.get(j)[2] - temp[2]);
                temp = r.get(j);
            }
            if (!elevationSum.containsKey(curElevationSum)) {
                elevationSum.put(curElevationSum, i);
            }
        }
        if (reqData.isIsMin()) {
            System.out.println(elevationSum.get(elevationSum.firstKey()));
            return new Path(routes.get(elevationSum.get(elevationSum.firstKey())));
        }
        else {
            System.out.println(elevationSum.toString());
            return new Path(routes.get(elevationSum.get(elevationSum.lastKey())));
        }
    }
}
