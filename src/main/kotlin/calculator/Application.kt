package calculator

import camp.nextstep.edu.missionutils.Console

/**
 * 문자열 덧셈 계산기 프로그램
 * Console API를 사용하여 입력을 받고, 문자열에서 숫자를 추출하여 더한 결과를 반환한다.
 */

fun main() {

    println("덧셈할 문자열을 입력해주세요.")

    // Console API를 통해 입력을 받아 StringCalculator에 전달
    val input = Console.readLine()
    val sCalculator = StringCalculator()
    val result = sCalculator.add(input)
    println("결과 : $result")

}
