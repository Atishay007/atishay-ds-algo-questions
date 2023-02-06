package com.arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class MostBeautifulItemForEachQuery {
    public static void main(String[] args) {
        //  int[][] items = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        //int[] queries = {1, 2, 3, 4, 5, 6};

        int[][] items = {{193, 732}, {781, 962}, {864, 954}, {749, 627}, {136, 746}, {478, 548}, {640, 908}, {210, 799}, {567, 715}, {914, 388}, {487, 853}, {533, 554}, {247, 919}, {958, 150}, {193, 523}, {176, 656}, {395, 469}, {763, 821}, {542, 946}, {701, 676}};
        int[] queries = {885, 1445, 1580, 1309, 205, 1788, 1214, 1404, 572, 1170, 989, 265, 153, 151, 1479, 1180, 875, 276, 1584};
        System.out.println(Arrays.toString(maximumBeauty(items, queries)));
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {

        //1. Sorting array: O(nlogn)
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        //2. Create HashMap: O(1)
        Map<Integer, Integer> map = new LinkedHashMap<>();

        //Adding first element in HashMap
        map.put(items[0][0], items[0][1]);

        //3. Populate HashMap with some logic.: O(N)
        //Here we have to keep beauty in increasing order.
        int maxBeauty = items[0][1];
        for (int i = 1; i < items.length; i++) {

            //if price is same so overwrite with max Beauty
            if (maxBeauty < items[i][1]) {
                if (items[i][0] == items[i - 1][0] && items[i][1] > items[i - 1][1]) {
                    map.put(items[i][0], items[i][1]);
                }
                //if price is different, then we have to put price which has max beauty
                else if (items[i][0] != items[i - 1][0] && items[i][1] > items[i - 1][1]) {
                    map.put(items[i][0], items[i][1]);
                }

                maxBeauty = items[i][1];
            }
        }

        //Taking new array for the prices of map where we can run custom binarySearch.
        int[] prices = new int[map.keySet().size()];

        int index = 0;
        for (int key : map.keySet()) {
            prices[index] = key;
            index++;
        }

        //Creating result array
        int[] resultArr = new int[queries.length];

        //4. Now populate the result by running all queriesO(m) against HashMap
        //We have to use custom BinarySearch.
        //O(mlogn)
        for (int i = 0; i < queries.length; i++) {
            if (map.get(queries[i]) != null) {
                resultArr[i] = map.get(queries[i]);
            } else {
                int price = binarySearch(prices, 0, prices.length - 1, queries[i]);
                if (price == -1) {
                    resultArr[i] = 0;
                } else {
                    resultArr[i] = map.get(price);
                }
            }
        }

        return resultArr;
    }

    //O(nlogn): It runs on sorted arrays.
    private static int binarySearch(int[] prices, int startIndex, int endIndex, int target) {
        int maxPrice = -1;
        while (startIndex <= endIndex) {
            int mid = startIndex + ((endIndex - startIndex) / 2);

            if (prices[mid] <= target) {
                maxPrice = Math.max(maxPrice, prices[mid]);
                startIndex = mid + 1;
            } else if (prices[mid] > target) {
                endIndex = mid - 1;
            }
        }
        return maxPrice;
    }
}
