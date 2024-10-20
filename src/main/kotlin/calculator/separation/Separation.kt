package calculator.separation

import calculator.constant.DelimiterConst
import calculator.delimiter.CustomDelimiter

class Separation {
    fun splitInput(userInputWithoutCustomDelimiter: String?): List<String>? {
        if (userInputWithoutCustomDelimiter == null) return null

        if (userInputWithoutCustomDelimiter == "") return listOf<String>()

        return if (CustomDelimiter.customDelimiter != null) {
            userInputWithoutCustomDelimiter.split(
                DelimiterConst.CLONE,
                DelimiterConst.COMMA,
                CustomDelimiter.customDelimiter!!
            )
        } else {
            userInputWithoutCustomDelimiter.split(DelimiterConst.CLONE, DelimiterConst.COMMA)
        }
    }
}
