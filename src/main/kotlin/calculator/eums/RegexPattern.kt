package calculator.eums

enum class RegexPattern(val pattern: String) {
    CUSTOM_OPERATOR("""//(.*?)\\n"""),
    SPLIT_OPERATOR("""//(.*?)\\n(.*)"""),
    KOREAN_AND_ALPHABET("([a-zA-Z]|[가-힣]|[ㄱ-ㅎ]|[ㅏ-ㅣ])")
}