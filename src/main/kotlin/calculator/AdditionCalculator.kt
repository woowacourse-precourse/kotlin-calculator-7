package calculator


open class AdditionCalculator {

    private val standardDelimiters = Regex("[:,]")

    fun calculate(verifiedUserInput: String): Int {
        if (verifiedUserInput.startsWith("//")) {
            val customDelimiter = verifiedUserInput.substring(2, verifiedUserInput.indexOf("\\n"))
            val exceptCustomDelimiter = verifiedUserInput.substring(
                verifiedUserInput.indexOf("\\n") + 2
            )

            val addedCustomDelimiterExtract = exceptCustomDelimiter.split(customDelimiter)
                .flatMap { it.split(standardDelimiters) }
                .filter { it.isNotBlank() }
                .map { it.toIntOrNull() ?: 0 }
            val sum = addedCustomDelimiterExtract.sum()

            return sum

        } else {
            val delimitersExtract = verifiedUserInput.split(standardDelimiters)
                .filter { it.isNotBlank() }
                .map { it.toIntOrNull() ?: 0 }
            val sum = delimitersExtract.sum()

            return sum
        }
    }
}
