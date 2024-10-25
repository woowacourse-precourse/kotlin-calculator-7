package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {

    println("덧셈할 문자열을 입력해 주세요.")

    val str = readLine()
    try {
        val sum = if (hasCustomDelimiter(str)) {
            val (newDelimiter, s) = splitByCustomDelimiter(str)
            sumOfStringList(s.split(",", ":", newDelimiter))
        } else {
            sumOfStringList(str.split(",", ":"))
        }
        println("결과 : $sum")
    } catch (e: Exception) {
        throw IllegalArgumentException("잘못된 입력 형식입니다.")
    }
}

fun hasCustomDelimiter(str: String) = Regex("//.*\\n").containsMatchIn(str.replace("\\n", "\n"))

fun splitByCustomDelimiter(str: String): Pair<String, String> {
    val splitList = str.split("//", "\\n")
    return splitList[1] to splitList[2]
}

fun sumOfStringList(list: List<String>) =
    list.sumOf {
        val n = it.toInt()
        if (n <= 0) throw IllegalArgumentException("잘못된 입력 형식입니다.")
        n
    }