package calculator.constant

object ErrorConst {
    const val INPUT_ERROR_MSG = "잘못된 입력입니다: "
    const val INPUT_NULL_EXCEPTION_MSG = "사용자가 enter를 포함하여 아무것도 입력을 하지 않았습니다."
    const val INPUT_LETTER_EXCEPTION_MSG = "에 문자가 포함되어 있습니다."
    const val INPUT_WHITESPACE_EXCEPTION_MSG = "에 공백 문자가 포함되어 있습니다."
    const val INPUT_SURROGATE_EXCEPTION_MSG = "에 유니코드 문자 또는 이모지가 포함되어 있습니다."
    const val INPUT_ESCAPE_EXCEPTION_MSG = "에 escape 문자가 포함되어 있습니다."
    const val INPUT_NOT_NUMBER_EXCEPTION_MSG = "는 숫자로 변환할 수 없습니다."
    const val INPUT_NOT_POSITIVE_NUMBER_EXCEPTION_MSG = "은 양수가 아닙니다."
}