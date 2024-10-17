package calculator.domain

class DelimiterSplitter(
    private val value: String
) {
    init {
        require(customDelimiterFormatCheck())
        require(otherCharacterCheck(getSplitResult()))
    }

    // 구분된 결과 내 양수가 아닌 다른 문자 여부 확인
    private fun otherCharacterCheck(splitResult: List<String>): Boolean =
        splitResult.all { it.matches(Regex("^(?:0|[1-9]\\d*)(\\.\\d+)?\$")) }

    // 커스텀 구분자 사용 선언 포맷 확인
    private fun customDelimiterFormatCheck(): Boolean =
        value.startsWith(CUSTOM_DELIMITER_FRONT) == value.contains(CUSTOM_DELIMITER_BACK)

    // 커스텀 구분자 사용 여부
    private fun customDelimiterIsUsed(): Boolean = value.startsWith(CUSTOM_DELIMITER_FRONT)

    // 커스텀 구분자 찾기
    private fun findCustomDelimiter() =
        value.substring(CUSTOM_DELIMITER_FRONT.length, value.lastIndexOf(CUSTOM_DELIMITER_BACK))

    // 커스텀 구분자로 나누기
    private fun customSplit(): List<String> {
        val splitResult = value.split(CUSTOM_DELIMITER_FRONT, CUSTOM_DELIMITER_BACK, findCustomDelimiter())
        return splitResult.drop(2)
    }

    // 기본 구분자로 나누기
    private fun basicSplit(): List<String> = value.split(COMMA_DELIMITER, COLON_DELIMITER)

    // 지정된 구분자를 이용하여 문자열 구분
    fun getSplitResult(): List<String> {
        if (customDelimiterIsUsed()) return customSplit().filter { it.isNotBlank() }
        return basicSplit().filter { it.isNotBlank() }
    }

    companion object {
        private const val COMMA_DELIMITER = ","
        private const val COLON_DELIMITER = ":"
        private const val CUSTOM_DELIMITER_FRONT = "//"
        private const val CUSTOM_DELIMITER_BACK = "\\n"
    }
}
