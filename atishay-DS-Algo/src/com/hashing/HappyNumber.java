package com.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/description/
 * TC:O(n)
 * SC:O(n)
 * <p>
 * We have to use Hashset.
 * What is Happy Number?
 * When the sum of Squared digits of a number == 1 then it is Happy
 * otherwise it is not.
 * <p>
 * Trick: If no. is not Happy then the sum of Squared digits of a number will be
 * repeated in future calculation giving an idea of loop,
 * so we have to use Hashset to check if the result was already calculated or not.
 */
public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));

        n = 2;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sumOfSquaredDigits = 0;

        while (n != 1) {
            sumOfSquaredDigits = 0;
            while (n > 0) {
                sumOfSquaredDigits = sumOfSquaredDigits + (int) Math.pow(n % 10, 2);
                n = n / 10;
            }

            if (set.contains(sumOfSquaredDigits)) {
                return false;
            } else {
                set.add(sumOfSquaredDigits);
            }

            n = sumOfSquaredDigits;
        }
        return true;
    }
}
