package com.example.josycom.reciperecyclerview;

public class RecipeData {
    private String name;
    private String description;

    public RecipeData(String name, String description){
        this.setName(name);
        this.setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}