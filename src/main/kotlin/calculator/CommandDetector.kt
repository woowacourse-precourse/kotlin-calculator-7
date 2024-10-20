package calculator

object CommandDetector {
    /**
     * 원본 입력 문자열에 커맨드 문자열의 존재 유무 검사
     * @param input 원본 입력 문자열
     * @return 커맨드의 존재 유무를 나타내는 부울 값
     */
    fun hasCommand(input: String): Boolean {
        if (input.length < COMMAND_LENGTH) {
            return false
        }

        val command = input.substring(0 until COMMAND_LENGTH)
        if (!command.startsWith("//")) {
            return false
        }
        if (!command.endsWith("\\n")) {
            return false
        }

        return true
    }

}