package calculator
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val input: MutableList<String> = getInput("덧셈할 문자열을 입력해 주세요.")
    val operands: MutableList<Long> = parseInput(input)

}
/** 문자열을 입력받고, 이를 MutableList로 반환
 *
 * @param requestMessage 문자열 입력을 요청하기 위해 사용자에게 표시되는 메시지
 * */
fun getInput(requestMessage: String): MutableList<String> {
    println(requestMessage)

    var lines = mutableListOf<String>()
    lines.add(readLine())
    lines.add(readLine())
    return lines
}

fun parseInput(input: MutableList<String>): MutableList<Long> {
    val delimiterList = mutableListOf<Char>(',', ':')

    if (input[0].startsWith("//")) {
        var idx = 2
        while (input[0][idx] != '\n') {
            delimiterList.addLast(input[0][idx])
        }
        return parseExpression(input[1], delimiterList)
    }
    return parseExpression(input[0], delimiterList)
}

fun parseExpression(expression: String, delimiterList: MutableList<Char>): MutableList<Long> {
    val numberList = mutableListOf<Long>()
    var number = mutableListOf<Char>()
    for (character in expression) {
        var isDelimiter = false
        delimiterList.forEach{ delimiter ->
            if (character == delimiter) isDelimiter = true
        }
        if (isDelimiter) {
            numberList.add(number.joinToString().toLong())
            number = mutableListOf<Char>()
            continue
        }
        number.add(character)
    }
    return numberList
}