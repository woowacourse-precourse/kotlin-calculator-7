package calculator

import calculator.ErrorMessages.CUSTOM_SEPARATOR_NOT_PROVIDED
import calculator.ErrorMessages.INVALID_CHARACTER
import calculator.ErrorMessages.INVALID_CUSTOM_FORMAT
import calculator.ErrorMessages.NUMBER_NOT_PROVIDED
import camp.nextstep.edu.missionutils.Console

const val CUSTOM_PREFIX = "//"
const val CUSTOM_SUFFIX = "\\n"

fun main() {
    print("덧셈할 문자열을 입력해 주세요.\n")
    val originInput: String = Console.readLine()
    val separators = mutableListOf(",", ":")

    val parsedInput = extractCustomSeparator(originInput, separators)
    val result = calculateSum(parsedInput, separators)

    print("결과 : $result")
}

fun extractCustomSeparator(originInput: String, separators: MutableList<String>): String {
    var parsedInput = originInput

    while (parsedInput.contains(CUSTOM_PREFIX) && parsedInput.contains(CUSTOM_SUFFIX)) {
        val prefixIndex = parsedInput.indexOf(CUSTOM_PREFIX) + CUSTOM_PREFIX.length
        val suffixIndex = parsedInput.indexOf(CUSTOM_SUFFIX)

        if (prefixIndex < suffixIndex) {
            val customSeparator = parsedInput.substring(prefixIndex, suffixIndex)
            separators.takeIf { !it.contains(customSeparator) }?.add(customSeparator)

            customSeparator.takeIf { it.isNotBlank() }
                ?: throw IllegalArgumentException(CUSTOM_SEPARATOR_NOT_PROVIDED)

            parsedInput = parsedInput.substring(suffixIndex + CUSTOM_SUFFIX.length)
        } else {
            throw IllegalArgumentException(INVALID_CUSTOM_FORMAT)
        }
    }

    return parsedInput
}

fun calculateSum(parsedInput: String, separators: List<String>): Int {
    val separatorPattern = separators.joinToString("|") { Regex.escape(it) }
    val numbers = parsedInput.split(Regex(separatorPattern))
    var sum = 0

    for (number in numbers) {
        number.takeIf { it.isNotBlank() } ?: throw IllegalArgumentException(NUMBER_NOT_PROVIDED)
        sum += number.toIntOrNull() ?: throw IllegalArgumentException(INVALID_CHARACTER)
    }
    return sum
}

object ErrorMessages {
    const val CUSTOM_SEPARATOR_NOT_PROVIDED = "커스텀 구분자가 입력되지 않았습니다."
    const val INVALID_CUSTOM_FORMAT = "커스텀 구분자의 형식이 잘못되었습니다."
    const val NUMBER_NOT_PROVIDED = "구분자 사이에 숫자가 없습니다. 계산할 숫자를 입력해주세요."
    const val INVALID_CHARACTER = "잘못된 입력입니다. 숫자나 구분자가 아닌 값이 포함되었습니다"
}