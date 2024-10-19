package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val input = Console.readLine()

    val numberList = if (input != null && input.startsWith("//")) {
        val parts = input.replace("\\n", "\n").split("\n", limit = 2)
        val custom = parts[0].substring(2)

        parts[1].split(custom)
    } else {
        input?.split(",", ":")
    }

    val answer = numberList
        ?.filter { it.isNotEmpty() }
        ?.map { it.toInt() }
        ?.sum() ?: 0

    println("결과 : ${answer}")
    Console.close()
}