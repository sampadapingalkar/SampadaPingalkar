
package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BeverageApplicationTests {

    @Test
    public void testcostCalculate() {
        BeverageApplication apptest = new BeverageApplication();
        String[] order = {
            "Chai,-sugar", "Chai", "Coffee,-milk"
        };
        double result = 0.0;
        try {
            result = apptest.costCalculate(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(11.5, result);

    }

    @Test
    public void testCheckforvalidOrder_a() {
        BeverageApplication apptest = new BeverageApplication();

        String[] wrongorder = {
            "Chai,-sugar,-milk,-water", "Chai", "Coffee,-milk"
        };

        Throwable exception = assertThrows(
            Exception.class, () -> {
                apptest.costCalculate(wrongorder);
            });

        assertEquals("You can not remove all the ingredients from an item.", exception.getMessage());
    }

    @Test
    public void testCheckforvalidOrder_b() {
        BeverageApplication apptest = new BeverageApplication();
        String[] emptyorder = {};

        Throwable exception = assertThrows(
            Exception.class, () -> {
                apptest.costCalculate(emptyorder);
            });

        assertEquals("Order must contain atleast one item.", exception.getMessage());
    }

}
