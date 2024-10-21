package calculator.view

import calculator.constants.Constants.INPUT_MSG
import calculator.constants.Constants.RESULT_MSG

class MsgView {
    fun inputMsg() {
        println(INPUT_MSG)
    }

    fun outputMsg(result: Int) {
        println(RESULT_MSG + result)
    }
}
