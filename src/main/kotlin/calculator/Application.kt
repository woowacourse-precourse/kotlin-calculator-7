package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val str = try {
        Console.readLine()
    } catch (e: IllegalArgumentException) {
        return
    }

    val num = splitString(str)

    // 출력 형식
    println("덧셈할 문자열을 입력해주세요.")
    println(str)
    println(sumNumbers(num))

    Console.close()
}

// 방법1: 문자열을 구분자로 나누는 함수
fun splitString(str: String): List<Int> {
    return str.split(",", ":").map { it.toInt() }
}

// 방법2: 문자열에서 숫자만 필터링하는 함수
/*fun filteringString(str: String): List<Int> {
    return str.filter { it.isDigit() }.map { it.toString().toInt() }
}*/

// 숫자의 합을 반환하는 함수
fun sumNumbers(numbers: List<Int>): Int = numbers.sum()