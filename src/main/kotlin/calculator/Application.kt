package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val str : String = readln()

    var sum : Int = 0
    val delimiterList : MutableList<Char> = mutableListOf(',', ':')

    if(str.length >= 5
        && str.substring(0,2) == "//"
        && str.substring(3,5) == "\\n"
        && !str[2].isDigit()
        ) {
            delimiterList.add(str[2])
       }

    

}
