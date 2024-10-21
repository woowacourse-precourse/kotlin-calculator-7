package calculator

import camp.nextstep.edu.missionutils.Console
import kotlin.text.StringBuilder

class Calculator(input: String) {
    private var inputProcessing: StringBuilder
    private var ans: Int = 0
    private var delimiter: String = ",:"
    private val customDelimiterRule = """//(.+)\\n""".toRegex()

    init {
        inputProcessing = StringBuilder(input)
    }

    fun calculate() {
        val delimiterRules = ("[$delimiter]").toRegex()
        val numberList = validationCheck(delimiterRules)
        ans = numberList.sum()

        identifyDelimiters()
        println("결과 : $ans")
    }

    private fun validationCheck(delimiterRules: Regex): Array<Int> {
        try {
            return validate(delimiterRules)
        } catch (e: Exception) {
            throw IllegalArgumentException("잘못된 값을 입력하여 종료합니다.")
        }
    }

    private fun validate(delimiterRules: Regex): Array<Int> {
        val stringList = inputProcessing.split(delimiterRules)
        val numberList = Array<Int>(stringList.size) {0}
        var num = 0

        for (i in 0..stringList.lastIndex) {
            num = stringList[i].toInt()

            if (num < 1) throw IllegalArgumentException("잘못된 값을 입력하여 종료합니다.")

            numberList[i] = num
        }

        return numberList
    }

    private fun identifyDelimiters() {
        while (customDelimiterRule.containsMatchIn(inputProcessing)) {
            val startIndex = inputProcessing.indexOf("//")
            val endIndex = inputProcessing.indexOf("\\n")
            delimiter += inputProcessing.substring(startIndex + 2, endIndex)

            inputProcessing.delete(startIndex, endIndex + 2)
        }
    }
}

fun main() {
    val calculator = Calculator(Console.readLine())

    calculator.calculate()
}