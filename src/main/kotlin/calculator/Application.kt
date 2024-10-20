package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val inputString = readLine()

    if(inputString.isEmpty()) {
        throw IllegalArgumentException("Empty String.")
    }

    val result = if(inputString.startsWith("//")) {  // 커스텀 구분자
        processCustomDelimiter(inputString)
    } else {    //기본 구분자
        processDefaultDelimiter(inputString)
    }

    println("결과 : $result")
}

fun processDefaultDelimiter(inputString : String) : Int {   //기본 구분자 처리 함수
    val numberList = inputString.split(',',':')
    if(numberList.any { it.isEmpty() }) throw IllegalArgumentException()

    validateNumber(numberList)

    return numberList.sumOf { it.toInt() }
}

fun processCustomDelimiter(inputString : String) : Int {    //커스텀 구분자 처리 함수
    val endIndex = inputString.indexOf("\\n")
    if(endIndex == -1) throw IllegalArgumentException()    //\n 이 없는 경우

    val customDelimiter = inputString.substring(2, endIndex)
    if(customDelimiter.isEmpty()) throw IllegalArgumentException()     //구분자가 없는 경우

    val numbers = inputString.substring(endIndex + 2)
    if(numbers.isEmpty()) throw IllegalArgumentException()  //숫자가 없는 경우

    val numberList = numbers.split(customDelimiter)
    if(numberList.any { it.isEmpty() }) throw IllegalArgumentException()    //구분자 사이에 숫자가 없는 경우

    validateNumber(numberList)

    return numberList.sumOf { it.toInt() }
}

fun validateNumber(numbers : List<String>) {    //숫자 체크 함수
    for(number in numbers) {
        if(number.isNotEmpty() && !number.all { it.isDigit() }) {
            throw IllegalArgumentException()
        }
    }
}