package calculator.utils

import calculator.enums.ValidationType

/**입력에 따라 업데이트하게 될 object*/
object InputManager {
    lateinit var oldInput: String

    /**기본 타입인지, 커스텀 타입인지*/
    lateinit var type: ValidationType

    /**구분자*/
    lateinit var delimiter: String

    /**피연산 문자열*/
    lateinit var newInput: String

    /**피연산 문자열에서 얻은 양의 정수만으로 이루어진 리스트*/
    lateinit var splittedList: List<String>

    /**최종 리턴하는 합*/
    var sum: Int = 0
}