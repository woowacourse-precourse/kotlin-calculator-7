package calculator.utils

import calculator.isContainCustomOperator
import calculator.splitWithCustomOperator
import calculator.toIntListByOperator

object Extractor {

    fun extractNumbers(input: String): List<Int> {
        if (!input.isContainCustomOperator()) {
            return input.toIntListByOperator()
        }
        return input.splitWithCustomOperator().map { it.toInt() }
    }
}