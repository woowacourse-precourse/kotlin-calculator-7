package calculator

class InputView {
    fun getInput(): String? {
        println("덧셈할 문자열을 입력해 주세요.")
        return camp.nextstep.edu.missionutils.Console.readLine()
    }
    // 리턴시 null 값 처리하기
}