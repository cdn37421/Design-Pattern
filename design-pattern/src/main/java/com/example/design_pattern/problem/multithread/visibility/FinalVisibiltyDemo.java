package com.example.design_pattern.problem.multithread.visibility;

class Person {
    final String name; // 即便是 final也無法保證可見性

    Person(String name) {
        this.name = name;
    }

}

public class FinalVisibiltyDemo {

    private static Person person = new Person("Alice");

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            person = new Person("Bob"); // 變換參考
        });

        Thread readerThread = new Thread(() -> {
            while (!person.name.equals("Alice")) { // 讀取共享變數的值

            }
            System.out.println("Person's name is " + person.name);// 若還是印出Alice，則還是舊的結果
        });
        writerThread.start();

        readerThread.start();
    }
}

/*
 * person = new Person("Bob");
 * 
 * new Person("Bob")會分配內存，並創建一個新的Person物件，在Java中，這會在Heap上創建一個新的實例
 * 當person 重新賦值為 new Person("Bob"), person之前指向的Person("Alice")物件的參考會被丟失
 * 
 */

/*
 * 
 * private static Person person = new Person("Alice");
 * 
 * Person newPerson = person;
 * 
 * person = new Person("Bob")
 * 
 * 這樣Alice還會被丟失嗎
 * 
 * -------------------------------------------------------
 * 
 * private static Person person = new Person("Alice");
 * 
 * ->這行程式碼會在堆內存中創建一個 Person("Alice") 物件，
 * 並將其參考賦給 person 變數。這時，person 指向 Person("Alice")。
 * 
 * -->在 Java 中，變數本身是 參考（reference），它指向某個物件在內存中的位置（即物件的引用）。
 * -->所以是變數person 指向 物件 Person("Alice")內存位置
 * 
 * Person newPerson = person;
 * 
 * -> person的參考賦給 newPerson，因此newPerson和person都會指向 Person("Alice")
 * 
 * person = new Person("Bob")
 * 
 * -> jvm建立新的物件， person更新參考
 */