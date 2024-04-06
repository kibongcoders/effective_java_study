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

## Garbage Collection
Garbage Collection은 JVM에서 메모리를 관리하는 방법인데, 이것은 Heap 영역에서 사용하지 않는 객체를 제거하는 방법이라고 볼 수 있다.

### Mark, Sweep, Compact
- Mark : GC 대상이 되는지 안되는 지(참조를 가지고 있는지) 체크
- Sweep : 필요없는 Object를 실제 메모리 공간에서 제거
  - Sequential 하게 메모리가 제거 될 수도 있지만 그것 보다는 중간 중간 메모리 공간일 비우는 것이 더 효율적이다.
  - 하지만 중간 중간 비우다 보면 공간의 크기가 맞지 않는 경우가 생기는데, 이것을 파편화(fragmentation)라고 부른다.
  - 이것을 해결하기 위해 Compact를 사용한다.
- Compact : 메모리 공간을 정리하는 것
  - Compact를 사용하면 파편화를 해결할 수 있다.
  - 하지만 Compact를 사용하면 GC가 느려지는 단점이 있다.
### Young/Old Generation
객체들은 생명주기가 짧다. 그래서 오래된 객체들은 Old Generation으로 이동하여 관리한다.
- Young Generation : 새로 생성된 객체가 저장되는 공간
  - Eden : 새로 생성된 객체가 저장되는 공간
  - Survivor 0, 1 : Eden에서 살아남은 객체가 저장되는 공간
- Old Generation : Young Generation에서 오래된 객체가 저장되는 공간

### Minor GC/Full GC
- Minor GC : Young Generation에서 일어나는 GC
- Full GC : Young Generation/Old Generation에서 일어나는 GC 

### Serial GC/Parallel GC/CMS GC/G1 GC
- Serial GC : 싱글 코어에서는 Serial GC를 사용하는 것이 좋다
- Parallel GC : 멀티 코어에서는 Parallel GC를 사용하는 것이 좋다

### GC 알고리즘
GC 알고리즘을 공부하려면 3가지 개념이 매우 중요하다.
- Throughput : 어플리케이션이 처리할 수 있는 처리량
  - 어떤 GC 알고리즘이 서버에 Throughput이 얼마나 높은지 확인
- Latency : 지연 시간
  - GC가 일하는 하는 동안에는 Stop the World가 발생한다. 이것이 길어지면 시스템에 장애가 발생할 수 있다.
  - Serial GC와 Pharaell GC는 Laytenct 관점에서 좋은 GC는 아니다.
  - CMS GC와 G1 GC는 Laytenct 관점에서 좋은 GC이다.
- Footprint : 메모리 사용량
  - GC 알고리즘이 얼마나 메모리를 사용하는지 확인

이 중 가장 중요한 것은 Latency이다.
Throughput과 Footprint 서버 사양을 늘리면 해결할 수 도 있지만 Laytenct는 서버 사양을 늘려도 해결이 되지 않는다.



