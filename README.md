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

#### main

```kotlin
    println("덧셈할 문자열을 입력해 주세요.")
    var inputString = readLine()
```
- `readLine()` 을 통해 사용자가 입력하는 값을 `inputString` 에 저장

### 숫자 추출 기능

#### main

```kotlin
    val numArray = numberExtraction(inputString)
```
- `numberExtraction` 함수를 실행하여 `inputString` 에서 숫자 배열을 추출하여 리턴 값을 `numArray` 에 저장

#### numberExtraction

```kotlin
fun numberExtraction(inputString: String): List<String> {
    val numArray : List<String>
    if(inputString[0]=='/'&&inputString[1]=='/'&&inputString[3]=='\\'&&inputString[4]=='n'){
        numArray = inputString.substring(5).split(inputString[2])
    }else{
        numArray = inputString.trim().split(",",":")
    }
    return numArray
}
```
- 사용자가 커스텀 구분자를 지정했는지 `if 문` 을 통해 확인
- 커스텀 구분자를 지정했다면 `substring` 함수를 통해 커스텀 구분자를 지정하는 부분 다음부터 커스텀 구분자로 `split` 함수를 통해 숫자를 추출하여 `numArray`에 저장
- 커스텀 구분자를 지정하지 않았다면 쉼표와 콜론으로 `split` 함수를 통해 숫자를 추출하여 `numArray`에 저장
- 추출되어 저장된 숫자 배열을 리턴

