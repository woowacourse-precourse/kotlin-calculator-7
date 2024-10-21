package calculator

class Controller(private val view: View) {
    private fun parseInput(input: String): Data {
        val delimiters = mutableListOf(",", ":")

        val customDelimiterPattern = Regex("//(.)\\n")
        val matchResult = customDelimiterPattern.find(input)
        val customDelimiter = matchResult?.groupValues?.get(1) // 구분자만 추출
        delimiters.add(customDelimiter.toString())

        val numbers = listOf(-1)

        return Data(numbers, delimiters)
    }

    fun add(data: Data): Int {
        return data.numbers.sum()
    }

    fun run() {
        try {
            var input = view.getInput()
            val data = parseInput(input)
        } catch (e: IllegalArgumentException) {
            view.showError(e)
        }
    }
}