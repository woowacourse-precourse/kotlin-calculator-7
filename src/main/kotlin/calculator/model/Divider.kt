package calculator.model

import calculator.constants.Constants.COLON
import calculator.constants.Constants.COMMA
import calculator.constants.Constants.DOUBLE_BACKSLASH_N
import calculator.constants.Constants.DOUBLE_SLASH

class Divider {
    fun checkDivider(inputValue: String): Int {
        when {
            isDefault(inputValue) -> return 0
            isCustom(inputValue) -> return 1
        }
        return 2
    }

    private fun isDefault(inputValue: String): Boolean {
        return !isCustom(inputValue) && inputValue.contains(COMMA) || inputValue.contains(COLON)
    }

    private fun isCustom(inputValue: String): Boolean {
        return (inputValue.contains(DOUBLE_SLASH) && inputValue.contains(DOUBLE_BACKSLASH_N))
    }
}
