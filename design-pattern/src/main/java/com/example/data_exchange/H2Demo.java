package com.example.data_exchange;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Demo {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:h2:mem:tesdb";
        String username = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username,
                password)) {

            // creates
            String createTable = "CREATE TABLE users (id INT PRIMARY KEY, NAME VARCHAR(255))";

            try (Statement statement = connection.createStatement()) {
                statement.execute(createTable);
                System.out.println("Table created.");
            }

            // insert
            String insertData = "INSERT INTO USERS(ID,NAME) VALUES(?,?)";

            try (PreparedStatement statement = connection.prepareStatement(insertData)) {
                statement.setInt(1, 1);
                statement.setString(2, "Alice");
                statement.executeUpdate();
                System.out.println("data already inserted");

            } catch (Exception e) {
                e.printStackTrace();
            }

            // query
            String queryData = "SELECT * FROM USERS";
            try (Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(queryData)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    System.out.println("ID: " + id + ", Name: " + name);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 打印錯誤詳情
        }
    }
}
