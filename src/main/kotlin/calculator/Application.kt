package calculator

fun main() {
    // TODO: 프로그램 구현
    val userInput = readlnOrNull()
    val result = userInput?.split("[,:]".toRegex())

    println(result)
}
