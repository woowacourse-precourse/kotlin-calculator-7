package calculator

import camp.nextstep.edu.missionutils.Console

val sepList = mutableListOf(",", ":")

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val str = Console.readLine()
    val splitStr = splitStr(str)
    val result = calculate(splitStr)
    println("결과 : $result")
}

fun splitStr(str: String): List<Int> {
    if (str.trim().isEmpty()) {
        throw IllegalArgumentException("구분자와 양수로 구성된 문자열을 입력해 주세요.")
    } else {
        val strWithoutSep = findCustomSeparator(str)
        return strWithoutSep.split(*sepList.toTypedArray())
            .filter { it.isNotBlank() }
            .map {
                try {
                    convertToIntOrThrow(it)
                } catch (e: NumberFormatException) {
                    throw IllegalArgumentException("잘못된 문자열 형식이 포함되어 있어요: '$it'")
                }
            }
    }
}

fun findCustomSeparator(str: String): String {
    if (str.startsWith("//") && str.contains("\\n")) {
        val customSeparator = getCustomSeparator(str)
        sepList.add(customSeparator)
        return Regex("""//.*\\n""").replace(str, "")
    }
    return str
}

fun getCustomSeparator(str: String): String {
    // "//"의 끝 위치와 "\n"의 시작 위치 찾기
    val startIndex = str.indexOf("//") + 2
    val endIndex = str.indexOf("\\n")

    val customSeparator = str.substring(startIndex, endIndex)

    // 구분자가 숫자인 경우 예외 발생
    if (customSeparator.trim().all { it.isDigit() }) {
        throw IllegalArgumentException("숫자는 커스텀 구분자로 사용할 수 없어요.")
    }

    // "//"와 "\n" 사이의 문자열을 추출하여 반환
    return customSeparator
}

fun calculate(strList: List<Int>): Int {
    var sum = 0
    for (n in strList) {
        sum += n
    }
    return sum
}

fun convertToIntOrThrow(str: String): Int {
    // 양수가 아닌 경우 예외 발생
    if (str.toInt() <= 0) {
        throw IllegalArgumentException("양수만 입력해 주세요.")
    }
    return str.toInt()
}
