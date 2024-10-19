package calculator

import camp.nextstep.edu.missionutils.Console

fun input(): String = Console.readLine()

fun splitNumber(str: String): List<Int> {
    var numberList: List<Int> = listOf()

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
    str.forEach { if (it !in '0'..'9' && it != ',' && it != ':') return false }
    return true
}

fun checkCustom(str: String): Boolean {
    var str = str

    if (str.contains("//") && str.contains("\\n")) {
        return true
    }
    throw IllegalArgumentException()
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
        throw IllegalArgumentException()
    }
    return newStr
}

fun main() {
    println("덧셈할 문자열을 입력해주세요.")

    try {
        var inputString = input()

        if (!isValid(inputString) && checkCustom(inputString)) {
            inputString = replaceCustom(inputString)
        }

        val numbers = splitNumber(inputString)
        val result = sum(numbers)
        println("결과 : $result")

    } catch (e: NoSuchElementException) {
        println("결과 : 0")
    } catch (e: IllegalArgumentException) {
        throw e
    }
}
