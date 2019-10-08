package com.example.calculator;

public class ShipItem {
    private final double BASE_WEIGHT = 16;
    private final double EXTRA_OUNCES = 4;
    private final double ADDED = 0.5;
    private final double BASE_COST = 3.00;
    private final double OVER_COST = 4.00;
    private final double ADDITIONAL_WEIGHT = 30;
    private double weight = 0;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getAddedCost() {
        if(weight > BASE_WEIGHT) {

            double average = weight - BASE_WEIGHT;
            return Math.ceil(average / EXTRA_OUNCES) * ADDED;
        }
        else{
            return 0.0;
        }
    }
    public double getBaseCost() {
        if(weight > 0 && weight < ADDITIONAL_WEIGHT ){
            return BASE_COST;
        }
        else if(weight >= ADDITIONAL_WEIGHT) {
            return OVER_COST;

        }
        else{
            return 0.0;
        }
    }
    public double getTotalCost() {
        return getAddedCost() + getBaseCost();
    }
}
