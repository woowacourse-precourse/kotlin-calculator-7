package calculator

import calculator.Constants.DEFAULT_SEPARATOR_COLON
import calculator.Constants.DEFAULT_SEPARATOR_COMMA

sealed class SeparatorState {
    data class CustomSeparator(val separator: Char) : SeparatorState()
    object DefaultSeparator : SeparatorState() {
        const val COLON = DEFAULT_SEPARATOR_COLON
        const val COMMA = DEFAULT_SEPARATOR_COMMA
    }
}