package calculator

object Parser {
    private val defaultDelimiters: List<String> = listOf(",", ":")
    private var delimiters: List<String> = defaultDelimiters

    private fun addDelimiters(vararg delimiters: String) {
        this.delimiters = this.delimiters.plus(delimiters)
    }

    private fun extractCustomDelimitersIfExist(value: String): String {
        if (!value.startsWith("//")) return value
        val customSeparator = value.substringAfter("//").substringBefore("\\n")
        if (customSeparator == ".") throw IllegalArgumentException()
        addDelimiters(customSeparator)
        return value.substringAfter("\\n")
    }

    fun parseToNumberList(value: String): List<Double> {
        val valueAfterExtractCustomDelimiters = extractCustomDelimitersIfExist(value)
        val splitList = valueAfterExtractCustomDelimiters.split(*delimiters.toTypedArray())
        val numberList = runCatching { splitList.map { element -> element.toDouble() } }.getOrElse {
            throw IllegalArgumentException()
        }
        if (!numberList.areAllPositive) {
            throw IllegalArgumentException()
        }
        return numberList
    }
}