package calculator

import camp.nextstep.edu.missionutils.Console.readLine

object CommandLineView : View {
    override fun read(): String = readLine()
    override fun show(content: String) = print(content)
    override fun sum() {
        val input = read()
        val numbers: List<Double> = Parser.parseToNumbers(input)
        val result = Calculator.sum(numbers)
        show(if (result % 1.0 == 0.0) "결과 : ${result.toInt()}" else "결과 : $result")
    }
}