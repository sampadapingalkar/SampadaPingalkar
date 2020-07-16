
package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BeverageApplication {

    public static List<MenuItem> menu = new ArrayList<>();
    public static HashMap<String, Double> price_card = new HashMap<>();

    static {
        String[] coffee_Ingredients = {
            "coffee", "sugar", "milk", "water"
        };
        String[] chai_Ingredients = {
            "tea", "sugar", "milk", "water"
        };
        String[] banana_Smoothie_Ingredients = {
            "banana", "sugar", "milk", "water"
        };
        String[] strawberry_Shake_Ingredients = {
            "strawberry", "sugar", "milk", "water"
        };
        String[] mojito_Ingredients = {
            "lemon", "sugar", "water", "soda", "mint"
        };

        MenuItem Coffee = new MenuItem("Coffee", coffee_Ingredients, 5.0);
        MenuItem Chai = new MenuItem("Chai", chai_Ingredients, 4.0);
        MenuItem Banana_Smoothie = new MenuItem("Banana_Smoothie", banana_Smoothie_Ingredients, 6.0);
        MenuItem Strawberry_Shake = new MenuItem("Strawberry_Shake", strawberry_Shake_Ingredients, 7.0);
        MenuItem Mojito = new MenuItem("Mojito", mojito_Ingredients, 7.5);

        menu.add(Coffee);
        menu.add(Chai);
        menu.add(Banana_Smoothie);
        menu.add(Strawberry_Shake);
        menu.add(Mojito);

        price_card.put("-sugar", 0.5);
        price_card.put("-milk", 1.0);
        price_card.put("-water", 0.5);
        price_card.put("-soda", 0.5);
        price_card.put("-mint", 0.5);
        price_card.put("Coffee", 5.0);
        price_card.put("Chai", 4.0);
        price_card.put("Banana_Smoothie", 6.0);
        price_card.put("Strawberry_Shake", 7.0);
        price_card.put("Mojito", 7.5);

    }

    public double costCalculate(String[] order) throws Exception {

        double cost = 0.0;
        double costremoved = 0.0;

        if (order.length == 0) {
            throw new Exception("Order must contain atleast one item.");
        }

        for (String item : order) {
            String[] items_ingredients = item.split(",");
            String mainItem = items_ingredients[0];

            if (checkforvalidorder(mainItem, items_ingredients.length)) {
                throw new Exception("You can not remove all the ingredients from an item.");
            }

            cost += price_card.get(mainItem);

            if (items_ingredients.length == 1) {
                costremoved += 0.0;
            } else {
                for (int i = 1; i < items_ingredients.length; i++) {
                    costremoved += price_card.get(items_ingredients[i]);
                }

            }

        }
        return cost - costremoved;
    }

    public boolean checkforvalidorder(String item, int ingredients) {
        for (MenuItem m : menu) {

            if (m.getName().equals(item) && ingredients == m.getIngredients().length)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String[] order = {
            "Chai,-sugar", "Chai", "Coffee,-milk"
        };

        String[] emptyorder = {};

        String[] wrongorder = {
            "Chai,-sugar,-milk,-water", "Chai", "Coffee,-milk"
        };

        BeverageApplication app = new BeverageApplication();
        try {
            System.out.println(app.costCalculate(order) + "$");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}