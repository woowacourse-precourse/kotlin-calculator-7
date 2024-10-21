package calculator

enum class Operator(
    private val value: Char,
    val calculate: (Number, Number) -> Number
) {
    PLUS('+', { a, b -> a + b })
    ;

    companion object {
        fun find(oper: Char): Operator {
            return entries.find { it.value == oper } ?: throw IllegalArgumentException("연산자가 올바르지 않습니다.")
        }
    }
}