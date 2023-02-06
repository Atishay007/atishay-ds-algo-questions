package com.arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> results = threeSum(nums);
        for (List<Integer> lst : results) {
            System.out.print(lst.get(0) + " " + lst.get(1) + " " + lst.get(2));
            System.out.println();
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        //Sorting: O(nlogn)
        Arrays.sort(nums);

        Set<String> set = new HashSet<>();

        List<List<Integer>> results = new ArrayList<>();
        int sum = 0;

        //As we know it is triplets so array should run till when
        //in end 2 elements are left.
        for (int i = 0; i < nums.length; i++) {
            //If nums[i] is > 0 then it means all elements after i are positive
            //their sum can't be 0;
            //Edge case
            if (nums[i] > 0) {
                break;
            }

            //If there is repeated consecutive no. then skip the flow.
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            sum = sum + nums[i];

            //Functionality of 2 sum
            int j = i + 1;
            int k = nums.length - 1;

            for (; j < k; ) {

                if (sum + nums[j] + nums[k] == 0) {
                    String tripletPair = String.valueOf(nums[i] + "" + nums[j] + "" + nums[k]);
                    if (set.contains(tripletPair)) {
                        j++;
                        continue;
                    }
                    List<Integer> lst = Arrays.asList(nums[i], nums[j], nums[k]);
                    results.add(lst);
                    set.add(tripletPair);

                    j++;
                    k--;
                } else if (sum + nums[j] + nums[k] > 0) {
                    k--;
                } else if (sum + nums[j] + nums[k] < 0) {
                    j++;
                }
            }

            sum = 0;
        }

        return results;
    }
}
