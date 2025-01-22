package com.example.data_exchange;

import java.io.BufferedWriter;
import java.io.FileWriter;

//其他程式利用 output.txt去讀取
public class FileShareDemo {
    public static void main(String[] args) {
        String result = "Hello from Java";
        String filePath = "output.txt";

        String property = System.getProperty("user.dir");

        System.out.println(property);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(result);
            System.out.println("結果已寫入檔案" + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
