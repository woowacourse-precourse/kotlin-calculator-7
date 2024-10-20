package Controller

import View.InputView
import View.OutputView

class Controller {
    fun runCalculator() {
        OutputView().enterPrompt()
        val input = InputView().getInput()
    }
}