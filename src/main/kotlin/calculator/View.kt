package calculator

class View() {
    init {
        println("문자열 덧셈 계산기입니다.")
    }

    fun getInput(): String {
        println("더할 숫자를 구분자로 구분하여 입력해주세요.")
        println("디폴트 구분자 : ',', ':'")
        println("다른 구분자를 사용하려면 \"//*\\n\"과 같이 구분자를 지정하고 사용해주세요.")
        print("입력 : ")
        return readlnOrNull() ?: ""
    }

    fun showResult(result: Int) {
        println("결과 : $result")
    }

    fun showError(e: Exception) {
        println("에러가 발생했습니다: ${e.message}")
    }
}