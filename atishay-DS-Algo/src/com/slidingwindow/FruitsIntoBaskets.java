package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//TC:O(n)
//SC:O(n)
//URL: https://leetcode.com/problems/fruit-into-baskets/description/
//Calculate the count of fruits, even 1 bucket is fill.
public class FruitsIntoBaskets {
    public static void main(String[] args) {
        //int[] fruits = {1, 2, 1};
        //int[] fruits = {0, 1, 2, 2};
        //int[] fruits = {1, 2, 3, 2, 2};
        //int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int[] fruits = {1, 1};

        System.out.println(findLengthOfLongestSubstring(fruits));
    }

    private static int findLengthOfLongestSubstring(int[] fruits) {
        //In Question it is hard coded that we have to pick only 2 types of fruits.
        int k = 2;
        int count = -1;
        int startIndex = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < fruits.length; i++) {
            //Inserting all elements in beginning
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            if (map.keySet().size() > k) {
                count = Math.max(count, countFruits(map, fruits[i]));

                //Slide the window
                while (map.keySet().size() > k) {
                    int val = map.get(fruits[startIndex]);
                    val--;

                    if (val == 0) {
                        map.remove(fruits[startIndex]);
                    } else {
                        map.put(fruits[startIndex], val);
                    }
                    startIndex++;
                }
            }
        }


        //Last case
        if (map.keySet().size()>0) {
            count = Math.max(count, countFruits(map, -1));
        }

        return count;
    }

    private static int countFruits(Map<Integer, Integer> map, int newFruit) {
        int totalFruits = 0;
        for (int key : map.keySet()) {
            if (key != newFruit) {
                totalFruits = totalFruits + map.get(key);
            }
        }
        return totalFruits;
    }
}
