package com.example.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WordStream {
    public static void main(String[] args) {

        // 1️⃣ 過濾以 "b" 開頭的單詞
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        words.stream()
                .filter(word -> word.startsWith("b"))
                .forEach(System.out::print); // banana
        System.out.println();

        // 2️⃣ 使用 chars() 遍歷字串中的字元（IntStream）
        String text = "hello";
        text.chars()
                .forEach(ch -> System.out.print((char) ch)); // hello
        System.out.println();

        // 3️⃣ 轉換成 Stream<Character>
        Stream<Character> charStream = text.chars()
                .mapToObj(c -> (char) c);
        charStream.forEach(System.out::print); // hello
        System.out.println();
    }
}