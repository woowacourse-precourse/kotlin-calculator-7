package calculator

object Parser {
    private val defaultDelimiters: List<String> = listOf(",", ":")
    private val prohibitedDelimiters: List<String> = listOf(".")
    private var delimiters: List<String> = defaultDelimiters

    private fun addDelimiters(vararg delimiters: String) {
        this.delimiters = this.delimiters.plus(delimiters)
    }

    private fun extractDelimiter(value: String): String? {
        if (!value.startsWith("//")) return null
        val delimiter = value.substringAfter("//").substringBefore("\\n")
        if (delimiter in prohibitedDelimiters) throw IllegalArgumentException()
        return delimiter
    }

    private fun extractNumbers(value: String): List<Double> {
        val numbersString = if (value.startsWith("//")) value.substringAfter("\\n") else value
        val numbers: List<Double> = runCatching {
            numbersString.split(*delimiters.toTypedArray()).map { element -> element.toDouble() }
        }.getOrElse {
            throw IllegalArgumentException()
        }
        return numbers
    }

    fun parseToNumbers(input: String): List<Double> {
        extractDelimiter(input)?.let { delimiter -> addDelimiters(delimiter) }
        val numbers: List<Double> = extractNumbers(input)
        if (!Validator.areNumbersValid(numbers)) throw IllegalArgumentException()
        return numbers
    }
}