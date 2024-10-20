# Kotlin Calculator Precourse

## 구현할 기능 목록
1. 문자열에서 구분자 분리
    - [x] 기본 구분자 `,` 또는 `:`
        - 예: `"1,2"`는 `1`과 `2`로 분리됩니다.
    - [x] 커스텀 구분자 `//{커스텀}\n`
        - 예: `"//;\n1;2;3"`는 세미콜론(`;`)을 구분자로 사용합니다.
    - [x] 위 2개 외 다른 입력이 들어가면 `IllegalArgumentException` 발생 후 프로그램이 오류 메시지를 출력합니다.
2. 문자열에서 숫자 추출
    - [x] 입력된 문자열에서 기본 구분자나 커스텀 구분자를 기준으로 숫자를 추출합니다.
    - [x] toIntOrNull()을 사용하여 문자열을 정수로 변환하며, 변환할 수 없는 경우 `IllegalArgumentException`을 발생시킵니다.
3. 더하기
    - [x] 모든 숫자의 합을 계산하여 반환

## 프로그래밍 요구 사항
- [x] Kotlin 1.9.24에서 실행 가능해야 한다.
- [x] Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- [x] 프로그램 실행의 시작점은 Application의 `main()`이다.
- [x] `build.gradle.kts` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 프로그램 종료 시 `System.exit()` 또는 `exitProcess()`를 호출하지 않는다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x] Kotlin 코드 컨벤션을 지키면서 프로그래밍한다.
- [x] 기본적으로 Kotlin Style Guide를 원칙으로 한다.
- [x] camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 예제
- 입력: `""` → 출력: `0`
- 입력: `"1,2"` → 출력: `3`
- 입력: `"//;\n1;2;3"` → 출력: `6`

