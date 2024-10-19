package calculator.utils

import calculator.extensions.isContainCustomOperator
import calculator.extensions.toIntListByOperator
import calculator.extensions.toIntListAppliedCustomOperator

object Extractor {

    fun extractNumbers(input: String): List<Int> {
        return if (!input.isContainCustomOperator()) {
            input.toIntListByOperator()
        } else input.toIntListAppliedCustomOperator()
    }
}