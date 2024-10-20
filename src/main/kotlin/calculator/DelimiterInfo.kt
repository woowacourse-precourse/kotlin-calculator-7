package calculator

/**
 * Delimiter(구분자)에 대한 정보를 담고 있다.
 * @param delimiters 구분자 목록
 * @param customDelimiterPrefixLast 커스텀 구분자 접두사의 마지막 문자
 */
data class DelimiterInfo(
    val delimiters: List<String>,
    val customDelimiterPrefixLast: String,
)
