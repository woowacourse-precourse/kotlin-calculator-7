package calculator

import java.math.BigDecimal
import java.util.LinkedList

class NumberTokenizer {

    private val delimiters = listOf(",", ":")

    fun tokenize(strings: String): List<BigDecimal> {
        val result = mutableListOf<BigDecimal>()
        val tempString = LinkedList<Char>()
        for (char in strings) {
            if (delimiters.contains(char.toString())) {
                result.add(getNumber(tempString))
                tempString.clear()
                continue
            }
            tempString.add(char)
        }
        if (tempString.isNotEmpty()) result.add(getNumber(tempString))
        return result
    }

    fun extractCustomDelimiters(input: String): List<String> {
        val customDelimiters = mutableListOf<String>()
        val parts = input.split("\n")
        for (part in parts) {
            val delimiterStartIndex = part.indexOf("//")
            if (delimiterStartIndex == -1) break
            val customDelimiter = part.substring(delimiterStartIndex+2)
            println(customDelimiter)
            customDelimiters.add(customDelimiter)
        }
        return customDelimiters
    }

    private fun getNumber(strings: LinkedList<Char>): BigDecimal {
        val result = StringBuilder()
        while (strings.isNotEmpty()) {
            result.append(strings.poll())
        }
        return result.toString().toBigDecimal()
    }
}