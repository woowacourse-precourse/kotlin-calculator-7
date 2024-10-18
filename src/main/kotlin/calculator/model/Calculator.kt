package calculator.model

class Calculator {
    fun defaultCal(inputValue: String): Int {
        val inputValueList = inputValue.split(',', ':').map { it.toInt() }
        val value = inputValueList.sum()

        return value
    }

    fun customCal(inputValue: String): Int {
        val customDivider = inputValue[2]
        val inputValueList = inputValue.split(customDivider).map { it.toInt() }
        val value = inputValueList.sum()

        return value
    }
}