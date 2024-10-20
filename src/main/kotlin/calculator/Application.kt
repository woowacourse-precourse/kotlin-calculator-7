package calculator

import camp.nextstep.edu.missionutils.Console
import kotlin.text.StringBuilder

class Calculator(input: String) {
    private var inputProcessing: StringBuilder
    private var answer: Int = 0
    private var delimiter: String = ",:"
    private val customDelimiterRule = """//(.+)\\n""".toRegex()

    init {
        inputProcessing = StringBuilder(input)
    }

    fun calculate() {
        identifyDelimiters()
        val delimiterRules = ("[$delimiter]").toRegex()
        val numberList = validationCheck(delimiterRules)
        answer = numberList.sum()
        println("결과 : $answer")
    }

    private fun identifyDelimiters() {
        while (customDelimiterRule.containsMatchIn(inputProcessing)) {
            val startIndex = inputProcessing.indexOf("//")
            val endIndex = inputProcessing.indexOf("\\n")
            delimiter += inputProcessing.substring(startIndex + 2, endIndex)
            inputProcessing.delete(startIndex, endIndex + 2)
        }
    }

    private fun validationCheck(delimiterRules: Regex): Array<Int> {
        try {
            return validate(delimiterRules)
        } catch (e: Exception) {
            throw IllegalArgumentException("입력값이 올바르지 않습니다.")
        }
    }

    private fun validate(delimiterRules: Regex): Array<Int> {
        val stringList = inputProcessing.split(delimiterRules)
        val numberList = Array<Int>(stringList.size) { 0 }
        var number = 0
        for (i in 0..stringList.lastIndex) {
            number = stringList[i].toInt()
            if (number < 1) throw IllegalArgumentException("입력값이 올바르지 않습니다.")
            numberList[i] = number
        }
        return numberList
    }
}

fun main() {
    val calculator = Calculator(Console.readLine())
    calculator.calculate()
}