package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val result = when {
        input.isBlank() -> 0
        input[0].isDigit() || input[0] == ',' || input[0] == ':' -> getDefaultDelimiter(input)
        input.startsWith("//") -> getCustomDelimiter(input)
        else -> throw IllegalArgumentException()
    }

    println("결과 : $result")
}

fun getCustomDelimiter(input: String): Int {
    val segments = input.split("\\n")
    if (segments.size != 2) throw IllegalArgumentException()

    val customDelimiter = segments[0].substring(2)
    if (customDelimiter.isEmpty()) throw IllegalArgumentException()

    return segments[1].ifEmpty { return 0 }
        .split(customDelimiter)
        .calculateSum()
}

fun getDefaultDelimiter(input: String): Int {
    return input.split(",", ":").calculateSum()
}

fun List<String>.calculateSum(): Int {
    return sumOf { number ->
        number.toIntOrNull() ?: throw IllegalArgumentException()
    }
}
