package calculator

object DelimiterExtractor {

    /**
     * 입력 문자열에서 커스텀 구분자 추출
     * 기본 구분자와 커스텀 구분자 함께 반환
     */
    fun extractDelimiters(input: String): Pair<List<String>, String> {
        val customDelimiterRegex = Regex("//(.)\\\\n(.*)")
        val matchResult = customDelimiterRegex.matchEntire(input)
        return if (matchResult != null) {
            val customDelimiter = matchResult.groupValues[1]
            val numbersString = matchResult.groupValues[2]
            Pair(listOf(customDelimiter), numbersString)
        } else {
            val defaultDelimiters = listOf(Constant.DEFAULT_DELIMITER_COMMA, Constant.DEFAULT_DELIMITER_COLON)
            Pair(defaultDelimiters, input)
        }
    }


}