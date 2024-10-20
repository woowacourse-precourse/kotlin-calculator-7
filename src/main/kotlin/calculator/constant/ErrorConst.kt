package calculator.constant

object ErrorConst {
    const val INPUT_ERROR_MSG: String = "잘못된 입력입니다: "
    const val INPUT_NULL_EXCEPTION_MSG: String = "사용자가 enter를 포함하여 아무것도 입력을 하지 않았습니다."
    const val INPUT_LETTER_EXCEPTION_MSG: String = "에 문자가 포함되어 있습니다."
    const val INPUT_SURROGATE_EXCEPTION_MSG: String = "에 유니코드 문자 또는 이모지가 포함되어 있습니다."
    const val INPUT_ESCAPE_EXCEPTION_MSG: String = "에 escape 문자가 포함되어 있습니다."
    const val INPUT_NOT_NUMBER_EXCEPTION_MSG: String = "는 숫자로 변환할 수 없습니다."
    const val INPUT_NOT_POSITIVE_NUMBER_EXCEPTION_MSG: String = "은 음수입니다."
}