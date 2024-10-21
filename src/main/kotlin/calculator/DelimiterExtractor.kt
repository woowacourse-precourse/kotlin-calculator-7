package calculator

// 구분자 추출하는 클래스
class DelimiterExtractor {
    fun extract(input: String): Pair<String, String> {
        return if (input.startsWith("//")) { // //로 시작할 때 커스텀 구분자로 분류시작
            val delimiterEndIndex = findFirstDigitIndex(input)
            val delimiter = input.substring(2, delimiterEndIndex-2)
            // 다수 커스텀 구분자들을 받아서 등록
            val delimiters = delimiter.toList().map { Regex.escape(it.toString()) }.joinToString("|") + "|,|:"
            val numbersString = input.substring(delimiterEndIndex)
            Pair(delimiters, numbersString)
        } else {
            Pair(",|:", input) // 기본 구문자 선언
        }
    }

    // 문자열에 있는 첫 숫자의 인덱스를 반환하는 함수
    private fun findFirstDigitIndex(input: String): Int {
        for (i in input.indices) {
            if (input[i].isDigit()) {
                return i
            }
        }
        // 숫자가 입력되지 않은 경우 예외처리
        throw IllegalArgumentException("숫자를 입력해주세요.")
    }
}
