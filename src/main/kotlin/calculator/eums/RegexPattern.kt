package calculator.eums

enum class RegexPattern(val pattern: String) {
    CUSTOM_OPERATOR("""//(.*?)\\n"""),
    SPLIT_OPERATOR("""//(.*?)\\n(.*)""")
}