package calculator

class Separator {
    val colonSeparator: String = ":"
    val commaSeparator: String = ","
    var customSeparator: String? = null
        private set

    fun isCustomSeparator(inputString: String): Boolean {
        if (inputString.length < CUSTOM_SEPARATOR_DECLARE_LENGTH) return false

        val inputItems: List<String> = inputString.map { it.toString() }

        return if (isComparedCustomSeparatorDeclare(inputItems)) {
            validateCustomSeparator(inputItems[CUSTOM_SEPARATOR_DECLARE_DEFINITION])
            customSeparator = inputItems[CUSTOM_SEPARATOR_DECLARE_DEFINITION]
            true
        } else false
    }

    private fun isComparedCustomSeparatorDeclare(inputItems: List<String>): Boolean {
        val inputItemsFrontToCompared: String =
            inputItems[CUSTOM_SEPARATOR_DECLARE_INDEX_FIRST] + inputItems[CUSTOM_SEPARATOR_DECLARE_INDEX_SECOND]
        val inputItemsBackToCompared: String =
            inputItems[CUSTOM_SEPARATOR_DECLARE_INDEX_FOURTH] + inputItems[CUSTOM_SEPARATOR_DECLARE_INDEX_FIFTH]

        return (inputItemsFrontToCompared == CUSTOM_SEPARATOR_DECLARE_START) && (inputItemsBackToCompared == CUSTOM_SEPARATOR_DECLARE_END)
    }

    private fun validateCustomSeparator(customSeparator: String) {
        val isCustomSeparatorNumber: Boolean = customSeparator.matches(DIGIT_REGEX)
        val isCustomSeparatorBlank: Boolean = customSeparator.isBlank()
        val isCustomSeparatorDash: Boolean = customSeparator == DASH_SEPARATOR

        if (isCustomSeparatorNumber || isCustomSeparatorBlank || isCustomSeparatorDash)
            throw IllegalArgumentException("커스텀 구분자는 숫자, 공백, '-'를 사용할 수 없습니다.")
    }

    companion object {
        const val CUSTOM_SEPARATOR_DECLARE_LENGTH: Int = 5
        private const val CUSTOM_SEPARATOR_DECLARE_INDEX_FIRST = 0
        private const val CUSTOM_SEPARATOR_DECLARE_INDEX_SECOND = 1
        private const val CUSTOM_SEPARATOR_DECLARE_INDEX_FOURTH = 3
        private const val CUSTOM_SEPARATOR_DECLARE_INDEX_FIFTH = 4
        private const val CUSTOM_SEPARATOR_DECLARE_DEFINITION = 2

        private const val CUSTOM_SEPARATOR_DECLARE_START: String = "//"
        private const val CUSTOM_SEPARATOR_DECLARE_END: String = "\\n"

        private val DIGIT_REGEX: Regex = Regex("\\d")
        private const val DASH_SEPARATOR: String = "-"
    }
}