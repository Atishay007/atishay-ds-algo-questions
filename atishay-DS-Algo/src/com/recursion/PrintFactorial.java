package com.recursion;

public class PrintFactorial {
    public static void main(String[] args) {
        System.out.println(calcFactorial(0));
    }

    private static int calcFactorial(int no) {
        //base case + negative condition
        if (no == 1 || no == 0) {
            return no;
        }
        return no * calcFactorial(no - 1);
    }
}
