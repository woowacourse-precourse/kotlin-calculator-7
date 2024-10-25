package calculator

import calculator.view.CommandLineView
import calculator.view.View

fun main() {
    CalculatorApp.run()
}

object CalculatorApp {
    private val view: View = CommandLineView

    fun run() {
        view.show("덧셈할 문자열을 입력해 주세요.\n")
        view.sum()
    }
}