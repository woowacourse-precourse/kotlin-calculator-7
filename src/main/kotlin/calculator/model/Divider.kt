package calculator.model

import calculator.constants.Constants.COLON
import calculator.constants.Constants.COMMA
import calculator.constants.Constants.DOUBLE_BACKSLASH_N
import calculator.constants.Constants.DOUBLE_SLASH

class Divider {
    fun isDefault(inputValue: String): Boolean {
        return !isCustom(inputValue) && inputValue.contains(COMMA) || inputValue.contains(COLON)
    }

    fun isCustom(inputValue: String): Boolean {
        return (inputValue.contains(DOUBLE_SLASH) && inputValue.contains(DOUBLE_BACKSLASH_N))
    }
}
