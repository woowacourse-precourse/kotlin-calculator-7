package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()
    var result = 0

    val numList = mutableListOf<String>()

    if (input.isNotEmpty()) {
        if (input.contains("//")) {
            val newSeparator = input.substringAfter("//").substringBefore("\\n")
            val newInput = input.substringAfter("\\n")

            for (n in newInput.split(newSeparator)) {
                if (n.contains(":")) {
                    for (s in n.split(":")) {
                        numList.add(s)
                    }
                } else if (n.contains(",")) {
                    for (s in n.split(",")) {
                        numList.add(s)
                    }
                } else {
                    numList.add(n)
                }
            }

            for (s in numList) {
                result += s.toInt()
            }

            println("결과 : $result")
        } else {
            for (n in input.split(",")) {
                if (n.contains(":")) {
                    for (s in n.split(":")) {
                        numList.add(s)
                    }
                } else {
                    numList.add(n)
                }
            }

            for (s in numList) {
                result += s.toInt()
            }

            println("결과 : $result")
        }
    } else {
        println("결과 : $result")
    }
}
