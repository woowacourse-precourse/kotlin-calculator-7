package calculator

import calculator.controller.AddController
import calculator.controller.ProcessController
import calculator.model.Repository
import calculator.view.InOutView

fun main() {
    val repo = Repository()
    val process = ProcessController(repo)
    val add = AddController(repo)
    val inout = InOutView()

    inout.input(repo)
    process.processInput()
    add.addNum()
    inout.printResult(repo)
}
