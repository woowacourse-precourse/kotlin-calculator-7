package calculator

class Controller(private val view: View) {
    private fun parseInput(input: String): Data {
        val delimiters = mutableListOf(",", ":")
        val customDelimiterPattern = Regex("//(.)\\n*")
        val matchResult = customDelimiterPattern.find(input)
        var contentToSplit = input

        if(matchResult != null){
            val customDelimiter = matchResult?.groupValues?.get(1)
            if (customDelimiter != null) {
                delimiters.add(customDelimiter)
            }
            contentToSplit = input.substring(matchResult.range.last+3)
        }

        val delimiterPattern = delimiters.joinToString("|")
        val regex = Regex(delimiterPattern)
        val foundNumByDelimiter = contentToSplit.split(regex).toList()
        val numbers = foundNumByDelimiter.map { it.toInt() }
        println("구분자 리스트: $delimiters")
        println("숫자 리스트: $numbers")
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