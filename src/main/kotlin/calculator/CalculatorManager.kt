package calculator

import calculator.PromptText.Companion.INPUT_PROMPT_TEXT
import calculator.PromptText.Companion.OUTPUT_PROMPT_TEXT
import camp.nextstep.edu.missionutils.Console

class CalculatorManager {
    fun start(){
        val userInput = getUserInput()
        // 사용자가 입력한 문자열 검증을 위한 함수
        Validator.validateUserInput(userInput)
        val result = NumberCalculator.addNumbers(userInput)
        printCalculate(result)
    }

    private fun getUserInput(): String?{
        println(INPUT_PROMPT_TEXT)
        return Console.readLine()
    }

    private fun printCalculate(result: Int){
        println(OUTPUT_PROMPT_TEXT + result)
    }
}