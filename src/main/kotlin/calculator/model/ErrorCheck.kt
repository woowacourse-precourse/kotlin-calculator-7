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

    fun negativeNumberCheck(inputValueList: List<String>): Boolean {
        if (!isNumberCheck(inputValueList)) {
            val newInputValueList = inputValueList.map { it.toInt() }
            for (i in newInputValueList.indices) {
                if (newInputValueList[i] <= 0) return true
            }
        }

        return false
    }

    fun isNumberCheck(inputValueList: List<String>): Boolean {
        try {
            inputValueList.map { it.toInt() }
        } catch (e: Exception) {
            return true
        }

        return false
    }
}
