package calculator

class DelimiterParser {
    enum class ParsingType(val index: Int) {
        CustomDelimiter(2),
        Expression(4)
    }

    private val customDelimiterRegex = Regex("^(//)(.*?)(\\\\n)(.*)")
    private val delimiters = mutableListOf(",", ":")

    // 구분자 리스트 리턴
    // 커스텀 구분자가 있으면 기본 구분자 + 커스텀 구분자 리턴
    // 커스텀 구분자가 없으면 기본 구분자만 리턴
    fun getDelimiterList(input: String): List<String> {
        if (hasCustomDelimiter(input)) {
            val customDelimiter = parseValueByType(input, ParsingType.CustomDelimiter)
                ?: throw IllegalArgumentException(ERROR_MISSING_CUSTOM_DELIMITER)
            delimiters.add(customDelimiter)
        }
        return delimiters
    }

    // 커스텀 구분자 존재 여부 확인
    private fun hasCustomDelimiter(input: String) = input.matches(customDelimiterRegex)

    // 커스텀 구분자가 있으면 커스텀 구분자를 제외한 수식만 추출
    fun getExpression(input: String): String =
        if (!hasCustomDelimiter(input)) input else parseValueByType(input, ParsingType.Expression) ?: ""

    // type에 따라 커스텀 구분자 또는 수식을 추출
    private fun parseValueByType(input: String, type: ParsingType) =
        customDelimiterRegex.find(input)?.groupValues?.get(type.index)

    companion object {
        const val ERROR_MISSING_CUSTOM_DELIMITER = "Unable to find custom delimiter"
    }
}