package calculator

import calculator.InputStringManager as ISM

object ErrorChecker {
    /**
     * 원본 입력 문자열을 Parse하여 예외를 체크
     * @param input 원본 입력 문자열
     * @throws IllegalArgumentException 잘못된 입력 탐지시 예외 발생
     */
    fun invalidInputCheck(input: String) {
        val availableDigits = ISM.getAvailableDigits(input)
        val splitInputString = ISM.getSplitStringList(input)
        if (ISM.emptyInputChecker(input)) {
            return
        }
        checkBothEndsIsNumber(input, availableDigits)
        checkElementValidity(input, splitInputString, availableDigits)
    }

    /**
     * 커맨드가 제거된 입력의 양 끝이 숫자인지 판별
     * @param input 원본 입력 문자열
     * @throws IllegalArgumentException 잘못된 입력 탐지시 예외 발생
     */
    private fun checkBothEndsIsNumber(input: String, availableDigits: Collection<Char>) {
        val commandRemovedInput = ISM.getCommandRemovedInput(input)

        if (commandRemovedInput.first() !in availableDigits) {
            throw IllegalArgumentException("오류: 커맨드를 제외한 입력값은 숫자로 시작해야 합니다.")
        }
        if (commandRemovedInput.last() !in availableDigits) {
            throw IllegalArgumentException("오류: 커맨드를 제외한 입력값은 숫자로 끝나야 합니다.")
        }
    }

    /**
     * 구분자로 잘려진 각각의 입력 요소가 유효한지 검증
     * @param input 원본 입력 문자열
     * @param availableDigits 현재 입력에서 이용 가능한 숫자가 저장된 컬렉션
     * @sample "1:2.0.3:2" 입력시 "2.0.3"에 '.'이 두번 입력되어 있으므로 예외 처리
     * @throws IllegalArgumentException 잘못된 구분자 입력 탐지시 예외 발생
     */
    private fun checkElementValidity(
        input: String, splitInputString: List<String>, availableDigits: Collection<Char>
    ) {
        splitInputString.forEach { splitInputElement ->
            if (splitInputElement.isEmpty()) {
                throw IllegalArgumentException("오류: 구분자는 숫자 사이에 입력해야 합니다.")
            }
            if (splitInputElement.first() == '.' || splitInputElement.last() == '.') {
                throw IllegalArgumentException("오류: 각각의 숫자는 .으로 시작하거나 끝날 수 없습니다.")
            }
        }
        checkMultipleDotInElement(splitInputString, availableDigits)
        checkZeroInElement(input)
    }

    /**
     * 각각의 숫자 요소에 .이 2번이상 포함되는지 체크
     * @param splitInputString 구분자로 분할된 문자열 리스트
     * @param availableDigits 현재 입력에서 이용 가능한 숫자가 저장된 컬렉션
     * @sample "1:2.0.3:2" 입력시 "2.0.3"에 '.'이 두번 입력되어 있으므로 예외 처리
     * @throws IllegalArgumentException 잘못된 구분자 입력 탐지시 예외 발생
     */
    private fun checkMultipleDotInElement(
        splitInputString: List<String>, availableDigits: Collection<Char>
    ) {
        splitInputString.forEach { splitInputElement ->
            var hasSeenPoint = false
            for ((index, char) in splitInputElement.withIndex()) {
                if (char in availableDigits) {
                    continue
                }
                if (!hasSeenPoint && index > 0 && char == '.') {
                    hasSeenPoint = true
                    continue
                }
                throw IllegalArgumentException("오류: 잘못된 구분자 입력입니다.")
            }
        }
    }

    /**
     * 각각의 숫자 요소에 0 또는 0.0이 포함되는지 체크
     * @param input 원본 입력 문자열
     * @throws IllegalArgumentException 잘못된 구분자 입력 탐지시 예외 발생
     */
    private fun checkZeroInElement(input: String) {
        val parsedList: List<Number> =
            when (ISM.isIntTypeInput(input)) {
                true -> ISM.parseInputStringToIntList(input)
                false -> ISM.parseInputStringToDoubleList(input)
            }
        if (0 in parsedList || 0.0 in parsedList) {
            throw IllegalArgumentException("오류: 양수만 입력해 주세요.")
        }
    }
}