package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    var input = readLine()
    println("결과 : ${calculate(input)}")

}

fun calculate(input: String?): Int {
    if (input.isNullOrEmpty()) return 0
    var calc = input
    val delimiters = mutableListOf(",", ":")
    // 커스텀 구분자인지 판단
    if (calc.startsWith("//")) {
        // 커스텀 구분자인 경우
        val custom = calc.substring(2 until calc.indexOf("\\n"))
        calc = calc.substring(calc.indexOf("\\n")+2 until calc.length)
        delimiters.add(custom)
    }
    val numbers = calc.split(*delimiters.toTypedArray()).map { isProperNumber(it)}
    return numbers.sum()
}

fun isProperNumber(it: String): Int {
    try {
        val number = it.toInt()
        if (number < 0) throw IllegalArgumentException("Input values must be positive numbers only.")
        return number
    } catch(e: NumberFormatException) {
        throw IllegalArgumentException("Input cannot be entered as values other than the specified delimiter")
    }
}