package calculator

fun add(input: String): Double {
    if (input.isEmpty()) return 0.0

    var delimiters = listOf(",", ":")
    var numbers = input

    // //와 \n 사이 문자열을 커스텀 구분자로 추가하는 로직
    if (input.startsWith("//")) {
        val endOfDelimiterIndex = input.indexOf("\\n")

        if (endOfDelimiterIndex == -1) {
            throw IllegalArgumentException("-> Error) 커스텀 구분자 오류")
        }

        val customDelimiter = input.substring(2, endOfDelimiterIndex)
        delimiters = delimiters + customDelimiter

        numbers = input.substring(endOfDelimiterIndex + 2)
    }

    // numbers를 저장된 구분자(delimiters)로 split 후 sum 계산하는 로직
    val tokens = numbers.split(*delimiters.toTypedArray())
    val sum = tokens.map {
        it.toDoubleOrNull() ?: throw IllegalArgumentException("-> Error) 숫자 입력 오류")
    }.sum()

    return sum
}