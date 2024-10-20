package calculator.util

object Constant {
    val CUSTOM_DELIMITER_DETERMINE_REGEX = "//(.*)\\\\n(.*)".toRegex()
    const val WELCOME_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    const val RESULT_FORMAT = "결과 : %s \n"
    const val ERROR_MESSAGE = "잘못된 입력입니다. [현재 입력한 숫자 = %s / 구분자 = %s]"
}