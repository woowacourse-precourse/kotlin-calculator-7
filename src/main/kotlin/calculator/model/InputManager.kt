package calculator.model

class InputManager(
    private val input: String = "",
    private val delimiters: List<String>
) {

    fun removeCustomDelimiterDefinition(): String {
        val regex = Regex("""//.\\n""")
        return regex.replace(input, "")
    }
}