package calculator
import camp.nextstep.edu.missionutils.Console

class CalculatorManager {
    fun start(){
        val input = promptUserInput()
        val (delimiters, numbersString) = DelimiterExtractor.extractDelimiters(input)
        val tokens = StringSplitter.split(numbersString, delimiters)
        val numbers = NumberParser.parseNumbers(tokens)
        val result = Calculator.calculateSum(numbers)
        displayResult(result)
    }

    private fun promptUserInput(): String{
        println(Constant.INPUT_PROMPT)
        return Console.readLine()
    }

    private fun displayResult(result: Int){
        println(Constant.OUTPUT_PROMPT + result)
    }
}