package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {

    // 입력 값
    println("덧셈할 문자열을 입해 주세요.")
    var customInput = Console.readLine()

    var newSeperator:String = ""

    if (customInput[0] == '/') {
        newSeperator = customInput[2].toString()
        customInput = customInput.substring(5)
    }

    var basicExpression = ""
    var seperatorExpression = ""

    if (newSeperator.isNotBlank()) {
        basicExpression = "^[0-9,:$newSeperator]+$"
        seperatorExpression = "[,:$newSeperator]"
    } else {
        basicExpression = "^[0-9,:]+$"
        seperatorExpression = "[,:]"
    }

    // 정규식
    val regex = basicExpression.toRegex()

    // 입력값 검사
    if (!regex.matches(customInput)) throw IllegalArgumentException("잘못된 입력 값을 입력하였습니다. ([0-9], [,], [:], [커스텀구분자]) 만 입력 가능합니다.")
    val input = customInput.split(Regex(seperatorExpression))

    // field
    var result = 0

    // 계산기
    for (i in input) {
        result += i.toInt()
    }

    // 결과값 출력
    println("결과 : $result")
}