# 생성자 대신 Static Factory Method를 고려하라.
## 공략
- 열거 타입은 인스턴스가 하나만 만들어짐을 보장한다.
- 같은 객체가 자주 요청되는 상황이라면 플라이웨이트 패턴을 사용할 수 있다.
- 자바 8부터는 인터페이스가 정적 메서드를 가질 수 없다는 제한이 풀렸기 때문에 인스턴스화 불가 동반 클래스를 둘 이유가 별로 없다.
- 서비스 제공자 프레임워크를 만다는 근간이 된다.
- 서비스 제공자 인터페이스가 없다면 각 구 현체를 인스턴스로 만들 때 리플렉션을 사용해야한다.
- Bridge 패턴
- 의존 객체 주입 프레임워크


## 장단점
### 장점

#### 1. 이름을 가질 수 있다.(동일한 시그니처의 생성자를 두개 가질 수 없다.)

  ```java

@Getter
public class Product {
    private String productName;
    private Boolean productIsAvailable;
    private Boolean productIsExpired;

    public Product(String productName, Boolean productIsAvailable) {
        this.productName = productName;
        this.productIsAvailable = productIsAvailable;
    }

    public Product(String productName, Boolean productIsExpired) {
        this.productName = productName;
        this.productIsExpired = productIsExpired;
    }
}
  ```

- 자바 내에서는 위와 같은 생성자를 가질 수 없다.
- 생성자의 시그니처가 중복 되는 경우에 static factory method를 사용하여 해결 가능하다.
- [Product.java](Product.java), [StaticFactoryMethodTest](..%2F..%2F..%2F..%2F..%2F..%2F..%2Ftest%2Fjava%2Fcom%2Fkibong%2Feffective_java_study%2Fcreating_destroying_objects%2Fstatic_factory_method%2FStaticFactoryMethodTest.java)
  참고

##### 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다. (Boolean.valueOf())

- 생성자를 통해 인스턴스를 생성하게 되면 매번 새로운 인스턴스를 생성하기 때문에 같은 인스턴스를 사용하고 싶을 때 사용하지 못하게
  된다.([newInstanceTest()](..%2F..%2F..%2F..%2F..%2F..%2F..%2Ftest%2Fjava%2Fcom%2Fkibong%2Feffective_java_study%2Fcreating_destroying_objects%2Fstatic_factory_method%2FStaticFactoryMethodTest.java))
- static factory method를 활용해서 인스턴스를 통제할 수 있다.  
  [FinalProduct](FinalProduct.java), [newFinalInstanceTest](..%2F..%2F..%2F..%2F..%2F..%2F..%2Ftest%2Fjava%2Fcom%2Fkibong%2Feffective_java_study%2Fcreating_destroying_objects%2Fstatic_factory_method%2FStaticFactoryMethodTest.java)

#### 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.(인터페이스 기반 프레임워크, 인터페이스에 정적 메소드)

#### 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.(EnumSet)

#### 5. Static Factory Method를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.(서비스 제공자 프레임워크)
### 단점

#### 1. 상속을 하려면 public이나 protected 생성자가 필요하기 때문에 Static Factory Method만 제공하면 하위 클래스를 만들 수 없다.

#### 2. 정적 팩터리 메소드는 프로그래머가 찾기 어렵다.

