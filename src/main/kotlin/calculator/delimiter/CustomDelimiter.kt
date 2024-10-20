package calculator.delimiter

import calculator.constant.DelimiterConst

object CustomDelimiter {
    private var _customDelimiter: String? = null

    val customDelimiter: String?
        get() = _customDelimiter

    fun extractCustomDelimiter(userInput: String?): String? {
        if (userInput != null && hasCustomDelimiter(userInput)) {
            val indexOfCustomDelimiterSuffix = userInput.indexOf(DelimiterConst.CUSTOM_DELIMITER_SUFFIX)
            _customDelimiter =
                userInput.substring(DelimiterConst.CUSTOM_DELIMITER_PREFIX.length, indexOfCustomDelimiterSuffix)
            val userInputWithoutCustomDelimiter: String =
                getInputWithoutCustomDelimiter(userInput, indexOfCustomDelimiterSuffix)
            return userInputWithoutCustomDelimiter
        }
        return userInput
    }

    private fun hasCustomDelimiter(userInput: String): Boolean {
        val hasCustomDelimiterPrefix: Boolean = userInput.startsWith(DelimiterConst.CUSTOM_DELIMITER_PREFIX)
        val customDelimiterSuffixIndex: Int = userInput.indexOf(DelimiterConst.CUSTOM_DELIMITER_SUFFIX)
        return hasCustomDelimiterPrefix && customDelimiterSuffixIndex == DelimiterConst.CUSTOM_DELIMITER_PREFIX.length + 1
    }

    private fun getInputWithoutCustomDelimiter(userInput: String, indexOfCustomDelimiterSuffix: Int): String {
        val userInputWithoutCustomDelimiter: String = userInput.substring(indexOfCustomDelimiterSuffix + 2)
        return userInputWithoutCustomDelimiter
    }
}