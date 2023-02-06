package com.misc;

import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {

        try (Scanner scn = new Scanner(System.in)) {
            System.out.print("Please enter first no: ");
            int no1 = scn.nextInt();
            System.out.print("Please enter Second no: ");
            int no2 = scn.nextInt();
            int result = no1 / no2;
            System.out.println("Result is: " + result);
        } catch (ArithmeticException e1) {
            System.out.println("No. can't be divided by 0");
        } catch (Exception e2) {
            System.out.println("Please enter positive non-decimal numbers");
        }
    }
}
