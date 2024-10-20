package calculator

import camp.nextstep.edu.missionutils.Console

const val CUSTOM_PREFIX = "//"
const val CUSTOM_SUFFIX = "\\n"

fun main() {
    print("덧셈할 문자열을 입력해 주세요.\n")
    val originCalculation: String = Console.readLine()
    val separatorList = mutableListOf(",", ":") // 동적 할당을 위한 mutableListOf
    // 그냥 ,; 이 있는지 분기처리로 해도 되지만, 이후 추가될 커스텀 구분자도 같은 연산(더하기)를 하기에 리스트로

    var currentNumber = StringBuilder() // 숫자를 저장할 변수
    var sum = 0
    var processedCalculation = originCalculation

    // 커스텀 구분자가 있을 때까지 반복
    while (processedCalculation.contains(CUSTOM_PREFIX) && processedCalculation.contains(CUSTOM_SUFFIX)) {
        // startCustom 이후부터 endCustom 이전까지의 구분자 추출
        // 커스텀 구분자가 없는 경우에는 변수가 생성되지 않도록 while문 안에 변수를 선언한다.

        val prefixIndex = processedCalculation.indexOf(CUSTOM_PREFIX) + CUSTOM_PREFIX.length
        val suffixIndex = processedCalculation.indexOf(CUSTOM_SUFFIX)

        if (prefixIndex < suffixIndex) {
            // 추출된 구분자를 separatorList에 추가 (이미 없을 경우에만)
            val customSeparator = processedCalculation.substring(prefixIndex, suffixIndex) // 구분자 추출
            separatorList.takeIf { !it.contains(customSeparator) }?.add(customSeparator)
            // 커스텀 구분자가 없는 경우 예외 처리
            customSeparator.takeIf { it.isNotBlank() }
                ?: throw IllegalArgumentException(ErrorMessages.CUSTOM_SEPARATOR_NOT_PROVIDED)

            // 구분자를 추출한 이후 문자열을 잘라서 반복할 수 있게 업데이트
            processedCalculation = processedCalculation.substring(suffixIndex + CUSTOM_SUFFIX.length)
        } else {
            throw IllegalArgumentException(ErrorMessages.INVALID_CUSTOM_FORMAT)
        }
    }

    for (char in processedCalculation) {
        when {
            separatorList.contains(char.toString()) -> {
                // 구분자인 경우
                if (currentNumber.isNotEmpty()) {
                    sum += currentNumber.toString().toIntOrNull()
                        ?: throw IllegalArgumentException(ErrorMessages.INVALID_NUMBER)
                    currentNumber = StringBuilder() // 숫자 초기화
                } else {
                    throw IllegalArgumentException(ErrorMessages.NUMBER_NOT_PROVIDED)
                }
            }

            // 숫자인 경우
            char.isDigit() -> currentNumber.append(char)

            // 구분자도 숫자도 아닌 값이 입력된 경우 예외 처리
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

    print("결과 : $sum")
}

object ErrorMessages {
    const val CUSTOM_SEPARATOR_NOT_PROVIDED = "커스텀 구분자가 입력되지 않았습니다."
    const val INVALID_CUSTOM_FORMAT = "커스텀 구분자의 형식이 잘못되었습니다."
    const val INVALID_NUMBER = "구분자 사이에 숫자가 아닌 값이 입력되었습니다."
    const val NUMBER_NOT_PROVIDED = "구분자 사이에 숫자가 없습니다. 계산할 숫자를 입력해주세요."
    const val INVALID_CHARACTER = "잘못된 입력입니다. 숫자나 구분자가 아닌 값이 포함되었습니다"
    const val LAST_VALUE_NOT_NUMBER = "마지막으로 입력된 값이 숫자가 아닙니다."
}