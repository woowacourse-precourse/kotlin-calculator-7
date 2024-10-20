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
    var currentNumber = StringBuilder()
    var sum = 0

    for (char in processedCalculation) {
        when {
            separatorList.contains(char.toString()) -> {
                if (currentNumber.isNotEmpty()) {
                    sum += currentNumber.toString().toIntOrNull()
                        ?: throw IllegalArgumentException(ErrorMessages.INVALID_NUMBER)
                    currentNumber = StringBuilder() // 숫자 초기화
                } else {
                    throw IllegalArgumentException(ErrorMessages.NUMBER_NOT_PROVIDED)
                }
            }

            char.isDigit() -> currentNumber.append(char)

            else -> {
                throw IllegalArgumentException(ErrorMessages.INVALID_CHARACTER)
            }
        }
    }

    if (currentNumber.isNotEmpty()) {
        sum += currentNumber.toString().toInt()
    } else {
        throw IllegalArgumentException(ErrorMessages.LAST_VALUE_NOT_NUMBER)
    }

    return sum
}

object ErrorMessages {
    const val CUSTOM_SEPARATOR_NOT_PROVIDED = "커스텀 구분자가 입력되지 않았습니다."
    const val INVALID_CUSTOM_FORMAT = "커스텀 구분자의 형식이 잘못되었습니다."
    const val INVALID_NUMBER = "구분자 사이에 숫자가 아닌 값이 입력되었습니다."
    const val NUMBER_NOT_PROVIDED = "구분자 사이에 숫자가 없습니다. 계산할 숫자를 입력해주세요."
    const val INVALID_CHARACTER = "잘못된 입력입니다. 숫자나 구분자가 아닌 값이 포함되었습니다"
    const val LAST_VALUE_NOT_NUMBER = "마지막으로 입력된 값이 숫자가 아닙니다."
}