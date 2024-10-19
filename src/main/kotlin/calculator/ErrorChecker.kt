package calculator

import calculator.InputStringManager as ISM

object ErrorChecker {
    /**
     * 원본 입력 문자열을 Parse하여 예외를 체크
     * @param input 원본 입력 문자열
     * @throws IllegalArgumentException 잘못된 입력 탐지시 예외 발생
     */
    fun invalidInputCheck(input: String) {
        val commandRemovedInput = ISM.getCommandRemovedInput(input)
        if (commandRemovedInput.isEmpty()) {
            return
        }

        // 현재 입력에서 사용가능한 숫자를 저장하기 위한 가변 리스트
        val availableDigits = (0..9).toList().map { it.digitToChar() }.toMutableList()
        val delimiter = DelimiterParser.getDelimiter(input)
        delimiter.forEach { availableDigits.remove(it) }

        if (commandRemovedInput.first() !in availableDigits) {
            throw IllegalArgumentException("오류: 구분자로 시작할 수 없습니다.")
        }
        if (commandRemovedInput.last() !in availableDigits) {
            throw IllegalArgumentException("오류: 구분자로 끝날 수 없습니다.")
        }

        val splitInputString = ISM.getSplitStringList(input)
        splitInputString.forEach { splitInputElement ->
            if (splitInputElement.isEmpty()) {
                throw IllegalArgumentException("오류: 구분자를 연속으로 입력할 수 없습니다.")
            }
            if (splitInputElement.first() == '.' || splitInputElement.last() == '.') {
                throw IllegalArgumentException("오류: 각각의 숫자는 .으로 시작하거나 끝날 수 없습니다.")
            }

            // 구분자로 잘려진 각각의 숫자 요소에 .이 2번이상 포함되는지 체크하는 코드
            // ex) "1:2.0.3:2" 입력시 "2.0.3"에 '.'이 두번 입력되어 있으므로 예외 처리
            var doublePointCheckFlag = true
            for ((index, char) in splitInputElement.withIndex()) {
                if (availableDigits.contains(char)) {
                    continue
                }
                if (doublePointCheckFlag && index > 0 && char == '.') {
                    doublePointCheckFlag = false
                    continue
                }
                throw IllegalArgumentException("오류: 잘못된 구분자 입력입니다.")
            }
        }

        // 입력값은 양수로 한정되므로 0 또는 0.0 입력시 예외 발생
        val isAllInt = ISM.hasDoubleInput(input)
        if (isAllInt && ISM.parseInputStringToIntList(input).contains(0)) {
            throw IllegalArgumentException("오류: 양수만 입력해 주세요.")
        }
        if (ISM.parseInputStringToDoubleList(input).contains(0.0)) {
            throw IllegalArgumentException("오류: 양수만 입력해 주세요.")
        }
    }
}