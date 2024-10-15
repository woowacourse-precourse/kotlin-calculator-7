package calculator

import camp.nextstep.edu.missionutils.Console

// 입력
fun input(): String {
    println("덧셈할 문자열을 입력해 주세요.")
    return Console.readLine()
}

// 문자열 유효성 검사
fun isValidString(string: String): Boolean {
    val customString = if (string.length >= 5) string.substring(0, 5) else null
    val allowedCharacters = mutableListOf(',', ':', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    if (customString != null)
        allowedCharacters += customString[2]

    val checkString = if (customString != null) string.substring(startIndex = 5) else string
    for (c in checkString)
        if (c !in allowedCharacters)
            return false
    return true
}

// 숫자 추출
fun extractNumbers(string: String): List<Int> {
    val customString = if (string.length >= 5) string.substring(0, 5) else null
    val separators = mutableListOf(',', ':')
    if (customString != null)
        separators += customString[2]

    val checkString = if (customString != null) string.substring(startIndex = 5) else string
    return if (customString != null) checkString.split(separators[0], separators[1], separators[2]).map { it.toInt() }
    else checkString.split(separators[0], separators[1]).map { it.toInt() }
}

// 연산
fun calculate(numbers: List<Int>): Int {
    return numbers.sum()
}

// 출력
fun printResult(result: Int) {
    print("결과 : $result")
}

fun main() {
    val string = input()
    if (!isValidString(string))
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")
    val numbers = extractNumbers(string)
    val result = calculate(numbers)
    printResult(result)
}

