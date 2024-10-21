package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val calculator = StringCalculator()

    try {
        calculator.isValid(input)
        val result = calculator.calculate(input)
        println("결과 : $result")
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
    }
}

class StringCalculator {
    fun calculate(input: String): Int {
        if (input.isEmpty()) return 0

        val (delimiter, numbers) = customDelimiter(input)
        val tokens = numbers.split(delimiter.toRegex())

        return tokens.sumOf { it.toInt() }
    }

    fun isValid(input: String) {
        if (input.isEmpty()) return

        val (delimiter, numbers) = customDelimiter(input)
        val tokens = numbers.split(delimiter.toRegex())

        tokens.forEach {
            it.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력값이 포함되어 있습니다: $it")
        }

        val minusNum = tokens.map { it.toInt() }.filter { it < 0 }
        if (minusNum.isNotEmpty()) {
            throw IllegalArgumentException("음수는 허용되지 않습니다.: $minusNum")
        }
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