package com.arrays.matrix;

import java.util.Arrays;

/**
 * This q. involves 7 Steps: Leetcode says it is medium, but putting all checks
 * and edge cases,it is hard.
 * https://leetcode.com/problems/set-matrix-zeroes/
 * TC:O(n*m): As we are iterating on all elements
 * SC:O(1)
 */
public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroesInMatrix(matrix);
        System.out.println();
        matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroesInMatrix(matrix);
        System.out.println();
        matrix = new int[][]{{1}, {0}};
        setZeroesInMatrix(matrix);
        System.out.println();
        matrix = new int[][]{{1, 0, 3}};
        setZeroesInMatrix(matrix);
        System.out.println();
        matrix = new int[][]{{1}};
        setZeroesInMatrix(matrix);
        System.out.println();
        matrix = new int[][]{{1}, {0}, {3}};
        setZeroesInMatrix(matrix);
        System.out.println();
        matrix = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        setZeroesInMatrix(matrix);
        System.out.println();

        matrix = new int[][]{{0, 0, 0, 5}, {4, 3, 1, 4}, {0, 1, 1, 4}, {1, 2, 1, 3}, {0, 0, 1, 1}};
        setZeroesInMatrix(matrix);
        System.out.println();
    }

    private static void setZeroesInMatrix(int[][] matrix) {
        boolean markerRowHasO = false;
        boolean markerColHasO = false;
    /*
    Step 1
    Find if the marker col has natural 0,
    so that we can mark them 0 after all operation.
    TC:O(n)
     */
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                markerColHasO = true;
                /*
                If there is single row but multiple cols in matrix and we are getting 0 in col
                then we will mark whole row with 0
                This is edge case.
                 */
                if (matrix.length == 1) {
                    markerRowHasO = true;
                }
                break;
            }
        }

        /*
        Step 2
        Find if the marker row has natural 0,
        so that we can mark them 0 after all operation.
        TC:O(n)
         */
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                markerRowHasO = true;
                /*
                If there is col but multiple rows in matrix and we are getting 0 in row
                then we will mark all col with 0.
                This is edge case.
                 */
                if (matrix[0].length == 1) {
                    markerColHasO = true;
                }
                break;
            }
        }

        /*
           Step 3
         * Setting 0 to marker row and col leaving markers
            TC:O(n*m)
         */
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    //setting marker col to 0
                    matrix[0][j] = 0;
                    //setting marker row to 0
                    matrix[i][0] = 0;
                }
            }
        }

        /*
           Step 4
        Setting all col=0 if col marker has 0 value in first row acting as marker.
        Going vertically
         */
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        /*
        Step 5
        Setting all row=0 if row marker has 0 value in first row acting as marker.
        Going Horizontally
         */
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        //Step 6: Setting whole row=0 if markerColHasO is true;
        if (markerColHasO) {
            matrix[0] = new int[matrix[0].length];
        }

        //Step 7: Setting all rows=0 if markerRowHasO true;
        if (markerRowHasO) {
            int col = 0;
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }
}
