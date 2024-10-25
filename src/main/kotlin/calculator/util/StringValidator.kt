package calculator.util

object StringValidator {
    private val prohibitedDelimiters: List<String> = listOf(".")

    fun doesDelimiterExist(input: String): Boolean = input.startsWith("//")
    fun isDelimiterValid(delimiter: String): Boolean = delimiter !in prohibitedDelimiters
}