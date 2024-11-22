package calculator.service

import calculator.validator.InputValidator

object CalcService {
    fun getSum(input: String) = InputValidator.getValidNumbers(input).sum()
}