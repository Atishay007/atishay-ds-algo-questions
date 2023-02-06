package com.algorithms;

public class BoyerMooreMajorityElement1 {
    /**
     * Solving using: Boyre-Moore Voting Algo.
     * It includes 2 steps
     * 1. Find the no. that is valid according to Algo.
     * 2. Recheck whether that no. is >n/2
     * Here,We don't have to perform 2nd step as it says that majority
     * element will always exists.
     * TC: O(n)
     * SC:O(1)
     *
     * This has another part
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(findMajorityElement(nums));
    }

    public static int findMajorityElement(int[] nums) {
        int count = 1;
        int no = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != no) {
                count--;
                if (count <= 0) {
                    count = 1;
                    no = nums[i];
                }
            } else {
                count++;
            }
        }
        return no;
    }
}
