package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val str = Console.readLine()

    println(str)

    val num1 = splitString(str)
    println(sumNumbers(num1))

    val num2 = filteringString(str)
    println(sumNumbers(num2))

    Console.close()
}

// 방법1: 문자열을 구분자로 나누는 함수
fun splitString(str: String): List<Int> {
    return str.split(",", ":").map { it.toInt() }
}

// 방법2: 문자열에서 숫자만 필터링하는 함수
fun filteringString(str: String): List<Int> {
    return str.filter { it.isDigit() }.map { it.toString().toInt() }
}

// 숫자의 합을 반환하는 함수
fun sumNumbers(numbers: List<Int>): Int = numbers.sum()