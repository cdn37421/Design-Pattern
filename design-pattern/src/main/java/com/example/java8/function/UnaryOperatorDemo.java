package com.example.java8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        // UnaryOperator<T> 更適合表示「相同類型的轉換」，語意清楚。
        Function<Integer, Integer> function = x -> x * x; // Function<T, R>
        UnaryOperator<Integer> unaryOperator = x -> x * x; // UnaryOperator<T>

        System.out.println(function.apply(6)); // 36
        System.out.println(unaryOperator.apply(6)); // 36

        java8();
        java9();
    }

    public static void replaceAll() {

        List<String> names = new ArrayList<>(List.of("java", "spring", "backend"));

        // names.replaceAll(x -> x.toUpperCase());
        names.replaceAll(String::toUpperCase);
        System.out.println(names);
    }

    // 限制20個數字
    public static void java8() {
        Stream.iterate(1, n -> n + 3).limit(20).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    // 範圍到20
    public static void java9() {
        Stream.iterate(1, n -> n < 20, n -> n + 3).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
