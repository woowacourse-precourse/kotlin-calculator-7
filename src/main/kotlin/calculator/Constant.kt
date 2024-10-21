package calculator

object Constant {
    // 커스텀 구분자
    const val CUSTOM_DELIMITER_PREFIX = "//"
    const val CUSTOM_DELIMITER_SUFFIX = "\n"
    const val DEFAULT_DELIMITER_COMMA = ","
    const val DEFAULT_DELIMITER_COLON = ":"

    const val INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요."
    const val OUTPUT_PROMPT = "결과 : "

    private const val INVALID_INPUT_MESSAGE = "잘못된 입력입니다."
    const val CUSTOM_DELIMITER_NEWLINE_MISSING = "$INVALID_INPUT_MESSAGE 커스텀 구분자 다음에 줄 바꿈이 필요합니다."
    const val CUSTOM_DELIMITER_EMPTY = "$INVALID_INPUT_MESSAGE 커스텀 구분자가 비어 있습니다."

}