package Model

class Exception {
    fun isInputValid(input: String, delimiter: Array<String>) {
        val regex = "[^${delimiter.joinToString("") { "\\$it" }}0-9]+".toRegex()

        if (regex.containsMatchIn(input))
            throw IllegalArgumentException("입력값에 구분자가 아닌 문자가 있거나 형식이 잘못되었습니다.")
    }

    fun isDelimiterValid(specifiedDelimiter: String) {
        if (specifiedDelimiter[0].isDigit())
            throw IllegalArgumentException("커스텀 구분자는 문자로만 가능합니다.")
    }
}