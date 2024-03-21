# Interface
- Java 8과 9에서 주요 인터페이스 변화
- 기본 메소드(Default Method)와 Static Method를 가질 수 있다.
- 자바 8 버전 부터 다음과 같은 기능들을 가질 수 있게 되어 인터페이스와 불가 동반 클래스를 가질 이유가 없다.
- 유틸이나 헬퍼 같은 경우에ㅐ는 아직 사용해야는 경우가 있다.
## Default Method
- default를 붙이면 된다.
- 해당 인터페이스를 구현하는 모든 곳에서 사용 가능하다.
- Java 9 버전 부터 사용 가능
- Interface에서 Method 선언 뿐 아니라, 기본적인 구현체까지 제공할 수 있다.
- 기존의 Interface를 구현하는 Class에 새로운 기능을 추가할 수 있다.
## Static Method
- Java 9부터 private static method도 가질 수 있다.
- - static을 붙여 정적인 Method를 사용 가능하다.
- 단, private 필드는 아직도 선언할 수 없다.

  

