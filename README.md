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
- [x] 결과 출력 기능
- [x] 예외 처리

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
fun numberExtraction(inputString: String): Array<String> {
    val numArray: Array<String>
    val regex = """//(.*?)\\n""".toRegex()
    val matchResult = regex.find(inputString)
    if(matchResult!=null){
        val customSeparator = matchResult.groupValues[1]
        val regex2 = """\\n(.*)""".toRegex()
        val matchResult2 = regex2.find(inputString)
        if (matchResult2 != null) {
            val inputStringSub = matchResult2.groupValues[1]
            numArray = inputStringSub.split(customSeparator).toTypedArray()
        }else{
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }else{
        numArray = inputString.trim().split(",",":").toTypedArray()
    }
    return numArray
}
```
- 사용자가 커스텀 구분자를 지정했는지 정규식을 통해 정해진 커스텀 구분자 지정 형식대로 추출한후 `if 문` 을 통해 확인
- 커스텀 구분자를 지정했다면 정규식을 통해 커스텀 구분자를 지정하는 부분을 제외한 나머지 문자열을 추출 이때 추출되지 않는다면 잘못된 형식으로 입력한 것임으로 예외 처리후 종료
- 구한 커스텀 구분자로 `split` 함수를 통해 숫자를 추출하여 `numArray`에 저장
- 커스텀 구분자를 지정하지 않았다면 쉼표와 콜론으로 `split` 함수를 통해 숫자를 추출하여 `numArray` 에 저장
- 추출되어 저장된 숫자 배열을 리턴

### 덧셈 기능

#### main

```kotlin
val sum = sumNumArray(numArray)
```
- `sumNumArray` 함수를 통해 `numArray` 배열 안의 숫자들의 합을 구한 후 리턴 값을 `sum`에 저장

#### sumNumArray

```kotlin
fun sumNumArray(numArray: Array<String>): Int {
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

### 예외 처리 기능

#### 사용자의 입력값이 "" 인 경우

```kotlin
    if (inputString.isNullOrBlank()) {
        println("결과 : 0")
        return
    }
```
- `readLine` 으로 받은 값이 빈 문자열일 경우 결과 0을 바로 출력하고 프로그램 종료

#### 사용자가 잘못된 값을 입력할 경우

```kotlin
    if(!isAllElementsNumeric(numArray)) throw IllegalArgumentException("잘못된 입력입니다.")
    if(!isAllElementsNumericPositive(numArray)) throw IllegalArgumentException("잘못된 입력입니다.")
```
- `isAllElementsNumeric` 함수에서 `numArray` 에 저장된 요소가 전부 숫자인지 판단
- 전부다 숫자가 아닌 경우 잘못된 입력값 임으로 IllegalArgumentException 예외를 던짐
- `isAllElementsNumericPositive` 함수에서 `numArray` 에 저장된 숫자가 전부 양의 정수인지 판단
- 전부다 양의 정수가 아닌 경우 잘못된 입력값 임으로 IllegalArgumentException 예외를 던짐

```kotlin
fun isAllElementsNumeric(numArray: Array<String>): Boolean {
    return numArray.all { it.toIntOrNull() != null }
}
```
- 추출된 배열의 요소가 전부 숫자인지를 판별하고 전부 숫자라면 true, 숫자가 아닌 요소가 있다면 false를 리턴

```kotlin
fun isAllElementsNumericPositive(numArray: Array<String>): Boolean {
    return numArray.all { it.toInt() > 0 }
}
```

- 추출된 배열의 요소가 전부 양의 정수인지를 판별하고 전부 숫자라면 true, 숫자가 아닌 요소가 있다면 false를 리턴

## 실행 결과

<img width="231" alt="image" src="https://github.com/user-attachments/assets/5a37e261-be0b-4c4a-bcdd-b3e0d980219c">

<img width="187" alt="image" src="https://github.com/user-attachments/assets/9b1a15a3-fb32-42cc-97ed-1db69c449e7c">

<img width="724" alt="image" src="https://github.com/user-attachments/assets/27628252-167d-40ee-99c4-2d9e5c6d3995">

## 추가 학습 내용 : Commit Message Conventions

### 커밋 메시지 형식

```
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

### 커밋 메시지 헤더
`<type>(<scope>): <subject>`

#### <type>

- feat : 새로운 기능 추가
- fix : 버그 수정
- docs : 문서 관련
- style : 스타일 변경 (포매팅 수정, 들여쓰기 추가, …)
- refactor : 코드 리팩토링
- test : 테스트 관련 코드
- build : 빌드 관련 파일 수정
- ci : CI 설정 파일 수정
- perf : 성능 개선
- chore : 그 외 자잘한 수정

#### <scope>

- 어디가 변경되었는지, 변경된 부분은 모두 들어갈 수 있음
- scope는 생략 가능

#### <subject>

- short summary
- 명령문, 현재 시제로 작성
- 첫 글자는 대문자가 아닌 소문자
- 마지막에 마침표(.)를 붙이지 않음

### **메시지 내용 (Message Body)**

- 명령문, 현재 시제로 작성하길 권장
- 변경한 이유와 변경 전과의 차이점을 설명

### **메시지 하단 (Message Footer)**

#### **주요 변경 내역들 (Breaking Changes)**

- 변경점 (description of the change)
- 변경 사유 (justification)
- 마이그레이션 지시 (migration instructions)

#### **해결된 이슈 (Referencing Issues)**

- 해결된 이슈는 커밋 메시지 하단에 `Closes #<이슈번호>` 와 같이 기록되어야 함
- `Closes #234`
- 해결된 이슈가 여러개인 경우는 다음과 같이 쓸 수 있음
- `Closes #123 #245 #992`

### 예시

#### feat

```
feat($browser): onUrlChange event (popstate/hashchange/polling)

Added new event to $browser:
- forward popstate event if available
- forward hashchange event if popstate not available
- do polling when neither popstate nor hashchange available

Breaks $browser.onHashChange, which was removed (use onUrlChange instead)
```

#### fix

```
fix($compile): couple of unit tests for IE9

Older IEs serialize html uppercased, but IE9 does not...
Would be better to expect case insensitive, unfortunately jasmine does
not allow to user regexps for throw expectations.

Closes #392
Breaks foo.bar api, foo.baz should be used instead
```