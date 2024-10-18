package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val userInput = Console.readLine()

}

fun parseUserInput(input: String): List<Int>{
    //구분자 처리 기능
    if (input.isEmpty()) return emptyList()

    val customDelimiterRegex = Regex("//(.)\n(.*)")
    val result = customDelimiterRegex.find(input)

    val delimiters = if (result != null) {
        val customDelimiter = result.groupValues[1]
        "[,$customDelimiter:]"
    } else {
        "[,:]"
    }

    val numberString = result?.groupValues?.get(2) ?: input

    return try {
        numberString.split(Regex(delimiters)).map { it.toInt() }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}

fun checkNumberList(numberList: List<Int>) {
    //입력 값 확인하는 기능
    numberList.forEach {
        if (it < 0) {
            throw IllegalArgumentException()
        }
    }
}

fun sumNumber(numberList: List<Int>): Int {
    //분리된 숫자를 합하는 기능
    return numberList.sum()
}

