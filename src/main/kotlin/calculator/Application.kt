package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // 사용자에게 입력 요청
    println("덧셈할 문자열을 입력해 주세요.")

    // 콘솔로부터 입력값을 읽어옴
    val input = Console.readLine()

    // StringCalculator 객체 생성를 생성하고 입력값을 처리하여 결과 얻음
    val result = StringCalculator().add(input)

    // 결과를 출력
    println("결과 : $result")
}
