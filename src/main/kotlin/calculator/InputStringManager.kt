package calculator

import calculator.StringUtility.splitByCollection

object InputStringManager {
    /**
     * Input 문자열을 구분자로 잘라 합산
     * @param input 원본 입력 문자열
     * @return 구분자로 끊어 합산한 결과값
     */
    fun sumInputString(input: String): Number {
        if (isIntTypeInput(input)) {
            return parseInputStringToIntList(input).sum()
        }
        return parseInputStringToDoubleList(input).sum()
    }

    /**
     * 원본 입력 문자열을 문자열 리스트로 분할
     * @param input 원본 입력 문자열
     * @return 분할된 문자열 리스트
     */
    fun getSplitStringList(input: String): List<String> {
        if (getCommandRemovedInput(input).isEmpty()) {
            return emptyList()
        }
        val delimiters: Set<Char> = DelimiterParser.getDelimiter(input)
        return getCommandRemovedInput(input).splitByCollection(delimiters)
    }

    /**
     * 원본 입력 문자열을 정수 리스트로 분할
     * @param input 원본 입력 문자열
     * @return 분할된 정수 리스트
     */
    fun parseInputStringToIntList(input: String): List<Int> {
        val strList = getSplitStringList(input)
        return strList.map { it.toInt() }
    }

    /**
     * 원본 입력 문자열을 실수 리스트로 분할
     * @param input 원본 입력 문자열
     * @return 분할된 실수 리스트
     */
    fun parseInputStringToDoubleList(input: String): List<Double> {
        val strList = getSplitStringList(input)
        return strList.map { it.toDouble() }
    }

    /**
     * Double 형인 숫자가 존재하는지 검출
     * @param input 원본 입력 문자열
     * @return 검출한 부울 결과 값
     */
    fun isIntTypeInput(input: String): Boolean {
        val noCommandInput = getCommandRemovedInput(input)
        val delimiters: Set<Char> = DelimiterParser.getDelimiter(input)

        if ('.' in delimiters) {
            return true
        }
        if ('.' in noCommandInput) {
            return false
        }
        return true
    }

    /**
     * 원본 input 문자열에서 커맨드를 제거하여 반환
     * @param input 원본 입력 문자열
     * @return 커맨드가 제거된 문자열
     */
    fun getCommandRemovedInput(input: String): String {
        if (CommandDetector.hasCommand(input)) {
            return input.substring(COMMAND_LENGTH until input.length)
        }
        return input
    }

    /**
     * 사용자의 입력에서 이용 가능한 숫자를 찾기
     * @param input 원본 입력 문자열
     * @return 입력 문자열에서 사용할 수 있는 숫자로 이루어진 Set
     */
    fun getAvailableDigits(input: String): Set<Char> {
        val digits = ('0'..'9').toSet()
        return digits - DelimiterParser.getDelimiter(input)
    }

    /**
     * 사용자의 입력이 비어있는지 검사
     * @param input 원본 입력 문자열
     * @return 입력값이 비어있는지 나타내는 부울 값
     */
    fun emptyInputChecker(input: String): Boolean {
        val commandRemovedInput = getCommandRemovedInput(input)
        return commandRemovedInput.isEmpty()
    }
}