package calculator

class MyParser {
    fun parse(input: String) {
        val tokens = tokenize(input)
        val delimiters = getDelimiters(tokens[2])
    }

    private fun tokenize(input: String): List<String> =
        delimiterInputRegex
            .find(input)
            ?.groupValues
            ?: throw IllegalArgumentException()

    private fun String.toPositiveInt(): Int =
        runCatching {
            val i = toInt()
            if (i > 0) i
            else throw IllegalArgumentException()
        }.getOrElse {
            throw IllegalArgumentException()
        }

    private fun getDelimiters(extraDelimiter: String): List<String> =
        if (extraDelimiter.isNotEmpty()) defaultDelimiters + extraDelimiter
        else defaultDelimiters

    companion object {
        private val defaultDelimiters = listOf(",", ":")
        private val delimiterInputRegex = "(//(.+)\\\\n)?(.*)".toRegex()
    }
}
