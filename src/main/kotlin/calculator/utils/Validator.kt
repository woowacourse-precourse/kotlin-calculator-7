package calculator.utils

import calculator.eums.DefaultOperator.*
import calculator.eums.Error.*
import calculator.eums.RegexPattern.*

object Validator {

    fun validateInput(input: String) {
        require(!input.contains(" ")) { CONTAIN_GAP.message }
        input.split(COLON.value, COMMA.value).forEach {
            require(!KOREAN_AND_ALPHABET.pattern.toRegex().matches(it)) { ONLY_NUMBER.message }
        }
    }

    fun validateNumbers(numbers: List<Int>) {
        for (idx in numbers.indices) {
            require(numbers[idx] > 0) { CONTAIN_NEGATIVE_NUMBER.message }
        }
    }
}