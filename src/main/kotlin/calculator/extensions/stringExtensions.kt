package calculator.extensions

import calculator.eums.DefaultOperator.*
import calculator.eums.RegexPattern.*

fun String.toIntListByOperator(): List<Int> {
    return split(COLON.value, COMMA.value).map { it.toInt() }
}

fun String.isContainCustomOperator(): Boolean {
    val regex = Regex(CUSTOM_OPERATOR.pattern)
    val result = regex.containsMatchIn(this)
    return result
}


fun String.splitWithCustomOperator(): List<String> {
    val regex = Regex(SPLIT_OPERATOR.pattern)
    val matchResult = regex.find(this)
    val delimiter = matchResult!!.groupValues[1]
    val numberPart = matchResult.groupValues[2]
    return numberPart.split(COLON.value, COMMA.value, delimiter)
}