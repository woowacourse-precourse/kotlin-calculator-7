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
            // 구분자인 경우
            separatorList.contains(char.toString()) -> {
                // 구분자를 만난 경우 이전의 숫자값을 모두 더하는 로직 추가 필요
            }

            // 숫자인 경우
            char.isDigit() -> {
                currentNumber.append(char)
            }

            else -> {
                // 구분자도 숫자도 아닌 값이 입력된 경우 예외 처리
                throw IllegalArgumentException("잘못된 입력입니다. 숫자나 구분자가 아닌 값이 포함되었습니다")
            }
        }
    }
}