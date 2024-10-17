package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator {
    private val validator: Validator = Validator()
    private val separator: Separator = Separator()

    private var result = 0

    fun turnOnCalculator() {
        println("덧셈할 문자열을 입력해 주세요.")
        val inputString: String = Console.readLine()
        val isInputStringEmpty: Boolean = validator.isInputStringEmpty(inputString)

        when (isInputStringEmpty) {
            true -> {
                println("결과 : 0")
                return
            }

            false -> useCalculator(inputString)
        }
    }

    private fun useCalculator(inputString: String) {
        val isDeclareCustomSeparator: Boolean = separator.isCustomSeparator(inputString)
        when (isDeclareCustomSeparator) {
            true -> {
                val separatedInputFromSeparator: List<String> =
                    inputString.drop(5).split(
                        separator.colonSeparator,
                        separator.commaSeparator,
                        separator.customSeparator ?: "",
                    ).map { it }

                val separatedInputNumber: List<Int> = separatedInputFromSeparator
                    .filter { it.matches(Regex("\\d")) }
                    .map { it.toInt() }

                addInputNumbers(separatedInputNumber)
            }

            false -> {
                val separatedInputFromSeparator: List<String> =
                    inputString.split(separator.colonSeparator, separator.commaSeparator).map { it }

                val separatedInputNumber: List<Int> = separatedInputFromSeparator
                    .filter { it.matches(Regex("\\d")) }
                    .map { it.toInt() }

                addInputNumbers(separatedInputNumber)
            }
        }
    }

    private fun addInputNumbers(inputNumbers: List<Int>) {
        inputNumbers.map { result += it }

        println("결과 : $result")
    }
}