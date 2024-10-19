package calculator

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")

    val str = readLine()
    if (hasCustomDelimiter(str)) {
        val (newDelimiter, s) = splitByCustomDelimiter(str)
    } else {

    }
}


fun readLine(): String = camp.nextstep.edu.missionutils.Console.readLine()

fun hasCustomDelimiter(str: String) = Regex("//.*\\n").containsMatchIn(str.replace("\\n", "\n"))

fun splitByCustomDelimiter(str: String): Pair<String, String> {
    val splitList = str.split("//", "\\n")
    return splitList[1] to splitList[2]
}