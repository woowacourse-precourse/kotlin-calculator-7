package calculator.model

class Calculator(
    private val nums: List<Int>
) {
    private var result = 0

    init {
        result = nums.sum()
    }

    fun getResult(): Int = result
}