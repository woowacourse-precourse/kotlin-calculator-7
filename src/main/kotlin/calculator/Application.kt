package calculator

fun main() {
    // 입력을 받는 부분
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: throw IllegalArgumentException("문자열은 구분자와 양수로만 이루어져야 합니다.")
}

fun inputString(input: String): Int {
    if (input.isBlank()) return 0

    return input.length
}
