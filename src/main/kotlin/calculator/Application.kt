package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // 정규식
    val basicExpression = "^[0-9,:]+$"
    val regex = basicExpression.toRegex()

    // 입력 값
    println("덧셈할 문자열을 입해 주세요.")
    val customInput = Console.readLine()

    // 입력값 검사
    if (!regex.matches(customInput)) throw IllegalArgumentException("잘못된 입력 값을 입력하였습니다. ([0-9], [,], [:], [커스텀구분자]) 만 입력 가능합니다.")
    val input = customInput.split(Regex("[,:]"))

    // field
    var result = 0

    // 계산기
    for (i in input) {
        result += i.toInt()
    }

    // 결과값 출력
    println("결과 : $result")
}