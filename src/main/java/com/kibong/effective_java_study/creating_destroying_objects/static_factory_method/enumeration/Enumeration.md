# 열거 타입 (Enumeration)
- 상수 목록을 담을 수 있는 데이터 타입
- 특정한 변수가 가질 수 있는 값을 제한할 수 있다.(Type-Safety)를 보장할 수 있다.
- 싱글톤 패턴을 구현할 때 사용하기도 한다.

## Enum Type 장점
- 특정한 값을 제한할 수 있다.(Type Safety)  
  - Human Error를 줄일 수 있다.
  - Type Safety를 통해 에러로 부터 보호받을 수 있다.
- Enumeration은 하나의 인스턴스만 만들어진다.
  - 싱글톤 패턴을 구현할 때 사용하기도 한다.

## HashSet EnumSet 차이

둘의 차이를 알아보기 전에 HashSet과 EnumSet의 차이를 알아보자. (둘다 Java 8에서 생성됨)

### HashSet

- HashTable(실제로 HashMap 인스턴스)을 기반으로 Set 인터페이스를 구현하는 구현체(HashTable의 경우 여기서 따로 설명하지는 않음)
- 모든 객체 저장 가능
- 순서대로 입력되지 않음, 시간이 지나도 일정하게 유지가 되지 않음
- 중복을 허용하지 않음
- null 값을 허영한다.
- HashSet을 반복하는 것은 HashSet의 인스턴스 크기 + 백업 HashMap 인스턴스의 용량(버킷 수)의 시간만큼 걸린다.
- HashSet은 MultiThread 환경에서 Syncronized를 지원하지 않음

### EnumSet

- Bit Vector 기반으로 Enumeration Type과 함께 사용하기 위한 Set 인터페이스의 구현체
- EnumSet의 모든 요소는 Enum으로부터 와야한다.
- null 허용 안함
- Enum의 순서대로 탐색하고 일관성이 보장
- EnumSet은 MultiThread 환경에서 Syncronized를 지원하지 않음

### HashSet과 EnumSet의 차이

| HashSet                              | EnumSet                         |
|--------------------------------------|---------------------------------|
| HashTable 구조                         | Bit Vector 구조                   |
| 모든 객체 저장 가능                          | Enum의 모든 요소는 EnumSet에 포함되어야 한다. |
| 순서대로 입력되지 않음, 시간이 지나도 일정하게 유지가 되지 않음 | Enum의 순서대로 탐색하고 일관성이 보장         |
| null 값을 허용한다.                        | null 허용 안함                      |

## Enum 클래스의 경우 EnumSet 사용해야 하는 이유
- Type-Safety를 보장할 수 있다.
- EnumSet은 Bit Vector 기반으로 만들어져서 메모리 사용량이 적다.
- 빠른 속도로 저장 및 탐색 가능 (containsAll, retainAll)