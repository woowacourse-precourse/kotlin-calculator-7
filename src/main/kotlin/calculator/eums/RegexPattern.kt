package calculator.eums

enum class RegexPattern(val pattern: String) {
    CUSTOM_DELIMITER("""//(.*?)\\n"""),
    SPLIT_DELIMITER("""//(.*?)\\n(.*)"""),
    KOREAN_AND_ALPHABET("([a-zA-Z]|[가-힣]|[ㄱ-ㅎ]|[ㅏ-ㅣ])")
}