package calculator

class PlusCalculator : Calculator {
    override fun execute(numbers: MutableList<Int>): Int {
        var sum = 0
        numbers.forEach {
            sum += it
        }
        return sum
    }
}