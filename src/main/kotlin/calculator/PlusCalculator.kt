package calculator

class PlusCalculator : Calculator {
    override fun execute(numbers: List<Long>): Long {
        var sum = 0L
        numbers.forEach {
            sum += it
        }
        return sum
    }
}