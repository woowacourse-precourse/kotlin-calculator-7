# kotlin-calculator-precourse
# ✅ 구현할 기능 목록

---
### 문자열 입력
+ 문자열 입력 받기
+ 문자열에서 Int나 Long을 넘어가는 숫자를 넘어가는 걸 방지 위해 BigDecimal을 사용
### 구분자 처리
+ 문자열에서 구분자 찾기
+ 기본 구분자가 있으면 문자열에서 구분자를 추출하고 해당 구분자를 사용하여 파싱
+ "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
### 숫자 추출 및 덧셈
+ 분리된 문자열을 정수로 변환
+ 변환된 숫자들을 합하여 결과를 냄
### 유효성 체크 기능
+ 입력값이 비어 있는 경우 0을 반환
+ 숫자가 포함되어 있지 않은 경우 예외 처리
+ 숫자가 아닌 값이 포함된 경우 예외 처리 
+ 음수가 포함된 경우 예외 처리 
### 예외 처리 기능
+ IllegalArgumentException을 발생시켜 에러 메시지와 함께 프로그램을 종료
### 결과 출력 기능
+ 계산된 결과 값을 사용자에게 보여줌

---

## 🚀과제 진행 요구 사항
+ 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.
+ 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
+ Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
+ AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
+ 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

---

## 🎯프로그래밍 요구 사항
+ Kotlin 1.9.24에서 실행 가능해야 한다.
+ Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
+ 프로그램 실행의 시작점은 Application의 main()이다.
+ build.gradle.kts 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
+ 프로그램 종료 시 System.exit() 또는 exitProcess()를 호출하지 않는다.
+ 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
+ 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
+ 기본적으로 Kotlin Style Guide를 원칙으로 한다.

### 라이브러리
+ camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
+ 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
