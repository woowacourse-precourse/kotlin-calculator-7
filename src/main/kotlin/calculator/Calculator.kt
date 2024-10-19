package calculator

object Calculator {
    private var result = 0

    fun getResult() = result

    fun sum(input: List<Int>) {
        result = input.sumOf { it }
    }

    fun reset() {
        result = 0
    }
}