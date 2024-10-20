package calculator.utils

import calculator.constants.RegexConsts
import calculator.enums.ValidationType

object Calculator {
    /**입력 문자열 처리 실행*/
    fun calculateString(input: String): String {
        InputManager.oldInput = input
        InputManager.type = checkType(InputManager.oldInput) // 타입 체크

        return "결과 : ${InputManager.sum}"
    }

    /**기본 타입인지, 커스텀 타입인지 체크하는 함수*/
    private fun checkType(input: String): ValidationType {
        // 커스텀타입인지 확인
        val regex = Regex(RegexConsts.CUSTOM_DELIMITER_DEFINE)

        return if (input.length < 4) {
            ValidationType.DEFAULT
        } else if (regex.matches(input.substring(0, 5))) {
            ValidationType.CUSTOM
        } else {
            ValidationType.DEFAULT
        }
    }
}