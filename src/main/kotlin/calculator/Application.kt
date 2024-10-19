package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    var input: String //입력 문자열
    var result: Int = 0//결과값

    //입력 문자열 받기
    println("덧셈할 문자열을 입력해 주세요.")
    input = Console.readLine()

    //입력 문자열이 공백이면 결과값은 0
    if (input.isBlank()) {
        print("결과 : 0")
        return
    }

    //결과 출력
    print("결과 : ${result}")
    return
}
