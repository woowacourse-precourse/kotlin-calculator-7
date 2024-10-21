package calculator

class SeparatorHandler(private val input: String) {

    private fun isExitCustomSeparator(): Boolean {
        return input.startsWith("//") && input.contains("\\n")
    }

    private fun getCustomSeparator(): String {
        val customSeparatorEndIndex = input.indexOf("\\n")
        return input.substring(2, customSeparatorEndIndex)
    }

    private fun splitWithCustomSeparator(): List<String> {
        val customSeparator = getCustomSeparator()
        val numberStartIndex = input.indexOf("\\n") + 2
        val numbers = input.substring(numberStartIndex)
        return numbers.split(customSeparator)
    }

    private fun splitWithDefaultSeparator(): List<String> {
        return input.split("[,:]".toRegex())
    }

    companion object {
        const val CUSTOM_SEPARATOR_END_CHAR = "\\n"
        const val CUSTOM_SEPARATOR_START_CHAR = "//"
        const val CUSTOM_SEPARATOR_START_INDEX = 2
        const val DEFAULT_SEPARATOR = "[,:]"
    }
}