package com.techelevator.model;

public class Ingredient {
    private int ingredientId;
    private String name;
    private String type;
    private double quantity;
    private double unit;

    public Ingredient(){};

    public Ingredient(int ingredientId, String name, String type, double quantity, double unit) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.unit = unit;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
