package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // 입력 안내 메세지 출력
    println("덧셈할 문자열을 입력해 주세요.")

    // 입력 값 받기
    val input = Console.readLine().trim() // 공백 지우기

    // 처리 계산
    val result = processInput(input)
    println("결과 : $result")
}

// 입력된 값의 구분자를 처리하는 함수
fun processInput(input: String): Int {
    if (input.isEmpty()) return 0 // 입력값이 비어있을 경우 0을 리턴

    // 단일 문자가 숫자인지 확인
    if (input.all { it.isDigit() }) {
        // .all은 모든원소가 조건을 만족, it은 암시적 변수, isDigit은 문자가 숫자인지 판별 true와 false로 반환()
        // .isDigit 쓴 이유는 ApplicationTest에 예외상황 발생에서 -1이 있었기에 음수를 포함하지않는 숫자를 판별할 필요가 있다고 생각했다
        return input.toInt() // 단일 숫자 처리
    }

    // 커스텀 구분자 처리
    if (input.contains("//") && input.contains("""\n""")) {
        val separator =
            input.substring(input.indexOf("//") + 2, input.indexOf("""\n""")) // 커스텀 구분자를 저장하기
        val numbers =
            input.substring(input.indexOf("""\n""") + 2).split(separator) // 커스텀 구분자를 기준으로 잘라서 저장하기

        return sumNumbers(numbers)
    }

    // 기본 구분자 처리
    if (input.contains(",") || input.contains(":")) {
        val numbers = input.split(",", ":")
        return sumNumbers(numbers)
    }

    throw IllegalArgumentException("잘못된 입력입니다")
}

// 합을 계산하는 함수
private fun sumNumbers(numbers: List<String>): Int {
    var sum = 0

    for (num in numbers) {
        if (num.all { it.isDigit() }) {
            sum += num.toInt()
        } else {
            throw IllegalArgumentException("잘못된 값이 포함되어 있습니다: $num")
        }
    }

    return sum
}
