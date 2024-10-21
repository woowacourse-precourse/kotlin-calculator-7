package calculator

class Separator(
    val values: List<String>,
    val isCustomSeparator: Boolean
) {
    constructor(read: String) : this(getSeparators(read), isContainCustomSeparator(read))

    companion object {
        /**
         * 구분자를 가져온다.
         */
        private fun getSeparators(input: String): List<String> {
            if (isContainCustomSeparator(input)) {
                return listOf(getCustomSeparator(input))
            }
            return listOf(",", ":")
        }

        /**
         * 숫자가 아니다 문자다
         */
        private fun isContainCustomSeparator(input: String): Boolean {
            return !input[0].isDigit() && input[0] != '-';
        }

        /**
         * 커스텀 구분자를 가져온다.
         */
        private fun getCustomSeparator(input: String): String {
            if (validateCustomSeparator(input)) {
                return input.split("//")[1].split("\\n")[0]
            }
            throw IllegalArgumentException("커스텀 구분자 지정 형식이 올바르지 않습니다.")
        }

        /**
         * 커스텀 구분자가 올바른지 검증한다.
         */
        private fun validateCustomSeparator(input: String): Boolean {
            return input.startsWith("//") && input.contains("\\n")
        }
    }
}