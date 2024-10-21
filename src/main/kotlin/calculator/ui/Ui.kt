package calculator.ui

import camp.nextstep.edu.missionutils.Console

class Ui {
    fun requestUserInput(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        return Console.readLine()
    }

    fun displaySum(sum: Double) {
        println("결과 : ${formatSum(sum)}")
    }

    private fun formatSum(sum: Double): String {
        if (sum.compareTo(sum.toInt()).isEqual()) return sum.toInt().toString()
        return sum.toString()
    }

    private fun Int.isEqual(): Boolean = this == 0
}