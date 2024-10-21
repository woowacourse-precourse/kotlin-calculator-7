package calculator

object StringSplitter {

    /**
     * 주어진 구분자를 기준으로 문자열 분할
     */
    fun split(input: String, delimiters: List<String>): List<String> {
        val regexPattern = delimiters.joinToString("|") { Regex.escape(it) }
        val regex = Regex(regexPattern)
        return regex.split(input)
    }

}