package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    val input = getInput()
}

private const val INPUT_STR = "덧셈할 문자열을 입력해 주세요."
/**
 * 콘솔 입력값을 저장하는 기능을 하는 함수
 * return : 콘솔 입력값
 */
fun getInput(): String {
    println(INPUT_STR)
    val input = Console.readLine()
    return input
}
