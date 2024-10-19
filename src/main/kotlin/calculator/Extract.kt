package calculator

class Extract {
    private val customPattern = Regex("""^(//(.)\\n)(.*)""")

    fun extractDelimiter(inputString: String): List<String> {
        val delimiters = mutableListOf(",", ":")
        val isCustom = customPattern.matches(inputString)
        if (isCustom) {
            delimiters.add(inputString[2].toString())
        }
        return delimiters
    }

    fun extractString(inputString: String): String {
        val pattern = customPattern.find(inputString)
        val inputFiltered = pattern?.groups?.get(3)?.value ?: inputString
        return inputFiltered
    }

    fun extractNumbers(inputString: String): List<Int> {
        val numbers = Regex("\\d+")
        val inputFiltered = extractString(inputString)
        val userNumbers = numbers.findAll(inputFiltered).map{ it.value.toInt() }.toList()
        return userNumbers
    }
}