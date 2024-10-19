package calculator

private const val ERROR_MESSAGE = "잘못된 입력입니다."

class User {
    private val extract = Extract()

    fun getNumbers(): List<Int> {
        val inputString = UserView.getInput()
        val delimiters = extract.extractDelimiter(inputString)
        if (inputException(inputString, delimiters)) {
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
        return extract.extractNumbers(inputString)
    }

    private fun inputException(inputString: String, delimiters: List<String>): Boolean {
        if (delimiters.size == 2) {
            val pattern = Regex("[^\\d,:]")
            val invalidChar = pattern.find(inputString)
            if (invalidChar != null) {
                return true
            }
        }
        if (delimiters.size == 3) {
            val pattern = Regex("[^\\d,:$delimiters[2]]")
            val inputFiltered = extract.extractString(inputString)
            val invalidChar = pattern.find(inputFiltered)
            if (invalidChar != null) {
                return true
            }
        }
        return false
    }
}