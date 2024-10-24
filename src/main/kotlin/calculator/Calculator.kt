package calculator

class Calculator(private val view: View = CommandLineView) {
    fun sum() {
        view.show("덧셈할 문자열을 입력해 주세요.\n")
        val userInput = view.readUserInput()
        val numbers = Parser.parseToNumberList(userInput)
        val result = numbers.sum()
        if (result % 1.0 == 0.0) view.show("결과 : ${result.toInt()}") else view.show("결과 : $result")
    }
}