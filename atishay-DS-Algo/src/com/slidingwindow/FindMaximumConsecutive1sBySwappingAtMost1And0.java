package com.slidingwindow;

/**
 * This question is similar to
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 * <p>
 * TC:O(n)
 * SC:O(n)
 * <p>
 * Here, we have created window size =1 as atmost 1 swap is allowed
 * So we have assumed that at least 1 swap will be possible.
 */
public class FindMaximumConsecutive1sBySwappingAtMost1And0 {
    public static void main(String[] args) {
        String s1 = "111000"; //output=3
        //String s1 = "111011101"; //output: 7
        int k = 2;
        System.out.println(findConsecutiveOne(s1, k));
    }

    private static int findConsecutiveOne(String s1, int k) {
        int total1s = counts1(s1);

        int startIndex = 0;
        //We have created window size ==1 as only at most 1 swap is allowed.
        int windowSize = 1;
        int globalCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (Character.getNumericValue(s1.charAt(i)) == 0) {
                windowSize--;
            }

            while (windowSize < 0) {
                if (Character.getNumericValue(s1.charAt(startIndex)) == 0) {
                    windowSize++;
                }
                startIndex++;
            }
            //Length of subarray: (endIndex-startIndex)+1
            globalCount = Math.max(globalCount, (i - startIndex) + 1);
        }

        return Math.min(globalCount, total1s);
    }

    private static int counts1(String s1) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (Character.getNumericValue(s1.charAt(i)) == 1) {
                count++;
            }
        }
        return count;
    }
}
