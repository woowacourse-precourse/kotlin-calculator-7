# 문자열 덧셈 계산기

## **요구 사항**

- **최종 결과물 : 입력한 문자열에서 숫자를 추출하여 더하는 계산기**
- **필요한 로직**
    - **문자열 입력 받기** : `camp.nextstep.edu.missionutils.Console` API의 `readLine()` 메소드 활용한다.
    - **입력 받은 문자열에서 숫자를 추출하기**
    - **추출한 숫자를 더한값 출력하기**
- 추가 기능 요구 사항
    - **구분자 : 쉼표(,), 콜론(:), 커스텀 구분자**(문자열 맨 앞 부분의 "//"와 "\n" 사이에 위치하는 문자)
    - **IllegalArgumentException** : 사용자가 잘못된 값을 입력할 경우 프로그램 종료. 단, 프로그램 종료 시 `System.exit()` 또는 `exitProcess()`를 호출하지 않는다.
- 입출력 요구 사항
    - 입력 : **구분자**와 **양수**로 구성된 문자열 → 해당 입력 양식이 아니면 IllegalArgumentException
    - 출력 : **덧셈** 결과
```kotlin
덧셈할 문자열을 입력해 주세요. 
1,2:3
결과 : 6
``` 
<br>

## **구현할 기능 목록(feat)**

1. 문자열 입력 받기 
2. 숫자 추출 - 기본 구분자(**쉼표(,), 콜론(:)**)
3. 숫자 추출 - 커스텀 구분자
4. 문자열 예외처리
5. 더한 결과 값 출력

<br>

## **예외 처리**
1. 구분자로 구분된 숫자값이 양수가 아닐 때
2. 커스텀 구분자 양식이 아닐때
3. 문자열에 공백을 포함하여 커스텀 구분자가 아니거나 기본 구분자(;,)가 아닌 문자열이 포함되어 있을 때

**IllegalArgumentException 예외가 발생하며 프로그램이 종료된다.**

<br>

1. 구분자로 구분된 숫자값이 양수일 때
2. 구분자가 기본 구분자(;,)이거나 커스텀구분자(//**\n)일 때
3. 기본 구분자와 커스텀 구분자가 섞여 있을 때
   
**IllegalArgumentException 예외는 발생하지 않는다.**
