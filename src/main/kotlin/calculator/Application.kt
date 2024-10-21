package calculator

/**
 * 1. 사용자에게 입력해 달라는 문자를 출력할 기능 구현
 * 2. 사용자에게 입력받는 기능 구현
 * 2-1. 커스텀 구분자를 지정하지 않고 양수로 이루어진 문자열인 경우
 * 2-2. 커스텀 구분자를 지정하고 양수로 이루어진 문자열인 경우
 * (이렇게 2가지 경우를 예상하고 구현해야 함.)
 * 3. 입력받은 문자열을 Int로 전환하여 각 문자열의 합을 구하고 결과값을 출력
 */
fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = readln()
    var delimiter = ""
    var result = ""

    //기본 구분자(',' , ':') 로 구분하는 경우
    fun defaultDelimiter(): String {
        var output = ""
        try {
            val numbers = input.split(",", ":").map {
                if (it.toInt() >= 0) {
                    it.toInt()
                } else throw IllegalArgumentException()
            }
            output = numbers.sum().toString()
        } catch (e: IllegalArgumentException) {
            println(e)
        }
        return output
    }


    // 커스텀 구분자를 지정하는 경우
    fun customDelimiter(): String {
        var numberList: List<Int>
        var output = ""

        delimiter = input.substring(2, 3)
        val numberString = input.substringAfter("n")
        try {
            numberList = numberString.split(delimiter).map {
                if (it.toInt() >= 0) {
                    it.toInt()
                } else throw IllegalArgumentException()
            }
            output = numberList.sum().toString()
        } catch (e: IllegalArgumentException) {
            output = e.toString()

        }
        return output
    }

    if (input.substring(0, 2) == "//") {
        result = customDelimiter()
    } else result = defaultDelimiter()

    if (result != "") println("결과 : $result")
}
