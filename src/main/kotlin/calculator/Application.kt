package calculator

// 1. 문자열 검사
fun checkString(input: String?): Boolean {
    // 입력값이 null인 경우 예외 발생
    if (input == null) {
        throw throw IllegalArgumentException("ERROR: IllegalArgumentException")
    }

    // 문자열에 숫자가 있는지 검사
    return if (input.any() { it.isDigit() }) {
        true
    } else {
        throw IllegalArgumentException("ERROR: IllegalArgumentException")
    }
}


fun main() {
    // TODO: 프로그램 구현
    // variable
    var firstCheck = false

    // 입력값 요청
    val input = readlnOrNull()

    // 1. 문자열 검사
    if (checkString(input)) {
        firstCheck = true
    }
    // 최종 출력의 형태: "결과 : n"
}
