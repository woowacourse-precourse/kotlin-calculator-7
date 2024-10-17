package calculator

private const val ERROR_MESSAGE = "잘못된 입력입니다."

class User {
    fun getStringInput() {
        val inputString = UserView.getStringInput()
        val initDelimiter = customDelimiter(inputString)
        if (inputException(inputString)) {
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
    }

    private fun inputException(inputString: String): Boolean {
        return false
    }

    private fun customDelimiter(inputString: String): List<String> {
        val initDelimiter = mutableListOf<String>(",", ":")
        val customInit = Regex("^(//(.+?)\\n)(.+)")
        val isCustom = customInit.matches(inputString)
        if (isCustom) {
            initDelimiter.add(inputString[2].toString())
        }
        return initDelimiter
    }

    fun extractedNumbers(): List<Int> {
        return userNumbers
    }
}