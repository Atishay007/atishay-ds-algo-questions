package com.arrays;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {

        int mid = 0;

        int index = binarySearch(nums, 0, nums.length - 1, target);

        if (index != -1) {
            return index;
        }

        //BinarySearch for finding start of the array element.
        mid = binarySearchForStartArrayElement(nums, 0, nums.length - 1);

        if (mid == -1) {
            return -1;
        }

        //BinarySearch for left
        index = binarySearch(nums, 0, mid - 1, target);

        if (index != -1) {
            return index;
        }

        //BinarySearch for right
        return binarySearch(nums, mid, nums.length - 1, target);
    }

    //We have to find the smallest no. that is present in the right part of array.
    private static int binarySearchForStartArrayElement(int[] nums, int startIndex, int endIndex) {

        while (startIndex <= endIndex) {

            int mid = startIndex + ((endIndex - startIndex) / 2);

            //Left Part of the array
            if (nums[mid] >= nums[0]) {
                startIndex = mid + 1;
            }
            //Right part of the array
            else if (nums[mid] < nums[0] && nums[mid - 1] < nums[mid]) {
                endIndex = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] nums, int startIndex, int endIndex, int target) {

        while (startIndex <= endIndex) {

            int mid = startIndex + ((endIndex - startIndex) / 2);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }

        return -1;
    }
}
