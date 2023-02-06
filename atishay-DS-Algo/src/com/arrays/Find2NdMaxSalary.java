package com.arrays;

public class Find2NdMaxSalary {
    public static void main(String[] args) {
        //int[] salaries = {1000, 500, 200, 800};
        //int[] salaries = {1000, 2000, 3000, 500};
        int[] salaries = {1000, 500, 200, 800, 2000};

        int firstMaxSalary = salaries[0];
        int secondMaxSalary = Integer.MIN_VALUE;

        //We have to handle 2 cases
        for (int i = 1; i < salaries.length; i++) {
            if (firstMaxSalary < salaries[i]) {
                secondMaxSalary = firstMaxSalary;
                firstMaxSalary = salaries[i];
            } else if (secondMaxSalary < salaries[i]) {
                secondMaxSalary = salaries[i];
            }
        }

        System.out.println("Second Max Salary: " + secondMaxSalary);
    }
}
