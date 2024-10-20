package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val calculator = Calculator()
    calculator.start()
}

class Calculator {
    private val parser = Parser()
    fun start() {
        UserInterface.showInputPrompt()
        val input = UserInterface.readInput()
        val numbers = UserInterface.safeRun { parser.parse(input) }
        val result = numbers.sum()
        UserInterface.showResult(result)
    }
}

object UserInterface {
    fun showInputPrompt() {
        println("계산할 문자열을 입력하시오... (ex: 1,2,3 또는 //;\n1;2;3): ")
    }

    fun readInput(): String {
        return Console.readLine()
    }

    fun showResult(result: Int) {
        println("결과 : $result")
    }

    private fun showError(message: String) {
        println("에러: $message")
    }

    fun <T> safeRun(action: () -> T): T {
        return try {
            action()
        } catch (e: IllegalArgumentException) {
            showError("잘못된 입력입니다: ${e.message}")
            throw e
        } catch (e: NumberFormatException) {
            showError("숫자 형식이 잘못되었습니다: ${e.message}")
            throw e
        } catch (e: Exception) {
            showError("알 수 없는 오류가 발생했습니다: ${e.message}")
            throw e
        }
    }
}

class Parser {
    private val delimiters = mutableListOf(",", ":")

    fun parse(input: String?): List<Int> {
        val nonNullInput = input ?: throw IllegalArgumentException("입력이 없습니다.")
        val numbersInput = addCustomDelimiter(nonNullInput)
        return parseNumbers(numbersInput)
    }

    private fun addCustomDelimiter(input: String): String {
        val processedInput = input.replace("\\n", "\n")
        val splitIndex = processedInput.indexOf('\n')

        if (input.startsWith("//") && splitIndex != -1) {
            val delimiterSection = processedInput.substring(2, splitIndex)
            delimiters.add(delimiterSection)
            return processedInput.substring(splitIndex + 1)
        }

        if (input.startsWith("//")) {
            val delimiterSection = processedInput.substring(2)
            delimiters.add(delimiterSection)
            UserInterface.showInputPrompt()
            return UserInterface.readInput()
        }

        return input
    }

    private fun parseNumbers(input: String): List<Int> {
        return input.split(*delimiters.toTypedArray())
            .map { it.toIntOrNull() ?: throw NumberFormatException("숫자가 아닌 값이 포함되어 있습니다.") }
            .onEach { if (it < 0) throw IllegalArgumentException("음수는 입력할 수 없습니다: $it") }
    }
}
