package calculator

class Calculator(private val userInterface: UserInterface = CommandLineInterface) {
    fun sum() {
        userInterface.show("덧셈할 문자열을 입력해 주세요.\n")
        val userInput = userInterface.readUserInput()
        val numbers = Parser.parseToIntList(userInput)
        val result = numbers.sum()
        if (result % 1.0 == 0.0) userInterface.show("결과 : ${result.toInt()}") else userInterface.show("결과 : $result")
    }
}