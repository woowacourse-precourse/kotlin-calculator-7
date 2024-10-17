package calculator

import kotlin.IllegalArgumentException

class Calculator {

    fun calculate(input: String) {
    }

    fun calculateCustom(input: String) {
        validateInputCustom(input)
    }

    private fun validateInputCustom(input: String) {
        val custom = input.split("//", "\\n").first { it.isNotEmpty() }
        val splitInput = input.split("//", "\\n").last { it.isNotEmpty() }

        // 커스텀 문자가 여러개일 경우
        if (custom.length != 1) throw IllegalArgumentException("입력이 잘못되었습니다")
        // 커스텀 문자가 문자가 아닐경우
        if (!custom[0].isLetter()) throw IllegalArgumentException("입력이 잘못되었습니다")
    }
}