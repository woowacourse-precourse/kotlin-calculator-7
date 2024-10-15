package calculator

private val CUSTOM_DELIMITER_BEFORE_FLAG = "//"
private val CUSTOM_DELIMITER_AFTER_FLAG = "\\n"

fun main() {
}

private fun hasCustomDelimiters(input: String) =
    input.startsWith(CUSTOM_DELIMITER_BEFORE_FLAG) &&
            input.indexOf(CUSTOM_DELIMITER_AFTER_FLAG) != -1
