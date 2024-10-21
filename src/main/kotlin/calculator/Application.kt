package calculator

import camp.nextstep.edu.missionutils.Console

fun input(): String = Console.readLine()

fun splitNumber(str: String): List<Int> = str.split("[,:]".toRegex()).map { it.toInt() }

fun sum(numbers: List<Int>): Int = numbers.sum()

fun isValid(str: String): Boolean {
    val inputRegex = "^[0-9,:]*$".toRegex()
    return inputRegex.matches(str)
}

fun checkCustom(str: String): Boolean = str.contains("^//.+\\\\n".toRegex())

fun replaceCustom(str: String): String {
    val afterIndex = str.indexOf("\\n")
    val customSeparator = str.substring(2, afterIndex)
    var newStr = str.substring(afterIndex + 2)
    newStr = newStr.replace(customSeparator, ",")

    return newStr
}

fun main() {
    println("덧셈할 문자열을 입력해주세요.")

    try {
        var inputString = input()

        if (checkCustom(inputString)) {
            inputString = replaceCustom(inputString)
        }

        if (!isValid(inputString) and !checkCustom(inputString)) {
            throw IllegalArgumentException()
        }

        val numbers = splitNumber(inputString)
        val result = sum(numbers)
        println("결과 : $result")

    } catch (e: NoSuchElementException) {
        println("결과 : 0")
    }
}
