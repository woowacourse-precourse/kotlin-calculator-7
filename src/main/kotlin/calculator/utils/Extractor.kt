package calculator.utils

import calculator.extensions.isContainCustomOperator
import calculator.extensions.toIntListByDefaultDelimiter
import calculator.extensions.toIntListAppliedCustomDelimiter

object Extractor {

    fun extractNumbers(input: String): List<Int> {
        Validator.validateDefaultInput(input)
        val result = mutableListOf<Int>()

        if (!input.isContainCustomOperator()) {
            result.addAll(input.toIntListByDefaultDelimiter())
        } else {
            Validator.validateInputContainedCustomOperator(input)
            result.addAll(input.toIntListAppliedCustomDelimiter())
        }

        Validator.validateNumbers(result)
        return result
    }
}