package calculator

import calculator.Constants.CUSTOM_SEPARATOR_POS
import calculator.Constants.CUSTOM_SEPARATOR_PREFIX
import calculator.Constants.CUSTOM_SEPARATOR_SUFFIX
import calculator.Constants.MESSAGE_FOR_GUIDE_CALCULATE
import calculator.Constants.MESSAGE_INPUT_EMPTY
import calculator.Constants.MESSAGE_INVALID_INPUT
import calculator.Constants.SEPARATOR_HEADER_LENGTH
import camp.nextstep.edu.missionutils.Console.close
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println(MESSAGE_FOR_GUIDE_CALCULATE)
    val userInput = readLine()

    checkInputIsEmpty(userInput)

    val separatedValues = getSeparatedValues(userInput)
    checkIsValidValue(separatedValues)

    val result = getSumOfNumbers(separatedValues)
    println("결과 : $result")
    close()
}

private fun checkInputIsEmpty(input: String) {
    if (input.isEmpty()) throw IllegalArgumentException(MESSAGE_INPUT_EMPTY)
}

private fun getSeparatedValues(input: String): List<String> {
    val rangeForDetermineSeparatorState = 0..4
    val contentForDetermineSeparatorState = input.substring(rangeForDetermineSeparatorState)

    return when (val separatorState = getSeparatorState(contentForDetermineSeparatorState)) {
        is SeparatorState.CustomSeparator -> {
            val separator = separatorState.separator
            val contentToSeparate = input.drop(SEPARATOR_HEADER_LENGTH)
            contentToSeparate.split(separator)
        }

        is SeparatorState.DefaultSeparator -> {
            val separators = arrayOf(separatorState.COLON, separatorState.COMMA)
            input.split(*separators)
        }
    }
}

private fun getSeparatorState(input: String): SeparatorState {
    return if (input.startsWith(CUSTOM_SEPARATOR_PREFIX) && input.contains(CUSTOM_SEPARATOR_SUFFIX)) {
        SeparatorState.CustomSeparator(input[CUSTOM_SEPARATOR_POS])
    } else {
        SeparatorState.DefaultSeparator
    }
}

private fun checkIsValidValue(numbers: List<String>) {
    numbers.forEach {
        if (it.isNotNumeric() or it.isNegativeNumber()) {
            throw IllegalArgumentException(MESSAGE_INVALID_INPUT)
        }
    }
}

private fun getSumOfNumbers(numbers: List<String>): Int {
    return numbers.sumOf { it.toInt() }
}