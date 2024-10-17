package calculator

import camp.nextstep.edu.missionutils.Console

class Calculator(input: String) {
    private val separator: Array<String>
    private val numbers: IntArray

    init {
        separator = getSeparator(input) ?: arrayOf(",", ":")
        numbers = getNumbers(input)
    }

    private fun getSeparator(input: String): Array<String>? {
        val startIdx = input.indexOf("""//""").let { if (it == -1) return null else it + 2 }
        val endIdx = input.indexOf("""\n""").let { if (it <= startIdx) throw IllegalArgumentException() else it }
        return arrayOf(input.substring(startIdx, endIdx))
    }

    private fun getNumbers(input: String): IntArray {
        try {
            val startIdx = input.indexOf("""//""") + 2
            val endIdx = input.indexOf("""\n""")
            val numbers = (if (startIdx in 2 until endIdx) input.substring(endIdx + 2) else input)
                .split(*separator).map(String::toInt).toIntArray()
            if (numbers.any { it <= 0 }) throw IllegalArgumentException()
            return numbers
        } catch (e: Exception) {
            throw IllegalArgumentException()
        }
    }

    fun result() = "결과 : ${numbers.sum()}"
}

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()
    val calculator = Calculator(input)
    println(calculator.result())
}
