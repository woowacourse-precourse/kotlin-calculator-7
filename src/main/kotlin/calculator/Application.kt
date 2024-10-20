package calculator

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Console.close
import javax.swing.JToolBar.Separator

fun main() {
    print("덧셈할 문자열을 입력해 주세요.\n")
    val word = Console.readLine()
    println(word.substring(word.indexOf("//") , word.indexOf("\\n")))

}

class Calculator(inputWord : String){
    private lateinit var word: String

    init {
        this.word = inputWord
    }

    fun Separator(){
        if(word.substring(0,2) == "//" && word.substring(3,5) == "\\n"){

        }
        else{
            throw IllegalArgumentException()
        }
    }
}
