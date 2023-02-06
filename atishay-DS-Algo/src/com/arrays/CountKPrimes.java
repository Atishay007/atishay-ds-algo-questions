package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountKPrimes {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(countPrimes(n));
    }


    public static List<Integer> countPrimes(int n) {
        List<Integer> lst = new ArrayList<>();
        int i = 2;
        for (; i <= Integer.MAX_VALUE; i++) {
            boolean isPrime = true;
            if (lst.size() == n) {
                break;
            }
            for (int k = 2; k * k <= i; k++) {
                if (i % k == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                lst.add(i);
            }
        }
        return lst;
    }
}
