package calculator.util

import camp.nextstep.edu.missionutils.Console

object UserUtil {
    fun getUserInput(): String? {
        return Console.readLine()
    }
}