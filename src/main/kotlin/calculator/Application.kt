package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    var result : Int = 0
    var numbers : Array<Int>

    println("덧셈할 문자열을 입력해 주세요.")
    val inputStr = Console.readLine()
    Console.close()

    if(inputStr.isNotEmpty()){
        if(inputStr[0] == '/' && inputStr[1] == '/' && inputStr[3]=='\\' && inputStr[4] == 'n'){ // 커스텀 구분자 있음
            val customGubun = inputStr[2].toString()
            numbers = inputStr.substring(5).split(",",":",customGubun).map { it.toInt() }.toTypedArray()
        }else{
            numbers = inputStr.split(",",":").map { it.toInt() }.toTypedArray()
        }

        if(numbers.any { i -> i<0 }){ // 예외 : 음수
            throw IllegalArgumentException()
        }
        result = numbers.sum()
    }

    println("결과 : $result")
}
