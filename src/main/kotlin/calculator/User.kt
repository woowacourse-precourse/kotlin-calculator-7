package calculator

private const val ERROR_MESSAGE = "잘못된 입력입니다."

class User {
    private val customPattern = Regex("^(//(.)\\\\n)(.*)")

    fun getNumbers(): List<Int> {
        val inputString = UserView.getStringInput()
        val delimiters = customDelimiter(inputString)
        if (inputException(inputString, delimiters)) {
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
        return extractedNumbers(inputString)
    }

    private fun inputException(inputString: String, delimiter: List<String>): Boolean {
        if (delimiter.size == 2) {
            val pattern = Regex("[^\\d,:]")
            val matchResult = pattern.find(inputString)
            if (matchResult != null) {
                return true
            }
        }
        if (delimiter.size == 3) {
            val pattern = Regex("[^\\d,:$delimiter[2]]")
            val matchResult = customPattern.find(inputString)
            val inputFiltered = matchResult?.groups?.get(3)?.value ?: inputString
            val matchFilteredResult = pattern.find(inputFiltered)
            if (matchFilteredResult != null) {
                return true
            }
        }
        return false
    }

    private fun customDelimiter(inputString: String): List<String> {
        val delimiters = mutableListOf(",", ":")
        val isCustom = customPattern.matches(inputString)
        if (isCustom) {
            delimiters.add(inputString[2].toString())
        }
        return delimiters
    }

    private fun extractedNumbers(inputString: String): List<Int> {
        val numbers = Regex("\\d+")
        val matchResult = customPattern.find(inputString)
        val inputFiltered = matchResult?.groups?.get(3)?.value ?: inputString
        if (inputString == "") {
            return emptyList()
        }
        val userNumbers = numbers.findAll(inputFiltered).map{ it.value.toInt() }.toList()
        return userNumbers
    }
}