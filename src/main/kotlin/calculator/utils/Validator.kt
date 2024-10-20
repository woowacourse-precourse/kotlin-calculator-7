package calculator.utils

import calculator.eums.DefaultDelimiter.*
import calculator.eums.Error.*
import calculator.eums.RegexPattern.*
import calculator.extensions.splitWithCustomDelimiter

object Validator {

    fun validateDefaultInput(input: String) {
        require(input != "") { EMPTY_INPUT.message }
        require(!input.contains(" ")) { CONTAIN_GAP.message }
        input.split(COLON.value, COMMA.value).forEach {
            require(!KOREAN_AND_ALPHABET.pattern.toRegex().matches(it)) { ONLY_NUMBER.message }
            require(it != "") { ONLY_NUMBER.message }
        }
    }

    fun validateInputContainedCustomOperator(input: String) {
        input.splitWithCustomDelimiter().forEach {
            require(it != "") { ONLY_NUMBER.message }
        }
    }

    fun validateNumbers(numbers: List<Int>) {
        for (idx in numbers.indices) {
            require(numbers[idx] > 0) { CONTAIN_NEGATIVE_NUMBER.message }
        }
    }
}