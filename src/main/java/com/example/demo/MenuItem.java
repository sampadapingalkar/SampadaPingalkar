
package com.example.demo;

public class MenuItem {

    private String name;
    private double price;
    private String[] ingredients;

    public MenuItem(String name, String[] ingredients, double d) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = d;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

}
