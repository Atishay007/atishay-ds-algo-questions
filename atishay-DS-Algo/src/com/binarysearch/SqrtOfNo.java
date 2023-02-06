package com.binarysearch;

public class SqrtOfNo {
    public static void main(String[] args) {
        int x = 16;
        if (x == 0) {
            System.out.println(0);
        }

        if (x == 1) {
            System.out.println(0);
        }
        System.out.println(binarySearch(1, x, x));
    }

    private static int binarySearch(int low, int high, int target) {
        int ans = 0;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (mid <= target / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
