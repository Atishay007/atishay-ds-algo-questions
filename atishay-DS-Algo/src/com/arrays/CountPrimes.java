package com.arrays;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 499979;
        System.out.println(countPrimes(n));
    }

    public static int countPrimes(int n) {
        //TC: O(LogLogN)
        //SC: O(n)
        boolean[] primes = new boolean[n];

        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        //i*i to Protect from ArraysIndexOutOfBoundException and also
        //All elements before 5 has marked non-prime so 5 series should start working from
        //5*5 index.
        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int k = i * i; k < primes.length; k = k + i) {
                    primes[k] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }

        return count;
    }
}