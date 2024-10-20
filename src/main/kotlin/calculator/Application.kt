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
        if (separatorList.contains(char.toString())) {
            print("구분자 : " + char + "\n")
        } else {
            currentNumber.append(char)
            print("숫자 : " + currentNumber.toString() + "\n")
        }
    }
}