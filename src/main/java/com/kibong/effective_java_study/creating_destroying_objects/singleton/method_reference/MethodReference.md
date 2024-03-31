# Method Reference
Java 8에 도입된 Method Reference는 람다 표현식을 더 간결하게 만들어주는 기능이다.  
Method Reference를 통해 더욱 간결하고 가독성 있게 코드를 짤수 있다.

## Method Reference 종류
Method Reference는 크게 4가지로 나눌 수 있다.
1. Static Method (정적 메소드) 
2. Instance Method Of Particular Object (특정 객체의 인스턴스 메소드)
3. Instance Method Of an Arbitrary Object of a Particular Type (특정 타입의 임의 객체의 인스턴스 메소드)
4. Constructor (생성자)

## Static Method
정적 메소드는 당연하게도 static한 Method를 참조할 때 사용하는 것이다.
Static Method의 특징은 ::기호 앞에 클래스 이름을 적어주는 것이다.
Math Class의 max Method
```java
    @IntrinsicCandidate
    public static int max(int a, int b) {
        return (a >= b) ? a : b;
    }
```
```java
Integer maxNumber = Math::max;
```

## Instance Method Of Particular Object
특정 객체의 인스턴스 메소드를 참조할 때 사용하는 것이다.
 