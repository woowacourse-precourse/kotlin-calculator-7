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

}


