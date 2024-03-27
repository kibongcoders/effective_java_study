# Singleton
어떤 타입의 인스턴스가 오로지 하나만 있어도 되는 경우 리소스를 덜 사용하면서 객체를 생성할 수 있는 패턴이다.

## Singleton Pattern을 만드는 방법

### private 생성자 + public static final 필드
```java
public class Singleton {
    public static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }
}
```
#### 장점 
- 간결하고 싱글턴임을 API에 드러낼수 있다.
  - Java Doc에 싱글턴 클래스임을 명시할 수 있다.
#### 단점 
- 싱글톤을 사용하는 클라이언트 테스트하기 어려워진다.
  - 테스트할 때 Mock 객체를 사용하기 어렵다.
- 리플렉션으로 private 생성자를 호출할 수 있다.
- 역직렬화 할 때 새로운 인스턴스가 생길 수 있다.

