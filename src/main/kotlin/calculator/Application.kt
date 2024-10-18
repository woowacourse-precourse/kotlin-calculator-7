package calculator

fun main() {
    val input = inputNumber()
    val numberList = splitString(input)
    didEnterCorrect(numberList)
    val numberListInt = translate2Int(numberList)
    val result = sumNumbers(numberListInt)
    println(result)
}

fun inputNumber(): String? {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine()

    return input
}

fun splitString(input: String?): List<String> {
    println("spliting elements...")
    var delimiters = "[,:]".toRegex()
    var numbers = input ?: return listOf("0")

    if (numbers.take(2) == "//") {
        val delimiterLastIndex = findCustomDelimiterIndex(numbers)

        delimiters = "[,:${numbers.slice(2..delimiterLastIndex)}]".toRegex()
        numbers = numbers.drop(delimiterLastIndex + 3)
    }
    return numbers.split(delimiters)
}

fun findCustomDelimiterIndex(input: String): Int {
    println("searching custom delimiter...")
    for (i in 3..<input.length) {
        if (input[i] == '\\' && input[i + 1] == 'n') {
            return i - 1
        }
    }
    throw IllegalArgumentException()
}

fun translate2Int(numbers: List<String>): List<Int> {
    println("translating...")
    return numbers.map { it.toInt() }
}

fun didEnterCorrect(numbers: List<String>) {
    println("checking elements...")
    if (doesListHaveEmptyValue(numbers) || isListNotDigit(numbers)) {
        throw IllegalArgumentException()
    }
}

fun doesListHaveEmptyValue(numbers: List<String>): Boolean {
    println("checking empty value...")
    return numbers.contains("")
}

fun isListNotDigit(numbers: List<String>): Boolean {
    println("checking not digit...")
    for (n in numbers.map { it.single() }) {
        if (!n.isDigit()) {
            return true
        }
    }
    return false
}

fun sumNumbers(numbers: List<Int>): Int {
    println("calculating...")
    return numbers.sum()
}