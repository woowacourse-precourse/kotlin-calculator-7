package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readLine()
    println("결과 : ${calculate(input)}")

}

fun calculate(input: String?): Long {
    if (input.isNullOrEmpty()) return 0
    var calc = input
    val delimiters = mutableListOf(",", ":")
    // 커스텀 구분자인지 판단
    if (calc.startsWith("//") && calc.contains("\\n")) {
        // 커스텀 구분자인 경우
        val custom = calc.substring(2 until calc.indexOf("\\n"))
        calc = calc.substring(calc.indexOf("\\n")+2 until calc.length)
        delimiters.add(custom)
    }
    if (calc.isNullOrEmpty()) return 0
    val numbers = calc.split(*delimiters.toTypedArray()).map { isProperNumber(it)}
    return numbers.sum()
}

fun isProperNumber(it: String): Long {
    try {
        val number = it.toLong()
        if (number < 0) throw IllegalArgumentException("Input values must be positive numbers only.")
        return number
    } catch(e: NumberFormatException) {
        throw IllegalArgumentException("Input cannot be entered as values other than the specified delimiter")
    }
}