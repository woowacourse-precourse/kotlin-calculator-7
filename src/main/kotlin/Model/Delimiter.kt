package Model

class Delimiter(private val input: String) {
    private var specified = 0
    fun numberSplit(): List<Int> {
        val delimiter = getDelimiter()

        if (checkInputValidation(input, delimiter)) {
            val numbers = input.substring(specified).split(*delimiter).map { it.toInt() }

            return numbers
        } else {
            return listOf()
        }
    }

    private fun checkInputValidation(input: String, delimiter: Array<String>): Boolean {
        try {
            Exception().isInputValid(input, delimiter)
            return true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return false
        }
    }

    private fun getDelimiter(): Array<String> {
        val delimiters = mutableListOf(",", ":")

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