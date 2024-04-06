# Avoid Creating Unnecessary Objects.
불필요한 객체  생성을 피하라

객체를 사용하다 보면 불필요하게 동일한 일을 함에도 불구하고 여러번 생성하는 경우가 있다.
그렇다고 모든 경우에 객체를 재사용하라는 이야기는 아니고 객체를 재사용하는 것이 성능에 도움이 되는 경우에만 재사용하라는 이야기이다.

## 불필요한 객체 생성하는 대표적인 3가지 예시
### 문자열
```java
String s = new String("bikini"); // don't do this
```
JVM에서 문자열을 Pool에서 관리하고 캐싱하고 있기 때문에 new String을 사용하여 불필요하게 생성하면 성능에 영향을 줄 수 있다.

### 정규 표현식
정규 표현식을 사용할 때 CPU 리소스를 사용한다. 따라서 정규 표현식을 사용할 때는 Pattern 인스턴스를 필드로 만들어 재사용하는 것이 좋다.
```java
public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(
        "^(?=.)M*(C[MD]|D?C{0,3})"
        + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    
    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
```

### Auto Boxing/Unboxing
- Auto Boxing : Primitive 타입을 Wrapper 타입으로 변환하는 것
- Unboxing : Wrapper 타입을 Primitive 타입으로 변환하는 것
```java
private static long sum() {
    Long sum = 0L;
    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
        sum += i;
    }
    return sum;
}
```
## 불필요한 객체 생성을 피하는 방법

### Deprecation
API를 개발하다보면 기존의 API를 사용하지 않게 되는 경우가 있다. 이런 경우에는 @Deprecated를 사용하여 알려 줄 수 있다.
```java

public class KiBong {
    
    @Deprecated(forRemoval = true)
    public KiBong() {
        
    }
    
    public void print() {
        System.out.println("Hello");
    }
}
```
@Deprecated에는 두가지 기능이 있다.
- forRemoval : 해당 API가 제거될 예정
- since : 해당 API가 언제부터 사용이 되지 않는지

그리고 Document에도 @deprecated를 사용하여 해당 API가 사용되지 않는다는 것을 알려줄 수 있다.
```java
/**
 * @deprecated
 * @since 2021-07-01
 */
@Deprecated
public void print() {
    System.out.println("Hello");
}
```
### 정규 표현식
정규 표현식이 쓰일 만한 3가지 경우
#### Replace
```java
String result = "Hello, World!".replaceAll("World", "KiBong");
String result = "Hello, World!".replaceFirst("World", "KiBong");
```
ReplaceAll과 ReplaceFirst는 첫번째 인자가 정규 표현식이다.
### Split
```java
String[] result = "Hello, World!".split(",");
```
Split은 첫번째 인자가 정규 표현식이다.  
Split은 One Character를 사용하는 것이 좋은데,   
그 이유는 spilt에 One Character 값을 넣어주게 되면 별도 처리 로직으로 정규 표현식을 match 시키게 된다.  
그렇기 때문에 만약 One Character가 아닌 경우에는 Pattern compile 메소드를 사용하는 것이 좋다.
```java
private static final Pattern COMMA = Pattern.compile(",,");

public static void main(String[] args) {
    String hello = "Hello,,World!";
    String[] result = COMMA.split(hello);
}
```
### Matches

```java
private static final Pattern ROMAN = Pattern.compile(
    "^(?=.)M*(C[MD]|D?C{0,3})"
    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

static boolean isRomanNumeral(String s) {
    return ROMAN.matcher(s).matches();
}
```
### 참고 사이트
- https://docs.oracle.com/javase/tutorial/essential/regex/
- https://regex101.com/ 
- https://regexr.com/




