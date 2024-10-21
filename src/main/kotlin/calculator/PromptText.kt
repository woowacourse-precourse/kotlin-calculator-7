package calculator

class PromptText {
    companion object{
        const val INPUT_PROMPT_TEXT = "덧셈할 문자열을 입력해 주세요."
        const val OUTPUT_PROMPT_TEXT = "결과 : "
        const val ERROR_INPUT_NULL = "입력 값이 null일 수 없습니다."
        const val ERROR_INPUT_CUSTOM_DELIMITER = "입력 값의 커스텀 구분자를 지정하는 문자를 정확히 입력해주세요"
        const val ERROR_INPUT_CUSTOM_DELIMITER_COUNT = "입력 값의 커스텀 구분자를 하나의 문자로만 입력해주세요."
        const val ERROR_INPUT_NOT_EXPRESSION = "지정한 구분자로만 올바른 식의 형태로 입력해주세요"
        const val INPUT_DELIMITER_FRONT = "//"
        const val INPUT_DELIMITER_END = "\\n"
        const val DELIMITER_TYPE_COMMA = ","
        const val DELIMITER_TYPE_COLON = ":"

    }
}