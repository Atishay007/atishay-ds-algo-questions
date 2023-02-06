package com.arrays;

/*
We have to use 2 pointer logic here.
 */
public class ContainerWithMaxWater {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        //int[] arr = {1, 1};
        System.out.println(getMaxWaterArea(arr));
    }

    private static int getMaxWaterArea(int[] arr) {

        int j = arr.length - 1;
        int maxArea = 0;


        for (int i = 0; i < j; ) {

            int minHeight = Math.min(arr[i], arr[j]);
            int area = j - i;
            //Formula: minHeight*area
            maxArea = Math.max(maxArea, minHeight * area);

            //Logic of Shifting 2 pointers
            if (arr[i] < arr[j]) {
                i++;
            } else if (arr[i] > arr[j]) {
                j--;
            } else if (arr[i] == arr[j]) {
                if (arr[i + 1] >= arr[j - 1]) {
                    i++;
                } else if (arr[i + 1] <= arr[j - 1]) {
                    j--;
                }
            }
        }
        return maxArea;
    }
}
