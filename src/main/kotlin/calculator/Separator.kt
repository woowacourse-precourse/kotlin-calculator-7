package calculator

class Separator {
    val colonSeparator: String = ":"
    val commaSeparator: String = ","
    var customSeparator: String? = null
        private set

    fun isCustomSeparator(inputString: String): Boolean {
        when (inputString.length >= 5) {
            true -> {
                val inputItems: List<String> = inputString.map { it.toString() }

                val inputItemsFrontToCompared: String = inputItems[0] + inputItems[1]
                val inputItemsBackToCompared: String = inputItems[3] + inputItems[4]

                val isComparedCustomDeclare: Boolean =
                    (inputItemsFrontToCompared == CUSTOM_SEPARATOR_DECLARE_START) && (inputItemsBackToCompared == CUSTOM_SEPARATOR_DECLARE_END)

                when (isComparedCustomDeclare) {
                    true -> {
                        validateCustomSeparator(inputItems[2])
                        customSeparator = inputItems[2]
                        return true
                    }

                    false -> return false
                }
            }

            false -> return false
        }
    }

    private fun validateCustomSeparator(customSeparator: String) {
        val isCustomSeparatorNumber: Boolean = customSeparator.matches(Regex("\\d"))
        val isCustomSeparatorBlank: Boolean = customSeparator.isBlank()
        val isCustomSeparatorDash: Boolean = customSeparator == "-"

        if (isCustomSeparatorNumber || isCustomSeparatorBlank || isCustomSeparatorDash)
            throw IllegalArgumentException("커스텀 구분자는 숫자, 공백, '-'를 사용할 수 없습니다.")

    }

    companion object {
        private const val CUSTOM_SEPARATOR_DECLARE_START: String = "//"
        private const val CUSTOM_SEPARATOR_DECLARE_END: String = "\\n"
    }
}