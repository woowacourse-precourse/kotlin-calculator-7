package calculator

import camp.nextstep.edu.missionutils.Console.readLine

object CommandLineInterface : UserInterface<String> {
    override fun readUserInput(): String = readLine()

    override fun show(content: String) {
        print(content)
    }
}