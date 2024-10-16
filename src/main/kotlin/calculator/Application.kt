package calculator

fun main() {
    val user = User()
    val parser = Parser()
    //user.run()
    val userInput = user.enterString()
    val parseString = parser.parseSeparator(userInput)
    println(parser.parseCustomSeparator(userInput))
}
