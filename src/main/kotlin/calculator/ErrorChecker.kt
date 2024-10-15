package calculator

// 오류를 검사하기 위한 객체
object ErrorChecker {
    // 인풋 오류를 검사하는 메소드
    fun invalidInputCheck(input: String) {
        if (input.isEmpty()) { // 비어있는 입력값을 탐지하여 예외 발생
            throw IllegalArgumentException("오류: 입력한 값이 비었습니다")
        }
        // 구분자와 구분자가 제거된 인풋 변수에 저장
        val delimiter = DelimiterParser.getDelimiter(input)
        val commandRemovedInput = InputStringManager.getCommandRemovedInput(input)
        // 아라비아 숫자를 char타입의 리스트로 저장
        val validDigits = (0..9).toList().map { it.digitToChar() }

        // 구분자가 2회 연속 등장하는지 탐지하기 위한 플래그 변수
        var beforeNumber = false

        // input 문자열을 char 단위로 순회
        for (c in commandRemovedInput) {
            if (validDigits.contains(c)) { // 숫자에 해당하면 플래그를 true으로 바꾸고 건너뛰기
                beforeNumber = true
                continue
            }

            // 구분자에 해당하며 이전이 숫자였다면 플래그를 false로 바꾸고 건너뛰기
            if (delimiter.contains(c) && beforeNumber) {
                beforeNumber = false
                continue
            }

            // 숫자 혹은 구분자가 아니거나 구분자가 연속 등장하는 경우 예외 발생
            throw IllegalArgumentException("오류: 잘못된 입력입니다. 에러 문자:'${c}'")
        }
        if (!beforeNumber) { // 구분자로 끝나는 문자열을 탐지하여 예외 발생
            throw IllegalArgumentException("오류: 구분자 뒤에 숫자를 입력해 주세요")
        }
    }
}