package calculator.utils

import calculator.constants.RegexConsts
import calculator.enums.ValidationType

object Calculator {
    /**입력 문자열 처리 실행*/
    fun calculateString(input: String): String {
        InputManager.oldInput = input
        InputManager.type = checkType(InputManager.oldInput) // 타입 체크
        InputManager.newInput = updateInput(InputManager.type) // 피연산 문자열

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

    /**피연산 문자열을 업데이트하는 함수*/
    private fun updateInput(type: ValidationType): String {
        return when (type) {
            ValidationType.DEFAULT -> InputManager.oldInput // 일반 타입이면 그대로 반환
            ValidationType.CUSTOM -> InputManager.oldInput.substring(5, InputManager.oldInput.length) // 커스텀 타입이면 뒷부분 반환
        }
    }
}