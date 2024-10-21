package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("문자열을 입력해주세요.")
    val input = Console.readLine()

    try {
        checkValid(input)
        println("입력된 값: $input")
    } catch (e: IllegalArgumentException) {
        println(e.message) // 예외 메시지를 출력
    }
}

fun checkValid(input: String?) {
    // 입력값이 null이거나 비어있으면 예외 발생
    if (input.isNullOrEmpty()) {
        throw IllegalArgumentException("잘못된 값을 입력했습니다. 종료합니다.")
    }
    findCustomDelimiter(input)
}

fun findCustomDelimiter(input: String) {

}
