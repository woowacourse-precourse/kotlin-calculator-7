package calculator

import java.math.BigInteger
import camp.nextstep.edu.missionutils.Console

fun main() {
    while(true) {
        print("덧셈할 문자열 입력: ")
        val userInput = Console.readLine()

        if(userInput=="end")break

        try {
            val result = delimiterExtraction(userInput)
            println("결과 : $result")
        } catch (e: IllegalArgumentException) {
            println("오류: ${e.message}")
        }
    }
}

//구분자 추출하는 함수
private fun delimiterExtraction(input: String): Pair<String, String> {
    return if (input.startsWith("//")) { // //로 시작할 때 커스텀 구분자로 분류시작
        val delimiterEndIndex = findFirstDigitIndex(input)
        val delimiter = input.substring(2, delimiterEndIndex-2) // 커스텀 구분자만 따로 분류
        val numbersString = input.substring(delimiterEndIndex) // 커스텀 구분자 선언부 제외 문자열 분류
        Pair(delimiter, numbersString)
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
    return throw IllegalArgumentException("숫자를 입력해주세요.")
}