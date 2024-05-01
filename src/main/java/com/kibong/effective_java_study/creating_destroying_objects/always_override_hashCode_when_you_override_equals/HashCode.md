# HashCode

## HashCode란?
HashCode는 Java에서 제공하는, 객체의 해시값을 반환하는 메서드이다.

## HashCode 값이란?
HashCode 값은 객체의 메모리 주소를 기반으로 생성된 객체의 고유한 정수값이다.
그렇기 때문에 equals가 true를 반환하는 두 객체는 반드시 같은 HashCode 값을 반환해야 한다.
같은 HashCode값을 변환하기 때문에 equals 메소드를 재정의 할 때는 반드시 HashCode 메소드도 재정의 해야 한다.

## hashCode()의 예시
- HashMap
- HashSet
- HashTable


