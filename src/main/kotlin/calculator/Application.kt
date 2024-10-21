package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    calculate()
}

fun calculate() {
    try {
        val userInputString = getUserInput()
        val splitList = splitString(userInputString)

        if (checkNegative(splitList)) {
            throw IllegalArgumentException()
        }

        val sum = sumSplitList(splitList)
        println("결과 : $sum")
    } catch (e:Exception) {
        throw IllegalArgumentException()
    }
}

fun getUserInput(): String = Console.readLine()

fun splitString(userInputString: String): List<Int> {
    return if (userInputString.startsWith("//")) {
        val customDelimiter = findCustomDelimiter(userInputString)
        val realInput = getRealUserInput(userInputString)
        realInput.split(customDelimiter).map { it.toInt() }
    } else {
        userInputString.split(",", ":").map { it.toInt() }
    }
}

fun sumSplitList(splitList: List<Int>): Int = splitList.sum()

fun findCustomDelimiter(userInputString:String):String {
    val start = userInputString.indexOf("//")
    val end = userInputString.indexOf("\\n")
    return userInputString.substring(start+2,end)
}

fun getRealUserInput(userInputString: String): String {
    val end = userInputString.indexOf("\\n")
    return userInputString.substring(end + 2)
}

fun checkNegative(splitList: List<Int>):Boolean {
    return splitList.any { it < 0 }
}