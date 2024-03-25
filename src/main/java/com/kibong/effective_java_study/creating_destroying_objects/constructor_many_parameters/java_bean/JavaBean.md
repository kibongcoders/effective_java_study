# JavaBean
java.beans 패키지 안에 있는 모든 것
- JavaBean이 지켜야 할 규약
  - Argumentless Constructor
    - Reflection을 통해 객체를 생성할 때 필요
  - getter/setter method name
    - boolean type의 경우 get이 아닌 is로 시작
  - serializable interface 구현
    - 객체를 재사용하기 위해서는 객체를 저장 가능한 형태로 만들어야 하는데 이것을 Serializable하게 저장했다가 복원 가능하다.
- getter/setter가 주로 사용되는 이유는 JPA나 스프링과 같은 여러 프레임워크에서 리플랙션을 통해 특정 객체 값을 조회하거나 설정하기 때문
- JavaBean 스팩을 완벽하게 따를 필요는 없다.


