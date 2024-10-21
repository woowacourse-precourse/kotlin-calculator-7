package calculator

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    try {
        // 첫 번째 줄을 입력 받는다
        val firstLine = readLine()

        // 커스텀 문자열이 있는 경우 해당 문자열을 추가하고, 두 번째 줄을 입력 받는다
        // 커스텀 문자열이 있는 경우에는 두 번째 줄이, 아닌 경우에는 첫 번째 줄이 수들의 합 계산에 사용된다
        val input: String
        val customDelimiter = InputProcessor.getCustomDelimiterIfExist(firstLine)
        if (customDelimiter == null) {
            input = firstLine

            // 첫째 줄이 숫자로 시작하지 않는데 커스텀 문자열이 추출되지 않을 경우 예외 처리
            if (firstLine.isNotEmpty() && !firstLine[0].isDigit()) {
                throw IllegalArgumentException()
            }
        } else {
            StringSplitter.addDelimiter(customDelimiter)
            val secondLine = readLine()
            input = secondLine
        }

        // 수들의 합을 계산하여 출력한다
        val numbers = StringSplitter.split(input)

        // 수들 중 하나라도 음수일 경우 예외 처리
        if (numbers.map { it.toLong() }.any { it < 0L }) {
            throw IllegalArgumentException()
        }

        val sumOfNumbers = NumberCalculator.getSumOfNumbers(numbers)
        println("결과 : $sumOfNumbers")
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }
}
