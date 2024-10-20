package calculator.utils

import calculator.extensions.isContainCustomOperator
import calculator.extensions.toIntListByOperator
import calculator.extensions.toIntListAppliedCustomOperator

object Extractor {

    fun extractNumbers(input: String): List<Int> {
        Validator.validateInput(input)
        val result = mutableListOf<Int>()

        if (!input.isContainCustomOperator()) {
            result.addAll(input.toIntListByOperator())
        } else {
            result.addAll(input.toIntListAppliedCustomOperator())
        }

        Validator.validateNumbers(result)
        return result
    }
}