package calculator

class Calculator(private val numbers: List<String>) {

    fun sumOfSplitNumbers(): Int {
        if (numbers.areAllDigits()) {
            return numbers.sumOfNumbers()
        } else {
            throw IllegalArgumentException(INVALID_INPUT)
        }
    }

    private fun List<String>.sumOfNumbers(): Int {
        return this.sumOf { it.toIntOrNull() ?: 0 }
    }

    private fun List<String>.areAllDigits(): Boolean {
        return this.all { it.all { char -> char.isDigit() } }
    }

    companion object {
        const val INVALID_INPUT = "잘못된 입력값이 들어왔습니다."
    }
}