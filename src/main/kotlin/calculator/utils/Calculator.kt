package calculator.utils

import calculator.constants.RegexConsts
import calculator.enums.ValidationType

object Calculator {
    /**입력 문자열 처리 실행*/
    fun calculateString(input: String): String {
        InputManager.oldInput = input
        InputManager.type = checkType(InputManager.oldInput) // 타입 체크
        InputManager.newInput = updateInput(InputManager.type) // 피연산 문자열
        InputManager.delimiter = updateDelimiter(InputManager.type) // 구분자 업데이트
        Validator.validateDelimiter() // 구분자 이외 문자가 들어있는지 체크
        updateSum()

        return "결과 : ${InputManager.sum}"
    }

    /**기본 타입인지, 커스텀 타입인지 체크하는 함수*/
    private fun checkType(input: String): ValidationType {
        // 커스텀타입인지 확인
        val regex = Regex(RegexConsts.CUSTOM_DELIMITER_DEFINE)

        return if (input.length < 5) {
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

    /**구분자를 업데이트하는 함수 */
    private fun updateDelimiter(type: ValidationType): String {
        return when (type) {
            ValidationType.DEFAULT -> RegexConsts.DEFAULT_DELIMITER
            ValidationType.CUSTOM -> ",:${InputManager.oldInput[2]}" // 구분자 업데이트
        }
    }

    /**구분자로 스플릿된 리스트의 원소를 정수로 변환해 합을 계산해주는 함수*/
    private fun updateSum() {
        if (InputManager.newInput.isEmpty()) { // 문자열이 비어있음
            InputManager.sum = 0
        } else {
            // 구분자로 나눈 스플릿리스트를 만듦
            InputManager.splittedList =
                InputManager.newInput.split(Regex("[${InputManager.delimiter}]"))
            // 스플릿 리스트에 있는 값들을 더함
            Validator.validateLastElement() // 마지막 요소
            InputManager.splittedList.forEach {
                InputManager.sum += it.toInt()
            }
        }
    }
}