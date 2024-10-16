package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val str = Console.readLine()

    val num = splitString(str)

    println(str)
    println(sumNumbers(num))


    Console.close()
}

// 방법1: 문자열을 구분자로 나누는 함수
fun splitString(str: String): List<Int> {
    return str.split(",", ":").map { it.toInt() }
}

// 방법2: 문자열에서 숫자만 필터링하는 함수
/*fun filteringString(str: String): List<Int> {

}*/

fun sumNumbers(numbers: List<Int>): Int = numbers.sum()