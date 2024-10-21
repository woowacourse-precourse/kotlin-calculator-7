package calculator
import camp.nextstep.edu.missionutils.Console

class CalculatorManager {
    fun start(){

    }

    private fun promptUserInput(){
        println(Constant.INPUT_PROMPT)
        Console.readLine()
    }

    private fun displayResult(result: Int){
        println(Constant.OUTPUT_PROMPT + result)
    }
}