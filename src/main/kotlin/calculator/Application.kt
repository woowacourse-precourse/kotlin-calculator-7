package calculator

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Console.close

fun main() {
    print("덧셈할 문자열을 입력해 주세요.\n")
    val word = Console.readLine()
    val separator = Separator(word)
    try {
        separator.checkIllegalArgumentException()
    }catch (e : IllegalArgumentException){
        close()
    }
}


class Separator(s: String) {
    private var word: String
    private lateinit var divider : String
    private var sum: Int = 0
    private var addWord: String = ""
    init {
        this.word = s
    }

    private fun checkCustomSeparator() {
        divider = word.substring(3,4)
        word = word.substring(6)
        for (i in word) {
            when ("$i") {
                ",", ":" -> {
                    sum += confirmNumber(addWord)
                    addWord = ""
                }
                divider -> {
                    sum += confirmNumber(addWord)
                    addWord = ""
                }
                "\"" -> continue
                else -> {
                    addWord += i
                }
            }
        }
        if (addWord.isNotEmpty()) {
            sum += confirmNumber(addWord)
        }
        println("결과 : $sum")
    }

    private fun checkSeparator() {
        for (i in word) {
            when ("$i") {
                ",", ":" -> {
                    sum += confirmNumber(addWord)
                    addWord = ""
                }
                "\"" -> continue
                else -> addWord += i
            }
        }
        if (addWord.isNotEmpty()) {
            sum += confirmNumber(addWord)
        }
        println("결과 : $sum")
    }

    private fun confirmNumber(addWord: String): Int {
        try {
            sum = addWord.toInt()
        } catch (e: NumberFormatException) {
            divider = addWord
        }
        return sum
    }

    fun checkIllegalArgumentException(){
        if (word.contains("//")) {
            this.checkCustomSeparator()
        } else if ((word.contains(":") || word.contains(","))) {
            this.checkSeparator()
        } else {
            throw IllegalArgumentException()
        }
    }

}
