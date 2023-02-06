package com.string;

import java.math.BigInteger;

/*
https://leetcode.com/problems/add-binary/
 */
public class AddBinaryStringsUsingBigInteger {
    public static void main(String[] args) {
        //Using BigInteger is very slow, use our traditional logic
        long startTime = System.nanoTime();
        String s1 = "1";
        String s2 = "1";
        BigInteger big1 = new BigInteger(s1, 2);
        BigInteger result = big1.add(new BigInteger(s2, 2));
        System.out.println(result.toString(2));
        System.out.println(System.nanoTime() - startTime);
    }
}
