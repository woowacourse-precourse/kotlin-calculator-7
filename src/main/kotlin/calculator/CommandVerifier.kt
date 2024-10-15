package calculator

// input 문자열에 커맨드가 존재하는지 판단하는 객체
object CommandVerifier {

    // input에 커스텀 구분자를 포함하는 커맨드 문자열이 있는지 검증하는 메서드
    fun verifyCommand(input: String): Boolean {
        // input의 길이가 커맨드의 길이보다 작을 때는 커스텀 구분자를 추출 하지 않음
        if (input.length < COMMAND_LENGTH) {
            return false
        }

        // 커맨드 문자열의 길이만큼 인풋 자르기
        val command = input.substring(0 until COMMAND_LENGTH)

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