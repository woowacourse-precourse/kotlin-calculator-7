package calculator

import camp.nextstep.edu.missionutils.Console

private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val CUSTOM_DELIMITER_SUFFIX = "\\n"

private const val CUSTOM_DELIMITER_SUFFIX_NOT_FOUND = -1
private const val CUSTOM_DELIMITER_PREFIX_LENGTH = 2

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()
}