# 🔖 우아한테크코스 7기 1주차 프리코스 - 문자열 덧셈 계산기

***

## 📃 Info
- 입력된 문자열에서 숫자를 추출하여 더하는 계산기 구현하기

***

## 🛠️ Funtion
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - Ex) "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
      
      -> 빈 문자열 입력시 0 출력, 음수 입력시 throw IllegalArgumentException()
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - Ex) "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
      
      -> 기본 구분자 '외에' -> 기본 구분자에 커스텀 구분자 추가하기
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
  
  -> 예외처리 -> throw IllegalArgumentException()
  
  -> 예외처리 -> 1. 숫자 오류(숫자가 아닌 값 입력), 2. 음수 오류(숫자지만 양수가 아닌 값 입력), 3. 구분자 입력 오류(구분자 list에 없는 구분자 입력)
  
***

## 📺 View
- Input
  > 구분자와 양수로 구성된 문자열

- Output
  > 덧셈할 문자열을 입력해 주세요.
  > 
  > 1,2:3
  > 
  > 결과: 6

- 실제 코드 구현
    - 기본 문자열 계산 결과
  
    >![](https://velog.velcdn.com/images/seoyoun8694/post/2d81668e-a2a2-427c-894c-9c0bd64eabb2/image.jpg)
    ![](https://velog.velcdn.com/images/seoyoun8694/post/3acfb7d5-16e1-4395-8df3-3622313856cb/image.jpg)
    ![](https://velog.velcdn.com/images/seoyoun8694/post/af9492d7-1682-4607-8178-bfb8ba8e5fc1/image.jpg)

    - 커스텀 구분자가 있는 문자열 계산 결과

    >![](https://velog.velcdn.com/images/seoyoun8694/post/c638661a-b1f8-42c0-b338-5a4fd9f8efcd/image.jpg)
    ![](https://velog.velcdn.com/images/seoyoun8694/post/e71ac481-c337-40d4-8e10-34c319e571d5/image.jpg)

***

## ⚙️ Requirements
- Kotlin 1.9.24에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle.kts` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()` 또는 `exitProcess()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 Kotlin Style Guide를 원칙으로 한다.

***

## 📘 Library
- `camp.nextstep.edu.missionutils`에서 제공하는 `Console API`를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

***

## 🔗 Velog
- https://velog.io/@seoyoun8694/%EC%9A%B0%ED%85%8C%EC%BD%94-7%EA%B8%B0-1%EC%A3%BC%EC%B0%A8-%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-%ED%9A%8C%EA%B3%A0
