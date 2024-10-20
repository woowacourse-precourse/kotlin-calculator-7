package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        val inputStr = Console.readLine().trim()
        val numbers = splitString(inputStr)
        // val numbers = filteringString(inputStr)

        if (numbers.any { it < 0 }) {
            throw IllegalArgumentException("잘못 입력하셨습니다.\n양수를 입력해 주세요.")
        }
        val sum = sumNumbers(numbers)
        printResult(inputStr, sum)
    } finally {
        Console.close()
    }
}

// 방법1: 문자열을 구분자로 나누는 함수
fun splitString(inputStr: String): List<Int> {
    return if (inputStr.contains("//")) {
        val startIndex = inputStr.indexOf("//")
        val delimiter = inputStr[startIndex + 2].toString()
        val result = inputStr.removeRange(startIndex, startIndex + 5)
        result.split(",", ":", delimiter).map { it.toInt() }
    } else {
        inputStr.split(",", ":").map { it.toInt() }
    }
}

// 방법2: 문자열에서 숫자만 필터링하는 함수
fun filteringString(inputStr: String): List<Int> {
    val numbers = if (inputStr.contains("//-\\n")){
        "\\d+".toRegex()
    } else {
        "-?\\d+".toRegex()
    }
    return numbers.findAll(inputStr).map { it.value.toInt() }.toList()
}

// 숫자의 합을 반환하는 함수
fun sumNumbers(numbers: List<Int>): Int = numbers.sum()

// 출력 형식대로 출력하는 함수
fun printResult(inputStr: String, result: Int) {
    println("덧셈할 문자열을 입력해 주세요.")
    println(inputStr)
    println("결과 : $result")
}