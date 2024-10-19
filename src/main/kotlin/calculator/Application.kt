package calculator

import java.util.regex.Pattern

fun main() {
    val calculator = CalculatorImpl()
    calculator.start()
}

class CalculatorImpl {
    private var calculator: Calculator? = null

    fun start() {
        println("덧셈할 문자열을 입력해 주세요.")
        process(readln())
    }

    private fun process(input: String) {
        setCalculator(input)
        print("결과 : ${calculator?.calculate(input = input)}")
    }

    private fun setCalculator(input: String) {
        calculator = if (isCustomSeparator(input)) {
            // TODO : 커스텀 구분자 계산기
        } else {
            // TODO : 기본 구분자 계산기
        }
    }

    private fun isCustomSeparator(input: String): Boolean =
        customSeparatorPattern.matcher(input).find()

    companion object {
        private const val CUSTOM_SEPARATOR_PATTERN = """^//.*\\n.*$"""
        private val customSeparatorPattern = Pattern.compile(CUSTOM_SEPARATOR_PATTERN)
    }
}

interface Calculator {
    fun calculate(input: String): Int
}
class BasicCalculator : Calculator {
    override fun calculate(input: String): Int {
    }
}