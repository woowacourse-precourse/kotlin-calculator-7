package calculator

import camp.nextstep.edu.missionutils.Console

val customDelimiterRegex = Regex("^//[^0-9]\\\\n.*")

fun main() {
    try {
        var input = Console.readLine()
        var result = 0
        val delimiters = mutableListOf(",", ":")
        if (customDelimiterRegex.matches(input))
        {
            val customDelimiter = input[2].toString()
            input = input.substring(5)
            delimiters.add(customDelimiter)
        }
        if (input.isNotEmpty()) {
            val delimiterRegex = Regex(delimiters.joinToString("|"))
            val operands = input.split(delimiterRegex)
            result = operands.sumOf{it.toInt()}
        }
        println("결과 : $result")
    }
    catch (e: java.util.NoSuchElementException) {
        println("결과 : 0")
    }
    catch (e: IllegalArgumentException) {
        return
    }
}
