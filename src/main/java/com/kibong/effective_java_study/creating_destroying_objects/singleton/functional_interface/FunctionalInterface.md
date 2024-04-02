# Functional Interface
Object Class의 메서드를 제외하고 구현해야 할 추상 메서드가 하나인 함수형 인터페이스

- default Method나 static Method가 있어도 상관 없다.
- @FunctionalInterface Annotation을 사용하면 컴파일러가 함수형 인터페이스를 확인한다.(안해도 상관 없다.)

```java
@FunctionalInterface
public interface FunctionalInterface {
    void abstractMethod();

    default void defaultMethod() {
        System.out.println("default Method");
    }

    static void staticMethod() {
        System.out.println("static Method");
    }
}
``` 
## 꼭 알아야하는 함수형 인터페이스
- Runnable
- Callable
- Comparator
- Predicate
- Function
- Supplier

### Runnable
Runnable은 인자를 받지 않고 리턴값이 없는 함수형 인터페이스이다.

```java
@FunctionalInterface
public interface Runnable {
    void run();
}
```

### Callable
Callable은 Runnable과 비슷하지만 리턴값이 있는 함수형 인터페이스이다.

```java
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
```

### Comparator
Comparator는 두 인자를 받아서 비교하는 함수형 인터페이스이다.

```java
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```

### Predicate
Predicate는 인자를 받아서 boolean을 리턴하는 함수형 인터페이스이다.

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```
### Function
Function은 인자를 받아서 리턴값을 리턴하는 함수형 인터페이스이다.

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```

### Supplier
Supplier는 인자를 받지 않고 리턴값을 리턴하는 함수형 인터페이스이다.

```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```
