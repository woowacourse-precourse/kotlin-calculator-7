package calculator.service

import calculator.validator.InputValidator

class CalcService {
    fun getSum(input: String) = InputValidator.getValidNumbers(input).sum()
}