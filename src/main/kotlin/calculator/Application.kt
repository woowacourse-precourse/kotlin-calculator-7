package calculator

const val CUSTOM_PATTERN = "//(.)\\\\n(.*)"

class InputExpression(val expression: String?) {
    var text = expression
    var spliter = Seperator(expression)

    fun splitExpression(): Any {
        if(spliter.usedCustomSeperator()){
            spliter.seperator = spliter.findSeperator()!!
            text = expression!!.substring(5)
        }
        return text?.split(Regex(spliter.seperator)) ?: 0
    }
}

class Seperator(val expression: String?) {
    var seperator = ",|:"
    fun usedCustomSeperator(): Boolean {
        return expression?.matches(Regex(CUSTOM_PATTERN)) ?: false
    }
    fun findSeperator(): String? {
        val regex = Regex(CUSTOM_PATTERN)
        val matchResult = regex.find(expression!!)
        return matchResult?.groupValues?.get(1)
    }
}

fun main() {
    // TODO: 프로그램 구현
}
