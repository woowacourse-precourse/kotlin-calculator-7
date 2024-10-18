package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator {
    private val separator: Separator = Separator()

    private var result = 0

    fun turnOnCalculator() {
        println("덧셈할 문자열을 입력해 주세요.")
        val inputString: String = Console.readLine()

        when (inputString.isEmpty()) {
            true -> {
                result = 0
                showResult()
                return
            }

            false -> operateCalculatorLogic(inputString)
        }
    }

    private fun operateCalculatorLogic(inputString: String) {
        val isDeclareCustomSeparator: Boolean = separator.isCustomSeparator(inputString)

        when (isDeclareCustomSeparator) {
            true -> operateCalculatorWithCustomSeparatorLogic(inputString)
            false -> operateCalculatorWithDefaultSeparatorLogic(inputString)
        }
    }

    private fun operateCalculatorWithCustomSeparatorLogic(inputString: String) {
        val separatedInputFromSeparator: List<String> =
            inputString.drop(Separator.CUSTOM_SEPARATOR_DECLARE_LENGTH).split(
                separator.colonSeparator,
                separator.commaSeparator,
                separator.customSeparator ?: "",
            ).map { it }

        val separatedInputNumber: List<Int> = separatedInputFromSeparator
            .filter { it.matches(DIGIT_REGEX) }
            .map { it.toInt() }

        validateSeparatedInputString(separatedInputFromSeparator)
        addInputNumbers(separatedInputNumber)
    }

    private fun operateCalculatorWithDefaultSeparatorLogic(inputString: String) {
        val separatedInputFromSeparator: List<String> =
            inputString.split(separator.colonSeparator, separator.commaSeparator).map { it }

        val separatedInputNumber: List<Int> = separatedInputFromSeparator
            .filter { it.matches(DIGIT_REGEX) }
            .map { it.toInt() }

        validateSeparatedInputString(separatedInputFromSeparator)
        addInputNumbers(separatedInputNumber)
    }

    private fun validateSeparatedInputString(separatedInputFromSeparator: List<String>) {
        val isNegativeNumber: Boolean = separatedInputFromSeparator.any { it.contains(NEGATIVE_NUMBER_SIGN) }
        val isAnySeparatedInputFromSeparator: Boolean = separatedInputFromSeparator.any { it.isBlank() }
        val isWrongSeparator: Boolean = separatedInputFromSeparator.any { !it.matches(DIGIT_REGEX) }

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
        showResult()
    }

    private fun showResult() {
        println("결과 : $result")
    }

    companion object {
        private const val NEGATIVE_NUMBER_SIGN: String = "-"
        private val DIGIT_REGEX = Regex("\\d+")
    }
}