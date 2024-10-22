package calculator

enum class ErrorType(val message: String) {
    INVALID_NON_DIGIT_INPUT("구분자 또는 숫자가 아닌 잘못된 입력값이 들어왔습니다."),
    INVALID_NON_POSITIVE_INPUT("양수가 아닌 잘못된 입력값이 들어왔습니다."),
    INVALID_CUSTOM_DELIMITER("커스텀 구분자 지정이 잘못되었습니다."),
}