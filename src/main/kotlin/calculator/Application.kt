package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val str = Console.readLine()
    val splitStr = splitStr(str)
    val result = calculate(splitStr)
    println(result)
}

fun splitStr(str: String): List<Int> {
    if (str == "") {
        return arrayListOf(0)
    } else {
        val customSeparator = findCustomSeparator(str)
        // 커스텀 구분자 입력 부분을 제거
        val strWithoutSep = Regex("""//.+\\n""").replace(str, "")
        return strWithoutSep.split(",", ":", customSeparator).filter { it.isNotEmpty() }.map { convertToIntOrThrow(it) }
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

fun calculate(strList: List<Int>): Int {
    var sum = 0
    for (n in strList) {
        sum += n
    }
    return sum
}

fun convertToIntOrThrow(str: String): Int {
    // 음수인 경우 예외 발생
    if (str.startsWith("-")) {
        throw IllegalArgumentException("음수는 입력할 수 없습니다.")
    }
    return str.toInt()
}
