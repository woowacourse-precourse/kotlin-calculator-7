package calculator

import calculator.StringUtility.splitByCollection

object InputStringManager {
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
    fun hasDoubleInput(input: String): Boolean {
        val noCommandInput = getCommandRemovedInput(input)
        val delimiters: Set<Char> = DelimiterParser.getDelimiter(input)

        if (delimiters.contains('.')) {
            return true
        }
        if (noCommandInput.contains('.')) {
            return false
        }
        return true
    }

    /**
     * Input 문자열을 구분자로 잘라 합산
     * @param input 원본 입력 문자열
     * @return 구분자로 끊어 합산한 결과값
     */
    fun sumInputString(input: String): Number {
        if (hasDoubleInput(input)) {
            return parseInputStringToIntList(input).sum()
        }
        return parseInputStringToDoubleList(input).sum()
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
}