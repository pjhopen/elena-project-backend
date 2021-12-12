package com.oakhill.elena.model;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<double[][]> routes;

    public Path(List<double[][]> routes) {
        this.routes = routes;
    }

    public Path(double[][] routes) {
        this.routes = new ArrayList<>();
        this.routes.add(routes);
    }

    public Path() {
        this.routes = new ArrayList<>();
    }

    public void addRoute(double[][] routes) {
        this.routes.add(routes);
    }

    public List<double[][]> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<double[][]> routes) {
        this.routes = routes;
    }

}
