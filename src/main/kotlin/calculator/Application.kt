package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val inputString = readLine()
    val result : Int

    if(inputString.startsWith("//")) {
        val endIndex = inputString.indexOf("\\n")

        val customDelimiter = inputString.substring(2, endIndex)

        val numbers = inputString.substring(endIndex + 2)

        result = numbers.split(customDelimiter).sumOf { it.toInt() }
    } else result = inputString.split(',', ':').sumOf { it.toInt() }

    println(result)
}
