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
            throw IllegalArgumentException("잘못된 입력입니다. 구분자와 숫자를 포함해야 합니다.")
        }
        val delimiter = part[0][2]    // 커스텀 구분자 추출
        return part[1].split(delimiter.toString())  // \n의 다음 부분을 구분자 기준으로 분리
    }

}


