


是的，除了 Runnable 之外，Java 內建了其他多個函式式介面（Functional Interface），這些介面都只有一個抽象方法，並且可以用來表示具體的行為或操作。這些函式式介面通常會和 Lambda 表達式搭配使用，來簡化程式碼的編寫。

常見的函式式介面：
Callable<V>：

和 Runnable 類似，不過 Callable 可以返回一個結果或丟出異常。
它的 call() 方法定義了要執行的任務，並且返回結果。
用於需要返回結果的多執行緒處理。
java
複製
編輯
public interface Callable<V> {
    V call() throws Exception;
}
Comparator<T>：

用來比較兩個物件的順序，並返回一個整數，表示兩個物件的比較結果。
它的 compare() 方法定義了比較邏輯。
java
複製
編輯
public interface Comparator<T> {
    int compare(T o1, T o2);
}
Function<T, R>：

用來將一個輸入型別的物件（T）轉換成另一個輸出型別的物件（R）。
它的 apply() 方法接受一個參數並返回一個結果。
java
複製
編輯
public interface Function<T, R> {
    R apply(T t);
}
Predicate<T>：

用來測試某個物件是否符合某個條件，返回 true 或 false。
它的 test() 方法用來測試條件。
java
複製
編輯
public interface Predicate<T> {
    boolean test(T t);
}
Supplier<T>：

用來提供一個物件（通常是延遲計算的結果）。
它的 get() 方法返回一個物件。
java
複製
編輯
public interface Supplier<T> {
    T get();
}
Consumer<T>：

用來消費（處理）一個物件，通常是做副作用操作，並且不返回任何結果。
它的 accept() 方法接收一個物件並處理它。
java
複製
編輯
public interface Consumer<T> {
    void accept(T t);
}