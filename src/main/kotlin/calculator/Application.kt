package calculator

fun main() {
    // TODO: 프로그램 구현

    var parser = Parser()

    println(parser.parse(null))
}

class Parser {
    fun parse(input: String?): List<Int> {
        if (input.isNullOrEmpty()) {
            return listOf(0)
        }
        return listOf()
    }
}