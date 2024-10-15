package calculator

import camp.nextstep.edu.missionutils.Console

fun isEmptyString(input: String): Boolean
{
    return true
}

fun main() {
    try{
        val input = Console.readLine()
        var result = 0
        if (!input.equals("")) {
            val operands = input.split(",", ":")
            result = operands.sumOf{it.toInt()}
        }
        println("결과 : $result")
    }
    catch (e: java.util.NoSuchElementException) {
        println("결과 : 0")
    }
}
