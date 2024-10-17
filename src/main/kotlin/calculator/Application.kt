package calculator

import camp.nextstep.edu.missionutils.Console

fun input(): String {
    return Console.readLine()
}

fun splitNumber(str: String): List<Int> {
    var numberList: List<Int> = listOf()

    str.forEach {
        println(it)
        if (it == ',' || it == ':') {
            return@forEach
        }
        numberList += it.toString().toInt()
    }

    return numberList
}

fun main() {
    println("덧셈할 문자열을 입력해주세요.")
    val inputString = input()
    val numbers = splitNumber(inputString)
}
