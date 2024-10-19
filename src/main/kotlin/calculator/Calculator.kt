package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator {
    var separators = mutableListOf(':', ',')
    private var result = 0L
    private var splitInput = listOf<String>()

    fun start() {
        printInput()

        val input = Console.readLine()

        splitInput = if (customSeparatorCheck(input)) {
            customSeparatorSplit(input)
        } else {
            defaultSeparatorSplit(input)
        }
        splitInputValidationCheck(splitInput)

        result = calculate(splitInput)
    }

    private fun printInput() = println(INPUT_MESSAGE)

    fun customSeparatorCheck(input: String): Boolean {
        if (input.startsWith("//")) {
            val newLineIndex = input.indexOf("\\n")

            if (newLineIndex == -1) throw IllegalArgumentException(ERROR_MESSAGE)

            val customSeparator = input.substring(2, newLineIndex)
            if (customSeparator.length != 1) throw IllegalArgumentException(ERROR_MESSAGE)

            if (customSeparator[0].isDigit()) throw IllegalArgumentException(ERROR_MESSAGE)

            separators.add(customSeparator[0])
            return true
        }
        return false
    }

    fun customSeparatorSplit(input: String): List<String> {
        return input.substring(5).split(*separators.toCharArray())
    }

    fun defaultSeparatorSplit(input: String): List<String> {
        return input.split(":", ",")
    }

    fun splitInputValidationCheck(splitInput: List<String>) {
        require(splitInput.all {
            if (it.isBlank()) true
            else {
                val number = it.toLongOrNull() ?: throw IllegalArgumentException(ERROR_MESSAGE)
                number > 0
            }
        }) { IllegalArgumentException(ERROR_MESSAGE) }
    }

    fun calculate(splitInput: List<String>): Long {
        return splitInput.sumOf { if (it.isBlank()) 0 else it.toLong() }
    }

    companion object {
        const val INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
        const val ERROR_MESSAGE = "잘못된 입력값입니다."
    }
}