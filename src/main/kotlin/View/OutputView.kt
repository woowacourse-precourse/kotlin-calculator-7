package View

const val ENTER_ADD_STRING = "덧셈할 문자열을 입력해 주세요."
const val RESULT_STRING = "결과 : "
const val EXIT_STRING = "프로그램을 종료합니다."

class OutputView {
    fun enterPrompt() {
        println(ENTER_ADD_STRING)
    }

    fun resultPrompt(result: Int) {
        println(RESULT_STRING + result)
    }

    fun exitPrompt() {
        println(EXIT_STRING)
    }
}