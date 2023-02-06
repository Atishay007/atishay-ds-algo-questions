package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortArrayDescending {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 4};
        List<Integer> lst = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(lst, (a, b) -> b - a);
    }
}
