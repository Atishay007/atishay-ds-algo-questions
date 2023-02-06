package com.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element-ii/description/
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * TC:O(n), SC:O(1)
 * We can do this by sorting but then:TC:O(nlogn) and SC:O(1)
 */
public class MajorityElement2 {
    public static void main(String[] args) {
        //int[] arr = {3, 2, 3};
        int[] arr = {1, 2};
        System.out.println(findMajorityElement(arr));
    }


    public static List<Integer> findMajorityElement(int[] nums) {
        int k = nums.length / 3;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > k) {
                result.add(key);
            }
        }
        return result;
    }
}
