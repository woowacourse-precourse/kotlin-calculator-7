package calculator


fun getNumberList(onlyNumberInputString: String, userSeparator: String?): List<Int> {
    try {
        return onlyNumberInputString.split(",|:|${userSeparator}".toRegex()).map { it.toInt() }
    } catch (err: NumberFormatException) {
        throw IllegalArgumentException("형식에 맞추어 문자열을 입력해주세요.")
    }
}

fun main() {
    // TODO: 프로그램 구현
    val SEPARATOR_COMMAND_FRONT = "//"
    val SEPARATOR_COMMAND_BACK = "\\\\n"

    println("덧셈할 문자열을 입력해 주세요.")
    val userInput = readlnOrNull() ?: ""

    val separatorRegex = Regex("(?<=${SEPARATOR_COMMAND_FRONT})(.*?)(?=${SEPARATOR_COMMAND_BACK})") // 정규식
    val userSeparator = separatorRegex.find(userInput)?.value

    val onlyNumberInputString =
        userSeparator?.length?.plus(SEPARATOR_COMMAND_FRONT.length + SEPARATOR_COMMAND_BACK.length - 1) ?: 0

    val numberList = getNumberList(userInput.substring(onlyNumberInputString), userSeparator)

    println("결과 : ${numberList.sum()}")

}
