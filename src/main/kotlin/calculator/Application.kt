package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    val calculator = Calculator()
    calculator.start()
}

class Calculator {
    private val parser = Parser()

    fun start() {
        println("계산할 문자열을 입력하시오... (ex: 1,2,3 또는 //;\n1;2;3): ")
        val input = Console.readLine()
        val numbers = parser.parse(input)
        val result = numbers.sum()
        println("결과 값: $result")
    }
}

class Parser {
    private val delimiters = mutableListOf(",", ":")

    fun parse(input: String?): List<Int> {
        val nonNullInput = input ?: return emptyListWithMessage()

        if (hasCustomDelimiter(nonNullInput)) {
            val parsedNumbers = addCustomDelimiter(nonNullInput)
            if (parsedNumbers != null) {
                return parsedNumbers
            }

            println("숫자를 입력하세요:")
            val numbersInput = Console.readLine()
            return parseNumbers(numbersInput)
        }

        return parseNumbers(nonNullInput)
    }

    private fun emptyListWithMessage(): List<Int> {
        println("결과 값: []")
        return emptyList()
    }

    private fun hasCustomDelimiter(input: String): Boolean {
        return input.startsWith("//")
    }

    private fun addCustomDelimiter(input: String): List<Int>? {
        // "\n" 또는 실제 개행 문자를 기준으로 구분자와 숫자 부분을 분리
        val processedInput = input.replace("\\n", "\n")
        val splitIndex = processedInput.indexOf('\n')
        if (splitIndex == -1) {
            val delimiterSection = processedInput.substring(2)
            println("구분자 섹션 추출: $delimiterSection")
            delimiters.add(delimiterSection)
            return null // 숫자가 없으므로 이후 입력을 받도록 함
        } else {
            val delimiterSection = processedInput.substring(2, splitIndex)
            println("구분자 섹션 추출: $delimiterSection")
            delimiters.add(delimiterSection)

            // 숫자 부분 추출 및 파싱
            val numbersInput = processedInput.substring(splitIndex + 1)
            println("숫자 섹션 추출: $numbersInput")
            return parseNumbers(numbersInput)
        }
    }

    private fun parseNumbers(input: String): List<Int> {
        return try {
            input.split(*delimiters.toTypedArray())
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
        } catch (e: NumberFormatException) {
            println("입력 형식이 잘못되었습니다. 숫자만 입력해주세요.")
            emptyList()
        }
    }
}

