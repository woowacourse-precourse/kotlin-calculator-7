package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    var userInput: String

    println("덧셈할 문자열을 입력해 주세요.")
    userInput = Console.readLine()


}

fun extractDelimiter(userInput: String): Pair<Regex, String> {
    val customDelimiterRegex = """^//(.)\n(.*)$""".toRegex()
    val matchResult = customDelimiterRegex.find(userInput)

    return if (matchResult != null) {
        val customDelimiter = matchResult.groupValues[1]
        val numbers = matchResult.groupValues[2]
        Regex("[$customDelimiter,:]") to numbers
    } else {
        Regex("[,:]") to userInput
    }
}