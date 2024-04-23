## Obey The General Contract When Overriding Equals
equals는 일반 규약을 지켜 재정의하라.

### equals 메서드를 재정의하지 않아야 할 때
1. 각 인스턴스가 본질적으로 고유하다.
2. 인스턴스의 '논리적 동치성'을 검사할 필요가 없다.
3. 상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어맞는다.
4. 클래스가 private이거나 package-private이고 equals 메서드를 호출할 일이 없다.

## equals 규약

- 반사성(reflexivity) : null이 아닌 모든 참조 값 A 에 대해, A.equals(A)는 true다.2
    - 자신과 같으면 true여야 한다.
- 대칭성(symmetry) : null이 아닌 모든 참조 값 A, B에 대해, A.equals(B)가 true면 B.equals(A)도 true다.
- 추이성(transitivity) : null이 아닌 모든 참조 값 A, B, C에 대해, A.equals(B)가 true이고 B.equals(C)도 true면 A.equals(C)도 true다.
- 일관성(consistency) : null이 아닌 모든 참조 값 A, B에 대해, A.equals(B)를 반복해서 호출하면 항상 true나 항상 false를 반환해야 한다.
- null-아님 : null이 아닌 모든 참조 값 A에 대해, A.equals(null)은 false다.

### 반사성
```java
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s)); // false
        System.out.println(s.equals(cis)); // false
    }
}
```

### 대칭성
```java
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp)); // true
        System.out.println(cp.equals(p)); // false
    }
}
```

### 추이성
```java
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
        ColorPoint cp2 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(cp1.equals(p)); // true
        System.out.println(p.equals(cp2)); // true
        System.out.println(cp1.equals(cp2)); // false
    }
}
```

### 일관성
```java
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s)); // true
        System.out.println(s.equals(cis)); // false
    }
}
```

### null-아님
```java
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        System.out.println(cis.equals(null)); // false
    }
}
```
