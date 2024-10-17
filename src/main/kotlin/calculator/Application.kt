package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.  ")
    val input = Console.readLine()
    var isCustom = false
    var customDelimeter = ";"

    try {
        if (isCustom) {
            val numberList = input
                .substring(5)
                .split(customDelimeter)
                .map {
                    if (it == "") 0 else it.toInt()
                }
            numberList.forEach {
                if (it < 0) {
                    throw IllegalArgumentException()
                }
            }
        } else {
            val numberList = input
                .split(regex = Regex("[,:]"))
                .map {
                    if (it == "") 0 else it.toInt()
                }
            numberList.forEach {
                if (it < 0) {
                    throw IllegalArgumentException()
                }
            }
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}