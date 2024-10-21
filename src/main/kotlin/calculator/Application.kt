package calculator

fun main() {
    start()
}

private fun start() {
    val numbers = input()
    val result = calculate(numbers)
    println("결과 : $result")
}

private fun input(): List<Int> {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputString = readlnOrNull()
        ?: throw IllegalArgumentException("입력 값이 없습니다.")

    val separatedNumbers = parseStringWithDelimiter(inputString)
    return separatedNumbers.map { toPositiveInt(it) }
}

private fun parseStringWithDelimiter(input: String): List<String> {
    val customDelimiterPattern = Regex("//(.*?)\\\\n")
    val matchResult = customDelimiterPattern.find(input)

    return if (matchResult != null) {
        val customDelimiter = matchResult.groupValues[1]
        input.substring(matchResult.range.last + 1).split(customDelimiter)
    } else {
        input.split(",", ":")
    }
}

private fun toPositiveInt(value: String): Int {
    return try {
        val number = value.toInt()
        if (number <= 0) {
            throw IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다 : $number")
        }
        number
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("잘못된 입력 값입니다 : $value")
    }
}

private fun calculate(numbers: List<Int>): Int {
    return numbers.sum()
}