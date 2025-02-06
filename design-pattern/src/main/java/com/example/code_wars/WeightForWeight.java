package com.example.code_wars;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WeightForWeight {
    public static void main(String[] args) {
        String result = orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123");
        System.out.println(result); // 2000 103 123 4444 99

    }

    public static String orderWeight(String str) {
        String[] strArr = str.split(" ");

        Arrays.sort(strArr, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                int weight1 = getWeight(o1);
                int weight2 = getWeight(o2);

                if (weight1 != weight2) {
                    return Integer.compare(weight1, weight2);
                }

                return o1.compareTo(o2);

            }

        });
        StringBuilder sb = new StringBuilder();

        String result = Arrays.stream(strArr).collect(Collectors.joining(" "));

        return result;
    }

    public static int getWeight(String str) {
        char[] charArr = str.toCharArray();
        int sum = 0;
        for (char c : charArr) {
            int n = Integer.valueOf(String.valueOf(c));
            sum += n;
        }
        return sum;
    }
    /*
     * My friend John and I are members of the "Fat to Fit Club (FFC)". John is
     * worried because each month a list with the weights of members is published
     * and each month he is the last on the list which means he is the heaviest.
     * 
     * I am the one who establishes the list so I told him:
     * "Don't worry any more, I will modify the order of the list". It was decided
     * to attribute a "weight" to numbers. The weight of a number will be from now
     * on the sum of its digits.
     * 
     * For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list
     * 100 will come before 99.
     * 
     * Given a string with the weights of FFC members in normal order can you give
     * this string ordered by "weights" of these numbers?
     */

    /*
     * "56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:
     * 
     * "100 180 90 56 65 74 68 86 99"
     */
}
