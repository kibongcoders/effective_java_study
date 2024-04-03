# Serialization
- Byte Stream으로 변환한 객체를 파일로 저장하거나 네트워크로 전송할 수 있는 기능 -> 상호 변환하는 기술
- 객체를 Byte Stream으로 변환하는 것을 Serialization, Byte Stream을 객체로 변환하는 것을 Deserialization이라고 한다.
- transient 키워드를 사용하면 직렬화 대상에서 제외할 수 있다.
```java
    public class KiBong implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private transient int age;
    }
```
- static한 필드는 직렬화 대상에서 제외된다.
- 직렬화된 객체를 역직렬화할 때는 serialVersionUID를 사용하여 직렬화된 객체와 역직렬화할 객체가 같은지 확인한다.