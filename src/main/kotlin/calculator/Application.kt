package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    var str : String = readln()

    var sum : Int = 0
    val delimiterList : MutableList<Char> = mutableListOf(',', ':') // 구분자 리스트

        // 커스텀 구분자 존재 여부 파악
        if(str.length >= 5 &&
            str.substring(0,2) == "//"
            && str.substring(3,5) == "\\n"
            && !str[2].isDigit()
            ) {
            delimiterList.add(str[2])
            str = str.substring(5, str.length)
        }


        var currentNumber = ""
        for(c in str) {
            if(c.isDigit()) currentNumber += c
            else {
                if(delimiterList.contains(c) && currentNumber.isNotEmpty()) {
                    sum += currentNumber.toInt()
                    currentNumber = ""
                }
                else {

                }
            }
        }

        if(currentNumber.isNotEmpty()) sum += currentNumber.toInt()
        println(sum)


}


