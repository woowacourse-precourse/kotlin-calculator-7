package calculator

import camp.nextstep.edu.missionutils.Console

class View(private val controller: Controller) {
    fun start() {
        while (true) {
            printGuide()
            execute()
        }
    }

    fun printGuide() {
        println("덧셈할 문자열을 입력해 주세요.")
    }

    fun execute() {
        val input = Console.readLine()
        val output = controller.calculate(input)
        printResult(output)
    }

    fun printResult(result: Int) {
        println("결과 : ${result}")
    }
}