# Eleminate Obsolete Object References
다 쓴 객체 참조를 해제하라.

## 다 쓴 객체 참조 해제하기
- 어떤 객체에 대한 레퍼런스가 남아있다면 해당 객체는 가비지 컬렉션의 대상이 되지 않는다.
- 객체 참조를 다 썼을 때 null 처리를 해주어야 한다.

```java
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
```
해당 코드를 보면 pop 메서드에서 배열의 마지막 원소를 반환하고 size를 감소시킨다.  
그런데 이렇게 코드를 pop 메서드를 한다고 해도 배열의 마지막 원소는 여전히 참조를 가지고 있기 때문에
언젠가는 OutOfMemoryError가 발생할 수 있다.  
그래서 코드를 이렇게 변경해야한다.  
```java
public Object pop() {
    if (size == 0) {
        throw new EmptyStackException();
    }
    Object result = elements[--size];
    elements[size] = null; // 다 쓴 참조 해제
    return result;
}
```
이렇게 하면 배열의 마지막 원소를 null로 처리하여 가비지 컬렉션의 대상이 된다.

## Null Pointer Exception

### Null Pointer Exception이 발생되는 이유
메소드에서 null을 return하거나 null을 체크하지 않았기 때문에 발생된다.

GC를 사용하기 위해 Reference를 Null 처리한 후 해당 Reference를 사용할 때 Null Pointer Exception이 발생한다  
이 때 Null Pointer Exception이 발생하지 않게 된다면 잘못된 일을 수행하게 될 것이다.

### Null Pointer Exception을 방지하는 방법
Optional을 사용
```java
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println(optional.orElse("Hello"));
    }
}
```
Primitive Type을 Optional로 사용하려면 OptionalInt, OptionalLong, OptionalDouble을 사용하면 된다.
```java
public class OptionalTest {
    public static void main(String[] args) {
        OptionalInt optionalInt = OptionalInt.of(1);
        System.out.println(optionalInt.orElse(0));
    }
}
```


WeakHashMap을 사용해서 객체 참조를 해제할 수도 있다.  
WeakHashMap은 키가 가비지 컬렉션의 대상이 되면 해당 키와 값이 제거된다.  
WeakHashMap을 사용할 때에 중요한 점은 같은 scope에서 사용할 경우 아직 해당 scope가 끝나지 않았다면,  
WeakHashMap의 키가 가비지 컬렉션의 대상이 되지 않는다.

다음 방법은 LRUCache를 사용하는 방법이다.
Latest Recently Used Cache이다.
LRUCache는 가장 오랫동안 참조되지 않은 객체를 제거하는 방법이다.

```java
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 100;

    public LRUCache() {
        super(MAX_ENTRIES, 0.75f, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRIES;
    }
}
```

다음 방법은 Scheduled ThreadPool을 사용하는 방법이다.
Scheduled ThreadPool은 일정 시간이 지나면 해당 객체를 제거하는 방법이다.

```java
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Hello");
        scheduledExecutorService.schedule(task, 1, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
```



