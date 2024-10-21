package calculator.view

import camp.nextstep.edu.missionutils.Console

class CalculatorView {
    fun getInput(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        return Console.readLine()
    }

    fun showResult(result: Int){
        println("결과 : $result")
    }
}