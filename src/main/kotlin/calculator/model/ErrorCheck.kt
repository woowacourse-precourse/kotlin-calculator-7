package calculator.model

class ErrorCheck {
    private val divider = Divider()

    fun dividerCheck(inputValue: String): Int {
        when {
            divider.isDefault(inputValue) -> return 0
            divider.isCustom(inputValue) -> return 1
        }
        return -1
    }

    fun negativeNumberCheck(inputValueList: List<Int>): Boolean {
        for (i in inputValueList.indices) {
            if (inputValueList[i] <= 0) return true
        }
        return false
    }
}
