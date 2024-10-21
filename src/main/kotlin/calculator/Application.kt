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
    val numbers = strings.map { it.toInt() }

    return numbers.sum()
}

fun splitForCalculate(string: String): List<String> {
    if (Regex("//.\\n(.+)").matches(string)) {
        return string.substring(4).split(string[2])
    }

    return string.split(",", ":")
}