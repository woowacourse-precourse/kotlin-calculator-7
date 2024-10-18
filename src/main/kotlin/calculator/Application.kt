package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    var result : Int = 0

    // 문자열 입력
    println("덧셈할 문자열을 입력해 주세요.")
    val inputStr = Console.readLine()
    Console.close()

    if(inputStr.isNotEmpty()){
        if(inputStr[0] == '/' && inputStr[1] == '/' && inputStr[3]=='\\' && inputStr[4] == 'n'){ // 커스텀 구분자 있음
            val customGubun = inputStr[2].toString()
            result = inputStr.substring(5).split(",",":",customGubun).sumOf { it.toInt() }
        }else{
            result = inputStr.split(",",":").sumOf { it.toInt() }
        }
    }

}
