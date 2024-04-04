# Private Constructor

인스턴스화를 막가 위해서 생성자를 private로 선언해라  
가끔 static한 method들만 가지고 있는 유틸리티성 클래스들이 있다.

``` java
public class KiBong {
        
   private KiBong() {        
        throw new AssertionError();
    }
        
   public static void print() {
        System.out.println("Hello");
   }
     
}
```

## 추상 클래스로 만들기

``` java
public abstract class KiBong {
    private static final KiBong INSTANCE = new KiBong() {
        @Override
        public void print() {
            System.out.println("Hello");
        }
    };
    
    public static KiBong getInstance() {
        return INSTANCE;
    }
    
    public abstract void print();
}
```

- 하지만 해당 방법은 추상 클래스를 상속받아서 사용할 수 있기 때문에 인스턴스화를 막을 수 없다.
- Spring 에서도 이 방법을 사용하기는 한다. (좋은 방법은 아니다.)