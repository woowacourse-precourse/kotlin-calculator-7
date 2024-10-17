# kotlin-calculator-precourse

---

## 기능목록

---

### 1. 사용자에게 안내글을 출력한다.

- 이유 : 사용자에게 입력을 유도할려면 안내글이 나가야하므로 이 기능을 구현해야 합니다.
- Main 클래스, “덧셈할 문자열을 입력해 주세요.”는 MessageConst 클래스 안에 작성

### 2. 사용자로부터 문자열을 입력 받는다.

- 이유 : 프로그램은 사용자 입력을 받아 계산을 수행해야 하므로 이 기능을 구현해야 합니다.
- 프로그래밍 요구 사항인 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
- Main 클래스 안에 작성

### 3. 커스텀 구분자 지정

- 이유 : 쉼표나 콜론 구분자로 데이터를 먼저 분리하면, 데이터가 오염이 된다고 생각했습니다. 이 때문에 커스텀 구분자를 먼저 찾을 것입니다.
- Delimiter 클래스 안에 작성

### 4. 커스텀 구분자가 있다면 삭제한다.

- 이유 : 더이상 커스텀 구분자를 정의하는 문자열은 필요가 없기 때문에 문자열에서 삭제해야 하므로 이 기능을 구현해야 합니다.
- Custom Delimiter 클래스 안에 작성

### 5. 커스텀 구분자로 문자를 분리한다.

- 이유 : 구분자라는 것이 각 문자 사이에 경계라고 생각했습니다. 숫자의 합을 구하기 전, 구분자로 데이터를 분리를 할 것입니다.
- Delimiter 클래스 안에 작성

### 6. 쉼표(,) 구분자로 문자를 분리한다.

- 이유 : 위와 동일합니다.
- Delimiter 클래스 안에 작성

### 7. 콜론(:) 구분자로 문자를 분리한다.

- 이유 : 위와 동일합니다.
- Delimiter 클래스 안에 작성

### 8. 입력 문자열이 빈 문자로 이루어진 경우, 0으로 반환

- 이유 : 기능 요구 사항에 예시로 `""` 입력 시 결과는 `0`이라고 명시되어 있으므로 이 기능을 구현해야 합니다.
- Validator 클래스 안에 작성

### 9. **입력 문자열이 유효하지 않은 경우 `IllegalArgumentException`을 발생**

- 이유 : 입력 요구 사항에 “구분자와 양수로 구성된 문자열”이라고 명시되어 있습니다. 하지만, 프로그래밍 요구 사항인 readLine()으로는 알파벳, 숫자, 공백, 빈 입력, 특수문자, 이모지, 유니코스, escape 문자, 조합형 문자가 들어 옵니다. 입력 요구 사항에 있는 것 빼고 다른 것은 **`IllegalArgumentException` 가 발생해야합니다. 다만, 빈 문자열인 경우 예시에서 “” → 0 이라고 명시했기 때문에, 양수와 빈 문자열만 허용합니다.**
- Validator 클래스 안에 작성
- **`IllegalArgumentException`을 발생할** 예시
  - 음수가 포함된 경우
  - 0이 포함된 경우
  - 문자가 포함된 경우
  - 특수 문자가 포함된 경우
  - 공백 문자가 포함된 경우
  - 이모지가 포함된 경우
  - 유니코드 문자가 포함된 경우
  - 조합형 문자가 포함된 경우
  - escape 문자가 포함된 경우

### 10. 문자를 숫자로 변환

- 이유 : 기능 요구 사항에 따라 계산 결과를 합산을 해야 하므로 이 기능을 구현해야 합니다.
- Calculator 클래스 안에 작성

### 11. 숫자를 합산

- 이유 : 기능 요구 사항에 따라 계산 결과를 출력해야 하므로 이 기능을 구현해야 합니다.
- Calculator 클래스 안에 작성

### 12. 합산의 결과를 출력하고 애플리케이션을 종료

- 이유 : 기능 요구 사항에 `결과 : 6` 명시되어 있으므로 이 기능을 구현해야 합니다.
- Main 클래스, “결과 :”는 MessageConst 클래스 안에 작성
