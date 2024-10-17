package calculator

import camp.nextstep.edu.missionutils.Console
import java.lang.StringBuilder

class Calculator {
    private val INIT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    private var input: String? = ""
    private lateinit var inputProcessing: StringBuilder
    private var answer: Int = 0
    private var delimiter: String = ",:"
    private val CUSTOMDEVIDER_RULES = """//(.+)\\n""".toRegex()

    fun initCalculator() { // 계산기 초기화
        println(INIT_MESSAGE)
        input = readLine()
        inputProcessing = StringBuilder(input)
        identifyDelimiters()
    }



    fun identifyDelimiters() { // 커스텀 구분자 식별
        while (CUSTOMDEVIDER_RULES.containsMatchIn(inputProcessing)) {
            val startIndex = inputProcessing.indexOf("//")
            val endIndex = inputProcessing.indexOf("\\n")
            delimiter += inputProcessing.substring(startIndex+2, endIndex)
            inputProcessing.delete(startIndex, endIndex+2)
        }
    }

    // TODO: 숫자 식별 및 합산

    fun finCalculator() { // 계산기 종료
        input = inputProcessing.toString()
        println(delimiter)
        println(input)
    }
}

fun main() {
    // TODO: 프로그램 구현
    val calculator = Calculator()
    calculator.initCalculator()

    calculator.finCalculator()
}
