package calculator

import calculator.PromptText.Companion.DELIMITER_TYPE_COLON
import calculator.PromptText.Companion.DELIMITER_TYPE_COMMA
import calculator.PromptText.Companion.ERROR_INPUT_CUSTOM_DELIMITER
import calculator.PromptText.Companion.ERROR_INPUT_CUSTOM_DELIMITER_COUNT
import calculator.PromptText.Companion.ERROR_INPUT_NOT_EXPRESSION
import calculator.PromptText.Companion.ERROR_INPUT_NULL
import calculator.PromptText.Companion.INPUT_DELIMITER_END
import calculator.PromptText.Companion.INPUT_DELIMITER_FRONT

object Validator {
    private val delimiterList = mutableListOf(DELIMITER_TYPE_COMMA, DELIMITER_TYPE_COLON)

    fun validateUserInput(userInput: String?) {
        userInputNull(userInput)
        if (userInput!!.isEmpty()) return
        userInputCustomDelimiter(userInput)
        userInputRightExpression(userInput)
    }

    // 사용자 입력이 null 인지 아닌지를 판단하는 함수
    private fun userInputNull(userInput: String?) {
        if(userInput == null){
            throw IllegalArgumentException(ERROR_INPUT_NULL)
        }
    }

    // 사용자가 입력한 문자열이 올바른 커스텀 구분자로 이루어짔는지 확인하는 함수
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
            // 커스텀 구분자를 추출하여 구분자 리스트에 추가
            delimiterList.add(userInput.substring(frontOfCustomDelimiter+2, endOfCustomDelimiter))
        }
    }

    // 커스텀 구분자 의외에 다른 구분자를 사용하고 있는지 확인하는 함수
    private fun userInputRightExpression(userInput: String) {
        val endOfCustomDelimiter = if (userInput.startsWith(INPUT_DELIMITER_FRONT)) {
            userInput.indexOf(INPUT_DELIMITER_END) + 2
        } else {
            0
        }
        val expression = userInput.substring(endOfCustomDelimiter)
        if (expression.isNotEmpty() && !expression.matches(Regex("^\\d+([${delimiterList.joinToString("")}]\\d*)*\$"))) {
            throw IllegalArgumentException(ERROR_INPUT_NOT_EXPRESSION)
        }
    }

    // 구분자를 기준으로 수를 추출하여 list형으로 계산식에 반환하는 함수
    fun returnNumber(userInput: String): List<Int> {
        val endOfCustomDelimiter = if (userInput.startsWith(INPUT_DELIMITER_FRONT)) {
            userInput.indexOf(INPUT_DELIMITER_END) + 2
        } else {
            0
        }
        val expression = userInput.substring(endOfCustomDelimiter)
        val numbers = expression.split(Regex("[" + delimiterList.joinToString("") + "]"))
            .map { it.ifEmpty { "0" } }
            .map { it.toInt() }
        return numbers
    }
}