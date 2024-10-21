package calculator

object StringSplitter {

    private val delimiters: MutableList<Char> = mutableListOf(',', ':')

    fun addDelimiter(delimiter: Char) {
        delimiters.add(delimiter)
    }

    fun split(input: String): List<String> {
        val regexBuilder = StringBuilder()
            .append('[')
        delimiters.forEach { delimiter ->
            regexBuilder.append(delimiter)
        }
        regexBuilder.append(']')

        val regex = regexBuilder.toString()

        return input.split(regex)
    }
}