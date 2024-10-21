package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val calculator = Calculator()
    calculator.play()
}

class Calculator {
    companion object {
        private const val INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요."
        private const val ERROR_MESSAGE = "IllegalArgumentException : 프로그램을 종료합니다."
    }

    fun play() {
        try {
            val input = getInput()
            val numbers = getNumbers(input)
            printSum(numbers)
        } catch (e: Exception) {
            println(ERROR_MESSAGE)
            throw IllegalArgumentException()
        }
    }

    /**
     * 콘솔 입력값을 저장하는 기능을 하는 함수
     * @return 콘솔 입력값
     */
    private fun getInput(): String {
        println(INPUT_MESSAGE)
        val input = Console.readLine()
        return input
    }

    /**
     * 문자열에서 숫자를 List로 추출하는 함수
     * @return 분리한 숫자들이 저장되어있는 List
     */
    private fun getNumbers(input: String): List<Int> {
        // 커스텀 구분자가 있는지 확인
        val isValidCustom = isCustomDelimiter(input)
        val delimiter = arrayOf(
            // 커스텀 구분자
            if(isValidCustom) getCustomDelimiter(input)
            // 기본 구분자
            else ",", ":"
        )
        val validInput = if(isValidCustom) input.removeCustomDelimiter() else input

        val numbers = validInput.split(*delimiter).map {
            it.toValidNum()
        }
        return numbers
    }

    /**
     * 문자열에서 커스텀 구분자를 확인하고 그 결과를 Boolean으로 반환하는 함수
     * 커스텀 구분자의 조건 : "//"으로 시작해서 "\n"으로 끝난다
     * @return 커스텀 구분자를 가지고 있는지 여부
     */
    private fun isCustomDelimiter(input: String): Boolean {
        val isStartCustom = input.startsWith("//")
        val isEndCustom = input.contains("""\n""")
        return isStartCustom && isEndCustom
    }

    /**
     * 문자열에서 커스텀 구분자를 추출하는 함수
     * 커스텀 구분자의 조건 : "//"으로 시작해서 "\n"으로 끝난다
     * @return 추출한 커스텀 구분자
     */
    private fun getCustomDelimiter(input: String): String {
        val delimiterEndIndex = input.indexOf("""\n""")
        val customDelimiter = input.substring(2, delimiterEndIndex)
        return customDelimiter
    }

    /**
     * 문자열에서 커스텀 구분자 영역을 제거하는 확장함수
     * @return 커스텀 구분자 영역을 제거한 문자열
     */
    private fun String.removeCustomDelimiter(): String {
        val delimiterEndIndex = indexOf("""\n""")
        val removeDelimiterStr = substring(delimiterEndIndex + 2)
        return removeDelimiterStr
    }

    /**
     * 숫자 리스트의 값들을 더한 결과값을 출력한다.
     */
    private fun printSum(numbers: List<Int>) {
        val sum = numbers.sum()
        println("결과 : $sum")
    }

    /**
     * 문자열을 유효한 정수로 변환한다.
     * 정수가 유효할 조건 : 양수
     * 유효하지 않을 경우 IllegalArgumentException()를 throw 한다.
     * @return 변환된 숫자
     */
    private fun String.toValidNum(): Int {
        val convertInt = toInt()
        if(convertInt < 0) throw IllegalArgumentException()
        return convertInt
    }
}