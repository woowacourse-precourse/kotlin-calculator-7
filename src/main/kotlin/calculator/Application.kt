package calculator

fun main() {
    // 입력을 받는 부분
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: throw IllegalArgumentException("문자열은 구분자와 양수로만 이루어져야 합니다.")
}

fun calculateString(input: String): Int {
    if (input.isBlank()) return 0

    //기본 구분자
    val delimiters = mutableListOf(",", ":")
    var numbersPart = input

    // 커스텀 구분자 처리
    if (input.startsWith("//")) {
        val parts = input.split("\n", limit = 2)
        if (parts.size < 2) throw IllegalArgumentException("Invalid custom delimiter format")
        val customDelimiter = parts[0].substring(2)
        delimiters.add(customDelimiter)
        numbersPart = parts[1]
    }

    return input.length
}
