package calculator

private const val ERROR_MESSAGE = "잘못된 입력입니다."

class User {
    private val extract = Extract()

    fun getNumbers(): List<Int> {
        val inputString = UserView.getInput()
        if (inputException(inputString)) {
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
        return extract.extractNumbers(inputString)
    }

    private fun inputException(inputString: String): Boolean {
        val delimiters = extract.extractDelimiter(inputString)
        val inputFiltered = extract.extractString(inputString)
        val pattern = Regex("[^\\d$delimiters]")
        val invalidChar = pattern.find(inputFiltered)
        return invalidChar != null
    }
}
