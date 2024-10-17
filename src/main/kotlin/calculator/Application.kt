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

fun checkCustom(str: String): Boolean {
    var str = str

    if(str.contains("//") && str.contains("\\n")) {
        return true
    }
    return false
}

fun replaceCustom(str: String): String {
    var str = str
    var newStr = ""
    var customSeparator = ""

    val beforeIndex = str.indexOf("//")
    val afterIndex = str.indexOf("\\n")
    if (beforeIndex < afterIndex) {
        customSeparator = str.substring(beforeIndex + 2, afterIndex)
        newStr = str.substring(afterIndex + 2)
        newStr = newStr.replace(customSeparator, ",")
    } else {
        throwException()
    }
    return newStr
}

fun throwException() {
    throw IllegalArgumentException()
}

fun main() {
    println("덧셈할 문자열을 입력해주세요.")

    var inputString = input()

    if (!isValid(inputString) && checkCustom(inputString)) {
        inputString = replaceCustom(inputString)
    } else {
        throwException()
    }
    val numbers = splitNumber(inputString)
    val result = sum(numbers)
    println("결과 : $result")
}
