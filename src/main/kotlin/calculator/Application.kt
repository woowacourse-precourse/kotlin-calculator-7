package calculator

import camp.nextstep.edu.missionutils.Console
import java.lang.StringBuilder

class Calculator {
    private val INIT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    private var input: String? = ""
    private lateinit var inputProcessing: StringBuilder
    private var answer: Int? = 0
    private var delimiter: String = ",:"
    private val CUSTOMDEVIDER_RULES = """//(.+)\\n""".toRegex()

    fun initCalculator() { // 계산기 초기화
        println(INIT_MESSAGE)
        input = Console.readLine()
        validation()
        input = inputProcessing.toString()
        println(delimiter)
        println(input)
    }

    fun validation() { // 입력 문자열 검증
        if (input?.length == 0) return // 문자열 null 여부 확인
        inputProcessing = StringBuilder(input)
        identifyDelimiters()
        val DELIMITER_RULES = ("[$delimiter]").toRegex()
        var inputList = inputProcessing.split(DELIMITER_RULES) // 구분자를 기준으로 문자열 나누기
        for (numbers in inputList) {
            try {
                numbers.toInt() // 숫자인가?
            } catch (e: Exception) {
                throw IllegalArgumentException("입력값이 올바르지 않습니다.")
            }
        }
    }
    fun identifyDelimiters() { // 커스텀 구분자 식별
        while (CUSTOMDEVIDER_RULES.containsMatchIn(inputProcessing)) {
            val startIndex = inputProcessing.indexOf("//")
            val endIndex = inputProcessing.indexOf("\\n")
            delimiter += inputProcessing.substring(startIndex+2, endIndex)
            inputProcessing.delete(startIndex, endIndex+2)
        }
    }
}

fun main() {
    // TODO: 프로그램 구현
    val calculator = Calculator()
    calculator.initCalculator()
}