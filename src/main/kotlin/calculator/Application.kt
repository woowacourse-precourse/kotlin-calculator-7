package calculator
import camp.nextstep.edu.missionutils.Console

// 잘못된 숫자나 음수 입력에 대한 예외 처리 함수
fun runException(input: String): List<Int> {
    // 문자열을 구분자 기준으로 분리하는 기능
    val numbers = if (input.startsWith("//")) {    // 커스텀 구분자일때
        val part = input.split("\\n")
        // 입력이 \n을 기준으로 두 파트(구분자 정의와 숫자 부분)로 나뉘지 않을 시 예외 발생
        if (part.size != 2) {
            throw IllegalArgumentException("잘못된 입력입니다. 구분자와 숫자를 포함해야 합니다.")
        }
        val delimiter = part[0][2]
        part[1].split(delimiter)    // \n의 다음 부분을 커스텀 구분자 기준으로 분리
    } else {    // 기본 구분자일때
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

// 기본 구분자 또는 커스텀 구분자에 대한 숫자 리스트 합산하는 함수
fun totalSum(numbers: List<Int>): Int {
    return numbers.sum()
}

fun main() {
    val input = Console.readLine()
    // 입력값이 null이나 빈문자열인지 확인
    if (input.isNullOrEmpty()) {
        println("결과 : 0")
    } else {
        val numbers = runException(input)   //예외 처리, 숫자 리스트 반환
        val result = totalSum(numbers)
        println("결과 : $result")
    }
}


