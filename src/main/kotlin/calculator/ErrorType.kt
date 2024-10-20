package calculator

enum class ErrorType(val errorMessage: String) {
    WRONG_DELIMITER_INPUT_ERROR("잘못된 구분자 입력 입니다."),
    NUMBER_START_ZERO_INPUT_ERROR("0으로 시작하는 숫자가 존재합니다."),
    NUMBER_INCLUDE_BLANK_INPUT_ERROR("앞뒤에 공백이 있는 숫자가 존재합니다."),
    WRONG_NUMBER_INPUT_ERROR("잘못된 숫자 형식이 존재합니다.(+, - 기호를 사용할 수 없습니다)"),
    NO_EXIST_DELIMITER_INPUT_ERROR("구분자가 존재 하지 않습니다."),
    DELIMITER_CAN_NOT_LONGER_TWO("구분자는 2글자 이상일 수 없습니다.")
}