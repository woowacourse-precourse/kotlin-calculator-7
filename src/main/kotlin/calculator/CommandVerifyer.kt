package calculator

// input 문자열에 커맨드가 존재하는지 판단하는 객체
object CommandVerifyer {
    //커스텀 구분자는 '문자'이므로 // \n를 포함하여 총 5자리임을 상수로 선언
    private const val LENGTH_FOR_COMMAND = 5

    // input에 커스텀 구분자를 포함하는 커맨드 문자열이 있는지 검증하는 메서드
    fun verifyCommand(input: String): Boolean {
        // input의 길이가 커맨드의 길이보다 작을 때는 커스텀 구분자를 추출 하지 않음
        if (input.length < LENGTH_FOR_COMMAND) {
            return false
        }

        // 커맨드 문자열의 길이만큼 인풋 자르기
        val command = input.substring(0 until LENGTH_FOR_COMMAND)

        // 커맨드가 //로 시작하지 않으면 올바른 커맨드가 아님을 검증
        if (!command.startsWith("//")) {
            return false
        }
        // 커맨드가 \n로 끝나지 않으면 올바른 커맨드가 아님을 검증
        if (!command.endsWith("\\n")) {
            return false
        }

        return true
    }

}