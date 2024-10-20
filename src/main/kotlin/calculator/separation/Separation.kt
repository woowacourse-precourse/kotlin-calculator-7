package calculator.separation

import calculator.constant.DelimiterConst
import calculator.delimiter.CustomDelimiter

class Separation {
    fun splitInput(input: String?): List<String>? {
        if (input == null) return null
        if (input == "") return listOf<String>()
        return if (CustomDelimiter.customDelimiter != null) {
            input.split(DelimiterConst.CLONE, DelimiterConst.COMMA, CustomDelimiter.customDelimiter!!)
        } else {
            input.split(DelimiterConst.CLONE, DelimiterConst.COMMA)
        }
    }
}
