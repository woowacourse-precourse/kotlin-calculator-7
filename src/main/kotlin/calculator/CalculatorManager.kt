package calculator

import calculator.PromptText.Companion.INPUT_PROMPT_TEXT
import camp.nextstep.edu.missionutils.Console

class CalculatorManager {
    fun start(){
        val userInput = getUserInput()
        Validator.validateUserInput(userInput)
    }

    private fun getUserInput(): String?{
        println(INPUT_PROMPT_TEXT)
        return Console.readLine()
    }
}