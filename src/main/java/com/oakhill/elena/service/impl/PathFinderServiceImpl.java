package com.oakhill.elena.service.impl;

import java.util.ArrayList;
import java.util.List;

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
        List<double[][]> routes = new ArrayList<>();
        for (int i = 0; i < features.size(); i++) {
            JsonObject f = features.getJsonObject(i);
            JsonObject geometry = f.getJsonObject("geometry");
            routes.add(Converters.geometryToPath(geometry));
        }
        return new Path(routes);
        
    }

    @Override
    public Path get3ElenaPath() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Path get3ElenaPathWithWeight() {
        // TODO Auto-generated method stub
        return null;
    }
}
