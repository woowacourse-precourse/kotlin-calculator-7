package calculator

import java.math.BigDecimal
import camp.nextstep.edu.missionutils.Console

fun main() {

    print("덧셈할 문자열 입력: ")
    val userInput = Console.readLine()

    val result = add(userInput)
    println("결과 : $result")

}

//구분자로 문자열 파싱하는 함수
fun parseNumbers(input: String): List<BigDecimal> {

    val (delimiter, numbersString) = delimiterExtraction(input)
    val numbers = numbersString.split(Regex(delimiter)).map {
        // 숫자로된 문자열로 나누어지지 않을 시 예외처리
        it.toBigDecimalOrNull() ?: throw IllegalArgumentException("잘못된 형식으로 숫자 분류가 실패되었습니다.")
    }

    //숫자가 음수인 경우 예외처리
    if (numbers.any { it < BigDecimal.ZERO }) {
        throw IllegalArgumentException("양수를 입력해주세요.")
    }
    return numbers //파싱한 문자열 반환
}

//구분자 추출하는 함수
private fun delimiterExtraction(input: String): Pair<String, String> {
    return if (input.startsWith("//")) { // //로 시작할 때 커스텀 구분자로 분류시작
        val delimiterEndIndex = findFirstDigitIndex(input)
        val delimiter = input.substring(2, delimiterEndIndex)
        // 다수 커스텀 구분자들을 받아서 등록
        val delimiters = delimiter.toList().map { Regex.escape(it.toString()) }.joinToString("|") + "|,|:"
        val numbersString = input.substring(delimiterEndIndex) // 커스텀 구분자 선언부 제외 문자열 분류
        Pair(delimiters, numbersString)
    } else {
        Pair("[,|:]", input) //기본 구문자 선언
    }
}

//문자열에 있는 첫 숫자의 인덱스를 반환하는 함수
fun findFirstDigitIndex(input: String): Int {
    for (i in input.indices) {
        if (input[i].isDigit()) {
            return i // 숫자가 발견되면 그 인덱스를 반환
        }
    }
    //숫자가 입력되지 않은 경우 예외처리
    return throw IllegalArgumentException("숫자를 입력해주세요.")
}

//파싱한 배열의 합을 구하는 함수 추가
fun add(input: String): BigDecimal {

    //입력값이 비어있는 경우 0을 반환
    if (input.isBlank()) return BigDecimal.ZERO

    val numbers = parseNumbers(input)
    val sum = numbers.sumOf { it }

    return sum
}
