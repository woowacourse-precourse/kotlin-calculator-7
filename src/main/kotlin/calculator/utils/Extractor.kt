package calculator.utils

import calculator.extensions.isContainCustomOperator
import calculator.extensions.splitWithCustomOperator
import calculator.extensions.toIntListByOperator

object Extractor {

    fun extractNumbers(input: String): List<Int> {
        if (!input.isContainCustomOperator()) {
            return input.toIntListByOperator()
        }
        return input.splitWithCustomOperator().map { it.toInt() }
    }
}