package calculator.model

class CalculatorModel {
    fun sumWithDefaultSeparator(input: String): Int {
        errorNotPositiveNumber(input)
        val numList = defaultSeparator(input)
        return numList.sumOf { it.toInt() }
    }

    fun sumWithCustomSeparator(input: String): Int {
        val newSeparator = input.substringAfter("//").substringBefore("\\n")
        val newInput = input.substringAfter("\\n")

        errorSeparator(newInput, newSeparator)
        val numList = customSeparator(newInput, newSeparator)
        return numList.sumOf { it.toInt() }
    }

    private fun defaultSeparator(input: String): List<String> {
        val numList = mutableListOf<String>()

        for (n in input.split(",")) {
            if (n.contains(":")) {
                colonSeparator(n, numList)
            } else {
                errorNotPositiveNumber(n)
                numList.add(n)
            }
        }

        return numList
    }

    private fun customSeparator(input: String, separator: String): List<String> {
        val numList = mutableListOf<String>()

        for (n in input.split(separator)) {
            if (n.contains(":") || n.contains(",")) {
                for (s in n.split(":")) {
                    if (s.contains(",")) {
                        commaSeparator(s, numList)
                    } else {
                        errorNotPositiveNumber(s)
                        numList.add(s)
                    }
                }
            } else {
                errorNotPositiveNumber(n)
                numList.add(n)
            }
        }

        return numList
    }

    private fun commaSeparator(s: String, numList: MutableList<String>) {
        for (c in s.split(",")) {
            errorNotPositiveNumber(c)
            numList.add(c)
        }
    }

    private fun colonSeparator(n: String, numList: MutableList<String>) {
        for (s in n.split(":")) {
            errorNotPositiveNumber(s)
            numList.add(s)
        }
    }

    private fun errorNotPositiveNumber(num: String) {
        if (num.toInt() < 1) {
            throw IllegalArgumentException("양수로 구성된 문자열을 입력해 주세요.")
        }
    }

    private fun errorSeparator(input: String, newSeparator: String = "") {
        val regex = "[^0-9,:-$newSeparator]".toRegex()
        val invalidChar = regex.findAll(input).map { it.value }.joinToString("")
        if (invalidChar.isNotEmpty()) {
            throw IllegalArgumentException("${invalidChar}는 구분자가 아닙니다.")
        }
    }
}