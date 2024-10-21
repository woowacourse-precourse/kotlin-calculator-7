package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {

    // TODO : 프로그램 구현

    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()
    val result = add(input)
    println("결과 : $result")
}

fun add(input: String?): Int {
    if (input.isNullOrEmpty()) {
        return 0
    }
    return -1  // 나머지 기능은 이후에 구현
}