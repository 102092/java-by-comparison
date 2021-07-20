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
    
# 2. 코드 스타일 정리
## 2.1 매직넘버를 상수로 대체
- 표면상 의미 없는 숫자 -> 매직넘버
- 이러한 숫자를 통해 코드를 제어하면.. 해당 코드 이해가 힘들어짐 
    - 그래서 이를 상수(constant) 대체
    - enum or static final..로.
    
## 2.2 정수 상수 대신에 열거형으로
- static final... 로 선언하기 보다는 enum 으로

## 2.3 For loop 대신 For-Each
- `IndexOutOfBoundsException` 을 피할 수 있음 -> 더 안전해짐

## 2.4 순회하며 컬렉션을 수정하지 말자
- `ConcurrentModificationException` 발생 가능
    - List를 순회하면서, List를 수정할 수는 없다.
- 이 문제의 핵심은, 문제가 발생하기 전에는 알기가 힘들다는 것 (컴파일러가 잡아내지 못한다는 의미인듯)
- `Iterator`를 활용하여 해결할 수 있음.
    - Iterator는 포인터처럼 동작
    - `removeIf()` 도 내부적으로는 Iterator를 사용하는듯.
    
## 2.5 순회하며 계산 집약적 연산 수행하지 않기
- 계산 집약적 연산? 
    - `Pattern.matches`... 같은
    - 루프 돌면서, 계속 특수한 목적의 오토마톤을 만드는데 이는 굉장한 자원을 소모한다.
- Pattern.compile로 미리 만들어두자..
- 아무튼 `Pattern` 클래스를 사용할 떄는 성능 조심하자
    
## 2.6 새 줄로 그루핑
- 연관된 코드, 개념은 그룹핑
- 서로 다른 그룹은 빈 줄을 추가하여 각각 나눠야함.

## 2.7 이어붙이기 대신에 서식화..
- `String.format` 을 이용해서 코드를 간소화 시키자.
- %s -> string, %tm -> time month, %te -> time day, %ty -> time year
- %d -> digit
- %S -> 객체를 toString() 메서드를 이용해 대문자 String 으로 변환
- %n -> 행바꿈 기호
- 문자열이 길면 `StringTemplate`을 사용하자
    -  참고 : https://www.programcreek.com/java-api-examples/?api=org.antlr.stringtemplate.StringTemplate
    
## 2.8 직접 만들지 말고 자바 API를 사용하자
- `Objects`, `Collections` 등의 이미 정의되어있는 api를 잘 활용하자.

# 3. 주석 사용하기
## 3.1 지나치게 많은 주석은 없애자
- 코드를 통해 이해할 수 있는 내용이면 굳이 주석을 남겨놓지 않아도 좋다.

## 3.2 주석 처리된 코드 제거
- 보통 주석 처리는, 특정 기능을 동작하지 못하게 하거나, 혹은 훗날 다시 사용할지도 모르기 때문에 하는 경우가 많음.
- 그냥 지우자. 
    - 왜? 코드 이해하는데 방해만 된다.
    
## 3.3 주석을 상수로 대체하자
- 의미있는 변수를 대체해놓은 주석은, 남겨두지 말고 상수로 대체하자

## 3.4 주석을 유틸리티 메서드로 대체하자
- Math.to... 이렇게 뭔가 계산하는 코드는 주석으로 어떤 목적인지 알려주는 경우가 많음.
- 그대신 이 부분을 메서드로 대체하자
- 이러면 더 이해하기가 쉬워진다.

## 3.5 구현 결정 설명..
- 왜 `Collections.binarySearch` 를 사용하였을 까?
    - 이 부분을 주석해 놓는 경우가 있음.
- 이러한 주석을 작성할 때 아래 해당 사항을 포함하여 주석을 작성하자
    1. 사용 사례의 맥락에서 
    2. 직면되는 우려사항
    3. 그리고 개발자가 선택한 해법으로
    4. 얻게되는 품질 (장점)과
    5. 받아들여야하는 단점
    - In the context of [USE CASE],
    - facing [CONCERN]
    - we decided for [OPTION]
    - to achieve [QUALITY],
    - accepting [DOWNSIDE].
    
## 3.6 예제로 설명하자
- regex 패턴에 대해 설명
    1. 형식
    2. 유효한 예
    3. 유효하지 않는 예
- 이런식으로 적어두면 해당 코드에 대해 훨씬 이해하기 편할듯!

## 3.7 패키지를 JavaDoc으로 구조화 하기
- JavaDoc은 java api가 제공하는 문서화 기능.

## 3.8 클래스와 인터페이스를 JavaDoc으로 구조화 하기
- 최상단에는 요약문
- 그 다음에 태그를 통해, 상세한 설명

## 3.9 메서드를 JavaDoc으로 구조화 하기
- 메서드는 객체의 동작을 표현
- IDE는 JavaDoc 주석에서 추출한 내용을 기반으로 개발자에게 호출할 메서드를 선택하게 해준다.
- `<pre>`는 xml환경. < 문자를 조심해야함.

## 3.10 생성자를 JavaDoc으로 구조화 하기
- 