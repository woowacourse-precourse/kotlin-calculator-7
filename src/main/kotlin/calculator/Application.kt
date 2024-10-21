package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val userInputString = userInputString()
    println(findCustomDelimiter(userInputString))
//    val splitList = splitString(userInputString)
//    val sum = sumSplitList(splitList)
//    println(sum)

}

fun userInputString():String {
    val input = Console.readLine()
    return input
}

fun splitString(userInputString:String):List<Int> {

    val basicSplitList = userInputString.split(",",":").map{it.toInt()}
    return basicSplitList

}

fun sumSplitList(splitList:List<Int>):Int {
    val sum = splitList.sum()
    return sum
}

fun findCustomDelimiter(userInputString:String):String {
    val start = userInputString.indexOf("//")
    val end = userInputString.indexOf("\\n")
    return userInputString.substring(start+2,end)
}
