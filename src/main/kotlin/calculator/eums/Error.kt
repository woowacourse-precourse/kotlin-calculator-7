package calculator.eums

import calculator.constants.ERROR

enum class Error(val message: String) {
    CONTAIN_GAP(ERROR.format("공백이 포함되면 안됩니다.")),
    CONTAIN_NEGATIVE_NUMBER(ERROR.format("음수를 입력할 수 없습니다.")),
    ONLY_NUMBER(ERROR.format("숫자만 입력할 수 있습니다."))
}