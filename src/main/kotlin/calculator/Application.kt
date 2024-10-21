package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val userInput = Console.readLine()

    val result = try {
        when {
            userInput.isBlank() -> 0
            userInput.startsWith("//") -> extractCustomDelimiter(userInput)
            userInput[0].isDigit() || userInput[0] == ',' || userInput[0] == ':' -> extractDefaultDelimiter(userInput)
            else -> throw IllegalArgumentException()
        }
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException()
    }

    println("결과 : $result")
}

fun extractCustomDelimiter(userInput: String): Int {
    val segments = userInput.split("\\n")
    if(segments.size != 2) throw IllegalArgumentException()

    val customDelimiter = segments[0].substring(2)
    if(customDelimiter.isEmpty()) throw IllegalArgumentException()

    return segments[1].ifEmpty{ return 0 }
        .split(customDelimiter)
        .calculateSum()
}

fun extractDefaultDelimiter(userInput: String): Int {
    return userInput.split(",", ":")
        .calculateSum()
}

fun List<String>.calculateSum(): Int {
    return sumOf {number ->
        number.toIntOrNull() ?: throw IllegalArgumentException()
    }
}