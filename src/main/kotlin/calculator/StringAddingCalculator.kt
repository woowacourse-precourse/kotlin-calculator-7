package calculator

import camp.nextstep.edu.missionutils.Console

class StringAddingCalculator {
    fun runCalculator() {
        while (true) {
            try {
                println("덧셈할 문자열을 입력해 주세요.")
                val inputText = Console.readLine()
                val sum = calculateSum(inputText)
                println("결과 : $sum")
            } catch (e: IllegalArgumentException) {
                println(e.message)
                break
            }
        }
    }

    private fun calculateSum(inputText: String): Int {
        if (inputText.isBlank()) {
            throw IllegalArgumentException("빈 문자열은 입력할 수 없습니다.")
        }

        val (numbers, delimiters) = divideInputText(inputText)
        println(numbers)

        val numberList = divideNumbers(numbers, delimiters)
        return sumValidNumbers(numberList)
    }

    private fun divideInputText(inputText: String): Pair<String, List<String>> {
        return if (inputText.startsWith("//")) {
            val customDelimiterEndIndex = inputText.indexOf("\\n")
            if (customDelimiterEndIndex == -1) {
                throw IllegalArgumentException("구분자 형식이 올바르지 않습니다.")
            }

            val customDelimiter = inputText.substring(2, customDelimiterEndIndex)
            val numbers = inputText.substring(customDelimiterEndIndex + 2)

            Pair(numbers, listOf(customDelimiter))
        } else {
            Pair(inputText, listOf(",", ":"))
        }
    }

    private fun divideNumbers(numbers: String, delimiters: List<String>): List<String> {
        return numbers.split(*delimiters.toTypedArray())
            .filter { it.isNotBlank() }
            .map { it.trim() }
    }

    private fun sumValidNumbers(numberList: List<String>): Int {
        return numberList.sumOf { number ->
            val parsedNumber = parseAndValidateNumber(number)
            parsedNumber
        }
    }

    private fun parseAndValidateNumber(number: String): Int {
        return number.toIntOrNull()?.takeIf { it >= 0 }
            ?: throw IllegalArgumentException("음수는 입력할 수 없습니다: $number")
    }
}