package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: ""
    try {
        validateLastCharacter(input)
        val result = add(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println(e.message)
        throw e
    }
}

fun validateLastCharacter(input: String) {
    if (input.isNotEmpty() && !input.last().isDigit()) {
        throw IllegalArgumentException("입력된 문자열의 마지막 글자는 숫자여야 합니다.")
    }
}

fun add(input: String): Int {
    if (input.isEmpty()) return 0

    val (delimiter, numbers) = parseInput(input)
    return calculateSum(numbers, delimiter)
}

private fun parseInput(input: String): Pair<String, String> =
    if (input.startsWith("//")) {
        val parts = input.split("\\n", limit = 2)
        if (parts.size != 2 || parts[0].length < 3) {
            throw IllegalArgumentException("입력값이 올바르지 않습니다.")
        }
        val customDelimiter = Regex.escape(parts[0].substring(2))
        customDelimiter to parts[1]
    } else {
        ",|:" to input
    }

private fun calculateSum(numbers: String, delimiter: String): Int {
    if (numbers.isEmpty()) return 0

    val tokens = numbers.split(delimiter.toRegex())
    var sum = 0
    for (token in tokens) {
        if (token.isNotEmpty()) {
            val number = token.toIntOrNull()
                ?: throw IllegalArgumentException("입력값이 올바르지 않습니다.")
            if (number < 0) {
                throw IllegalArgumentException("음수는 허용되지 않습니다.: $number")
            }
            sum += number
        }
    }
    return sum
}
