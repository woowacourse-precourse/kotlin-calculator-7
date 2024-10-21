package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val input = try {
        Console.readLine()  // 입력값 받기
    } catch (e: Exception) {
        ""  // 예외 발생 시 빈 문자열로 처리
    }

    println(calculate(input))
}

fun calculate(input: String): String {
    if (input.isBlank()) return "결과 : 0"  // 빈 문자열 처리

    var delimiter = "[,:]"  // 기본 구분자: 쉼표와 콜론
    var inputString = input
    val sum: Int

    // 커스텀 구분자 처리
    if (input.startsWith("//")) {
        val customDelimiterArea = input.substring(2, input.indexOf("\\n"))
        delimiter = Regex.escape(customDelimiterArea)  // 커스텀 구분자 설정
        inputString = input.substring(input.indexOf("\\n") + 2)  // 입력된 문자열 부분만 남기기
    }

    // 기본 구분자 처리
    val numberList = inputString.split(delimiter.toRegex()).map {
        try {
            it.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("잘못된 값이 입력되었습니다: $it")
        }
    }

    // 음수 처리
    val negativeNumbers = numberList.filter { it < 0 }
    if (negativeNumbers.isNotEmpty()) {
        throw IllegalArgumentException("음수는 허용되지 않습니다: $negativeNumbers")
    }

    sum = numberList.sum()

    return "결과 : $sum"
}
