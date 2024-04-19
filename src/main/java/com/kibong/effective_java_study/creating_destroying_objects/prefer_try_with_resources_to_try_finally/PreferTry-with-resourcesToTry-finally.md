## Prefer try-with-resources to try-finally
try-finally 보다 try-with-resouces를사용하라.

## try-finally 사용

```java
public static void main(String[] args) {
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader("test.txt"));
        System.out.println(br.readLine());
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
### try-finally 단점
- 코드가 지저분해진다.
- 예외가 발생하면 close() 메서드도 예외를 던질 수 있다.
- close() 메서드에서도 예외가 발생하면 이전에 발생한 예외는 무시된다.
- close() 메서드에서 발생한 예외는 숨겨진다.
- close() 메서드에서 발생한 예외는 무시된다.

## try-with-resources 사용

```java
public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
        System.out.println(br.readLine());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```
### try-with-resources 장점
- 코드가 깔끔해진다.
- close() 메서드에서 발생한 예외는 숨겨지지 않는다.
- close() 메서드에서 발생한 예외는 무시되지 않는다.
