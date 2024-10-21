package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val calculator = StringCalculator()
    if (calculator.isValid(input)) {
        val result = calculator.calculate(input)
        println("결과 : $result")
    } else {
        println("잘못된 입력입니다.")
    }
}

class StringCalculator {
    fun calculate(input: String): Int {
        if (input.isEmpty()) return 0

        val (delimiter, numbers) = customDelimiter(input)
        val tokens = numbers.split(delimiter.toRegex())
        return tokens.sumOf { it.toInt() }
    }

    fun isValid(input: String): Boolean {
        if (input.isEmpty()) return true

        val (delimiter, numbers) = customDelimiter(input)
        val tokens = numbers.split(delimiter.toRegex())
        return tokens.all { it.toIntOrNull() != null }
    }

    private fun customDelimiter(input: String): Pair<String, String> {
        return if (input.startsWith("//")) {
            val parts = input.split("""\n""", limit = 2)
            val delimiter = parts[0].substring(2)
            Pair(delimiter, parts[1])
        } else {
            Pair("[,:]", input)
        }
    }
}
