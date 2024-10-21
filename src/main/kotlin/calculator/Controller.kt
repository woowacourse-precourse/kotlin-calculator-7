package calculator

class Controller(private val view: View) {
    private fun parseInput(input: String): Data {
        val delimiters = mutableListOf(",", ":")
        val customDelimiterPattern = Regex("//(.)\\n*")
        val matchResult = customDelimiterPattern.find(input)
        val customDelimiter = matchResult?.groupValues?.get(1) // 구분자만 추출
        if (customDelimiter != null) {
            delimiters.add(customDelimiter) // 구분자 리스트에 추가
        }

        println("정규식: $customDelimiterPattern")
        println("추출된 구분자: $customDelimiter")
        println("구분자 리스트: $delimiters")
        val numbers = listOf(-1)

        return Data(numbers, delimiters)
    }

    fun add(data: Data): Int {
        return data.numbers.sum()
    }

    fun run() {
        try {
            var input = view.getInput()
            println("$input 입력받았습니다.")
            val data = parseInput(input)
        } catch (e: IllegalArgumentException) {
            view.showError(e)
        }
    }
}