package calculator

class Validation {
    fun didEnterCorrect(numbers: List<String>) {
        if (doesListHaveEmptyValue(numbers) || isListNotDigit(numbers)) {
            throw IllegalArgumentException()
        }
    }

    private fun doesListHaveEmptyValue(numbers: List<String>): Boolean {
        return numbers.contains("")
    }

    private fun isListNotDigit(numbers: List<String>): Boolean {
        return numbers.any { !it.single().isDigit() }
    }
}