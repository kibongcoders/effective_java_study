# Avoid Creating Unnecessary Objects.
불필요한 객체  생성을 피하라

객체를 사용하다 보면 불필요하게 동일한 일을 함에도 불구하고 여러번 생성하는 경우가 있다.
그렇다고 모든 경우에 객체를 재사용하라는 이야기는 아니고 객체를 재사용하는 것이 성능에 도움이 되는 경우에만 재사용하라는 이야기이다.

## 문자열
```java
String s = new String("bikini"); // don't do this
```
JVM에서 문자열을 Pool에서 관리하고 캐싱하고 있기 때문에 new String을 사용하여 불필요하게 생성하면 성능에 영향을 줄 수 있다.

## 정규 표현식
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

## Auto Boxing/Unboxing
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
