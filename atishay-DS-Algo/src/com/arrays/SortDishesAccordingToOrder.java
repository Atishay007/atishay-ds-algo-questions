package com.arrays;

import java.util.Arrays;

public class SortDishesAccordingToOrder {
    public static void main(String[] args) {
        String[] dishes = {"KA", "SB", "CL"};
        int[] orders = {1, 3, 2};

        System.out.println("Original Order: " + Arrays.toString(dishes));

        for (int i = 0; i < dishes.length - 1; i++) {
            String temp = dishes[i];
            dishes[i] = dishes[orders[i] - 1];
            dishes[orders[i] - 1] = temp;
        }
        System.out.println("Custom Order: " + Arrays.toString(dishes));

    }
}
