package calculator

import camp.nextstep.edu.missionutils.Console.readLine
fun main() {
    // 입력을 받는 부분
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine() ?: throw IllegalArgumentException("문자열은 구분자와 양수로만 이루어져야 합니다.")

    val result = calculateString(input)
    println("결과 : $result")

}

fun calculateString(input: String): Int {
    if (input.isBlank()) return 0

    //기본 구분자
    val delimiters = mutableListOf(",", ":")
    var numbersPart = input

    // 커스텀 구분자 처리
    if (input.startsWith("//")) {
        val delimiterEndIndex = input.indexOf("\\n")
        if (delimiterEndIndex == -1) throw IllegalArgumentException("커스텀 구분자 사용 방식에 맞지 않습니다.")

        val customDelimiter = input.substring(2, delimiterEndIndex)
        delimiters.add(customDelimiter)
        numbersPart = input.substring(delimiterEndIndex + 2)
    }

    val numbers = split(numbersPart, delimiters)

    val intNumbers = numbers.map {
        val num = it.toIntOrNull() ?: throw IllegalArgumentException("입력 형식에 맞지 않습니다.: $it")
        if (num < 0) throw IllegalArgumentException("양수만 입력할 수 있습니다. $num")
        num
    }

    return intNumbers.sum()
}

fun split(input: String, delimiters: List<String>): List<String> {
    val regex = delimiters.joinToString("|") { Regex.escape(it) }.toRegex()
    return input.split(regex)
}