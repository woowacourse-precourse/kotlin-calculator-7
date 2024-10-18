package calculator

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println("덧셈할 문자열을 입력해 주세요.")
    val calc = br.readLine()
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
            // 커스텀 연산자인지 판단
            if (calc.substring(0..1) == "//") {
                // 커스텀 연산자인 경우
            }
            else {
                // 커스텀 연산자를 활용하지 않은 경우
                val numbers = calc.split(",", ":").map { it.toInt() }
                println("결과 : ${numbers.sum()}")
            }

        }
    }


}
