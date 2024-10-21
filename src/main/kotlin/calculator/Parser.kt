package calculator

import calculator.utils.InputUtil

class Parser {

    /**
     * String 형태의 숫자를 구분자로 파싱
     */
    fun parseSeparator(input: String): List<String> {
        val separators = InputUtil.getSeparators(input)
        val numbers = InputUtil.getNumbers(input, separators)

        return numbers.split(*separators.toTypedArray())
    }

    /**
     * 파싱된 리스트를 숫자로 변환
     */
    fun parseNumber(list: List<String>): List<Long> {
        val numbers = mutableListOf<Long>()
        list.forEach {
            if (Validator.validatePositiveNumber(it)) {
                numbers.add(it.toLong())
            }
        }
        return numbers
    }
}