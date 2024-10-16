package calculator

// 오류를 검사하기 위한 객체
object ErrorChecker {
    // 인풋 오류를 검사하는 메소드
    fun invalidInputCheck(input: String) {
        val isAllInt = InputStringManager.detectAllIntInput(input)
        val commandRemovedInput = InputStringManager.getCommandRemovedInput(input)
        // 비어있는 값이 입력될 경우 예외처리를 건너뜀
        if (commandRemovedInput.isEmpty()) {
            return
        }

        // 아라비아 숫자를 char타입의 리스트로 저장
        val validDigits = (0..9).toList().map { it.digitToChar() }

        // 커맨드를 제외한 인풋이 구분자로 시작하면 예외 발생
        if (!validDigits.contains(commandRemovedInput[0])) {
            throw IllegalArgumentException("오류: 구분자로 시작할 수 없습니다.")
        }

        // 구분자로 분할한 String타입 리스트를 불러옴
        val strList = InputStringManager.getSplitStringList(input)

        // 구분자로 분할된 각각의 원소를 검사
        strList.map {
            // 점이 2번 이상 사용되었는지 검사하기 위한 플래그
            var pointFlag = true
            // 원소의 값을 문자단위로 다시 쪼개서 검사
            for ((index, char) in it.withIndex()) {
                // 숫자이면 다음 문자로 이동
                if (validDigits.contains(char)) {
                    continue
                }
                // .이 2번 연속 나오지 않고 0번 인덱스가 아니면 다음문자로 이동
                if (pointFlag && index != 0 && char == '.') {
                    pointFlag = false
                    continue
                }
                // .이 두번 등장하거나 .이 맨 앞에 등장하거나 .이나 숫자가 아닌경우 예외처리됨
                throw IllegalArgumentException("오류: 잘못된 구분자 입력입니다.")
            }
        }

        // 0 또는 0.0 입력을 탐지하여 예외 발생
        if (isAllInt && InputStringManager.parseInputStringToIntList(input).contains(0)) {
            throw IllegalArgumentException("오류: 양수만 입력해 주세요")
        }
        if (InputStringManager.parseInputStringToDoubleList(input).contains(0.0)) {
            throw IllegalArgumentException("오류: 양수만 입력해 주세요")
        }
    }
}