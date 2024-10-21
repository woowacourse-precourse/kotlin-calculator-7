package calculator

import camp.nextstep.edu.missionutils.Console

class InputConsole : Input {
    override fun read(): String {
        return Console.readLine()
    }
}

interface Input {
    fun read(): String
}