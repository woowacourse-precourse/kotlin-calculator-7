package calculator
import camp.nextstep.edu.missionutils.Console

// 기본구분자에 대한 숫자 합산하는 함수
fun defaultSum(input: String?): Int {
    if (input.isNullOrEmpty()) {
        return 0
    }
    // 기본 구분자에 대한 숫자 합산
    val sep1 = input.split(",", ":")
    return sep1.sumOf { it.toInt() }
}

fun main() {

    val input = Console.readLine()
    val result = defaultSum(input)

    println("결과 : $result")
}

