package calculator

val customDelimiterRegex = Regex("^//[^0-9]\\\\n.*")
val basicDelimiterRegex = Regex("([1-9]\\d*[,:])*[1-9]\\d*")

class DelimiterParser(private val input: String) {
    fun getOperands(): List<String> {
        if (customDelimiterRegex.matches(input)) {
            val customDelimiter = input[2].toString()
            val inputSubstring = input.substring(5)
            return inputSubstring.split(",", ":", customDelimiter)
        }
        if (input.isEmpty()) {
            return listOf("0")
        }
        if (basicDelimiterRegex.matches(input)) {
            return input.split(",", ":")
        }
        throw IllegalArgumentException()
    }
}