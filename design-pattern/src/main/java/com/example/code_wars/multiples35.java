package com.example.code_wars;

import java.util.stream.IntStream;

public class multiples35 {

    public static void main(String[] args) {

        System.out.println(solution2(10));
    }

    // O(1)
    public static int solution(int number) {

        if (number <= 0) {
            return 0;
        }
        number--;

        int sumMultiples = sumOfMutiples(3, number) + sumOfMutiples(5, number) - sumOfMutiples(15, number);

        return sumMultiples;
    }

    public static int sumOfMutiples(int n, int limit) {

        int k = limit / n;
        return n * k * (k + 1) / 2;
    }

    // O(n)
    public static int solution2(int number) {
        return IntStream.range(3, number).filter(n -> n % 3 == 0 || n % 5 == 0).sum();
    }

}

// If we list all the natural numbers below 10 that are multiples of 3 or 5, we
// get 3, 5, 6 and 9. The sum of these multiples is 23.

// Finish the solution so that it returns the sum of all the multiples of 3 or 5
// below the number passed in.

// Note: If the number is a multiple of both 3 and 5, only count it once.