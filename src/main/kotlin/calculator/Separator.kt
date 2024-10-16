package calculator

class Separator {
    val colonSeparator: String = ":"
    val commaSeparator: String = ","
    var customSeparator: String? = null
        private set

    fun isCustomSeparator(inputString: String): Boolean {
        val inputItems: List<String> = inputString.map { it.toString() }

        val inputItemsFrontToCompared: String = inputItems[0] + inputItems[1]
        val inputItemsBackToCompared: String = inputItems[3] + inputItems[4]

        val isComparedCustomDeclare: Boolean =
            (inputItemsFrontToCompared == CUSTOM_SEPARATOR_DECLARE_START) && (inputItemsBackToCompared == CUSTOM_SEPARATOR_DECLARE_END)
        when (isComparedCustomDeclare) {
            true -> {
                customSeparator = inputItems[2]
                return true
            }

            false -> return false
        }
    }

    companion object {
        private const val CUSTOM_SEPARATOR_DECLARE_START: String = "//"
        private const val CUSTOM_SEPARATOR_DECLARE_END: String = "\\n"
    }
}