package calculator

import camp.nextstep.edu.missionutils.Console

// 입력
fun input(): String {
    return Console.readLine()
}

// 문자열 유효성 검사
fun isValidString(string: String): Boolean {
    val regex = Regex("^//.\n")
    val isCustomSeparator = regex.containsMatchIn(string)
    val allowedCharacters = mutableListOf(',', ':', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    if (isCustomSeparator)
        allowedCharacters += string[2]

    val checkString = if (isCustomSeparator) string.substring(startIndex = 5) else string
    for (c in checkString)
        if (c !in allowedCharacters)
            return false
    return true
}

fun main() {
    // TODO: 프로그램 구현
}
