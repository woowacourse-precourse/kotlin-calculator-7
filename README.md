# 우테코 프리코스 1주차 - 문자열 덧셈 계산기
## ⚙️ 기능 목록 정리

입력한 문자열에서 숫자를 추출하여 더하는 **문자열 덧셈 계산기**를 구현

### 1. **기본 구분자 사용**
쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.

#### 📌 예시
- `""` → `0`
- `"1,2"` → `3`
- `"1,2,3"` → `6`
- `"1,2:3"` → `6`

<br/>

### 2. **커스텀 구분자 지정**
앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.  
`커스텀 구분자`: 문자열 앞부분의 "//" 와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

#### 📌 예시
- `"//;\n1;2;3"` → `6`  
  _(커스텀 구분자는 세미콜론(`;`))_

<br/>

### 3. **예외 처리**
사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨 후 애플리케이션은 종료되어야 한다.
