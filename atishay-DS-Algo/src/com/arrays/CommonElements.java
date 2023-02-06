package com.arrays;

import java.util.*;

public class CommonElements {
    public static void main(String[] args) {
        List<Integer> lst1 = Arrays.asList(1, 2, 2, 1);
        List<Integer> lst2 = Arrays.asList(2, 3, 1, 2);

        System.out.println(solve(lst1, lst2));
    }

    public static List<Integer> solve(List<Integer> lst1, List<Integer> lst2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> finalLst = new ArrayList<>();

        //Adding entries in map for List1.
        for (int i = 0; i < lst1.size(); i++) {
            map.put(lst1.get(i), map.getOrDefault(lst1.get(i), 0) + 1);
        }

        //Populating final list which are duplicates.
        for (int i = 0; i < lst2.size(); i++) {

            Integer val = map.get(lst2.get(i));

            if (val != null && val > 0) {

                finalLst.add(val);

                //decreasing count if duplicate found.
                map.put(val, map.getOrDefault(val, 0) - 1);
            }
        }
        return finalLst;
    }
}
