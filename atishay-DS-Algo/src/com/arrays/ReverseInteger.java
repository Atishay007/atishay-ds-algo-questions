package com.arrays;

public class ReverseInteger {
    public static void main(String[] args) {
        int no = -2147483648;
        System.out.println(reverse(no));
    }

    public static int reverse(int no) {
        //Edge case if Integer overflows then return 0
        if (no >= Integer.MAX_VALUE || no <= Integer.MIN_VALUE) {
            return 0;
        }

        int tempNo = Math.abs(no);
        int reverseNo = 0;

        String str = String.valueOf(tempNo);
        int length = str.length();

        while (length > 1) {
            int temp = tempNo % 10;
            reverseNo = reverseNo * 10 + temp;
            tempNo = tempNo / 10;
            length--;
        }

        if (reverseNo > (Integer.MAX_VALUE / 10)) {
            return 0;
        } else if (reverseNo == (Integer.MAX_VALUE / 10)) {
            //If no is negative.
            if (no < 0) {
                if (tempNo > Math.abs(Integer.MIN_VALUE % 10)) {
                    return 0;
                }
            } else if (tempNo > (Integer.MAX_VALUE % 10)) {
                return 0;
            }
        }
        //Last Case as we are stopping above loop 1 less iteration before.
        reverseNo = reverseNo * 10 + tempNo;

        if (no < 0) {
            return -reverseNo;
        }

        return reverseNo;
    }
}
