package com.arrays;

import java.util.Arrays;

public class FistAndLastPositionInSortedArray {
    public static void main(String[] args) {
        // int nums[] = {5, 7, 7, 8, 8, 10};
        //  int target = 8;

        // int nums[] = {5, 7, 7, 8, 8, 10};
        //int target = 6;
        int[] nums = {1};
        int target = 1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] resultArr = {-1, -1};

        if (nums == null || nums.length == 0) {
            return resultArr;
        }

        int lastIndex = searchIndex(nums, 0, nums.length - 1, target, -1, -1);

        if (lastIndex == -1) {
            return resultArr;
        }

        int firstIndex = searchIndex(nums, 0, lastIndex, target, -1, lastIndex);

        resultArr[0] = firstIndex;
        resultArr[1] = lastIndex;

        return resultArr;
    }

    private static int searchIndex(int[] nums, int startIndex, int endIndex, int target, int firstIndex, int lastIndex) {

        while (startIndex <= endIndex) {

            int mid = (startIndex + endIndex) / 2;

            if (nums[mid] == target) {

                if (lastIndex == -1) {
                    if (mid == nums.length - 1) {
                        return mid;
                    } else if (mid < nums.length - 1 && nums[mid + 1] != target) {
                        return mid;
                    }

                    startIndex = mid + 1;
                } else {
                    if (mid == 0) {
                        return mid;
                    } else if (mid > 0 && nums[mid - 1] != target) {
                        return mid;
                    }

                    endIndex = mid - 1;
                }
            } else if (nums[mid] > target) {
                endIndex = mid - 1;
            } else if (nums[mid] < target) {
                startIndex = mid + 1;
            }
        }

        return -1;
    }
}
