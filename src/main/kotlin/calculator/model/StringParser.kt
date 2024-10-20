package calculator

class StringParser(input: String) {
    private val numberList: List<Int>
    private val delimiters: List<String>
    private val cleanedInput: String

    init {
        val (delimitersFromInput, cleaned) = manageDelimiters(input)
        delimiters = delimitersFromInput
        cleanedInput = cleaned
        numberList = parseNumbers(cleanedInput, delimiters)
    }

    private fun manageDelimiters(input: String): Pair<List<String>, String> {
        val delimitersData = mutableListOf(",", ":")
        val pattern = Regex("""\/\/(.+?)\\n""")
        val matchResult = pattern.find(input)

        if (matchResult != null) {
            delimitersData.add(matchResult.groupValues[1])
            checkForMinusAsDelimiter(delimitersData, input)  // 구분자 목록과 입력 문자열을 넘김
            val cleanedInput = input.replaceFirst(pattern, "")
            return Pair(delimitersData, cleanedInput)
        }
        checkForMinusAsDelimiter(delimitersData, input)  // 구분자 목록과 입력 문자열을 넘김
        return Pair(delimitersData, input)
    }

    private fun checkForMinusAsDelimiter(delimiters: List<String>, input: String) {
        if (delimiters.contains("-")) {
            println(delimiters)
            return  // 구분자 목록에 '-'가 있으면 그대로 통과
        }

        if (input.contains('-')) {
            // 구분자 목록에 '-'가 없는데 입력에 '-'가 포함된 경우 예외 처리
            throw IllegalArgumentException("'-'는 커스텀 구분자로 지정되어야 사용 가능합니다.")
        }
    }
    private fun parseNumbers(numbersString: String, delimiters: List<String>): List<Int> {
        // 구분자 리스트로 문자열 자르기
        return numbersString
            .split(*delimiters.toTypedArray()) // 구분자로 문자열 자르기
            .filter { it.isNotBlank() } // 빈 문자열 필터링
            .map {
                it.toIntOrNull() ?: throw IllegalArgumentException("Invalid number format: $it")
            } // 정수 리스트로 변환 및 예외 처리
    }

    fun getNumberList(): List<Int> = numberList
}
