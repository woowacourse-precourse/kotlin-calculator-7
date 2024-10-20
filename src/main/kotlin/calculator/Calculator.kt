package calculator

class Calculator(private val expression: String, private val delimiters: List<String>) {
    fun calculateSum(): Int {
        val numbers = getNumberList()
        validateNoNegativeNumber(numbers)
        return numbers.getSum()
    }

    // 구분자로 숫자 추출
    private fun getNumberList(): List<Int> {
        try {
            return splitByDelimiters(expression, delimiters).toNumbers()
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_UNABLE_TO_EXTRACT_NUMBERS)
        }
    }

    // 구분자로 분리
    private fun splitByDelimiters(input: String, delimiters: List<String>) =
        input.split(*delimiters.toTypedArray()).filter { it.isNotBlank() }

    // 숫자로 변환
    private fun List<String>.toNumbers() = this.map { it.toInt() }

    // 음수 존재하면 Exception 발생
    private fun validateNoNegativeNumber(numbers: List<Int>) {
        if (numbers.hasNegativeNumber()) throw IllegalArgumentException(ERROR_CONTAINS_NEGATIVE_NUMBERS)
    }

    // 음수 존재 여부 확인
    private fun List<Int>.hasNegativeNumber() = this.any { it < 0 }

    // 합 계산
    private fun List<Int>.getSum() = this.sum()

    companion object {
        const val ERROR_UNABLE_TO_EXTRACT_NUMBERS = "Unable to extract numbers"
        const val ERROR_CONTAINS_NEGATIVE_NUMBERS = "Contains negative numbers"
    }
}