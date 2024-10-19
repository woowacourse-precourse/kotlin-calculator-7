# kotlin-calculator-precourse

## 계획

1. domain 계획
2. 테스트 코드 작성
3. 어플리케이션 코드 작성

## 구현할 기능 목록

1. 쉼포 또는 클론을 구분자로 하는 문자열 분리
2. 숫자 합 반환
3. 커스텀 구분자 지정 (//와 \n 사이 값)
4. 사욪자의 잘못된 값은 `IllegalArgumentExecption` 후 어플리케이션 종료

## 입출력 요구 사항

**입력**
구분자와 양수로 구성된 문자열

**출력**
덧셈 결과
결과 : 6

**실행 결과 예시**
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6

## 프로그래밍 요구 사항

Kotlin version: 1.9.24

Application: main()

camp.nextstep.edu.missionutils.Console: readLine()

## 설계

* 흐름
    * 사용자 입력
    * 구분자와 숫자로 파싱
    * 잘못된 입력일 경우
        * 에러 출력과 프로그램 종료
    * 숫자 합 계산
    * 값 반환 (출력)

* 양수
    * [양수(陽數)는 +1, 2, sqrt(2), π, e처럼 양의 부호(+)를 붙인 수로 0보다 큰 수다. 양수 중 양의 정수는 수론에서 자연수라고 일컬으며, 양수 앞에 붙은 부호 (+)는 생략할 수 있다.](https://ko.wikipedia.org/wiki/%EC%96%91%EC%88%98_(%EC%88%98%ED%95%99))
    * 편의를 위해 루트, 파이, 자연 지수는 생략

* 구분자
    * `//`와 `\n` 사이의 값
    * 두 개 이상의 문자가 지정되면,
        * 두 개의 문자열로 이루어진 한 개의 구분자? 한 개의 문자열로 이루어진 두 개이 구분자?
            * **두 개의 문자열로 이루어진 한 개의 구분자로 구현**
    * 구분자로 시작하거나 끝나는 문자열 입력
        * 예외 처리
    * `kotlin REGEX`를 사용하여 구분자 추출 [Kotlin Regex](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-regex/)

* 입력
    * `1,2:3`
    * 계산기 클래스 사용
    * `String.split(구분자)`: [Kotlin split](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/split.html)
        * 문자열, 문자, 정규식

* 출력
    * 계산기 클래스 값 계산
    * 값 반환
    * 애플리케이션에서 양수의 합 출력

* `class Calculator`
