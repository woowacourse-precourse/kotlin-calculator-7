package calculator

import calculator.calculator.Calculator
import calculator.delimiter.CustomDelimiter
import calculator.separation.Separation
import calculator.util.MessageUtil
import calculator.util.UserUtil
import calculator.validation.InputValidation

fun main() {
    // TODO: 프로그램 구현
    MessageUtil.printInputMessage()
    val userInput: String? = UserUtil.getUserInput()

    val userInputWithoutCustomDelimiter = CustomDelimiter.extractCustomDelimiter(userInput)

    val listOfUserInput: List<String>? = Separation().splitInput(userInputWithoutCustomDelimiter)

    val doneValidation: List<String> = InputValidation().validateInput(listOfUserInput)

    val sum = Calculator().calculateInput(doneValidation)

    MessageUtil.printOutputMessage(sum)
}
