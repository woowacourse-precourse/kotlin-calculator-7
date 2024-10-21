package Model

class Delimiter(private val input: String) {
    private var specified = 0

    private val exception = Exception()
    private var validator = false

    fun numberSplit(): List<Int> {
        val delimiter = getDelimiter()

        checkInputValidation(input, delimiter)
        if (validator) {
            val numbers = input.substring(specified).split(*delimiter).map { it.toInt() }

            return numbers
        } else {
            return listOf()
        }
    }

    private fun checkInputValidation(input: String, delimiter: Array<String>) {
        try {
            exception.isInputValid(input, delimiter)
            validator = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun getDelimiter(): Array<String> {
        val delimiters = mutableListOf(",", ":")

        val regex = Regex("^//.\\\\n")
        val specifiedString = regex.find(input)

        if (specifiedString != null) {
            val specifiedDelimiter = specifiedString.value[2].toString()

            checkDelimiterValidation(specifiedDelimiter)

            delimiters.add(specifiedDelimiter)
            specified = 5
        }

        return delimiters.toTypedArray()
    }

    private fun checkDelimiterValidation(specifiedDelimiter: String) {
        try {
            exception.isDelimiterValid(specifiedDelimiter)
            validator = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}