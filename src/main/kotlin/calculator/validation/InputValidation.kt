package calculator.validation

import calculator.constant.ErrorConst

class InputValidation {
    fun validateInput(listOfUserInput: List<String>?): List<String> {
        validateInputNull(listOfUserInput)
        val checkEmpty: List<String> = validateEmpty(listOfUserInput!!)
        val checkEmptyAndWhitespace: List<String> = validateInputEmptyAndWhitespace(checkEmpty)
        val checkNumber = validateInputNumber(checkEmptyAndWhitespace)
        return checkNumber
    }

    private fun validateInputNull(listOfUserInput: List<String>?) {
        if (listOfUserInput == null) {
            throw IllegalArgumentException(ErrorConst.INPUT_ERROR_MSG + ErrorConst.INPUT_NULL_EXCEPTION_MSG)
        }
    }

    // enter(\n)만 입력한 경우
    private fun validateEmpty(listOfUserInput: List<String>): List<String> {
        return listOfUserInput.ifEmpty { listOf<String>("0") }
    }

    // 공백과 요소의 값이 빈 경우
    private fun validateInputEmptyAndWhitespace(listOfUserInput: List<String>): List<String> {
        val mutableListOfInput = listOfUserInput.toMutableList()
        for (idx in mutableListOfInput.indices) {
            mutableListOfInput[idx] = isEmpty(mutableListOfInput[idx])
            mutableListOfInput[idx] = isWhitespace(mutableListOfInput[idx])
        }
        return mutableListOfInput
    }

    private fun validateInputNumber(listOfUserInput: List<String>): List<String> {
        for (element in listOfUserInput) {
            if (!isNumber(element) || !isPositiveNumber(element)) {
                validateInputElement(element)
            }
        }
        return listOfUserInput
    }

    private fun isWhitespace(element: String): String = if (element.all { it.isWhitespace() }) "0" else element

    private fun isEmpty(element: String): String = if (element.isEmpty()) "0" else element

    private fun isNumber(element: String): Boolean = element.toIntOrNull() != null

    private fun isPositiveNumber(element: String): Boolean = element.toInt() >= 0

    private fun validateInputElement(element: String) {
        if (element.any { it.isLetter() }) {
            throw IllegalArgumentException(ErrorConst.INPUT_ERROR_MSG + element + ErrorConst.INPUT_LETTER_EXCEPTION_MSG)
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