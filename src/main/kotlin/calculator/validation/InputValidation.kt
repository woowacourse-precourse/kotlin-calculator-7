package calculator.validation

import calculator.constant.ErrorConst

class InputValidation {
    fun validateInput(listOfInput: List<String>?): List<String> {
        validateInputNull(listOfInput)
        val checkEmptyInput: List<String> = validateInputEmpty(listOfInput!!)
        val checkIsNumberInput = validateInputNumber(checkEmptyInput)
        return checkIsNumberInput
    }

    private fun validateInputNull(listOfInput: List<String>?) {
        if (listOfInput == null) {
            throw IllegalArgumentException(ErrorConst.INPUT_ERROR_MSG + ErrorConst.INPUT_NULL_EXCEPTION_MSG)
        }
    }

    private fun validateInputEmpty(listOfInput: List<String>): List<String> {
        return listOfInput.ifEmpty { listOf<String>("0") }
    }

    private fun validateInputNumber(listOfInput: List<String>): List<String> {
        for (element in listOfInput) {
            if (!isNumber(element) || !isPositiveNumber(element)) {
                validateInputElement(element)
            }
        }
        return listOfInput
    }

    private fun isNumber(element: String): Boolean = element.toIntOrNull() != null

    private fun isPositiveNumber(element: String): Boolean = element.toInt() >= 0

    private fun validateInputElement(element: String) {
        if (element.any { it.isLetter() }) {
            throw IllegalArgumentException(ErrorConst.INPUT_ERROR_MSG + element + ErrorConst.INPUT_LETTER_EXCEPTION_MSG)
        }
        if (element.any { it.isWhitespace() }) {
            throw IllegalArgumentException(ErrorConst.INPUT_ERROR_MSG + element + ErrorConst.INPUT_WHITESPACE_EXCEPTION_MSG)
        }
        if (element.any { it.isSurrogate() }) {
            throw IllegalArgumentException(ErrorConst.INPUT_ERROR_MSG + element + ErrorConst.INPUT_SURROGATE_EXCEPTION_MSG)
        }
        if (element.contains("\u0008") || element.contains("\u0009") || element.contains("\u001B")) {
            throw IllegalArgumentException(ErrorConst.INPUT_ERROR_MSG + element + ErrorConst.INPUT_ESCAPE_EXCEPTION_MSG)
        }
        if (element.toIntOrNull() == null) {
            throw IllegalArgumentException(ErrorConst.INPUT_ERROR_MSG + element + ErrorConst.INPUT_NOT_NUMBER_EXCEPTION_MSG)
        }
        if (element.toInt() < 0) {
            throw IllegalArgumentException(ErrorConst.INPUT_ERROR_MSG + element + ErrorConst.INPUT_NOT_POSITIVE_NUMBER_EXCEPTION_MSG)
        }
    }
}