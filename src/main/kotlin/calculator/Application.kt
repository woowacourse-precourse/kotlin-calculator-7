package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()
    var result = 0

    val numList = mutableListOf<String>()

    if (input.isNotEmpty()) {
        for (n in input.split(",")) {
            if (n.contains(":")) {
                for (s in n.split(":")) {
                    numList.add(s)
                }
            } else {
                numList.add(n)
            }
        }

        for (s in numList) {
            result += s.toInt()
        }

        println("결과 : $result")
    } else {
        println("결과 : $result")
    }
}
