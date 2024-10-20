# [우테코 프리코스] 문자열 덧셈 계산기

## 🚀 미션 설명
- 문자열을 입력받아 구분자와 커스텀 구분자를 사용해 숫자를 추출하여 합을 구하는 간단한 덧셈 계산기
 
## ✒️ 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
 
## 🖨️ 입출력 요구 사항
### 입력
- 구분자와 양수로 구성된 문자열
### 출력
- 덧셈 결과
```
결과 : 6
```
### 실행 결과 예시
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```
 
## 🧷 추가적으로 정의한 사항
- "문자"는 "Char타입으로 저장이 가능한 것"으로 제한한다.
  - Char타입에 저장이 불가능한 "🍪", "👀"와 같은 길이가 2 이상인 이모지는 입력이 불가능하다.
  - Char타입에 저장이 가능한 '⚽', '☕' 같은 길이가 1인 이모지는 입력이 가능하다.
  - Char타입에 저장이 가능한 숫자('1'), 공백(' '), 마이너스 기호('-') 등의 입력이 가능하다.
- 커스텀 구분자는 "문자"이므로 단 1개만 지정이 가능하다.
- 커스텀 구분자를 식별하기 위한 `// \n`를 포함한 5자리 문자열을 **커맨드**로 정의한다.
- "양수"는 음수, 0을 제외한 정수와 실수를 의미한다.
- 입력값이 없는 경우를 허용하며 0을 출력한다.
 
## 🛠️구현할 기능 목록

1. 제공된 콘솔 API를 이용하여 문자열 입력 받기
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

2. 커맨드를 검증하여 구분자 Set 생성
    - 기본 구분자 ,와 :을 구분자 Set에 추가하기
        - 커맨드를 검증한 뒤 정상 커맨드일 경우 커스텀 구분자를 구분자 Set에 추가하기

3. 구분자를 이용해 슬라이싱 하여 합을 구하고 출력하기
    - 2번에서 구한 구분자를 이용해 구분자를 제외한 문자열의 분할
    - 양의 정수만 존재하는 경우와 양의 실수가 포함된 경우를 판별
        - 각각 Int와 Double형으로 분할된 문자열을 변환한 뒤 합산

4. 잘못된 입력을 예외 처리하기
    - `IllegalArgumentException`을 발생시키고 애플리케이션 종료하기
    - 에외 검사목록
        - 커맨드를 제외한 전체 입력값은 숫자로 시작하거나 끝났는가
        - 각 구분자가 입력 가능한 숫자 사이에 입력되었는가
        - 구분자로 끊어진 각각의 수는 .으로 시작하거나 끝나지 않았는가
        - 구분자로 지정되지 않은 문자가 입력되지 않았는가
        - 양수만 입력되었는가 (0 또는 0.0이 입력되지 않았는가)
 
## 📝테스트
- test/kotlin/calculator/ExceptionTest.kt에서 예외 입력값 테스트를 수행할 수 있다.
- test/kotlin/calculator/NormalInputTest.kt에서 정상 입력값 테스트를 수행할 수 있다.
 
## ⚙️ 프로젝트 요구사항
- Intellij Kotlin 1.9.24 환경에서 불러올 수 있다.
- Java 코드가 아닌 Kotlin 코드로만 구현되어 있다.
- build.gradle.kts 파일은 변경하지 않았으며, 제공된 [camp.nextstep.edu.missionutils](https://github.com/woowacourse-projects/mission-utils/tree/main/src/main/java/camp/nextstep/edu/missionutils)라이브러리만 사용한다.
- 프로그램 종료 시 System.exit() 또는 exitProcess()를 호출하지 않는다.
- 프로그래밍 요구 사항의 명시가 없을경우 파일, 패키지 등의 이름 변경과 이동을 하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Kotlin Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/kotlin)를 원칙으로 한다.
 
## 📕 라이브러리
- [camp.nextstep.edu.missionutils](https://github.com/woowacourse-projects/mission-utils/tree/main/src/main/java/camp/nextstep/edu/missionutils)에서 제공하는 Console API를 사용하였다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용하였다.
 