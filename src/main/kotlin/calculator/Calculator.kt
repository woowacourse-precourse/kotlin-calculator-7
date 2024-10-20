package calculator

class Calculator {
    private val ioHandler = IOHandler()
    private val preprocessor = Preprocessor()

    fun calculate() {
        val input = ioHandler.inputNumber()
        val numberList = preprocessor.preprocessInput(InputString(input))
        ioHandler.printSum(sumNumbers(numberList))
    }

    private fun sumNumbers(numbers: List<Int>): Int {
        return numbers.sum()
    }
}

data class InputString(var input: String?)