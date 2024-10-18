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
        return str.split(",", ":").filter { it.isNotEmpty() }.map { it.toInt() }
    }
}
