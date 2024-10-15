# kotlin-calculator-precourse

## 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

- 구분자와 양수로 구성된 문자열

## 구현할 기능 목록

- [x] 입력 기능
- [ ] 숫자 추출 기능
- [ ] 덧셈 기능
- [ ] 결과 출력 기능
- [ ] 예외 처리

## 문제 해결 과정

### 입력 기능

#### main 함수

```kotlin
    println("덧셈할 문자열을 입력해 주세요.")
    var numList : IntArray = input()
```
- input 함수를 실행

#### input 함수

```kotlin
fun input(): IntArray {
    val inputString = readLine()
    val numList : IntArray = numberExtraction(inputString)
    return numList
}
```
- `readLine()`을 통해 사용자가 입력하는 값을 `inputString`에 저장 
- `numberExtraction` 함수를 통해 `inputString`에서 추출된 숫자 배열을 `numList`에 저장
- 추출된 숫자 배열인 `numList`를 리턴
