package calculator.view

import calculator.model.Repository
import camp.nextstep.edu.missionutils.Console

class InOutView() {
    fun input(repo: Repository) {
        println("덧셈할 문자열을 입력해 주세요.")

        repo.userInput = Console.readLine()
    }

    fun printResult(repo: Repository) {
        println("결과 : ${repo.sum}")
    }
}