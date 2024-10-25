package calculator.view

import camp.nextstep.edu.missionutils.Console.readLine

object CommandLineView : View {
    private val viewModel = ViewModel()

    override fun read(): String = readLine()
    override fun show(content: String) = print(content)
    override fun sum() {
        viewModel.userInput = read()
        show(viewModel.sumOutput)
    }
}