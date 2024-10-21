package calculator


import camp.nextstep.edu.missionutils.Console


fun main() {

    println("덧셈할 문자열을 입력해 주세요.")

    val userInput = Console.readLine()
    val customDelimiterChecker = CustomDelimiterChecker()
    val customDelimiterInputValidator = CustomDelimiterInputValidator()
    val delimitersInputValidator = DelimitersInputValidator()
    val additionCalculator = AdditionCalculator()

    val verifiedUserInput = if (customDelimiterChecker.customDelimiterTest(userInput)) {
        customDelimiterInputValidator.customDelimitersInputErrorCheck(userInput)
    } else {
        delimitersInputValidator.delimitersInputErrorCheck(userInput)
    }

    println("결과 : " + additionCalculator.calculate(verifiedUserInput))
}
