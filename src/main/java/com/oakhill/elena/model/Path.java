package com.oakhill.elena.model;

import java.util.List;

/**
 * Stores path data returned from API
 */
public class Path {
    private List<double[]> route;

    public List<double[]> getRoutes() {
        return this.route;
    }

    public void setRoutes(List<double[]> routes) {
        this.route = routes;
    }

    public Path(List<double[]> routes) {
        this.route = routes;
    }

}
