package calculator.utils

import calculator.Validator

object InputUtil {

    /**
     * 커스텀 구분자 및 기본 구분자를 List 혈태로 반환
     */
    fun getSeparators(input: String): List<String> {
        val defalutSeparators = listOf(",", ":")
        val regex = """^//(.+)\\n(.*)""".toRegex()
        val matchResult = regex.find(input)

        return when {
            matchResult != null -> {
                val customSeparator = matchResult.groupValues[1]
                when {
                    Validator.validateCustomSeparatorLength(customSeparator) -> {
                        Validator.validateCustomSeparator(customSeparator.single())
                        defalutSeparators + customSeparator
                    }

                    else -> defalutSeparators
                }
            }

            else -> defalutSeparators
        }
    }

    /**
     * 입력한 숫자와 구분자를 포함한 리스트를 String형태로 반환
     */
    fun getNumbers(input: String, separator: List<String>): String {
        return if (separator.size > 2) {
            input.substringAfter("\\n")
        } else {
            input
        }
    }
}