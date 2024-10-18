package calculator

import calculator.delimiter.CustomDelimiter
import calculator.separation.Separation
import calculator.util.MessageUtil
import calculator.util.UserUtil
import calculator.validation.InputValidation

fun main() {
    // TODO: 프로그램 구현
    MessageUtil.printInputMessage()
    val input: String? = UserUtil.getUserInput()
    val customDelimiter = CustomDelimiter()
    val inputWithoutCustomDelimiter = customDelimiter.extractCustomDelimiter(input)
    val listOfInput: List<String>? = Separation().splitInput(inputWithoutCustomDelimiter, customDelimiter)
    val doneValidation: List<String> = InputValidation().validateInput(listOfInput)
}
