package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    var calc = readLine()
    var result = 0
    when(calc.length) {
        0 -> {
            // 아무것도 입력하지 않았을 때
        }
        else -> {
            var custom: String? = null
            var delimiters = mutableListOf(",", ":")

            // 커스텀 구분자인지 판단
            if (calc.length >= 2 && calc.substring(0..1) == "//") {
                // 커스텀 구분자인 경우
                custom = calc.substring(2 until calc.indexOf("\\n"))
                calc = calc.substring(calc.indexOf("\\n")+2 until calc.length)
                delimiters.add(custom)

            }

            val numbers = calc.split(*delimiters.toTypedArray()).map {
                try {
                    it.toInt()
                } catch (e: NumberFormatException){
                    throw IllegalArgumentException("Input cannot be entered as values other than the specified delimiter")
                }

            }
            numbers.forEach{
                if (it < 0) {
                    throw IllegalArgumentException("Input values must be positive numbers only.")
                }
            }
            result = numbers.sum()

        }
    }
    println("결과 : ${result}")

}
