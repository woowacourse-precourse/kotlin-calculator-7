package Model

class Delimiter(private val input: String) {
    private var specified = 0
    fun numberSplit(): List<Int> {
        val delimiter = getDelimiter()
        val numbers = input.substring(specified).split(*delimiter).map { it.toInt() }

        return numbers
    }

    private fun getDelimiter(): Array<String> {
        val delimiters = mutableListOf(",", ":")
        println(input)

        val regex = Regex("^//.\\\\n")
        val specifiedString = regex.find(input)
        if (specifiedString != null) {
            val specifiedDelimiter = specifiedString.value[2]
            delimiters.add(specifiedDelimiter.toString())
            specified = 5
        }

        return delimiters.toTypedArray()
    }
}