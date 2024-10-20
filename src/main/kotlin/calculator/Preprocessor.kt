package calculator

class Preprocessor {
    private val splitter = SplitPreprocessor()
    private val translator = TranslatePreprocessor()
    private val validation = Validation()

    fun preprocessInput(input: InputString): List<Int> {
        val numberListString = splitter.splitStringTemp(input)
        validation.didEnterCorrect(numberListString)
        return translator.translateToInt(numberListString)
    }
}

class SplitPreprocessor {
    fun splitStringTemp(input: InputString): List<String> {
        if (input.input?.take(2) == "//") {
            return splitWithCustomDelimiter(input)
        }
        return splitWithDefaultDelimiter(input)
    }

    private fun findCustomDelimiterWithIndex(input: InputString): Pair<Int, String> {
        for (i in 3..<input.input!!.length) {
            if (input.input!![i] == '\\' && input.input!![i + 1] == 'n') {
                return Pair(i - 1, input.input!!.slice(2..<i))
            }
        }
        throw IllegalArgumentException()
    }

    private fun splitWithCustomDelimiter(input: InputString): List<String> {
        val delimiterWithIndex = findCustomDelimiterWithIndex(input)
        val delimiters = "[,:${delimiterWithIndex.second}]".toRegex()

        input.input = input.input!!.drop(delimiterWithIndex.first + 3)
        return input.input?.split(delimiters) ?: listOf("0")
    }

    private fun splitWithDefaultDelimiter(input: InputString): List<String> {
        val delimiters = "[,:]".toRegex()

        return input.input?.split(delimiters) ?: listOf("0")
    }
}

class TranslatePreprocessor {
    fun translateToInt(numberList: List<String>): List<Int> {
        return numberList.map { it.toInt() }
    }
}
