package calculator.domain

class DelimiterSplitter(
    private val value: String,
) {
    init {
        require(customDelimiterFormatCheck())
    }

    // 커스텀 구분자 사용 선언 포맷 확인
    private fun customDelimiterFormatCheck(): Boolean = value.startsWith(CUSTOM_DELIMITER_FRONT) == value.contains(CUSTOM_DELIMITER_BACK)

    // 커스텀 구분자 사용 여부
    private fun customDelimiterIsUsed(): Boolean = value.startsWith(CUSTOM_DELIMITER_FRONT)

    // 커스텀 구분자 찾기
    private fun findCustomDelimiter() = value.substring(CUSTOM_DELIMITER_FRONT.length, value.lastIndexOf(CUSTOM_DELIMITER_BACK))

    companion object {
        private const val COMMA_DELIMITER = ","
        private const val COLON_DELIMITER = ":"
        private const val CUSTOM_DELIMITER_FRONT = "//"
        private const val CUSTOM_DELIMITER_BACK = "\\n"
    }
}
