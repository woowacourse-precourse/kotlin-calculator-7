package calculator

object NumberCalculator {

    fun getSumOfNumbers(numbers: List<String>): Long {
        return numbers.sumOf { number -> number.toLong() }
    }
}