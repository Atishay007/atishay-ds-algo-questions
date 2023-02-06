package com.arrays;

public class BalancedArray {
    public static void main(String[] args) {
        // int[] arr = {2, 1, 6, 4};
        int[] arr = {1, 1, 1};
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        int count = 0;

        int leftEvenSum = 0;
        int leftOddSum = 0;
        int rightEvenSum = 0;
        int rightOddSum = 0;

        //Populating Right odd and even sum.
        for (int i = 0; i < arr.length; i++) {
            if ((i & 1) == 0) { //even index
                rightEvenSum = rightEvenSum + arr[i];
            } else {
                rightOddSum = rightOddSum + arr[i];
            }
        }

        //Counting Special elements.
        for (int i = 0; i < arr.length; i++) {
            //Edge Case for last index where all Right Even/Odd sum should be 0
            if (i == arr.length - 1) {
                rightEvenSum = 0;
                rightOddSum = 0;
            }

            int tmpRightEvenSum = rightEvenSum;
            int tmpRightOddSum = rightOddSum;


            //Edge case when i==0 then both leftEvenSum and leftOddSum should be 0
            if (i != 0) {
                if (((i - 1) & 1) == 0) { //even index
                    leftEvenSum = leftEvenSum + arr[i - 1];
                } else {
                    leftOddSum = leftOddSum + arr[i - 1];
                }
            }

            if (i != arr.length - 1) {
                if ((i & 1) == 0) { //even index
                    tmpRightEvenSum = tmpRightEvenSum - (arr[i] + leftEvenSum);
                } else {
                    tmpRightEvenSum = tmpRightEvenSum - leftEvenSum;
                }

                if ((i & 1) == 1) { //odd index
                    tmpRightOddSum = tmpRightOddSum - (arr[i] + leftOddSum);
                } else {
                    tmpRightOddSum = tmpRightOddSum - leftOddSum;
                }
            }

            //Swap part: Odd index value becomes even index value and vice versa
            int temp = tmpRightEvenSum;
            tmpRightEvenSum = tmpRightOddSum;
            tmpRightOddSum = temp;

            if ((leftEvenSum + tmpRightEvenSum) == (leftOddSum + tmpRightOddSum)) {
                count++;
            }
        }
        return count;
    }
}
