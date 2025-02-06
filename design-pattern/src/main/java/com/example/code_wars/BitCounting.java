package com.example.code_wars;

public class BitCounting {

    public static void main(String[] args) {
        // System.out.println("binaryString : " + countBits(4));
        System.out.println("binaryString : " + countBits5(5));

    }

    // 01 1
    // 10 2
    // 11 3
    // 100 4
    // 101 5
    // 110 6
    // 111 7
    // 1000 8
    // 1001 9
    // 1010 10

    public static int countBits5(int n) {
        int ret = n % 2;
        while ((n /= 2) > 0) {
            ret += n % 2;
        }
        return ret;
    }

    public static int countBits4(int n) {

        return Integer.bitCount(n);
    }

    public static int countBits3(int n) {
        int count = 0;
        // n & (n - 1) 的作用
        // 這個運算用來 消除數字中最低位的 1，主要用於：

        // 判斷是否為 2 的次方（只有一個 1 的數字）。
        // 計算 1 的個數。
        // 清除最低位的 1 以進行高效計算。
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static int countBits2(int n) {
        String binaryString = Integer.toBinaryString(n);

        System.out.println("Binary Representation: " + binaryString);

        int count = 0;

        for (char c : binaryString.toCharArray()) {
            if (c == '1')
                count++;
        }

        return count;
    }

    // 自己寫的版本1
    public static int countBits(int n) {
        int t = 2;
        int len = 0;

        while ((int) Math.pow(2, len) <= n) {
            t = (int) Math.pow(2, len);
            // System.out.println(t);
            len++;
        }

        // System.out.println("len " + len);
        int sum = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (sum + Math.pow(2, i) <= n) {
                sum += Math.pow(2, i);
                sb.append("1");
                count++;
            } else {
                sb.append("0");
            }
        }

        System.out.println(sb.toString());

        return count;
    }
}
// Write a function that takes an integer as input, and returns the number of
// bits that are equal to one in the binary representation of that number. You
// can guarantee that input is non-negative.

// Example: The binary representation of 1234 is 10011010010, so the function
// should return 5 in this case