package calculator
import camp.nextstep.edu.missionutils.Console

// 잘못된 숫자나 음수 입력에 대한 예외 처리 함수
fun runException(input: String) {
    // 문자열을 구분자 기준으로 분리
    val numbers = input.split(",", ":")
    // 각 숫자에 대한 유효성 검사
    for (number in numbers) {
        // 문자열을 정수로 변환, 변환할 수 없으면 예외 발생
        val value = number.toIntOrNull() ?: throw IllegalArgumentException("잘못된 숫자입니다: $number")
        // 음수일 경우 예외 발생
        if (value < 0) {
            throw IllegalArgumentException("음수는 허용되지 않습니다: $value")
        }
    }
}

// 기본 구분자에 대한 숫자 합산하는 함수
fun defaultSum(input: String?): Int {

    if (input.isNullOrEmpty()) {
        return 0
    }
    runException(input)
    val sep1= input.split(",",":")   // 기본 구분자를 기준으로 분리
    return sep1.sumOf { it.toInt() }
}

// 커스텀 구분자에 대한 숫자 합산하는 함수
fun customSum(input: String): Int {

    val part = input.split("\\n")   // \n 기준으로 두 파트로 분리
    val delimiter = part[0][2]  // 구분자 추출
    val sep2 = part[1].split(delimiter)  // 커스텀 구분자를 기준으로 분리

    return sep2.sumOf { it.toInt() }
}

fun main() {

    val input = Console.readLine()
    val result: Int
    // 기본 구분자와 커스텀 구분자의 경우 분리
    if (input.startsWith("//")) {
        result = customSum(input)
    } else {
        result = defaultSum(input)
    }
    println("결과 : $result")
}


