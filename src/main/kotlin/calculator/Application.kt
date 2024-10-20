package calculator

import camp.nextstep.edu.missionutils.Console

const val CUSTOM_PREFIX = "//"
const val CUSTOM_SUFFIX = "\\n"

fun main() {
    print("덧셈할 문자열을 입력해 주세요.\n")
    val originCalculation: String = Console.readLine()
    val separatorList = mutableListOf(",", ":")

    val processedCalculation = extractCustomSeparator(originCalculation, separatorList)
    val result = calculateSum(processedCalculation, separatorList)

    print("결과 : $result")
}

fun extractCustomSeparator(originCalculation: String, separatorList: MutableList<String>): String {
    var processedCalculation = originCalculation

    while (processedCalculation.contains(CUSTOM_PREFIX) && processedCalculation.contains(CUSTOM_SUFFIX)) {
        val prefixIndex = processedCalculation.indexOf(CUSTOM_PREFIX) + CUSTOM_PREFIX.length
        val suffixIndex = processedCalculation.indexOf(CUSTOM_SUFFIX)

        if (prefixIndex < suffixIndex) {
            val customSeparator = processedCalculation.substring(prefixIndex, suffixIndex)
            separatorList.takeIf { !it.contains(customSeparator) }?.add(customSeparator)

            customSeparator.takeIf { it.isNotBlank() }
                ?: throw IllegalArgumentException(ErrorMessages.CUSTOM_SEPARATOR_NOT_PROVIDED)

            processedCalculation = processedCalculation.substring(suffixIndex + CUSTOM_SUFFIX.length)
        } else {
            throw IllegalArgumentException(ErrorMessages.INVALID_CUSTOM_FORMAT)
        }
    }

    return processedCalculation
}

fun calculateSum(processedCalculation: String, separatorList: List<String>): Int {
    // 구분자들을 |로 묶어 정규식 패턴을 만들고 문자열을 쪼갠다
    val separatorPattern = separatorList.joinToString("|") { Regex.escape(it) }
    val numbers = processedCalculation.split(Regex(separatorPattern))
    var sum = 0

    for (number in numbers) {
        if (number.isBlank()) {
            throw IllegalArgumentException(ErrorMessages.NUMBER_NOT_PROVIDED)
        }

        sum += number.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.INVALID_CHARACTER)
    }

    return sum
}

object ErrorMessages {
    const val CUSTOM_SEPARATOR_NOT_PROVIDED = "커스텀 구분자가 입력되지 않았습니다."
    const val INVALID_CUSTOM_FORMAT = "커스텀 구분자의 형식이 잘못되었습니다."
    const val NUMBER_NOT_PROVIDED = "구분자 사이에 숫자가 없습니다. 계산할 숫자를 입력해주세요."
    const val INVALID_CHARACTER = "잘못된 입력입니다. 숫자나 구분자가 아닌 값이 포함되었습니다"
}