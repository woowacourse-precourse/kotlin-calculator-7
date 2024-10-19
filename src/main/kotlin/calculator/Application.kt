package calculator

fun main() {
    // TODO: 프로그램 구현

    val parser = Parser()

    println(parser.parse(null))
    println(parser.parse(""))
    println(parser.parse("1,2,3"))
    println(parser.parse("4:5:6"))
    println(parser.parse("7,8:9"))
}

class Parser {
    fun parse(input: String?): List<Int> {
        if (input.isNullOrEmpty()) {
            return listOf(0)
        }
        return input.split(",", ":").map { it.toInt() }
    }
}