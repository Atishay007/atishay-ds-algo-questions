package com.twopointer;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 * 2 pointer
 * TC:O(N)
 * SC:O(1)
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));

        height = new int[]{1, 1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            //Rectangle area formula: l*b
            maxArea = Math.max(maxArea, minHeight * (j - i));

            //Shift pointers
            if (height[i] < height[j]) {
                i++;
            } else if (height[j] < height[i]) {
                j--;
            } else {
                if (height[i + 1] > height[j - 1]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return maxArea;
    }
}
