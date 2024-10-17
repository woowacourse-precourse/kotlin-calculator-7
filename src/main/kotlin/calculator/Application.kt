package calculator

import calculator.delimiter.CustomDelimiter
import calculator.util.MessageUtil
import calculator.util.UserUtil

fun main() {
    // TODO: 프로그램 구현
    MessageUtil.printInputMessage()
    val input: String? = UserUtil.getUserInput()
    val customDelimiter = CustomDelimiter()
    val inputWithoutCustomDelimiter = customDelimiter.extractCustomDelimiter(input)
}
