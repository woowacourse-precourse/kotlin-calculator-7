package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val input: String = getInput("덧셈할 문자열을 입력해 주세요.")
    inspectError(input)
    val operands: MutableList<Long> = parseInput(input)
    printSum("결과 : ", operands)
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
            // input[idx] = '\\' (backslash)인 상태
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
        if (delimiterList.find { it == character } != null) {
            isDelimiter = true
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

fun printSum(responseMessage: String, numberList: MutableList<Long>) {
    var sum: Long = 0
    numberList.forEach { number -> sum += number }
    println("$responseMessage$sum")
}

fun inspectError(input: String) {
    val delimiterList = mutableListOf<Char>(',', ':')
    var inspectIndex = 0
    var prevCharacter: Char? = null

    if (input.startsWith("//")) {
        inspectIndex = 2
        while (inspectIndex < input.length) {
            while (input[inspectIndex] != '\\') {
                delimiterList.addLast(input[inspectIndex])
                inspectIndex++
                prevCharacter = input[inspectIndex]
            }
            // input[idx] = '\\' (backslash)인 상태
            if (input[inspectIndex + 1] == 'n') {
                inspectIndex += 2
                prevCharacter = 'n'
                break
            }

            delimiterList.addLast(input[inspectIndex])
            prevCharacter = input[inspectIndex]
            inspectIndex++
        }
    }
    
    while (inspectIndex < input.length) {
        var isDelimiter = false
        if (delimiterList.find { it == input[inspectIndex] } != null) {
            isDelimiter = true
        }


        if (isDelimiter) {
            // 첫 번째 character로 구분자가 나타난 경우
            if (prevCharacter == null) throw IllegalArgumentException()
            // 구분자가 연속 두 번 나타난 경우
            if (delimiterList.find { it == prevCharacter } != null) throw IllegalArgumentException()
        } else {
            // 숫자가 아닌 경우
            if (!input[inspectIndex].isDigit()) throw IllegalArgumentException()
        }
        prevCharacter = input[inspectIndex]
        inspectIndex++
    }

    if (delimiterList.find { it == prevCharacter } != null) throw IllegalArgumentException()
}