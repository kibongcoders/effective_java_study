# Service Provider Framework
- 개념적인 것이고 다양한 구현 방법과 변형이 존재 가능하다.
- 다음과 같은 프레임워크의 목적은 Extensible Application을 만드는 것이다.  
  - 확장 가능한 어플리케이션을 만드는 것
  - 확장 가능한 어플리케이션은 코드는 그대로 유지하고  외적인 요인이 변경되었을 때 어플리케이션의 동작을 다르게 할 수 있는 것을 말한다.
  - EX) 코드는 그대로 있는데 설정 파일 하나만 있으면 출력 되는 메시지가 다른 경우

## 주요 구성 요소
- Service Provider Interface와 Service Provider(Service Implements)
- 서비스 제공자 등록 API (서비스 인터페이스의 구현체를 등록하는 방법)
  - @Configuration, @Bean, @Service, @Component, @Repository 등등
- 서비스 접근 API (서비스의 클라이언트가 서비스 인터페이스의 인스턴스를 가져올 때 사용하는 API)
  - Bean 주입
## 다양한 변형
- 브릿지 패턴
  - 구체적인 것과 추상적인 것을 분리하는 것
  - 각기 독립적으로 각각의 계층구조로 변화할 수 있도록 하기 위해 사용
- 의존 객체 주입 프레임워크
- java.util.ServiceLoader