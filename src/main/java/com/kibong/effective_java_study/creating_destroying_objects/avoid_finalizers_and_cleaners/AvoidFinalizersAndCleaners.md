# AvoidFinalizersAndCleaners
finalizer와 cleaner 사용을 피하라

## 요약
- finalizer와 cleaner는 예측할 수 없고, 대체로 위험하고, 일반적으로 불필요하다.
- finalizer와 cleaner를 사용하면 성능이 심각하게 저하될 수 있다.
- finalizer와 cleaner를 사용하는 클래스는 finalizer와 cleaner를 사용하지 않는 클래스보다 신뢰할 수 없다.
