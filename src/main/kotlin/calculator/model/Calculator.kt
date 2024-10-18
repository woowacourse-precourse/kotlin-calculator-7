package calculator.model

class Calculator {
    fun defaultCal(inputValue: String): Int {
        val inputValueList = inputValue.split(',', ':').map { it.toInt() }
        if (negativeNumberCheck(inputValueList)) return -1
        val value = inputValueList.sum()

        return value
    }

    fun customCal(inputValue: String): Int {
        val customDivider = inputValue[2]
        val inputValueList = inputValue.substring(5).split(customDivider).map { it.toInt() }
        if (negativeNumberCheck(inputValueList)) return -1
        val value = inputValueList.sum()

        return value
    }

    private fun negativeNumberCheck(inputValueList: List<Int>): Boolean {
        for (i in inputValueList.indices) {
            if (inputValueList[i] < 0) return true
        }
        return false
    }
}
