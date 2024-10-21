package calculator

import camp.nextstep.edu.missionutils.Console

const val CUSTOM_PATTERN = "//(.)\\\\n(.*)"

class InputExpression(val expression: String?) {
    var text = expression
    var spliter = Seperator(expression)

    fun splitExpression(): List<String> {
        if (spliter.usedCustomSeperator()) {
            spliter.seperator = ",|:|${spliter.findSeperator()!!}"
            text = expression!!.substring(5)
        }
        val splitedText = text?.split(Regex(spliter.seperator)) ?: listOf("0")

        for (txt in splitedText) {
            if (!txt.matches(Regex("[0-9]+"))) {
                throw IllegalArgumentException("[ERROR] 잘못된 입력: $txt")
            }
        }

        return splitedText
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

fun parseNumber(txt: String?): Int {
    if (txt.isNullOrEmpty()) {
        return 0
    }
    val num = Integer.parseInt(txt)
    if (num < 0) {
        throw IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.")
    }
    return num
}

fun calculate(text: List<String>): Int {
    var result = 0;
    for (txt in text) {
        result += parseNumber(txt)
    }
    return result
}

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputExpression = InputExpression(Console.readLine())
    println("결과 : ${calculate(inputExpression.splitExpression())}")
}
