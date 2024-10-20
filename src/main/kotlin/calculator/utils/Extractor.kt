package calculator.utils

import calculator.extensions.isContainCustomOperator
import calculator.extensions.toIntListByOperator
import calculator.extensions.toIntListAppliedCustomOperator

object Extractor {

    fun extractNumbers(input: String): List<Int> {
        Validator.validateDefaultInput(input)
        val result = mutableListOf<Int>()

        if (!input.isContainCustomOperator()) {
            result.addAll(input.toIntListByOperator())
        } else {
            Validator.validateInputContainedCustomOperator(input)
            result.addAll(input.toIntListAppliedCustomOperator())
        }

        Validator.validateNumbers(result)
        return result
    }
}