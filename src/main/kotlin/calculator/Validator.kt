package calculator

import calculator.PromptText.Companion.DELIMITER_TYPE_COLON
import calculator.PromptText.Companion.DELIMITER_TYPE_COMMA
import calculator.PromptText.Companion.ERROR_INPUT_CUSTOM_DELIMITER
import calculator.PromptText.Companion.ERROR_INPUT_CUSTOM_DELIMITER_COUNT
import calculator.PromptText.Companion.ERROR_INPUT_NULL
import calculator.PromptText.Companion.INPUT_DELIMITER_END
import calculator.PromptText.Companion.INPUT_DELIMITER_FRONT

object Validator {
    private val delimiterList = mutableListOf(DELIMITER_TYPE_COMMA, DELIMITER_TYPE_COLON)

    fun validateUserInput(userInput: String?) {
        userInputNull(userInput)
        userInputCustomDelimiter(userInput!!)
    }

    private fun userInputNull(userInput: String?) {
        if(userInput == null){
            throw IllegalArgumentException(ERROR_INPUT_NULL)
        }
    }

    private fun userInputCustomDelimiter(userInput: String) {
        if(userInput.startsWith(INPUT_DELIMITER_FRONT)){
            val frontOfCustomDelimiter = userInput.indexOf(INPUT_DELIMITER_FRONT)
            val endOfCustomDelimiter = userInput.indexOf(INPUT_DELIMITER_END)
            if(endOfCustomDelimiter == -1){
                throw IllegalArgumentException(ERROR_INPUT_CUSTOM_DELIMITER)
            }
            if(endOfCustomDelimiter != 3){
                throw IllegalArgumentException(ERROR_INPUT_CUSTOM_DELIMITER_COUNT)
            }
            delimiterList.add(userInput.substring(frontOfCustomDelimiter+2, endOfCustomDelimiter))
        }
    }
}