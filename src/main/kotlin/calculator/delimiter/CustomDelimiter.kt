package calculator.delimiter

import calculator.constant.DelimiterConst

object CustomDelimiter {
    private var _customDelimiter: String? = null

    val customDelimiter: String?
        get() = _customDelimiter

    private fun hasCustomDelimiter(input: String): Boolean {
        val hasCustomDelimiterPrefix: Boolean = input.startsWith(DelimiterConst.CUSTOM_DELIMITER_PREFIX)
        val customDelimiterSuffixIndex: Int = input.indexOf(DelimiterConst.CUSTOM_DELIMITER_SUFFIX)
        return hasCustomDelimiterPrefix && customDelimiterSuffixIndex == DelimiterConst.CUSTOM_DELIMITER_PREFIX.length + 1
    }

    fun extractCustomDelimiter(input: String?): String? {
        if (input != null && hasCustomDelimiter(input)) {
            val endIndexOfCustomDelimiterSuffix = input.indexOf(DelimiterConst.CUSTOM_DELIMITER_SUFFIX)
            _customDelimiter =
                input.substring(DelimiterConst.CUSTOM_DELIMITER_PREFIX.length, endIndexOfCustomDelimiterSuffix)
            val inputWithoutCustomDelimiter: String =
                getInputWithoutCustomDelimiter(input, endIndexOfCustomDelimiterSuffix)
            return inputWithoutCustomDelimiter
        }
        return input
    }

    private fun getInputWithoutCustomDelimiter(input: String, endIndexOfCustomDelimiterSuffix: Int): String {
        val inputWithoutCustomDelimiter: String = input.substring(endIndexOfCustomDelimiterSuffix + 2)
        return inputWithoutCustomDelimiter
    }
}