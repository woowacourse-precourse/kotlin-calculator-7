package calculator

class Validator {
    fun validateString(inputString: String): String {
        // TODO: 문자열의 유효성 검증

        var checkString = inputString

        var delimiter = ",|:"
        if (checkString[0] == '/') {
            // 첫 문자가 '/' 인 경우 앞의 5부분 문자열 검증
            val customDelimiter = validateCustomDelimiter(checkString)
            delimiter = "$delimiter|$customDelimiter"
            checkString = checkString.substring(5, checkString.length)
        }

        val delimiterList = delimiter.split("|")
        var beforeChar = checkString[0]

        for (char in checkString) {
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

        return checkString
    }

    // 앞 5문자의 유효성을 검증하는 기능
    fun validateCustomDelimiter(inputString: String): String {
        val slashIndex = inputString.substring(0, 2) == "//"
        val enterIndex = inputString.substring(3, 5) == "\\n"
        val customDelimiter = inputString[2]

        if (slashIndex and enterIndex and !customDelimiter.isDigit()) {
            return customDelimiter.toString()
        } else {
            // 첫 두 문자가 "//" 가 아니고,
            // 3번째 문자가 숫자가 아니고,
            // 4,5 번째 문자가 각각 '\' , 'n' 이 아니면,
            // IllegalArgumentException() 발생
            throw IllegalArgumentException()
        }
    }

    private fun Char.isNotValid(delimiterList: List<String>): Boolean {
        val isValidDigit = this.isDigit()
        val isValidDelimiter = this.isDelimiter(delimiterList)

        return !(isValidDigit or isValidDelimiter)
    }

    private fun Char.isDelimiter(delimiterList: List<String>): Boolean = this.toString() in delimiterList
}
