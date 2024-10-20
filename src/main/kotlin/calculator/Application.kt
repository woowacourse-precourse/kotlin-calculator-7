package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현

    val parser = Parser()

    println("계산할 문자열을 입력하시오... (ex: 1,2,3 또는 //;\n1;2;3): ")
    val input = Console.readLine()
    val result = parser.parse(input)
    println(result)
}

class Parser {
    private val delimiters = mutableListOf(",", ":", "\n")

    fun parse(input: String?): List<Int> {
        val nonNullInput = input ?: return emptyListWithMessage()

        if (hasCustomDelimiter(nonNullInput)) {
            addCustomDelimiter(nonNullInput)
            return parseNumbersWithCustomDelimiter()
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

    private fun addCustomDelimiter(input: String) {
        if (input.length > 2) {
            val customDelimiter = input.substring(2).trim().take(1)
            delimiters.add(customDelimiter)
            println("구분자가 추가되었습니다: $customDelimiter")
        } else {
            println("올바른 구분자를 입력해 주세요.")
        }
    }

    private fun parseNumbersWithCustomDelimiter(): List<Int> {
        println("숫자를 입력하시오 (구분자: ${delimiters.joinToString()}): ")
        val numbersInput = generateSequence { Console.readLine() }
            .takeWhile { it.isNotBlank() }
            .joinToString("\n")
        return if (numbersInput.isEmpty()) {
            emptyListWithMessage()
        } else {
            parseNumbers(numbersInput)
        }
    }

    private fun parseNumbers(input: String): List<Int> {
        return input.split(*delimiters.toTypedArray())
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    }
}



