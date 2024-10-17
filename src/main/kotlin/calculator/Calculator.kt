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

                validateSeparatedInputString(separatedInputFromSeparator)

                val separatedInputNumber: List<Int> = separatedInputFromSeparator
                    .filter { it.matches(Regex("\\d")) }
                    .map { it.toInt() }

                addInputNumbers(separatedInputNumber)
            }

            false -> {
                val separatedInputFromSeparator: List<String> =
                    inputString.split(separator.colonSeparator, separator.commaSeparator).map { it }

                validateSeparatedInputString(separatedInputFromSeparator)

                val separatedInputNumber: List<Int> = separatedInputFromSeparator
                    .filter { it.matches(Regex("\\d")) }
                    .map { it.toInt() }

                addInputNumbers(separatedInputNumber)
            }
        }
    }

    private fun validateSeparatedInputString(separatedInputFromSeparator: List<String>) {
        val isNegativeNumber: Boolean = separatedInputFromSeparator.any { it.contains("-") }
        val isAnySeparatedInputFromSeparator: Boolean = separatedInputFromSeparator.any { it.isBlank() }
        val isWrongSeparator: Boolean =
            separatedInputFromSeparator.any { !it.matches(Regex("\\d")) }

        if (isNegativeNumber) {
            throw IllegalArgumentException("음수는 포함될 수 없습니다.")
        }
        if (isAnySeparatedInputFromSeparator) {
            throw IllegalArgumentException("숫자를 입력해야 합니다.")
        }
        if (isWrongSeparator) {
            throw IllegalArgumentException("잘못된 구분자입니다.")
        }
    }

    private fun addInputNumbers(inputNumbers: List<Int>) {
        inputNumbers.map { result += it }

        println("결과 : $result")
    }
}