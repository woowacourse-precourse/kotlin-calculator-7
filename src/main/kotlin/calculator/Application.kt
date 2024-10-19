package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    var str : String = readln()

    var sum = 0
    val delimiterList : MutableList<Char> = mutableListOf(',', ':') // 구분자 리스트

        // 커스텀 구분자 존재 여부 파악
        if(str.length >= 5 &&
            str.substring(0,2) == "//"
            && str.substring(3,5) == "\\n"
            && !str[2].isDigit()
            ) {
            // 커스텀 구분자 존재 시 -> 구분자 리스트에 추가
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
                    val errorMessage = if(!delimiterList.contains(c)) "올바르지 않은 구분자를 사용했습니다." else "구분자는 숫자 사이에 있어야 합니다."
                    throwInvalidStringException(errorMessage)
                }
            }
        }

        if(currentNumber.isNotEmpty()) sum += currentNumber.toInt()
        println("결과 : " + sum)

}

private fun throwInvalidStringException(message : String) {
    throw IllegalArgumentException(message)
}



