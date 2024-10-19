package calculator
import camp.nextstep.edu.missionutils.Console

// 잘못된 숫자나 음수 입력에 대한 예외 처리 함수
fun runException(input: String): List<Int> {
    // 문자열을 구분자 기준으로 분리
    val numbers = if (input.startsWith("//")) {
        val part = input.split("\\n")
        val delimiter = part[0][2]
        part[1].split(delimiter)
    } else {
        input.split(",", ":")
    }
    // 각 숫자에 대한 유효성 검사
    return numbers.map { number ->
        // 문자열을 정수로 변환, 변환할 수 없으면 예외 발생
        val value = number.toIntOrNull() ?: throw IllegalArgumentException("잘못된 숫자입니다: $number")
        // 음수일 경우 예외 발생
        if (value < 0) {
            throw IllegalArgumentException("음수는 허용되지 않습니다: $value")
        }
        value
    }
}

// 기본 구분자 또는 커스텀 구분자에 대한 숫자 합산하는 함수
fun totalSum(numbers: List<Int>): Int {
    return numbers.sum()
}

fun main() {

    val input = Console.readLine()
    if (input.isNullOrEmpty()) {
        println("결과 : 0")
    } else {
        val numbers = runException(input)   //예외 처리, 숫자 리스트 반환
        val result = totalSum(numbers)

        println("결과 : $result")
    }
}


