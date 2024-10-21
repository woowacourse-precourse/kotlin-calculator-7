# kotlin-calculator-precourse

1. 입력값 받기
   - Console.readLine()을 사용하여 사용자 입력 받기
2. 커스텀 구분자 확인
   - 입력값이 "//"로 시작하는지 확인
   - 커스텀 구분자가 있다면 추출하여 저장
3. 구분자를 이용해 문자열 분리
   - 기본 구분자(쉼표, 콜론) 및 커스텀 구분자로 문자열 분리
4. 분리된 문자열을 숫자로 변환
   - 각 문자열을 정수로 변환
   - 잘못된 입력 시 IllegalArgumentException 발생
5. 숫자 합 계산
   - 변환된 숫자들의 합 계산
6. 결과 출력
   - 계산된 합 출력
