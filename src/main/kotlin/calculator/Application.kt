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
            BasicCalculator()
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
        validate(input)
    }

    private fun validate(input: String) {
        val inputs = input.split(",", ":")
        return when {
            input.isEmpty() -> Unit
            inputs.any { it.first() == '+' || it.first() == '-' } -> throw IllegalArgumentException("+ 또는 - 으로 시작하는 숫자가 있는 경우")
            inputs.any { it.first() == '0' } -> throw IllegalArgumentException("0 으로 시작한 숫자가 있는 경우")
            inputs.map { it.toIntOrNull() }.any { it == null } -> throw IllegalArgumentException("숫자 형식(Int)이 올바르지 않은 경우(기본 구분자가 아닌 문자포함, 공백포함, 오버플로우)")
            inputs.isOverflowOnIntSum() -> throw IllegalArgumentException("합계가 양수(Int)범위를 넘어갈 경우(오버플로우)")
            else -> Unit
        }
    }
}


fun List<String>.isOverflowOnIntSum(): Boolean {
    var sum = 0
    this.forEach {
        sum += it.toInt()
        if (sum < 0) {
            return true
        }
    }
    return false
}