# kotlin-calculator-precourse

## 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

- 구분자와 양수로 구성된 문자열

## 구현할 기능 목록

- [x] 입력 기능
- [x] 숫자 추출 기능
- [x] 덧셈 기능
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

### 덧셈 기능

#### main

```kotlin
val sum = sumNumArray(numArray)
```
- `sumNumArray` 함수를 통해 `numArray` 배열 안의 숫자들의 합을 구한 후 리턴 값을 `sum`에 저장

#### sumNumArray

```kotlin
fun sumNumArray(numArray: List<String>): Int {
    var sum = 0
    numArray.forEach { sum+=it.toInt() }
    return sum
}
```
- 고차함수 `forEach` 를 사용하여 `sum` 에 숫자 배열 요소들의 합을 저장후 `sum` 값을 리턴

### 결과 출력 기능

#### main
```kotlin
    println("결과 : $sum")
```
- `println` 함수를 이용해 추출된 숫자 배열안의 요소의 합이 저장된 `sum` 값을 출력
