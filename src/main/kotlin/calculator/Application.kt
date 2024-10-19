package calculator
import camp.nextstep.edu.missionutils.Console


fun minusCheck(number : Int) : Int{
    if(number < 0) throw IllegalArgumentException()
    return number
}
fun sumOfNumber(input : String) : Int{
    if (input.isEmpty()) return 0

    val customDelimiterPattern = """//(.)\\n(.*)""".toRegex()
    val matchResult = customDelimiterPattern.matchEntire(input)

    return if (matchResult != null) {
        val delimiter = matchResult.groupValues[1]
        val numbers = matchResult.groupValues[2]
        numbers.split("[$delimiter,:]".toRegex()).sumOf { minusCheck(it.toInt()) }
    } else {
        input.split("[,:]".toRegex()).sumOf { minusCheck(it.toInt()) }
    }
}
fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

    println("결과 : ${sumOfNumber(input)}")
}

fun test1(){
    println("결과 : ${sumOfNumber("1:2:3,4,5:6")}")
    println("결과 : ${sumOfNumber("//;\\n1;2;3;4")}")
    println("결과 : ${sumOfNumber("//;\\n1;2:3,4,5;6")}")
}

fun test2(){
    println("결과 : ${sumOfNumber("1:2:3;-6")}")
}

fun test3(){
    println("결과 : ${sumOfNumber("1:2:a,bb,5:6")}")
}
