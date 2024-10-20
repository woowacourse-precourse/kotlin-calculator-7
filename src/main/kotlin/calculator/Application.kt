package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    val textCalculator: TextCalculator = TextSumCalculator()
    val result = textCalculator.calculate(input)

    println("결과 : $result")
}

interface TextCalculator {
    fun calculate(input: String): Number
}

class TextSumCalculator : TextCalculator {
    private val divider = mutableListOf<String>(",", ":")
    private var isCustomDividerUsed: Boolean = true

    override fun calculate(input: String): Number {
        val splitInput = input.split(CUSTOM_DIVIDER_PREFIX, CUSTOM_DIVIDER_SUFFIX)

        if (!checkInputTypeAndValidity(splitInput)) throw IllegalArgumentException(INVALID_INPUT_MESSAGE)

        val numbers = splitInput.splitByDivider()
        return numbers.getSum()
    }

    private fun checkInputTypeAndValidity(input: List<String>): Boolean {
        return when {
            isInputExceeding(input) -> false
            isCustomDividerNotUsed(input) -> true
            isInvalidCustom(input) -> false
            else -> {
                addCustomDivider(input)
                return true
            }
        }
    }

    private fun isInputExceeding(input: List<String>): Boolean {
        return input.size >= CUSTOM_DIVIDER_EXCEEDING_SIZE
    }

    private fun isCustomDividerNotUsed(input: List<String>): Boolean {
        val isCustomDividerNotUsed = input.size == CUSTOM_DIVIDER_NONE_SIZE
        isCustomDividerUsed = isCustomDividerNotUsed.not()
        return isCustomDividerNotUsed
    }

    private fun isInvalidCustom(input: List<String>): Boolean {
        return input.first().isNotBlank()
    }

    private fun addCustomDivider(input: List<String>) {
        divider.add(input[CUSTOM_DIVIDER_INDEX])
    }

    private fun List<String>.splitByDivider(): List<Double> {
        if (this == listOf("")) return emptyList()

        val regex = divider.joinToString("|") { Regex.escape(it) }.toRegex()
        val expression = when (isCustomDividerUsed) {
            true -> this[NUMBERS_WITH_CUSTOM_DIVIDER_INDEX]
            false -> this[NUMBERS_WITHOUT_CUSTOM_DIVIDER_INDEX]
        }

        val splitResult = expression.split(regex)
        return splitResult.map { it.toValidNumber() }
    }

    private fun String.toValidNumber(): Double {
        return try {
            val number = this.toDouble()
            checkIsPositiveNumber(number)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_INPUT_MESSAGE)
        }
    }

    private fun checkIsPositiveNumber(number: Double): Double {
        if (number <= 0.0) throw IllegalArgumentException(INVALID_INPUT_MESSAGE)
        return number
    }

    private fun List<Double>.getSum(): Number {
        var sum = 0.0

        this.forEach { number ->
            sum += number
        }

        return if (sum % 1 == 0.0) sum.toLong() else sum
    }

    companion object {
        private const val INVALID_INPUT_MESSAGE = "유효하지 않은 입력입니다."
        private const val CUSTOM_DIVIDER_PREFIX = "//"
        private const val CUSTOM_DIVIDER_SUFFIX = "\\n"

        private const val CUSTOM_DIVIDER_EXCEEDING_SIZE = 4
        private const val CUSTOM_DIVIDER_NONE_SIZE = 1

        private const val CUSTOM_DIVIDER_INDEX = 1
        private const val NUMBERS_WITH_CUSTOM_DIVIDER_INDEX = 2
        private const val NUMBERS_WITHOUT_CUSTOM_DIVIDER_INDEX = 0
    }
}
