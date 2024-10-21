package calculator

const val CUSTOM_PATTERN = "//(.)\\\\n(.*)"

class InputExpression(val expression: String?)

class Seperator(val expression: String) {
    var seperator = ",|:"
    fun usedCustomSeperator(): Boolean {
        return expression.matches(Regex(CUSTOM_PATTERN))
    }
    fun findSeperator(): String? {
        val regex = Regex(CUSTOM_PATTERN)
        val matchResult = regex.find(expression)
        return matchResult?.groupValues?.get(1)
    }
}

fun main() {
    // TODO: 프로그램 구현
}
