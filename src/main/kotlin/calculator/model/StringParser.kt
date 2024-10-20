package calculator

class StringParser(input: String) {
    private val numberList: List<Int>
    private val delimiters: List<String>
    private val cleanedInput: String

    init {
        val (delimitersFromInput, cleaned) = manageDelimiters(input) // 구분자 관리 및 선언 부분 삭제
        delimiters = delimitersFromInput
        cleanedInput = cleaned
        numberList = parseNumbers(cleanedInput, delimiters) // 선언 부분 제거 후 숫자 파싱
    }

    private fun manageDelimiters(input: String): Pair<List<String>, String> {
        val delimitersData = mutableListOf(",", ":")
        val pattern = Regex("""\/\/(.+?)\\n""")  // 커스텀 구분자 선언 패턴
        val matchResult = pattern.find(input)

        if (matchResult != null) {
            delimitersData.add(matchResult.groupValues[1]) // 커스텀 구분자 추가
            // 구분자 선언 부분을 삭제한 문자열 반환
            val cleanedInput = input.replaceFirst(pattern, "")
            return Pair(delimitersData, cleanedInput)
        }
        return Pair(delimitersData, input) // 구분자가 없으면 원본 문자열 그대로 반환

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
