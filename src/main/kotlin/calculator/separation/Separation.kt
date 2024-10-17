package calculator.separation

import calculator.constant.DelimiterConst
import calculator.delimiter.CustomDelimiter

class Separation {
    fun splitInput(input: String?, customDelimiter: CustomDelimiter): List<String>? {
        if (input == null) return null
        if (input == "") return listOf<String>()
        return if (customDelimiter.customDelimiter != null) {
            input.split(DelimiterConst.CLONE, DelimiterConst.COMMA, customDelimiter.customDelimiter!!)
        } else {
            input.split(DelimiterConst.CLONE, DelimiterConst.COMMA)
        }
    }
}
