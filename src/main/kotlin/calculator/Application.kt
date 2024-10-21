package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun add(input: String): Int {
    if (input.isEmpty()) return 0

    val (delimiter, numbers) = parseInput(input)
    return calculateSum(numbers, delimiter)
}

fun parseInput(input: String): Pair<String, String> =
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

fun calculateSum(numbers: String, delimiter: String): Int {
    if (numbers.isEmpty()) return 0

    val tokens = numbers.split(delimiter.toRegex())
    var sum = 0
    for (token in tokens) {
        if (token.isNotEmpty()) {
            val number = token.toInt()
            sum += number
        }
    }
    return sum
}


fun main() { // test
    println(add("//;\\n1;2;3"))
}