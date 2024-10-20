package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val input: String = getInput("덧셈할 문자열을 입력해 주세요.")
    inspectError(input)
    val operands: MutableList<Long> = parseInput(input)
    printSum("결과 : ", operands)
}

/**
 * 문자열을 입력받고, 이를 String으로 반환
 *
 * @param requestMessage 문자열 입력을 요청하기 위해 사용자에게 표시되는 메시지
 * */
fun getInput(requestMessage: String): String {
    println(requestMessage)
    return readLine()
}

/**
 * 주어진 문자열을 파싱하여, 피연산자인 숫자들의 리스트로 반환
 *
 * @param input 사용자로부터 입력받은 문자열
 * @return 파싱된 수들의 리스트
 */
fun parseInput(input: String): MutableList<Long> {
    val delimiterList = mutableSetOf<Char>(',', ':')
    var expression = input

    if (input.startsWith("//")) {
        var idx = 2
        while (true) {
            while (input[idx] != '\\') {
                delimiterList.add(input[idx])
                idx++
            }
            // input[idx] = '\\' (backslash)인 상태
            if (input[idx + 1] == 'n') {
                expression = input.substring(idx + 2)
                break
            }

            delimiterList.add(input[idx])
            idx++
        }
    }
    return parseExpression(expression, delimiterList)
}

/**
 * 주어진 수식 문자열을 구분자로 나누어 숫자 리스트로 변환
 *
 * @param expression 연산자와 구분자로 이루어진 수식 문자열
 * @param delimiterList 구분자로 사용할 문자들의 리스트
 * @return 구분자를 기준으로 분리된 수들의 리스트
 */
fun parseExpression(expression: String, delimiterList: MutableSet<Char>): MutableList<Long> {
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

/**
 * 주어진 숫자 리스트의 합을 계산하여 출력
 *
 * @param responseMessage 결과 메시지에 포함시킬 문자열 (ex - "결과 : ")
 * @param numberList 합계를 구할 수들의 리스트
 */
fun printSum(responseMessage: String, numberList: MutableList<Long>) {
    var sum: Long = 0
    numberList.forEach { number -> sum += number }
    println("$responseMessage$sum")
}

/**
 * 입력 문자열을 검사하여 잘못된 형식이 있는지 확인하고, 발견 시 IllegalArgumentException을 발생시킴
 *
 * @param input 사용자로부터 입력받은 문자열
 */
fun inspectError(input: String) {
    val delimiterList = mutableSetOf<Char>(',', ':')
    var inspectIndex = 0
    var prevCharacter: Char? = null

    if (input.startsWith("//")) {
        inspectIndex = 2
        while (inspectIndex < input.length) {
            while (input[inspectIndex] != '\\') {
                delimiterList.add(input[inspectIndex])
                inspectIndex++
                prevCharacter = input[inspectIndex]
            }
            // input[idx] = '\\' (backslash)인 상태
            if (input[inspectIndex + 1] == 'n') {
                inspectIndex += 2
                prevCharacter = 'n'
                break
            }

            delimiterList.add(input[inspectIndex])
            prevCharacter = input[inspectIndex]
            inspectIndex++
        }
    }

    while (inspectIndex < input.length) {
        var isDelimiter = false
        if (input[inspectIndex] in delimiterList) {
            isDelimiter = true
        }

        if (isDelimiter) {
            // 첫 번째 character로 구분자가 나타난 경우
            if (prevCharacter == null) throw IllegalArgumentException()
            // 구분자가 연속 두 번 나타난 경우
            if (prevCharacter in delimiterList) throw IllegalArgumentException()
        } else {
            // 숫자가 아닌 경우
            if (!input[inspectIndex].isDigit()) throw IllegalArgumentException()
        }
        prevCharacter = input[inspectIndex]
        inspectIndex++
    }

    if (prevCharacter in delimiterList) throw IllegalArgumentException()
}