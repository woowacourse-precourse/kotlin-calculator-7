package calculator.domain

data class Separator(
    val comma: Char = DEFAULT_SEPARATOR_COMMA,
    val colon: Char = DEFAULT_SEPARATOR_COLON,
    val custom: Char? = null
)

private const val DEFAULT_SEPARATOR_COMMA = ','
private const val DEFAULT_SEPARATOR_COLON = ':'
