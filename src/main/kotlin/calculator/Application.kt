package calculator

fun main() {
    val user = User()
    val parser = Parser()
    val calculator = PlusCalculator()

    fun run() {
        val parsedSeparator = parser.parseSeparator(user.enterString())
        val parsedNumbers = parser.parseNumber(parsedSeparator)
        println("결과 : ${calculator.execute(parsedNumbers)}")

    }
    run()
}
