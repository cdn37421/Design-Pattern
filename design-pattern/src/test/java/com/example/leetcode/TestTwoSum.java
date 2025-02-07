package com.example.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class TestTwoSum {

    @Test
    public void testTwoSum() {
        TwoSum twoSum = new TwoSum();

        // 測試用例1 :正常情況
        int[] nums1 = { 2, 7, 11, 15 };
        int target = 9;
        int[] expect1 = { 0, 1 };
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> expectSet = new HashSet<>();

        int[] result = twoSum.twoSum(nums1, target);
        if (result != null) {
            for (int i : result) {
                resultSet.add(i);
            }
        }

        for (int i : expect1) {
            expectSet.add(i);
        }

        assertEquals(expectSet, resultSet); // 無視順序比較

        // 測試用例2: 無解情況
        int[] nums2 = { 1, 2, 3 };
        int target2 = 7;
        int[] expected3 = null;
        assertNull(twoSum.twoSum(nums2, target2)); // 應該返回 null
    }
}
