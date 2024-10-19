package calculator

object Extractor {

    fun extractNumbers(input: String): List<Int> {
        if (!input.isContainCustomOperator()) {
            return input.toIntListByOperator()
        }
        return input.splitWithCustomOperator().map { it.toInt() }
    }
}