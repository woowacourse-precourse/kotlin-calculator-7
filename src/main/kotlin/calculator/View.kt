package calculator

class View() {
    init {
        println("문자열 덧셈 계산기입니다.")
    }

    fun getInput() {

    }

    fun showResult() {

    }

    fun showError(e: Exception) {
        println("에러가 발생했습니다: ${e.message}")
    }
}