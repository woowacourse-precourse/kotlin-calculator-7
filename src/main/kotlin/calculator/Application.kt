package calculator

fun main() {
    // TODO: 프로그램 구현
    val SEPARATOR_COMMAND_FRONT = "//"
    val SEPARATOR_COMMAND_BACK = "\\n"

    val userInput = readlnOrNull() ?: ""

    val separatorRegex = Regex("(?<=${SEPARATOR_COMMAND_FRONT})(.*?)(?=${SEPARATOR_COMMAND_BACK})") // 정규식
    val userSeparator = separatorRegex.find(userInput)?.value

    val onlyNumberInputString =
        userSeparator?.length?.plus(SEPARATOR_COMMAND_FRONT.length + SEPARATOR_COMMAND_BACK.length - 1) ?: 0

    val result = userInput.substring(onlyNumberInputString).split(",|:|${userSeparator}".toRegex())

    println("결과 : ${result}")

}
