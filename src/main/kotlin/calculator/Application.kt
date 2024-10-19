package calculator

import java.util.regex.Pattern

fun main() {
    val calculator = CalculatorImpl()
    calculator.start()
}

class CalculatorImpl {
    fun start() {
        println("덧셈할 문자열을 입력해 주세요.")
        process(readln())
    }
    private fun isCustomSeparator(input: String): Boolean =
        customSeparatorPattern.matcher(input).find()

    companion object {
        private const val CUSTOM_SEPARATOR_PATTERN = """^//.*\\n.*$"""
        private val customSeparatorPattern = Pattern.compile(CUSTOM_SEPARATOR_PATTERN)
    }
}