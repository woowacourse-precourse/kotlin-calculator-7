package calculator

class ViewModel {
    var userInput: String? = null
    val sumOutput: String
        get() {
            val numbers: List<Double> = Parser.parseToNumbers(userInput ?: throw IllegalArgumentException())
            val result = Calculator.sum(numbers)
            return if (result % 1.0 == 0.0) "결과 : ${result.toInt()}" else "결과 : $result"
        }
}