package com.techelevator.model;

public class Ingredient {
    private int ingredientId;
    private String name;
    private String type;

    public Ingredient(){};

    public Ingredient(int ingredientId, String name, String type) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.type = type;
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

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
