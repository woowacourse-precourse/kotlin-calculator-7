package calculator

class PlusCalculator : Calculator {
    override fun execute(numbers: MutableList<Long>): Long {
        var sum = 0L
        numbers.forEach {
            sum += it
        }
        return sum
    }
}