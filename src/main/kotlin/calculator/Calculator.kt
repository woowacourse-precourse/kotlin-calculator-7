package calculator

private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val CUSTOM_DELIMITER_SUFFIX = "\\n"

private const val CUSTOM_DELIMITER_SUFFIX_NOT_FOUND = -1
private const val CUSTOM_DELIMITER_PREFIX_LENGTH = 2

private const val ERROR_INVALID_INPUT = "입력이 유효하지 않습니다."
private const val ERROR_SUM_OUT_OF_RANGE = "계산 결과가 Int 범위를 초과합니다."

class Calculator(private val input: String) {

    private fun separateNumbersAndDelimiter(input: String): Pair<String?, String> {
        if (input.isEmpty()) return null to ""

        return if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            extractDelimiter(input)
        } else {
            null to input
        }
    }

    private fun extractDelimiter(input: String): Pair<String, String> {
        val delimiterIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX)

        if (delimiterIndex == CUSTOM_DELIMITER_SUFFIX_NOT_FOUND) {
            throw IllegalArgumentException(ERROR_INVALID_INPUT)
        }

        val delimiter = input.substring(CUSTOM_DELIMITER_PREFIX_LENGTH, delimiterIndex)
        val numbers = input.substring(delimiterIndex + CUSTOM_DELIMITER_SUFFIX.length)
        return delimiter to numbers
    }

    private fun validateInput(numbersPart: String, delimiter: String?) {
        val isValid = numbersPart.split(delimiter ?: ",", ":").all { isValidNumber(it.trim()) }
        if (!isValid) throw IllegalArgumentException(ERROR_INVALID_INPUT)
    }

    private fun isValidNumber(value: String): Boolean {
        val number = value.toDoubleOrNull()

        return number != null && number > 0 && number <= Int.MAX_VALUE
    }

    private fun separateNumbers(numbers: String, delimiter: String?): List<Double> {
        return numbers.split(delimiter ?: ",", ":")
            .mapNotNull { it.trim().toDoubleOrNull() }
    }

    private fun calculateSum(numbers: String, delimiter: String?): Number {
        val separateNumbers = separateNumbers(numbers, delimiter)
        val sum = separateNumbers.sum()

        if (sum > Int.MAX_VALUE) {
            throw IllegalArgumentException(ERROR_SUM_OUT_OF_RANGE)
        }

        return if (sum % 1.0 == 0.0) sum.toInt() else sum
    }
}