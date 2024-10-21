package calculator

import camp.nextstep.edu.missionutils.Console

class StringAdditionCalculator {
    fun runCalculator() {
        println("덧셈할 문자열을 입력해 주세요.")
        val inputText = Console.readLine()

        if (inputText.isBlank()) {
            throw IllegalArgumentException(EMPTY_STRING_ERROR)
        }
        val sum = calculateSum(inputText)
        println("결과 : $sum")
    }

    private fun calculateSum(inputText: String): Int {
        if (inputText.isBlank()) {
            throw IllegalArgumentException(EMPTY_STRING_ERROR)
        }

        val parser = InputTextDivider()
        val (numbers, delimiters) = parser.divideInputText(inputText)

        val numberList = parser.divideNumbers(numbers, delimiters)

        val validator = NumberValidator()
        return validator.sumValidNumbers(numberList)
    }

    companion object {
        private const val EMPTY_STRING_ERROR = "빈 문자열은 입력할 수 없습니다."
    }
}