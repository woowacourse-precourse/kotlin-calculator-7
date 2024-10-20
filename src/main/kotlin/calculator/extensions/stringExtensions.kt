package calculator.extensions

import calculator.eums.DefaultDelimiter.*
import calculator.eums.RegexPattern.*

fun String.toIntListByDefaultDelimiter(): List<Int> {
    return split(COLON.value, COMMA.value).map { it.toInt() }
}

fun String.isContainCustomOperator(): Boolean {
    val regex = Regex(CUSTOM_DELIMITER.pattern)
    val result = regex.containsMatchIn(this)
    return result
}


fun String.splitWithCustomDelimiter(): List<String> {
    val regex = Regex(SPLIT_DELIMITER.pattern)
    val matchResult = regex.find(this)
    val delimiter = matchResult!!.groupValues[1]
    val numberPart = matchResult.groupValues[2]
    return numberPart.split(COLON.value, COMMA.value, delimiter)
}

fun String.toIntListAppliedCustomDelimiter(): List<Int> = splitWithCustomDelimiter().map { it.toInt() }