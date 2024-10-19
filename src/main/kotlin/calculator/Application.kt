package calculator

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println("덧셈할 문자열을 입력해 주세요.")
    var calc = br.readLine()
    when(calc.length) {
        0 -> {
            // 아무것도 입력하지 않았을 때 0 출력
            println("결과 : 0")
            return
        }
        1 -> {
            // 하나만 입력했을 때 숫자인지 확인 & 결과 출력
            println("결과 : ${calc.toIntOrNull()?:throw IllegalArgumentException("string must be...")}")
        }
        else -> {

            val delimiters = arrayOf(",", ":", )
            // 커스텀 구분자인지 판단
            if (calc.substring(0..1) == "//") {
                // 커스텀 구분자인 경우
                val custom = calc.substring(2 until calc.indexOf("\\n"))
                calc = calc.substring(calc.indexOf("\\n")+2 until calc.length)
                val numbers = calc.split(",", ":", custom).map {
                    try {
                        it.toInt()
                    } catch (e: NumberFormatException){
                        throw IllegalArgumentException("string must be...")
                    }

                }
                println("결과 : ${numbers.sum()}")

            }
            else {
                // 커스텀 구분자를 활용하지 않은 경우
                val numbers = calc.split(",", ":").map {
                    try {
                        it.toInt()
                    } catch (e: NumberFormatException){
                        throw IllegalArgumentException("string must be...")
                    }

                }
                println("결과 : ${numbers.sum()}")
            }

        }
    }


}
