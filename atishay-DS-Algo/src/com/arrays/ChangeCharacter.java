package com.arrays;

import java.util.Arrays;

public class ChangeCharacter {
    public static void main(String[] args) {
        String str = "qghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxfxtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknlyjyhfixjswnkkufnuxxzrzbmnmgqooketlyhnkoaugzqrcddiuteiojwayyzpvscmpsajlfvgubfaaovlzylntrkdcpwsrtesjwhdizcobzcnfwlqijtvdwvxhrcbldvgylwgbusbmborxtlhcsmpxohgmgnkeufdxotogbgxpeyanfetcukepzshkljugggekjdqzjenpevqgxiepjsrdzjazujllchhbfqmkimwzobiwybxduunfsksrsrtekmq";
        int operAllowed = 119;
        int maxFreq = 0;

        int[] freqCountArr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            freqCountArr[(str.charAt(i) - 97)]++;
            maxFreq = Math.max(maxFreq, freqCountArr[str.charAt(i)-97]);
        }

        Arrays.sort(freqCountArr);

        for (int i = 0; i < freqCountArr.length; i++) {
            if (operAllowed >= freqCountArr[i] && maxFreq > freqCountArr[i]) {
                operAllowed = operAllowed - freqCountArr[i];
                freqCountArr[i] = 0;
            }
        }

        //Counting where freq is not 0.
        int distCharacter = 0;
        for (int i = 0; i < freqCountArr.length; i++) {
            if (freqCountArr[i] != 0) {
                distCharacter++;
            }
        }

        System.out.println(distCharacter);

    }
}
