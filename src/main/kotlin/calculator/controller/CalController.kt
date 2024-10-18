package calculator.controller

import calculator.model.Calculator
import calculator.model.ErrorCheck
import calculator.view.ErrorMsg
import calculator.view.MsgView

class CalController {
    private var result = 0
    private val calculator = Calculator()
    private val errorMsg = ErrorMsg()
    private val msgView = MsgView()

    fun run() {
        msgView.inputMsg()
        val inputValue = readLine()!!
        val isCheck = ErrorCheck().dividerCheck(inputValue)

        when (isCheck) {
            -1 -> errorMsg.errorMsg()
            0 -> result = calculator.defaultCal(inputValue)
            1 -> result = calculator.customCal(inputValue)
        }
        if (result == -1) errorMsg.errorMsg()
        msgView.outputMsg(result)
    }
}
