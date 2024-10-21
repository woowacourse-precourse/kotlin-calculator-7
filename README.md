# kotlin-calculator-precourse

## 구현할 기능 목록

- 문자열을 입력받고 출력받는 역할의 `UserInterface` 구현
- CLI를 통해 사용자와 소통하는 `UserInterface의` 구현체 `CommandLineInterface` 구현
- 커스텀 구분자를 추출하고, 구분자로 문자열을 분리해 양수의 배열로 만드는 `Parser` 구현
- 양수 배열의 총 합을 구하는 `Calculator` 구현

## 생각해볼 것

### 1.커스텀 구분자는 추가되는가, 대체되는가?

> 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.

1. 기본 구분자를 제거하거나 무효화하라는 **언급이 없음**
2. **외**, **지정**이라는 키워드가 대체가 아닌 추가의 느낌을 줌

따라서 기본 구분자 쉼표, 콜론을 지정하고 커스텀 구분자를 **추가하는 방식**을 사용한다.

### 2. 구분자로 지정될 수 없는 문자열이 존재하는가?

- `.`

  해당 문자는 양수 중 **소수를 표현할 때 사용**될 수 있으므로 구분자로 지정하지 못 하도록 한다.

## 설계

### 1. 문자열을 입력받는다.

`UserInterface`의 책임

### 2. 커스텀 구분자가 존재한다면 추가한다.

`Parser`의 책임

### 3. 구분자를 통해 문자열을 분리한다.

`Parser`의 책임

### 4. 분리된 문자열들을 각각 양수로 변환한다.

`Parser`의 책임

### 5. 양수들의 총합을 구한다.

`Calculator`의 책임

### 6. 총합을 출력한다.

`UserInterface`의 책임

## 학습 노트

- `*` 키워드의 역할

  **[Variable number of arguments (varargs)](https://kotlinlang.org/docs/functions.html#variable-number-of-arguments-varargs)

  `vararg`를 인자로 받는 함수에 원시 타입으로 전달하고 싶다면 `*` 연산자를 사용할 수 있다.