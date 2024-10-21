package calculator

import org.assertj.core.internal.Numbers
import java.text.NumberFormat

class Controller(private val view: View) {
    private fun parseInput(input: String): Data {
        val delimiters = mutableListOf(",", ":")
        val customDelimiterPattern = Regex("//(.)\\n*")
        val matchResult = customDelimiterPattern.find(input)
        var contentToSplit = input

        if (matchResult != null) {
            val customDelimiter = matchResult.groupValues[1]
            delimiters.add(customDelimiter)
            contentToSplit = input.substring(matchResult.range.last + 3)
        }

        val delimiterPattern = delimiters.joinToString("|")
        val regex = Regex(delimiterPattern)
        val foundNumByDelimiter = contentToSplit.split(regex).toList()


        val numbers = foundNumByDelimiter.map {
            try {
                it.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(
                    "숫자가 아닌 값이 포함되어 있습니다: '$it'\n" +
                            "커스텀 구분자는 //*\\n과 같이 입력\n" +
                            "양의 정수만 입력\n" +
                            "구분자는 정수 사이에 한 번만 입력\n"
                )
            }
        }

        runException(numbers)

        return Data(numbers, delimiters)
    }

    private fun add(data: Data): Int {
        return data.numbers.sum()
    }

    fun runException(numbers: List<Int>) {
        numbers.forEach { num ->
            if(num <0){
                throw IllegalArgumentException("음수는 허용되지 않습니다: $num")
            }
        }
    }

    fun run() {
        val input = view.getInput()
        println("$input 입력받았습니다.")
        val data = parseInput(input)
        val result = add(data)
        view.showResult(result)
    }
}