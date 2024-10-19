package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해주세요.")
    var inputString = Console.readLine()
    try {
        // Classification
        //taskClassification(inputString)
    } catch (e: IllegalArgumentException){
        println(e.message)
    }
}

