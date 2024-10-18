# kotlin-calculator-precourse
# 문자열 덧셈 계산기

## 🛠️ 기능 목록
1. **기본 덧셈**: 쉼표(`,`) 또는 콜론(`:`)으로 구분된 숫자 더하기
2. **커스텀 구분자**: `//[구분자]\n[숫자들]` 형식으로 커스텀 구분자 사용 가능
3. **숫자가 아닌 입력 에러 처리**: 숫자가 아닌 입력이 있을 경우 `IllegalArgumentException` 예외 발생
4. **구분자 형식 에러 처리**: 잘못된 구분자 형식일 경우 `IllegalArgumentException` 예외 발생
5. **음수 에러 처리**: 음수가 입력된 경우 `IllegalArgumentException` 예외 발생

## 💡 요구 사항
### 기능 요구 사항
- 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다. 
  - `예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6`
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 
- 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항
- 입력: 구분자로 숫자를 분리한 문자열
- 출력: 문자열에서 추출한 숫자의 합
- 예시
    ```
    덧셈할 문자열을 입력해 주세요.
    1,2:3
    결과 : 6
    ```

### 라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
