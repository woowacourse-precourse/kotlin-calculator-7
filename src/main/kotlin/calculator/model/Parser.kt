package calculator.model

import calculator.util.Validator

class Parser {
    private var delimiter: Regex = Regex("[,:]")
    private var numbers: List<Int> = mutableListOf()

    fun parse(input: String): List<Int> {
        val numberPart = extractNumberPart(input)
        val customDelimiter = extractCustomDelimiter(input)

        if (customDelimiter != null) {
            delimiter = addCustomDelimiter(customDelimiter)
        }

        val rawNumbers = numberPart.split(delimiter)

        numbers = rawNumbers.map { it.toInt() }
        Validator.validateNegativeNumbers(numbers)

        return numbers
    }

    private fun addCustomDelimiter(customDelimiter: String): Regex {
        return Regex("${delimiter.pattern}|${customDelimiter}")
    }

    private fun extractCustomDelimiter(input: String): String? {
        val delimiterIndex = input.indexOf("\\n")
        return input.substring(2, delimiterIndex)
    }

    private fun extractNumberPart(input: String): String {
        return if (input.startsWith("//")) {
            input.substringAfter("\\n")
        }
        else {
            input
        }
    }
}
