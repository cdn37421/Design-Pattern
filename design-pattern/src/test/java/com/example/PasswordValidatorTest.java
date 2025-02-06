package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.TDD.InvalidPasswordException;
import com.example.TDD.PasswordValidator;

public class PasswordValidatorTest {

    // 1️⃣ 先寫測試（紅 Red）
    // 我們先假設 PasswordValidator 這個類別還不存在，直接寫測試：

    // 2️⃣ 實作最小功能（綠 Green）
    // 我們只寫足夠的代碼來讓測試通過：

    // 3️⃣ 持續重構、優化代碼(Refactor)
    @Test
    void testShortPassword() {
        assertThrows(InvalidPasswordException.class, () -> {
            PasswordValidator.isValidPassword("Sh@123");
        }, "密碼長度不足，應拋出異常");
    }

    @Test
    void testNullPassword() {
        assertThrows(InvalidPasswordException.class, () -> {
            PasswordValidator.isValidPassword(null);
        }, "密碼為空應拋出異常");
    }

    @Test
    void testMissingUppercase() {
        assertThrows(InvalidPasswordException.class, () -> {
            PasswordValidator.isValidPassword("weak@123");
        }, "缺少大寫字母，應拋出異常");
    }

    @Test
    void testMissingLowercase() {
        assertThrows(InvalidPasswordException.class, () -> {
            PasswordValidator.isValidPassword("WEAK@123");
        }, "缺少小寫字母，應拋出異常");
    }

    @Test
    void testNoSpecialCharacter() {
        assertThrows(InvalidPasswordException.class, () -> {
            PasswordValidator.isValidPassword("Weak1234");
        }, "缺少特殊符號，應拋出異常");
    }
}
