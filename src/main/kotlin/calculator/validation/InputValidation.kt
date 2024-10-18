package calculator.validation

import calculator.constant.ErrorConst

class InputValidation {
    fun validateInput(listOfInput: List<String>?): List<String> {
        validateInputNull(listOfInput)
        val checkEmptyInput: List<String> = validateInputEmpty(listOfInput!!)
        return checkEmptyInput
    }

    private fun validateInputNull(listOfInput: List<String>?) {
        if (listOfInput == null) {
            throw IllegalArgumentException(ErrorConst.INPUT_NULL_EXCEPTION_MSG)
        }
    }

    private fun validateInputEmpty(listOfInput: List<String>): List<String> {
        return listOfInput.ifEmpty { listOf<String>("0") }
    }
}