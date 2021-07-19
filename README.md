# 참고
- 웹 페이지: https://pragprog.com/titles/javacomp
- 토론 포럼: http://forums.pragprog.com/forums/javacomp
- 정오표: http://pragprog.com/titles/javacomp/errata
- 소스 코드: https://pragprog.com/titles/javacomp/source_code
- 길벗 홈페이지: https://www.gilbut.co.kr
- 길벗 소스 코드: https://github.com/gilbutITbook/007025

## 실습 준비 사항
실습에는 다음 준비 사항이 필요합니다.
- JDK 8 이상의 컴파일러
- 텍스트 에디터
- 빌드를 위한 Gradle
- 맑은 정신!(원서의 유머)

## 예제 파일 구조 및 참고 사항
이 책에서 사용하는 예제 파일은 주제별로 분류되어 있습니다.

- src
  - comments | 3장
  - design     | 7장         
  - error_handling | 5장
  - general         | 1장, 2장
  - lambdas | 8장
  - naming | 4장
  - preface | 서문
  - realworld  | 9장
  - testing | 6장

--- 

# Intro
- [x] FizzBuzzTest

# 1. 코드 정리
## 1.1  쓸모 없는 비교 피하기
- if-else문에서 return값이 boolean인 경우 굳이 비교할 필요 없음.

## 1.2 부정 피하기
- 불연산자(!) 를 사용하지 말자 -> 가독성에 별로 안 좋음.
-  누구나 부정이 없는 표현을 좋아한다.

## 1.3 불(boolean) 표현식은 직접 반환하자
- true, false를 리턴하기 보다는, 그 표현식 자체를 리턴하도록 리팩토링하자
- 드 모르간의 법칙
    - `!A && !B == !(A || B)`
    - `!A || !B == !(A && B)`
- 조건문이 세 개 이상 합칠 떄는, 변수로 따로 빼서 최적화를 시도하자

## 1.4 불 표현식 간소화
- 여러 조건문이 합쳐져 있으면, 이해하기 어려움 혹은 잘못 이해할 가능성 높음.
- &&가 항상  || 보다 먼저 평가된다.

## 1.5 조건문에서 NullPointerException 피하기
- 인수를 검증할 떄는 순서가 중요.
    - 반드시 `null` 을 먼저 확인한 후에, 다른 유효하지 않은 값을 검사해야함.
- 매개 변수 검사는 public, protected, default 메서드에서만 하면 됨.

## 1.6 스위치(switch) 실패 피하기
- case 문에 `break`가 없으면, 그대로 진행됨.

## 1.7 항상 괄호 사용하기
- if문 body에는 항상 `{}`를 사용하자
- 그래야 코드 가독성이 더 좋음 (들여쓰기..)

## 1.8 코드 대칭 이루기
- if문의 분기들이, 모두 비슷한 관심사를 표현하는가..?
- 첫번째는 유저 상태에 따라서, 로그인을 거절함
- 두번쨰, 세번쨰는 유저의 상태에 따라서 접근을 허락함.
    - 즉 접근이라는 관심사에 대해 서로 다른 입장을 표명하고 있음을 알 수 있음.
    - 이를 코드 대칭적으로 나타내려면..