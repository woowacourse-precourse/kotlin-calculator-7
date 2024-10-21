package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    if (input.isNotEmpty()) {
        if (input.contains("//")) {
            customSeparator(input)
        } else {
            defaultSeparator(input)
        }
    } else {
        println("결과 : 0")
    }
}

private fun defaultSeparator(
    input: String,
) {
    errorSeparator(input)

    var result = 0
    val numList = mutableListOf<String>()

    for (n in input.split(",")) {
        if (n.contains(":")) {
            for (s in n.split(":")) {
                errorNotPositiveNumber(s)
                numList.add(s)
            }
        } else {
            errorNotPositiveNumber(n)
            numList.add(n)
        }
    }

    for (s in numList) {
        result += s.toInt()
    }

    println("결과 : $result")
}

private fun customSeparator(
    input: String,
) {
    var result = 0
    val numList = mutableListOf<String>()

    val newSeparator = input.substringAfter("//").substringBefore("\\n")
    val newInput = input.substringAfter("\\n")

    errorSeparator(newInput, newSeparator)

    for (n in newInput.split(newSeparator)) {
        if (n.contains(":") || n.contains(",")) {
            for (s in n.split(":")) {
                if (s.contains(",")) {
                    for (c in s.split(",")) {
                        errorNotPositiveNumber(c)
                        numList.add(c)
                    }
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

    for (s in numList) {
        result += s.toInt()
    }

    println("결과 : $result")
}


private fun errorNotPositiveNumber(s: String) {
    if (s.toInt() < 1) {
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