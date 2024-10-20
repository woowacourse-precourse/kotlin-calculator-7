package calculator

import camp.nextstep.edu.missionutils.Console.readLine

/**
 * 커스텀 구분자는 "문자" 이므로 "// \n"를 포함하여 총 5자리이며
 * 이 5자리를 "커맨드"로 정의하였고 커맨드의 길이를 저장함
 */
const val COMMAND_LENGTH = 5

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input: String = readLine()
    ErrorChecker.invalidInputCheck(input)
    println("결과 : ${InputStringManager.sumInputString(input)}")
}