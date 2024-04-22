## Obey The General Contract When Overriding Equals
equals는 일반 규약을 지켜 재정의하라.

### equals 메서드를 재정의하지 않아야 할 때
1. 각 인스턴스가 본질적으로 고유하다.
2. 인스턴스의 '논리적 동치성'을 검사할 필요가 없다.
3. 상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어맞는다.
4. 클래스가 private이거나 package-private이고 equals 메서드를 호출할 일이 없다.