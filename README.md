# kotlin-calculator-precourse

## calculator 기능 목록

1. **입력 받기** :
   - `Console.readLine()`을 사용하여 입력된 문자열을 저장

2. **입력 값 처리** :
   - 입력 값이 비어있을 경우, 0을 반환

3. **커스텀 구분자 추출 (extractCustomSeparator)** :
   - 문자열 앞부분을 확인하여 커스텀 구분자 유무를 확인
   - 1. `//`와 `\n`사이의 단일 문자인지
   - 2. 한 글자인지
   - 3. 기본 구분자(쉼표, 콜론)가 아닌지
   - 4. 숫자가 아닌지
   - 확인하고 이 조건들 중 하나라도 만족하지 않으면 `IllegalArgumentException` 발생

4. **구분자를 기준으로 숫자 분리 (splitNumbers)** :
   - 기본 또는 커스텀 구분자를 기준으로 입력 문자열을 숫자들로 분리

5. **숫자 합산 (sumNumbers)** :
   - 각 숫자를 `Long` 타입으로 변환하여 합산
   - 음수가 포함되어 있으면 `IllegalArgumentException`을 발생
   - 숫자가 아닌 문자열이 포함되어 있으면 `IllegalArgumentException`을 발생