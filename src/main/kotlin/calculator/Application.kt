package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val str = Console.readLine()
    val splitStr = splitStr(str)
    println(splitStr)
}

fun splitStr(str: String): List<Int> {
    if (str == "") {
        return arrayListOf(0)
    } else {
        val customSeparator = findCustomSeparator(str)
        // 커스텀 구분자 입력 부분을 제거
        val strWithoutSep = Regex("""//.+\\n""").replace(str, "")
        return strWithoutSep.split(",", ":", customSeparator).filter { it.isNotEmpty() }.map { it.toInt() }
    }
}

fun findCustomSeparator(str: String): String {
    // "//"의 끝 위치와 "\n"의 시작 위치 찾기
    val startIndex = str.indexOf("//") + 2
    val endIndex = str.indexOf("\\n")

    // 구분자가 없으면 빈 문자열 반환
    if (startIndex < 2 || endIndex == -1 || startIndex >= endIndex) {
        return ""
    }

    // "//"와 "\n" 사이의 문자열을 추출하여 반환
    return str.substring(startIndex, endIndex)
}