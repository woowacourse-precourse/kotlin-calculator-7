package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val strInput = Console.readLine()

    // \n을 개행 문자로 바꿔주기
    val formattedInput = strInput.replace("\\n", "\n")
    val result = addNumbers(formattedInput)

    println("결과: $result")
    Console.close()
}

fun addNumbers(input: String): Int {
    if (input.isEmpty()) {
        return 0
    }
    val (delimiter, numbers) = parseInput(input)
    val numberList = splitNumbers(numbers, delimiter)
    validateNumbers(numberList)
    return numberList.sumOf { it.toInt() }
}

fun parseInput(input: String): Pair<String, String> {
    return if (input.startsWith("//")) {
        val delimiterEndIndex = input.indexOf("\n")
        if(delimiterEndIndex == -1) throw IllegalArgumentException("잘못된 값 입니다.")
        val customDelimiter = input.substring(2, delimiterEndIndex)
        val numbers = input.substring(delimiterEndIndex + 1)
        Pair(customDelimiter, numbers)
    } else {
        Pair(",|:", input)
    }
}

fun splitNumbers(input: String, delimiter: String): List<String> {
    val result = if(delimiter.equals(",|:")) {
        input.split(",",":")
    }
    else{
        input.split(delimiter,",",":")
    }

    return result
}

fun validateNumbers(numbers: List<String>) {
    for (number in numbers) {
        val num = number.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: '$number'")
        if (num < 0) {
            throw IllegalArgumentException("음수는 허용되지 않습니다: $num")
        }
    }
}



