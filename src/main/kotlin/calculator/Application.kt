package calculator

import calculator.constants.Message

fun main() {
    val user = User()
    val parser = Parser()
    val calculator = PlusCalculator()

    fun run() {
        val parsedSeparator = parser.parseSeparator(user.enterString())
        val parsedNumbers = parser.parseNumber(parsedSeparator)
        println(Message.RESULT + calculator.execute(parsedNumbers))

    }
    run()
}
