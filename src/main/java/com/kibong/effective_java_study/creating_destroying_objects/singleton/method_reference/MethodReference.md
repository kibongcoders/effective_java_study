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
int maxNumber = Math::max;
```

## Instance Method Of Particular Object
특정 객체의 인스턴스 메소드를 참조할 때 사용하는 방법

 ```java
    Function<String, String> toUpperCase = String::toUpperCase;
    String upperCase = toUpperCase.apply("hello");
```

특정 객체의 인스턴스 메소드를 사용하려면 인스턴스 :: 메소드명으로 사용하면 된다.  
위에 내용에서 보면 String Class의 toUpperCase Method를 참조하고 있다.  

### Instance Method Of an Arbitrary Object of a Particular Type
특정 유형의 임의 객체 인스턴스 메소드를 참조하는 방법

```java
    List<String> list = Arrays.asList("a", "b", "c");
    
    //Before
    List<Integer> lengthList = list.stream().map(s -> s.length()).collect(Collectors.toList());
    
    //After
    List<Integer> lengthList = list.stream().map(String::length).collect(Collectors.toList());
```

Stream을 사용하다 보면 map을 통해 데이터를 변환해주는데 이 때 Method Reference로 간결하게 사용할 수 있다.

### Constructor
인스턴스를 생성할 때 생성 하는 방법

```java
    //Before
    KiBong kibong = new KiBong();

    //After
    KiBong kibong = KiBong::new;
```

인스턴스 뒤에 ::new를 붙여 생성자를 참조 가능하다.