package com.example.java8.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.hibernate.metamodel.mapping.ForeignKeyDescriptor.Side;

// IntStream 是 Java 8 引入的 數值型 Stream，專門處理 int 型別的序列，提供 高效的數值運算 和 流式操作，避免了
// Stream<Integer> 產生的 裝箱/拆箱 (boxing/unboxing) 開銷。
public class IntStreamDemo {
    public static void main(String[] args) {
        range();
        of();
        iterate();
    }

    // ---🔹 1. 建立 IntStream ---
    // (1) range(start, end) & rangeClosed(start, end)
    public static void range() {
        // 1234
        IntStream.range(1, 5).forEach(System.out::print);
        System.out.println();
        // 12345
        IntStream.rangeClosed(1, 5).forEach(System.out::print);
        System.out.println();
    }

    // (2) of(...) 直接建立
    public static void of() {
        IntStream.of(10, 20, 30).forEach(System.out::print);
        System.out.println();
    }

    // (3) iterate() 產生遞增序列
    public static void iterate() {
        IntStream.iterate(1, n -> n + 2).limit(5).forEach(System.out::print);
    }

    // ---🔹 2. 基本數值運算 ---
    // (1) 計算總和
    // 使用 for loop 計算總和
    public static int sumUsingForLoop() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    // 使用 Stream.iterate 計算總和
    public static int sumUsingStreamIterate() {
        return Stream.iterate(1, n -> n + 1)
                .limit(100)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 使用 IntStream.rangeClosed 計算總和
    public static int sumUsingIntStream() {
        return IntStream.rangeClosed(1, 100).sum();
    }
}

// ✅ 適合用 IntStream 的情境
// 數值處理（如求和、篩選、轉換）
// 函數式寫法，提高可讀性
// 平行處理 (parallel())

// ❌ 不適合用 IntStream 的情境
// 有副作用（Side Effects）→
// 需要修改外部變數 需要 break/return（ IntStream 不能中途停止）
// 過於複雜的控制流程（如巢狀迴圈 ）
