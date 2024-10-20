package calculator

import camp.nextstep.edu.missionutils.Console

fun input(): String = Console.readLine()

fun splitNumber(str: String): List<Int> {
    val numberList: MutableList<Int> = mutableListOf()
    var num = ""

    str.forEach {
        if (it == ',' || it == ':') {
            if (num != "") {
                numberList += num.toInt()
                num = ""
            }
            return@forEach
        }
        num += it.toString()
    }
    if (num != "") {
        numberList += num.toInt()
    }

    return numberList
}

fun sum(numbers: List<Int>): Int = numbers.sum()


fun isValid(str: String): Boolean {
    val inputRegex = "^[0-9,:]*$".toRegex()
    return inputRegex.matches(str)
}

fun checkCustom(str: String): Boolean {
    if (str.contains("//") && str.contains("\\n")) {
        val beforeIndex = str.indexOf("//")
        val afterIndex = str.indexOf("\\n")

        if (beforeIndex < afterIndex && beforeIndex == 0) {
            return true
        }
    }
    return false
}

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

        if (!isValid(inputString)) {
            if (checkCustom(inputString)) {
                inputString = replaceCustom(inputString)
            } else {
                throw IllegalArgumentException()
            }
        }

        val numbers = splitNumber(inputString)
        val result = sum(numbers)
        println("결과 : $result")

    } catch (e: NoSuchElementException) {
        println("결과 : 0")
    }
}
