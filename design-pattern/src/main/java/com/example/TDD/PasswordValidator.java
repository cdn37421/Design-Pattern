package com.example.TDD;

public class PasswordValidator {

    public static void main(String[] args) {
    }

    // 2️⃣ 實作最小功能（綠 Green）
    // 我們只寫足夠的代碼來讓測試通過：
    public static boolean isValidPassword(String password) {

        if (password == null) {
            throw new InvalidPasswordException("密碼不可為空");
        }

        if (password.length() < 8 || password.length() > 20) {
            throw new InvalidPasswordException("密碼長度必須在8到20個字符之間");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException("密碼必須包含至少一個小寫字母");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("密碼必須包含至少一個大寫字母");
        }

        if (!password.matches(".*[!@#$%^&*()].*")) {
            throw new InvalidPasswordException("密碼必須包含至少一個特殊字符");
        }

        return true;
    }

}