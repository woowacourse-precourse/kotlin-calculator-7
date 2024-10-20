package calculator.view

class InputView {

    fun printInputValueMessage() = println(INPUT_VALUE_MESSAGE)

    companion object {
        private const val INPUT_VALUE_MESSAGE = "덧셈할 문자열을 입력해 주세요."
    }
}
