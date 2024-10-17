package calculator

class Validator {
    private lateinit var checkString: String

    fun validateString(inputString: String): String {
        checkString = inputString

        val checkString =
            validatePrecedingString(checkString)
                .validateRemainingString()
        return checkString
    }

    // 첫 문자가 '/' 이라면 앞선 5문자의 유효성을 검증하고, 앞선 5문자를 제외한 남은 부분을 리턴한다.
    // 첫 문자가 '/' 이 아니라면 그냥 입력을 그대로 리턴한다.
    private fun validatePrecedingString(checkString: String): String {
        if (checkString[0] == '/') {
            val slashIndex = checkString.substring(0, 2) == "//"
            val enterIndex = checkString.substring(3, 5) == "\\n"
            val customDelimiter = checkString[2]
            // 유효하지 않다면 예외 발생
            if (!slashIndex || !enterIndex || customDelimiter.isDigit()) {
                throw IllegalArgumentException()
            }
            return checkString.substring(5, checkString.length)
        } else {
            return checkString
        }
    }

    private fun String.validateRemainingString(): String {
        val delimiter = getDelimiter(checkString)
        val delimiterList = delimiter.substring(1, delimiter.length - 1).split("")

        var beforeChar = this[0]
        for (char in this) {
            // 1. 유효하지 않은 문자
            if (char.isNotValid(delimiterList)) {
                throw IllegalArgumentException()
            }
            // 2. 첫 문자가 구분자인 경우
            // 3. 구분자가 연속으로 나오는 경우
            if (beforeChar.isDelimiter(delimiterList) and char.isDelimiter(delimiterList)) {
                throw IllegalArgumentException()
            }
            beforeChar = char
        }
        // 4. 마지막 문자가 구분자인 경우
        if (beforeChar.isDelimiter(delimiterList)) throw IllegalArgumentException()

        return this
    }

    // 커스텀 구분자가 있다면 그 구분자를 반환한다
    fun getDelimiter(inputString: String): String =
        if (inputString[0] == '/') {
            val customDelimiter = inputString[2]
            "[,:$customDelimiter]"
        } else {
            "[,:]"
        }

    private fun Char.isNotValid(delimiterList: List<String>): Boolean {
        val isValidDigit = this.isDigit()
        val isValidDelimiter = this.isDelimiter(delimiterList)

        return !(isValidDigit or isValidDelimiter)
    }

    private fun Char.isDelimiter(delimiterList: List<String>): Boolean = this.toString() in delimiterList
}
