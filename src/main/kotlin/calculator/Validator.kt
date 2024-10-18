package calculator

import calculator.PromptText.Companion.ERROR_INPUT_NULL

object Validator {

    fun validateUserInput(userInput: String?) {
        userInputNull(userInput)
    }

    private fun userInputNull(userInput: String?) {
        if(userInput == null){
            throw IllegalArgumentException(ERROR_INPUT_NULL)
        }
    }
}