package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    print("덧셈할 문자열을 입력해 주세요.\n")
    val word = Console.readLine()
    val calculator = Calculator(word)
    calculator.calc(calculator.checkWord())
}

class Calculator(inputWord: String) {
    private var word: String

    init {
        this.word = inputWord
    }

    fun checkWord(): DividerType {
        return if(word.isBlank() || word == ""){
            DividerType.NULL
        }
        else if (word.substring(0, 2) == "//" && word.substring(3, 5) == "\\n") {
            word = word.substring(2)
            DividerType.CUSTOM
        } else if (word.contains(":") || word.contains(",")) {
            checkNumberFormat(wordNumberFormat = word.replace(",", "").replace(":", ""))
            DividerType.DIVIDER
        } else {
            throw IllegalArgumentException()
        }
    }

    private fun checkNumberFormat(wordNumberFormat : String) {
        try {
            wordNumberFormat.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }

    private fun calculator(divider3: Char) {
        var num = ""
        var sum = 0
        for (i in word) {
            when (i) {
                ':', ',', divider3 -> {
                    checkNumberFormat(num)
                    if(num.toInt() < 0)
                        throw IllegalArgumentException()
                    sum += num.toInt()
                    num = ""
                }

                else -> {
                    num += i
                }
            }
        }
        sum+=num.toInt()
        println("결과 : $sum")
    }

    fun calc(dividerType: DividerType) {
        when (dividerType) {
            DividerType.CUSTOM -> {
                val customWord = word.substring(0, 1)
                word = word.substring(3)
                calculator(customWord[0])
            }

            DividerType.DIVIDER -> {
                calculator(':')
            }

            DividerType.NULL ->{
                print("결과 : 0")
            }
        }
    }
}

enum class DividerType {
    DIVIDER, CUSTOM, NULL
}