package calculator

import camp.nextstep.edu.missionutils.Console

val customDelimiterRegex = Regex("^//[^0-9]\\\\n.*")
val basicDelimiterRegex = Regex("([1-9]\\d*[,:])*[1-9]\\d*")

fun getOperands(input: String): List<String> {
    if (customDelimiterRegex.matches(input)) {
        val customDelimiter = input[2].toString()
        val inputSubstring = input.substring(5)
        return inputSubstring.split(",", ":", customDelimiter)
    }
    if (basicDelimiterRegex.matches(input)) {
        return input.split(",", ":")
    }
    throw IllegalArgumentException()
}

fun main() {
    try {
        val input = Console.readLine()
        var result = 0
        val operands = getOperands(input)
        if (input.isNotEmpty()) {
            result = operands.sumOf{it.toInt()}
        }
        println("결과 : $result")
    }
    catch (e: java.util.NoSuchElementException) {
        println("결과 : 0")
    }
    catch (e: IllegalArgumentException) {
        throw e
    }
}
