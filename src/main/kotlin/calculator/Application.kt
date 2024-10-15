package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    val info = Console.readLine()
    val separatorSet = mutableSetOf<Char>()

    separatorSet.add(',')
    separatorSet.add(':')
    val cursor: Int

    try {
        cursor = findSeparator(info, separatorSet)
    } catch (e: IllegalArgumentException) {
        Console.close(); return
    }



    Console.close()
}

@Throws(IllegalArgumentException::class)
fun findSeparator(inputString: String, separatorSet: MutableSet<Char>): Int {
    if (inputString.length < 4) {
        return 0
    }

    val opener = "//"
    val closer = """\n"""
    val openerCheck = inputString.slice(0..1) == opener

    if (!openerCheck) {
        return 0
    }

    val separator = inputString[2]
    val closerCheck = inputString.slice(3..4) == closer

    if (!closerCheck) {
        throw IllegalArgumentException()
    }

    separatorSet.add(separator)

    return 5
}