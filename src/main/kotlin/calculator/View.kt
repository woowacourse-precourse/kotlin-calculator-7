package calculator

class View() {

    fun getInput(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        return readlnOrNull() ?: ""
    }

    fun showResult(result: Int) {
        println("결과 : $result")
    }

    fun showError(e: Exception) {
        println("에러가 발생했습니다: ${e.message}")
    }
}