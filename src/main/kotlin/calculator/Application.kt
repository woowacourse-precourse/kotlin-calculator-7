package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: ""

    try {
        val result = add(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun add(input: String): Int {
    if (input.isEmpty()) return 0

    var delimiters = listOf(",", ":")
    var numbers = input

    // 입력 문자열이 "//"로 시작하는 경우
    if (input.startsWith("//")) {
        val customDelimiter = input[2].toString()
        delimiters = delimiters + customDelimiter

        numbers = input.substring(5)
    }

    val tokens = numbers.split(*delimiters.toTypedArray())

    val sum = tokens.map {
        it.toIntOrNull() ?: throw IllegalArgumentException("Error")
    }.sum()

    return sum
}
