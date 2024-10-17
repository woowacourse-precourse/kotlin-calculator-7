package calculator

import kotlin.IllegalArgumentException

class Calculator {

    fun calculate(input: String) {
        val splitInput = input.split(",", ":")
        validateInput(splitInput)
        printResult(splitInput.sumOf { it.toInt() })
    }

    fun calculateCustom(input: String) {
        val (customSeparator, customInput) = input
            .split("//", "\\n")
            .filter { it.isNotEmpty() }
        validateInputCustom(customSeparator, customInput)
        val splitInput = customInput.split(customSeparator)
        printResult(splitInput.sumOf { it.toInt() })
    }

    private fun validateInput(splitInput: List<String>) {
        splitInput.forEach {
            // 값이 구분자로 나누어지지 않았을 경우
            if (it.toBigIntegerOrNull() == null) throw IllegalArgumentException("입력된 값이 잘못됐습니다.")
            // 입력된 값이 음수일 경우
            if (it[0] == '-') throw IllegalArgumentException("입력된 값이 잘못됐습니다.")
        }
    }

    private fun validateInputCustom(customSeparator: String, customInput: String) {
        // 커스텀 문자가 여러개일 경우
        if (customSeparator.length != 1) throw IllegalArgumentException("커스텀 문자 입력이 잘못되었습니다")
        // 커스텀 문자가 문자가 아닐 경우
        if (customSeparator.first().isDigit()) throw IllegalArgumentException("커스텀 문자 입력이 잘못되었습니다")

        validateInput(customInput.split(customSeparator))
    }

    private fun printResult(result: Int) {
        println("결과 : $result")
    }
}