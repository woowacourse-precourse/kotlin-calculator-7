package calculator

// input 문자열을 조작하거나 연산을 수행하는 객체
object InputStringManager {

    fun getSplitStringList(input: String): List<String> {
        // 커맨드를 제외한 값이 비어있다면 비어있는 리스트를 반환
        if (getCommandRemovedInput(input).isEmpty()) {
            return emptyList()
        }
        // input 문자열에서 Set<Char>으로 구분자를 추출해놓은 변수
        val delimiters: Set<Char> = DelimiterParser.getDelimiter(input)

        // 구분자 Set의 각각의 원소를 정규식 이스케이프 처리하여 리스트로 저장
        val escapedDelimiters = delimiters.map { Regex.escape(it.toString()) }
        // 이스케이프 처리된 구분자 리스트를 하나의 문자열로 결합
        val joinedDelimiters = escapedDelimiters.joinToString(separator = "")
        // 결합한 문자열을 대괄호로 감싸서 각각의 구분자를 선택하는 정규식으로 변환
        val regex = "[${joinedDelimiters}]".toRegex()
        // 정규식을 사용해 커맨드를 제거한 인풋 문자열을 슬라이싱
        return getCommandRemovedInput(input).split(regex)
    }

    // input 문자열을 구분자로 쪼개서 List<Int>로 반환하는 메서드
    fun parseInputStringToIntList(input: String): List<Int> {
        val strList = getSplitStringList(input)
        // 슬라이싱한 String타입의 리스트를 Int형 List로 변환하여 반환
        return strList.map { it.toInt() }
    }

    // input 문자열을 구분자로 쪼개서 List<Float>로 반환하는 메서드
    fun parseInputStringToDoubleList(input: String): List<Double> {
        val strList = getSplitStringList(input)

        // 슬라이싱한 String타입의 리스트를 Double형 List로 변환하여 반환
        return strList.map { it.toDouble() }
    }

    // input값이 정수만 사용되었는지 감지하여 Boolean을 반환하는 함수
    fun detectAllIntInput(input: String): Boolean {
        // 커맨드를 제거한 인풋과 구분자를 불러오기
        val noCommandInput = getCommandRemovedInput(input)
        val delimiters: Set<Char> = DelimiterParser.getDelimiter(input)

        // 구분자에 .이 있을경우 무조건 정수로 나뉘게 되므로 true반환
        if (delimiters.contains('.')) {
            return true
        }
        // 구분자에 .이 없으며 입력값에 .이 포함되어 있으면 실수이므로 false반환
        if (noCommandInput.contains('.')) {
            return false
        }
        // 구분자와 인풋에 .이 없으면 정수이므로 true반환
        return true
    }

    // 인풋 문자열을 합산하여 반환하는 메소드
    fun sumString(input: String): String {
        // input 문자열을 구분자를 통해 슬라이싱된 int타입 List로 불러옴
        if (detectAllIntInput(input)) {
            return parseInputStringToIntList(input).sum().toString()
        }
        return parseInputStringToDoubleList(input).sum().toString()
    }

    // 인풋 문자열에서 커맨드를 제거한 문자열을 반환하는 메소드
    fun getCommandRemovedInput(input: String): String {
        if (CommandVerifier.verifyCommand(input)) { //커맨드의 존재 확인후 존재한다면 커맨드를 제거하여 반환
            return input.substring(COMMAND_LENGTH until input.length)
        }
        return input
    }
}