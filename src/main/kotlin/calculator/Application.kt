package calculator

fun main() {
    print("덧셈할 문자열을 입력해 주세요.\n")
    val input = camp.nextstep.edu.missionutils.Console.readLine()
    val result = calculate(input)
    print("결과 : $result")
}

fun calculate(string: String): Int {
    if (string == "") return 0
    
    val strings = splitForCalculate(string)
    val numbers = changeToInt(strings)

    return numbers.sum()
}

fun splitForCalculate(string: String): List<String> {
    if (string.length > 5 &&
        string.startsWith("//") &&
        string.slice(3 until 5) == "\\n") {
        return string.substring(5).split(string[2])
    }

    return string.split(",", ":")
}

fun changeToInt(list: List<String>): List<Int> {
    try {
        return list.map { it.toInt() }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("잘못된 입력입니다.", e)
    }
}