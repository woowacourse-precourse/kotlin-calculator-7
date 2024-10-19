package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        val str = Console.readLine().trim()
        // val numbers = splitString(str)
        val numbers = filteringString(str)

        if (numbers.any { it < 0 }) {
            throw IllegalArgumentException("잘못 입력하셨습니다.\n양수를 입력해 주세요.")
        }

        val sum = sumNumbers(numbers)
        printResult(str, sum)
    } finally {
        Console.close()
    }
}


// 방법1: 문자열을 구분자로 나누는 함수
fun splitString(str: String): List<Int> {
    return if (str.contains("/")) {
        val index = str.indexOf("//")
        val delimiter = str[index + 2].toString()
        val result = str.removeRange(index, index + 5)
        result.split(",", ":", delimiter).map { it.toInt() }
    } else {
        str.split(",", ":").map { it.toInt() }
    }
}

// 방법2: 문자열에서 숫자만 필터링하는 함수
fun filteringString(str: String): List<Int> {
    val regex = "\\d+".toRegex()
    return regex.findAll(str).map { it.value.toInt() }.toList()
}

// 숫자의 합을 반환하는 함수
fun sumNumbers(numbers: List<Int>): Int = numbers.sum()

// 출력 형식대로 출력하는 함수
fun printResult(str: String, sum: Int) {
    println("덧셈할 문자열을 입력해 주세요.")
    println(str)
    println("결과 : $sum")
}