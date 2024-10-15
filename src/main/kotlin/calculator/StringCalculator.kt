package calculator

// input 문자열을 Parse해 연산을 수행하는 메소드
object StringCalculator {
    // input 문자열을 구분자로 쪼개서 List<Int>로 반환하는 메서드
    private fun parseInputStringToNumbers(input: String): List<Int> {
        var commandRemovedInput = input // 커맨드를 제거한 구분자로 연결된 문자열을 저장할 면수
        if (CommandVerifier.verifyCommand(input)) { //커맨드의 존재 확인후 존재한다면 커맨드를 제거함
            commandRemovedInput = input.substring(COMMAND_LENGTH until input.length)
        }

        // input 문자열에서 Set<Char>으로 구분자를 추출해놓은 변수
        val delimiters: Set<Char> = DelimiterParser.getDelimiter(input)

        // 구분자 Set의 각각의 원소를 정규식 이스케이프 처리하여 리스트로 저장
        val escapedDelimiters = delimiters.map { Regex.escape(it.toString()) }
        // 이스케이프 처리된 구분자 리스트를 하나의 문자열로 결합
        val joinedDelimiters = escapedDelimiters.joinToString()
        // 결합한 문자열을 대괄호로 감싸서 각각의 구분자를 선택하는 정규식으로 변환
        val regex = "[${joinedDelimiters}]".toRegex()
        // 정규식을 사용해 커맨드를 제거한 인풋 문자열을 슬라이싱
        val strList = commandRemovedInput.split(regex)

        // 슬라이싱한 String타입의 리스트를 Int형 List로 변환하여 반환
        return strList.map { it.toInt() }
    }

    // 인풋 문자열을 합산하여 반환하는 메소드
    fun sumString(input: String): Int {
        // input 문자열을 구분자를 통해 슬라이싱된 int타입 List로 불러옴
        val intList = parseInputStringToNumbers(input)
        return intList.sum()
    }
}