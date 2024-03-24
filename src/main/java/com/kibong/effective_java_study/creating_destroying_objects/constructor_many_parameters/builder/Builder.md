# Builder Pattern
- Return 빌터 타입 그 자체를 반환한다.  
- Fluent API 및 Method Chaining을 지원한다.(Java Beans보다 더 Consistent하게 가져올 수 있다.)   
  필수로 필요로 한 값들을 가져올 수 있게끔 강제할 수 있기 때문
- 모든 경우에 빌더가 유효한건 아니다.
  - 필수적인 필드와 필수적이지 않은 필드가 있을 때 사용한다.