package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val input: String = getInput("덧셈할 문자열을 입력해 주세요.")
    val operands: MutableList<Long> = parseInput(input)
    // 피연산자 출력 확인
    println(operands)
}

/** 문자열을 입력받고, 이를 MutableList로 반환
 *
 * @param requestMessage 문자열 입력을 요청하기 위해 사용자에게 표시되는 메시지
 * */
fun getInput(requestMessage: String): String {
    println(requestMessage)
    return readLine()
}

fun parseInput(input: String): MutableList<Long> {
    val delimiterList = mutableListOf<Char>(',', ':')
    var expression = input

    if (input.startsWith("//")) {
        var idx = 2
        while (true) {
            while (input[idx] != '\\') {
                delimiterList.addLast(input[idx])
                idx++
            }
            // input[idx] = '\\' 인 상태

            if (input[idx + 1] == 'n') {
                expression = input.substring(idx + 2)
                break
            }

            delimiterList.addLast(input[idx])
            idx++
        }
    }
    return parseExpression(expression, delimiterList)
}


fun parseExpression(expression: String, delimiterList: MutableList<Char>): MutableList<Long> {
    val numberList = mutableListOf<Long>()
    var number = mutableListOf<Char>()
    for (character in expression) {
        var isDelimiter = false
        delimiterList.forEach { delimiter ->
            if (character == delimiter) isDelimiter = true
        }
        if (isDelimiter) {
            numberList.add(number.joinToString("").toLong())
            number = mutableListOf<Char>()
            continue
        }
        number.add(character)
    }

    if (number.size > 0) numberList.add(number.joinToString("").toLong())
    return numberList
}