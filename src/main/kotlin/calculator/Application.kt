package calculator

fun main() {
    // TODO: 프로그램 구현
private fun isEmptyOrSingleNumber(input: String): Boolean {
    if (input.isEmpty()) {
        println(MESSAGE_RESULT_NUMBER.replace("%s", "0"))
        return true
    }

    val number = input.toLongOrNull()
    if (number != null) {
        println(MESSAGE_RESULT_NUMBER.replace("%s", number.toString()))
        return true
    }
    return false
}
private const val MESSAGE_RESULT_NUMBER = "결과 : %s"
