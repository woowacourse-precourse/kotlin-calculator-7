package calculator

import calculator.constants.Message

class Simulator {
    val user = User()
    val parser = Parser()
    val calculator = PlusCalculator()

    /**
     * 전체적인 실행을 진행
     */
    fun run() {
        val parsedSeparator = parser.parseSeparator(user.enterString())
        val parsedNumbers = parser.parseNumber(parsedSeparator)
        println(Message.RESULT + calculator.execute(parsedNumbers))
    }
}