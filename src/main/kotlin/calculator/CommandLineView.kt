package calculator

import camp.nextstep.edu.missionutils.Console.readLine

object CommandLineView : View {
    override fun readUserInput(): String = readLine()

    override fun show(content: String) = print(content)
}