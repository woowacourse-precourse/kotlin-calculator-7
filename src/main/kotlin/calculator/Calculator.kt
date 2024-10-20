package calculator

import camp.nextstep.edu.missionutils.Console

enum class CalculatorType {
    STANDARD, CUSTOM
}

class Calculator {
    private val separator: Separator = Separator()

    fun startCalculator() {
        println(CALCULATOR_INPUT_GUIDE_MESSAGE)
        val inputData: String = Console.readLine()

        if (inputData.isEmpty()) {
            println("$CALCULATOR_OUTPUT_MESSAGE $EMPTY_RESULT")
        } else {
            checkCalculatorType(inputData)
        }
    }

    private fun checkCalculatorType(inputData: String) {
        val calculateType: CalculatorType = separator.checkCustomSeparator(inputData)

        val splitResult = when (calculateType) {
            CalculatorType.STANDARD -> {
                separator.splitStandardSeparator(inputData)
            }

            CalculatorType.CUSTOM -> {
                separator.splitCustomSeparator(inputData)
            }
        }

        printCalculateResult(splitResult)
    }

    private fun printCalculateResult(splitResult: List<String>) {
        val sumResult = splitResult.sumOf { data -> data.toInt() }
        println("$CALCULATOR_OUTPUT_MESSAGE $sumResult")
    }

    companion object {
        const val CALCULATOR_INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요."
        const val CALCULATOR_OUTPUT_MESSAGE = "결과 :"
        const val EMPTY_RESULT = 0
    }
}