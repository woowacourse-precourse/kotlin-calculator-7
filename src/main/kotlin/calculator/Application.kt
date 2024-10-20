package calculator
import camp.nextstep.edu.missionutils.Console

// Calculate 클래스
class Calculate(private val input: String) {

    // 문자열을 숫자 리스트로 변환하고 예외 처리 하는 메서드
    fun parseInput(): List<Int> {
        val numbers = if (input.startsWith("//")) {
            customDel()
        } else {
            defaultDel()
        }
        runException(numbers)
        return numbers
    }

    // 기본 구분자에 대해 숫자 분리하는 메서드
    private fun defaultDel(): List<String> {
        return input.split(",", ":")
    }

    // 커스텀 구분자에 대해 숫자 분리하는 메서드
    private fun customDel(): List<String> {
        val part = input.split("\\n")
        if (part.size != 2) {   // \n을 기준으로 입력을 두 부분(구분자 정의와 숫자 부분)으로 분리
            throw IllegalArgumentException("구분자와 숫자를 포함해야 합니다.")
        }
        val delimiter = part[0][2]    // 커스텀 구분자 추출
        return part[1].split(delimiter.toString())  // \n의 다음 부분을 구분자 기준으로 분리
    }

    // 잘못된 숫자와 음수 입력에 대해 예외 발생시키는 메서드
    private fun runException(numbers: List<String>) {
        numbers.forEach { number ->
            val value = number.toIntOrNull() ?: throw IllegalArgumentException("잘못된 숫자입니다.")    // 문자열을 정수로 변환할 수 없을 경우 예외 발생
            if (value < 0) {    // 음수일 경우 예외 발생
                throw IllegalArgumentException("음수는 입력할 수 없습니다.")
            }
        }
    }

    // 숫자 리스트의 합을 반환하는 메서드
    fun totalSum(numbers: List<Int>): Int {
        return numbers.sum()
    }

    fun main() {
        println("덧셈할 문자열을 입력해 주세요.")
        val input = Console.readLine()
        if (input.isNullOrEmpty()) {    // 빈문자열이나 null값을 입력받을 경우 0 출력
            println("결과 : 0")
        } else {
            val calculate = Calculate(input)
            val numbers = calculate.parseInput()
            val result = calculate.totalSum(numbers)
            println("결과 : $result")
        }

    }

}


