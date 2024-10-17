package calculator

import camp.nextstep.edu.missionutils.Console

fun input(): String {
    return Console.readLine()
}

fun splitNumber(str: String): List<Int> {
    var numberList: List<Int> = listOf()

    str.forEach {
        if (it == ',' || it == ':') {
            return@forEach
        }
        numberList += it.toString().toInt()
    }

    return numberList
}

fun sum(numbers: List<Int>): Int {
    return numbers.sum()
}

fun isValid(str: String): Boolean {
    str.forEach { if (it !in '0'..'9' && it != ',' && it != ':') return false }
    return true
}

fun main() {
    println("덧셈할 문자열을 입력해주세요.")

    val inputString = input()

    if (!isValid(inputString)) { println("유효하지 않은 식") }
    val numbers = splitNumber(inputString)
    val result = sum(numbers)

    println("결과 : $result")
}
