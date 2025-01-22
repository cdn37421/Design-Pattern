package com.example.data_exchange;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseDemo {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/scm_web"; // 修改為正確的資料庫名稱
        String username = "root"; // 修改為你的 MySQL 帳號
        String password = "1234"; // 修改為你的 MySQL 密碼
        String name = "Admin"; // 要插入的角色名稱

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username,
                password)) {
            // 正確的 INSERT 語句
            String insertQuery = "INSERT INTO ROLES (NAME, LEVEL) VALUES (?, 1)";

            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setString(1, name); // 將 `name` 綁定到第一個問號
                statement.executeUpdate(); // 執行插入操作
                System.out.println("結果已存入資料庫");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 打印錯誤詳情
        }
    }
}
