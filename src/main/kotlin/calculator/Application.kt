package calculator

import camp.nextstep.edu.missionutils.Console

const val ERROR_INVALID_CUSTOM_DELIMITER = "구분자로 숫자는 사용할 수 없습니다."
const val ERROR_INVALID_DELIMITER = "올바르지 않은 구분자를 사용했습니다."
const val ERROR_DELIMITER_POSITION = "구분자는 숫자 사이에 있어야 합니다."


fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    var str : String = Console.readLine()

    var sum = 0
    val delimiterList : MutableList<Char> = mutableListOf(',', ':') // 구분자 리스트

        // 커스텀 구분자 존재 여부 파악
        if(str.length >= 5 &&
            str.substring(0,2) == "//"
            && str.substring(3,5) == "\\n"
            ) {
            // 커스텀 구분자 존재 시 -> 구분자 리스트에 추가
           if(!str[2].isDigit()) {
               delimiterList.add(str[2])
               str = str.substring(5, str.length)
           } else throwInvalidStringException(ERROR_INVALID_CUSTOM_DELIMITER)

        }

        var currentNumber = ""
        for(c in str) {
            if(c.isDigit()) currentNumber += c
            else {
                if(delimiterList.contains(c) && currentNumber.isNotEmpty()) {
                    sum += currentNumber.toInt()
                    currentNumber = ""
                }
                else {
                    val errorMessage = if(!delimiterList.contains(c)) ERROR_INVALID_DELIMITER else ERROR_DELIMITER_POSITION
                    throwInvalidStringException(errorMessage)
                }
            }
        }

        if(currentNumber.isNotEmpty()) sum += currentNumber.toInt()
        println("결과 : " + sum)

}

private fun throwInvalidStringException(message : String) {
    throw IllegalArgumentException(message)
}



