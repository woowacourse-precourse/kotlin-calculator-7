package calculator.utils

import calculator.constants.ExceptionConsts

/**예외의 경우인지 검사하는 함수가 있는 object*/
object Validator {
    /**등록된 구분자 아닌 구분자 포함시 예외 발생시키는 함수*/
    fun validateDelimiter() {
        // 입력 문자열에서 숫자와 구분자를 제외한 문자가 있는지 검사
        val pattern = "[^\\d${InputManager.delimiter}]"
        val regex = Regex(pattern)
        if (InputManager.newInput.contains(regex)) {
            throw IllegalArgumentException(ExceptionConsts.INVALID_DELIMITER)
        }
    }
    /**처음 또는 마지막 요소가 공백이면(digit이 아닌 letter로 끝난다면) 예외를 발생시키는 함수*/
    fun validateElement(){
        if(InputManager.splittedList.contains("")){
            throw IllegalArgumentException(ExceptionConsts.INVALID_CHARACTER)
        }
    }
}