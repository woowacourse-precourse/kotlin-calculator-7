package calculator

class Controller(private val view: View) {
    private fun parseInput(input: String): Data {
        val delimiters = mutableListOf(",", ":")
        val customDelimiterPattern = Regex("//(.)\\n*")
        val matchResult = customDelimiterPattern.find(input)
        var contentToSplit = input

        if (matchResult != null) {
            val customDelimiter = matchResult.groupValues[1]
            delimiters.add(customDelimiter)
            contentToSplit = input.substring(0, matchResult.range.first) + input.substring(matchResult.range.last + 3)
        }

        val delimiterPattern = delimiters.joinToString("|")
        val regex = Regex(delimiterPattern)
        val foundNumByDelimiter = contentToSplit.split(regex).toList()

        runExceptionForString(foundNumByDelimiter)
        val numbers = foundNumByDelimiter.map { it.toInt() }
        runExceptionForInt(numbers)

        return Data(numbers, delimiters)
    }

    private fun add(data: Data): Int {
        return data.numbers.sum()
    }

    private fun runExceptionForInt(numbers: List<Int>) {
        numbers.forEach { num ->
            if (num < 0) {
                throw IllegalArgumentException("음수는 허용되지 않습니다: $num")
            }
        }
    }

    private fun runExceptionForString(numbers: List<String>) {
        numbers.map {
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
    }

    fun run() {
        val input = view.getInput()
        val data = parseInput(input)
        val result = add(data)
        view.showResult(result)
    }
}