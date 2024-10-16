package calculator

class Controller(private val validator: Validator) {
    fun calculate(input: String): Int {
        return validator.validate(input)
    }
}