package calculator

import camp.nextstep.edu.missionutils.Console

class InOutController(private val repo: Repository) {

    fun input() {
        // 문자열을 입력받고, 커스텀 구분자의 유무를 확인
        val input = Console.readLine()
        repo.userInput = input
        checkCustomDivider(repo.userInput)

        // 문자열 예외 처리
        checkException()
    }

    private fun checkCustomDivider(input: String) {
        if (input.startsWith("//")) {
            if (input.indexOf("\\n") != -1) {
                repo.customDivider = input.substring(2, input.indexOf("\\n"))
                repo.userInput = input.substring(input.indexOf("\\n") + 2)
            }
        } else repo.customDivider = null
    }

    private fun checkException() {
        var occurException = false
        val input = repo.userInput
        val divider = listOf(",", ":", repo.customDivider)

        // 예외 처리 1. //, \n 사이에 커스텀 구분자가 입력되지 않은 경우
        // 예외 처리 2. //, \n 둘 중 하나만 입력된 경우
        if (input.startsWith("//")) {
            if (input.indexOf("\\n") != -1) {
                if (input.indexOf("\\n") == 2) occurException = true
            } else occurException = true
        } else {
            if (input.indexOf("\\n") != -1) occurException = true
        }

        // 예외 처리 3. ,, :, 커스텀 구분자, //, \n, 숫자 이외의 입력이 있는 경우
        val validCharactersRegex = Regex("[0-9${Regex.escape(divider.joinToString(""))}]*")
        if (!validCharactersRegex.matches(input)) {
            occurException = true
        }

        // 예외 출력
        if (occurException) throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
    }
}