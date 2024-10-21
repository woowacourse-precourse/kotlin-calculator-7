package calculator.model

import calculator.constants.Constants.COLON
import calculator.constants.Constants.COMMA
import calculator.constants.Constants.DOUBLE_BACKSLASH_N
import calculator.constants.Constants.DOUBLE_SLASH

class Calculator {
    private val errorCheck = ErrorCheck()

    fun defaultCal(inputValue: String): Int {   //기본 구분자일 때 계산
        val inputValueList = inputValue.split(COMMA, COLON)

        if (errorCheck.negativeNumberCheck(inputValueList) ||
            errorCheck.isNumberCheck(inputValueList)) {
            return -1
        }
        val total = inputValueList.sumOf { it.toInt() }

        return total
    }

    fun customCal(inputValue: String): Int {    //커스텀 구분자일 때 계산
        val startIndex = inputValue.indexOf(DOUBLE_SLASH) + 2
        val endIndex = inputValue.indexOf(DOUBLE_BACKSLASH_N)
        val customDivider = inputValue.substring(startIndex, endIndex)
        val inputValueList = inputValue
            .substring(endIndex + 2)
            .split(customDivider)
        if (errorCheck.negativeNumberCheck(inputValueList) ||
            errorCheck.isNumberCheck(inputValueList)) {
            return -1
        }
        val total = inputValueList.sumOf { it.toInt() }

        return total
    }
}
