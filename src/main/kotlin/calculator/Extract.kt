package calculator

class Extract {
    private val customPattern = Regex("""^//(.)\\n(.*)""")

    fun extractDelimiter(inputString: String): List<String> {
        val delimiters = mutableListOf(",", ":")
        val pattern = customPattern.matchEntire(inputString)
        if (pattern != null) {
            delimiters.add(pattern.groupValues[1])
        }
        return delimiters
    }

    fun extractString(inputString: String): String {
        val pattern = customPattern.matchEntire(inputString)
        return if (pattern != null) pattern.groupValues[2] else inputString
    }

    fun extractNumbers(inputString: String): List<Int> {
        val numbers = Regex("\\d+")
        val inputFiltered = extractString(inputString)
        val userNumbers = numbers.findAll(inputFiltered).map{ it.value.toInt() }.toList()
        return userNumbers
    }
}