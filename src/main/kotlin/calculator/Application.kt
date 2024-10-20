package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println(MESSAGE_FOR_GUIDE_CALCULATE)
    val userInput = readLine()

    checkInputIsEmpty(userInput)

    val separatedValues = getSeparatedValues(userInput)
    checkIsValidValue(separatedValues)
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
    return if (input.startsWith("//") && input.contains("\\n")) {
        val rangeForFindSeparator = 2..3
        SeparatorState.CustomSeparator(input.substring(rangeForFindSeparator))
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

private const val MESSAGE_FOR_GUIDE_CALCULATE = "덧셈할 문자열을 입력해 주세요."
private const val MESSAGE_INPUT_EMPTY = "빈 값을 입력하였습니다."
private const val MESSAGE_INVALID_INPUT = "잘못된 입력입니다"
private const val SEPARATOR_HEADER_LENGTH = 5