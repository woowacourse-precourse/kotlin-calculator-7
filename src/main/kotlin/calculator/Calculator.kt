package calculator

class Calculator {

    fun calculateSum(parsedInput: String, separatorList: MutableList<String>): Int {
        val separatorPattern = separatorList.joinToString("|") { Regex.escape(it) }
        val numbers = parsedInput.split(Regex(separatorPattern))
        var sum = 0

        for (number in numbers) {
            number.takeIf { it.isNotBlank() } ?: throw IllegalArgumentException(ErrorMessages.NUMBER_NOT_PROVIDED)
            number.takeIf { it >= "0" } ?: throw IllegalArgumentException(ErrorMessages.INVALID_NEGATIVE)
            sum += number.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.INVALID_CHARACTER)
        }
        return sum
    }
}