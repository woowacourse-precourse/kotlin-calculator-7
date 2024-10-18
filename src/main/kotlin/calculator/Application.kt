package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    /** 입력 받기 */
    println("덧셈할 문자열을 입력해 주세요.")
    val input:String = Console.readLine().toString()

    /** 구분자 리스트 생성 */
    val sepList = findNewOperator(input)

    /** 추가 구분자 파트를 제외한 나머지로 input 구성 */
    val checkedInput = splitInput(input, sepList)

    /** 계산한 결과 출력값 */
    val result = calculate(checkedInput, sepList)

    println(result)
}

/**
 * [input]안에 구분자를 추가하는 부분이 있는제 확인 후 구분자 리스트 return
 */
fun findNewOperator(input:String) :List<Char> {
    if (input.length >= 5){
        if (input[0] == '/' && input[1] == '/' && input[3] == '\\' && input[4] == 'n' &&
            ((input[2].code - '0'.code) < 0 || (input[2].code - '0'.code) > 9)){
            return listOf(input[2]);
        }
    }
    return listOf(',', ':');
}

/**
 * [input], [sepList]를 받아 커스텀 구분자가 있을 시 [input]에서 1구분자를 생성하는 부분을 잘라 return
 */
fun splitInput(input:String, sepList:List<Char>) :String {
    /** 구분자 리스트가 하나라면 커스텀 구부낮이고, 아니라면 일반 구분자이다. */
    if (sepList.size == 2){
        return input;
    }
    return input.substring(5);
}

/**
 * [input], [sepList]를 받아 계산기 기능을 실행한 결괏값 return
 */
fun calculate(input:String, sepList:List<Char>) :String {
    var num : Int? = null
    var answer = 0

    if (input.isEmpty()){
        return "결과 : $answer"
    }

    for (c in input){
        /** 구분자가 들어왔을 때 */
        if (sepList.contains(c)){
            if (num == null){
                throw IllegalArgumentException()
            }
            else {
                answer += num
                num = null
                continue
            }
        }
        /** 구분자도, 숫자도 아닌 문자일 시 오류 발생 */
        if ((c.code - '0'.code) < 0 || (c.code - '0'.code) > 9){
            throw IllegalArgumentException()
        }

        if (num == null){
            num = (c.code - '0'.code)
        }
        else {
            num = (num * 10) + (c.code - '0'.code)
        }
    }

    /** num이 null이라면 구분자로 input이 끝났다는 것. 오류 발생 */
    if (num == null){
        throw IllegalArgumentException()
    }
    else{
        answer += num
    }

    return "결과 : $answer"
}
