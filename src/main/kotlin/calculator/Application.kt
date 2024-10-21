package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val result = when {
        input.isBlank() -> 0
        input[0].isDigit() || input[0] == ',' || input[0] == ':' -> getDefaultDelimiter(input)
        else -> {}
    }
}

fun getDefaultDelimiter(input: String): Int {
    return input.split(",", ":").calculateSum()
}

fun List<String>.calculateSum(): Int {
    return sumOf { number ->
        number.toIntOrNull() ?: throw IllegalArgumentException()
    }
}
