package calculator.view

class OutputView {
    fun showResult(result: Int) {
        println("결과: $result")
    }

    fun showError(message: String) {
        println("오류: $message")
    }
}