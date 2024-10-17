package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.  ")
    val input = Console.readLine()
    var isCustom = false
    var customDelimeter = ";"

    if (input.length >= 5
        && input.substring(IntRange(0, 1)) == "//"
        && input.substring(IntRange(3, 4)) == "\\n"
    ) {
        isCustom = true
        customDelimeter = input[2].toString()
    }

    try {
        if (isCustom) {
            var sum = 0
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
                sum += it
            }
            print("결과 : $sum")
        } else {
            var sum = 0
            val numberList = input
                .split(regex = Regex("[,:]"))
                .map {
                    if (it == "") 0 else it.toInt()
                }
            numberList.forEach {
                if (it < 0) {
                    throw IllegalArgumentException()
                }
                sum += it
            }
            print("결과 : $sum")
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}