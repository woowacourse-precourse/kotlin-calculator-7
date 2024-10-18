package calculator.model

import calculator.constants.Constants.COLON
import calculator.constants.Constants.COMMA

class Calculator {
    private val errorCheck = ErrorCheck()

    fun defaultCal(inputValue: String): Int {
        val inputValueList = inputValue
            .split(COMMA, COLON)
            .map { it.toInt() }
        if (errorCheck.negativeNumberCheck(inputValueList)) return -1
        val total = inputValueList.sum()

        return total
    }

    fun customCal(inputValue: String): Int {
        val customDivider = inputValue[2]
        val inputValueList = inputValue
            .substring(5)
            .split(customDivider)
            .map { it.toInt() }
        if (errorCheck.negativeNumberCheck(inputValueList)) return -1
        val total = inputValueList.sum()

        return total
    }
}
