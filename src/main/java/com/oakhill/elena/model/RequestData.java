package com.oakhill.elena.model;

/**
 * Store arguments from frontend
 */
public class RequestData {
    double[] start;
    double[] end;
    double weight;
    boolean isMin;
    
    public boolean isIsMin() {
        return this.isMin;
    }

    public boolean getIsMin() {
        return this.isMin;
    }

    public void setIsMin(boolean isMin) {
        this.isMin = isMin;
    }

    public double[] getStart() {
        return this.start;
    }

    public void setStart(double[] start) {
        this.start = start;
    }

    public double[] getEnd() {
        return this.end;
    }

    public void setEnd(double[] end) {
        this.end = end;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
