package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        println("덧셈할 문자열을 입력해 주세요.")

        val input = Console.readLine()

        if (input =="") {
            println("결과 : 0")
            return
        }

        val numberList = if (input != null && input.startsWith("//")) {
            val parts = input.replace("\\n", "\n").split("\n", limit = 2)

            if (parts.size < 2 || parts[1].isEmpty()) {
                throw IllegalArgumentException("잘못된 입력입니다.")
            }

            val custom = parts[0].substring(2)
            parts[1].split(Regex(custom))
        } else {
            input?.split(Regex("[,:]"))
        }

        val answer : Long = numberList
            ?.filter { it.isNotEmpty() }
            ?.map { it.toLongOrNull() ?: throw IllegalArgumentException("잘못된 입력입니다.") }
            ?.sum() ?: throw IllegalArgumentException("잘못된 입력입니다.")

        println("결과 : ${answer}")

    } catch (e: IllegalArgumentException) {
        println("오류가 발생했습니다. ${e.message}")
    } finally {
        Console.close()
    }
}