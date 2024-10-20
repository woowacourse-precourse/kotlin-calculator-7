package calculator

object DelimiterParser {
    /**
     * 구분자 추출 및 반환
     * @param input 원본 입력 문자열
     * @return 추출된 구분자로 이루어진 Set
     */
    fun getDelimiter(input: String): Set<Char> {
        val delimiterSet: MutableSet<Char> = mutableSetOf(',', ':')
        if (CommandDetector.hasCommand(input)) {
            delimiterSet.add(input[2])
        }
        return delimiterSet
    }
}