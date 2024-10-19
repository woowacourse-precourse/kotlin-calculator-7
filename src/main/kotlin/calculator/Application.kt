package calculator

fun main() {
    val user = User()
    val parser = Parser()
    val calculator = PlusCalculator()
    println("덧셈할 문자열을 입력해주세요.")
    fun run() {
        val parsedSeparator = parser.parseSeparator(user.enterString())
        val parsedNumbers = parser.parseNumber(parsedSeparator)
        println("결과 : ${calculator.execute(parsedNumbers)}")

    }
    run()
}
