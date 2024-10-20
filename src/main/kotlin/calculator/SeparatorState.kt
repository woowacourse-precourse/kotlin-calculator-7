package calculator

sealed class SeparatorState {
    data class CustomSeparator(val separator: String) : SeparatorState()
    object DefaultSeparator : SeparatorState() {
        const val COLON = ":"
        const val COMMA = ","
    }
}