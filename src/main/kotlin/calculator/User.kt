package calculator

private const val ERROR_MESSAGE = "잘못된 입력입니다."

class User {
    private val customPattern = Regex("^(//(.+?)\\n)(.+)")

    fun getNumbers(): List<Int> {
        val inputString = UserView.getStringInput()
        val initDelimiter = parserDelimiter(inputString)
        if (inputException(inputString, initDelimiter)) {
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
        return extractedNumbers(inputString)
    }

    private fun inputException(inputString: String, initDelimiter: List<String>): Boolean {
        val matchResult = customPattern.find(inputString)
        val inputFiltered = matchResult?.groups?.get(3)?.value ?: inputString
        val isPattern = Regex("") // 조건에 맞는 패턴 정의
        return !isPattern.matches(inputFiltered) // 조건에 맞는 패턴이 아니면 true를 반환
    }

    private fun parserDelimiter(inputString: String): List<String> {
        val initDelimiter = mutableListOf(",", ":")
        val isCustom = customPattern.matches(inputString)
        if (isCustom) {
            initDelimiter.add(inputString[2].toString())
        }
        return initDelimiter
    }

    private fun extractedNumbers(inputString: String): List<Int> {
        val numbers = Regex("\\d+")
        val matchResult = customPattern.find(inputString)
        val inputFiltered = matchResult?.groups?.get(3)?.value ?: inputString
        val userNumbers = numbers.findAll(inputFiltered).map{ it.value.toInt() }.toList()
        return userNumbers
    }
}