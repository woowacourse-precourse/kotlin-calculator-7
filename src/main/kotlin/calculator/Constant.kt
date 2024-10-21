package calculator

object Constant {
    const val DEFAULT_DELIMITER_COMMA = ","
    const val DEFAULT_DELIMITER_COLON = ":"

    const val INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요."
    const val OUTPUT_PROMPT = "결과 : "

    private const val INVALID_INPUT_MESSAGE = "잘못된 입력입니다."
    const val CUSTOM_DELIMITER_NEWLINE_MISSING = "$INVALID_INPUT_MESSAGE 커스텀 구분자 다음에 줄 바꿈이 필요합니다."
    const val CUSTOM_DELIMITER_EMPTY = "$INVALID_INPUT_MESSAGE 커스텀 구분자가 비어 있습니다."

    const val NO_NUMBERS_INPUT = "$INVALID_INPUT_MESSAGE 입력되지 않았습니다."
    const val EMPTY_TOKEN = "$INVALID_INPUT_MESSAGE 빈 값은 숫자로 변환할 수 없습니다."
    const val INVALID_NUMBER = "$INVALID_INPUT_MESSAGE 유효한 숫자가 아닙니다: "
    const val NEGATIVE_NUMBER = "$INVALID_INPUT_MESSAGE 음수는 입력할 수 없습니다: "

}