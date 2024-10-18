package calculator

fun main() {
//    inputNumber()
    println(splitString(inputNumber()))
}

fun inputNumber(): String? {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine()

    return input
}

fun splitString(input: String?): List<String?> {
    var delimiters = "[.:]".toRegex()
    var numbers = input ?: return listOf("0")

    if (numbers.take(2) == "//") {
        val delimiterLastIndex = findCustomDelimiterIndex(numbers)

        delimiters = "[.:${numbers.slice(2..delimiterLastIndex)}]".toRegex()
        numbers = numbers.drop(delimiterLastIndex + 3)
    }
    return numbers.split(delimiters)
}

fun findCustomDelimiterIndex(input: String): Int {
    for (i in 3..<input.length) {
        if (input[i] == '\\' && input[i + 1] == 'n') {
            return i - 1
        }
    }
    throw IllegalArgumentException()
}