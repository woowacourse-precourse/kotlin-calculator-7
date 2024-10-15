package calculator

import camp.nextstep.edu.missionutils.Console.readLine

//커스텀 구분자는 '문자'이므로 // \n를 포함하여 총 5자리임을 상수로 선언
const val COMMAND_LENGTH = 5

fun main() {
    val input: String = readLine()  // 문자열 입력 받기
    ErrorChecker.invalidInputCheck(input)
    println("결과 : ${InputStringManager.sumString(input)}")
}
