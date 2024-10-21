package calculator

class Number(
    val value: Int
) {
    init {
        validatePositive(value)
    }

    constructor(value: Char) : this(value.convertToDigit())

    companion object {
        private fun Char.convertToDigit(): Int =
            if (isDigit()) digitToInt() else throw IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.")
    }

    private fun validatePositive(value: Int) {
        if (value <= 0) throw IllegalArgumentException("양수만 가능합니다.")
    }

    operator fun plus(other: Number): Number = Number(value + other.value)
}