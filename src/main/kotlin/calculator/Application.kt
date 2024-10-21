package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() // 사용자 입력 받기
    try {
        val result = add(input)
        println("결과 : $result") // 결과 출력
    } catch (e: IllegalArgumentException) {
        println("잘못된 입력입니다: ${e.message}")
    }
}

fun add(input: String?): Int {
    if (input.isNullOrEmpty()) return 0

    try {
        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            val parts = input.split("\n", limit = 2)
            val customDelimiter = parts[0].substring(2)
            return parts[1].split(customDelimiter)
                .map { it.toInt() }
                .sum()
        }

        // 기본 구분자 쉼표와 콜론 처리
        val delimiters = "[,:]".toRegex()
        return input.split(delimiters)
            .map { it.toInt() }
            .sum()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("잘못된 입력입니다.")
    }
}
