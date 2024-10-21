package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun add(input: String): Int {
    if (input.isEmpty()) return 0
    return input.split(",", ":")
        .sumOf { it.toInt() }
}

fun main() { // test
    println(add("1,2:3"))
}