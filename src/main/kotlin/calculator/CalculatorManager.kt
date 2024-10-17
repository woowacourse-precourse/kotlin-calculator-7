package calculator

import calculator.PromptText.Companion.INPUT_PROMPT_TEXT
import camp.nextstep.edu.missionutils.Console

class CalculatorManager {
    fun start(){
        println(INPUT_PROMPT_TEXT)
    }
    private fun getUserInput(): String?{
        return Console.readLine()
    }
}