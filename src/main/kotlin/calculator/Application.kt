package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    print("덧셈할 문자열을 입력해 주세요.\n")
    val originCalculation: String = Console.readLine()
    val separatorList = mutableListOf(",", ":") // 동적 할당을 위한 mutableListOf
    // 그냥 ,; 이 있는지 분기처리로 해도 되지만, 이후 추가될 커스텀 구분자도 같은 연산(더하기)를 하기에 리스트로

    var currentNumber = StringBuilder() // 숫자를 저장할 변수
    var sum = 0
    var processedCalculation = originCalculation

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
        sum += currentNumber.toString().toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessages.LAST_VALUE_NOT_NUMBER)
    }

    print(sum)
}

object ErrorMessages {
    const val INVALID_NUMBER = "구분자 사이에 숫자가 아닌 값이 입력되었습니다."
    const val NUMBER_NOT_PROVIDED = "구분자 사이에 숫자가 없습니다. 계산할 숫자를 입력해주세요."
    const val INVALID_CHARACTER = "잘못된 입력입니다. 숫자나 구분자가 아닌 값이 포함되었습니다"
    const val LAST_VALUE_NOT_NUMBER = "마지막으로 입력된 값이 숫자가 아닙니다."
}