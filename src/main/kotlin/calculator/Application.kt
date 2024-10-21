package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    val input = getInput()
    val nums = getNumbers(input)
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

/**
 * 문자열에서 숫자를 List로 추출하는 함수
 */
fun getNumbers(input: String): List<Int> {
    // 기본 구분자(,:) 분리
    val numbers = input.split(",", ":").map { it.toInt() }
    return numbers
}