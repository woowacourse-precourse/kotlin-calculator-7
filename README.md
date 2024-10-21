# kotlin-calculator-precourse

# 🖥️ 프로그래밍 요구 사항
- Kotlin 1.9.24에서 실행 가능해야 한다.
- Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle.kts 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit() 또는 exitProcess()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 Kotlin Style Guide를 원칙으로 한다.
- 


# 💡구현할 기능
- `덧셈할 문자열을 입력해 주세요.`를 출력한다
- 구분자를 포함한 숫자를 입력받는다.
- 입력 받은 값을 기본구분자(쉼표, 세미콜론)로만 이루어진 값인지 확인한다.
- 입력 받은 값을 커스텀구분자(//, \n사이 문자)로 이루어진 값인지 확인한다.
- 입력 값을 구분자를 바탕으로 숫자를 추출한다.
- 추출된 숫자들을 더한다.
- `결과 : `를 출력한 후, 결과 값을 출력한다.
- 이를 제외한 잘못된 값을 입력한 경우, `IllegalArgumentException`를 발생시킨 후 애플리케이션을 종료한다.

# 👥 객체 생성

## [model]
### - Divider
`isCustom`:
- `inputValue`를 매개변수로 지정한다.
- `//`와 `\n`을 포함하면 `true`를 반환한다.

`isDefault`:
- `inputValue`를 매개변수로 지정한다.
- `isCustom`이 `false`이며 `,`나 `:`를 포함하면 `true`를 반환한다.

### - Calculator
`defaultCal`:
- 기본구분자의 숫자를 추출하여 배열에 저장한다.
- 배열의 모든 숫자들을 `sum()`을 통해 더한 후, `total`변수에 저장한다.
- `errorCheck`메서드가 `true`일 경우 -1를 반환한다.
- `total`를 반환한다.

`customCal`: 
- `inputValue`의 3번째 배열을 `customDivider`로 지정한다.
- `customDivider`를 통해 커스텀구분자의 숫자를 추출하여 배열에 저장한다.
- 배열의 모든 숫자들을 `sum()`을 통해 더한 후, `total`변수에 저장한다.
- `errorCheck`메서드가 `true`일 경우 -1를 반환한다.
- `total`를 반환한다.

`negativeNumberCheck`
- `inputValueList`를 매개변수로 받는다
- `inputValueList`에 음수가 포함되어 있으면 `true`를 반환한다.

### - ErrorCheck
`checkDivider`:
- `inputValue`를 매개변수로 지정한다.
- 기본구분자로 이루어진 값인지 커스텀구분자로 이루어진 값인지 구분한다.
- 기본구분자는 0을 반환한다.
- 커스텀구분자는 1을 반환한다.
- 어느 것도 아니라면 -1를 반환한다.

`negativeNumberCheck`:
- `inputValueList`를 매개변수로 지정한다.
- `inputValueList`의 원소에 음수가 있다면 `true`를 반환한다.

`isNumberCheck`:
- `inputValueList`를 매개변수로 지정한다.
- `inputValueList`에 숫자이외의 값이 있다면 `true`를 반환한다.

## [view]
### - MsgView
`inputMsg`: 
- `덧셈할 문자열을 입력해 주세요.`를 출력한다.


`outputMsg`: 
- `결과 : `와 `result`매개변수를 통해 결과 값을 출력한다.

### - ErrorMsg
`errorMsg`: 
- `IllegalArgumentException`를 발생시킨다.

## [controller]
`run` :
- `result` 변수를 정수타입으로 생성한다.
- `inputMsg`메서드를 호출한다.
- `readLine()`메서드를 호출하여 `inputValue` 변수에 저장한다.
- `checkDivider`메서드를 호출하여 `isCheck` 변수에 저장한다.
- `isCheck`가 0이면 `defaultCal`를 `result`변수에 저장한다.
- `isCheck`가 1이면 `customCal`를 `result`변수에 저장한다.
- `isCheck`가 -1면 `errorMsg`를 호출한다.
- `result`가 -1이면 `errorMsg`를 호출한다.
- `outputMsg`에 `result` 값을 삽입하여 호출한다.


## [constants]
### - Constants
#### 아래와 같이 상수를 정의한다.
- `덧셈할 문자열을 입력해 주세요.` ➡ INPUT_MSG
- `결과 : ` ➡ RESULT_MSG
- `,` ➡ COMMA
- `:` ➡ COLON
- `//` ➡ DOUBLE_SLASH
- `\\n` ➡ DOUBLE_BACKSLASH_N


