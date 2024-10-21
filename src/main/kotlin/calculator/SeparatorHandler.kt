package calculator

class SeparatorHandler(private val input: String) {

    private fun isExitCustomSeparator(): Boolean {
        return input.startsWith("//") && input.contains("\\n")
    }

    private fun getCustomSeparator(): String {
        val customSeparatorEndIndex = input.indexOf(CUSTOM_SEPARATOR_END_CHAR)
        return input.substring(CUSTOM_SEPARATOR_START_INDEX, customSeparatorEndIndex)
    }

    private fun splitByCustomSeparator(): List<String> {
        val customSeparator = getCustomSeparator()
        val numberStartIndex = input.indexOf(CUSTOM_SEPARATOR_END_CHAR) + 2
        return input.substring(numberStartIndex).split(customSeparator)
    }

    private fun splitByDefaultSeparator(): List<String> = input.split(DEFAULT_SEPARATOR.toRegex())

    companion object {
        const val CUSTOM_SEPARATOR_END_CHAR = "\\n"
        const val CUSTOM_SEPARATOR_START_CHAR = "//"
        const val CUSTOM_SEPARATOR_START_INDEX = 2
        const val DEFAULT_SEPARATOR = "[,:]"
    }
}