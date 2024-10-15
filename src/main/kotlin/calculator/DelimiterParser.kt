package calculator

// 구분자를 추출 및 반환하는 작업을 하는 객체
object DelimiterParser {

    // 구분자 추출 메서드
    private fun parse(input: String): Set<Char> {
        val delimiterSet: MutableSet<Char> = mutableSetOf(',', ':') // 기본 구분자로 이루어진 가변 Set

        // input 문자열에 커맨드의 존재 여부를 체크한뒤 커맨드에 해당하는 문자를 Set에 추가하기
        if (CommandVerifier.verifyCommand(input)) {
            delimiterSet.add(input[2])
        }

        return delimiterSet
    }

    // input에서 추출된 구분자를 반환하는 메소드
    fun getDelimiter(input: String): Set<Char> {
        return parse(input)
    }

}