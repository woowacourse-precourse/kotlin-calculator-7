package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    calculate()
}

fun calculate() {
    try {
        val userInputString = userInputString()
        val splitList = splitString(userInputString)
        val sum = sumSplitList(splitList)
        println(sum)
    } catch (e:Exception) {
        throw IllegalArgumentException()
    }
}

fun userInputString():String {
    val input = Console.readLine()
    return input
}

fun splitString(userInputString:String):List<Int> {
    if(userInputString.startsWith("//")){
        val customDelimiter = findCustomDelimiter(userInputString)
        val realUserInputString = realUserInputString(userInputString)
        val customSplitList = realUserInputString.split(customDelimiter).map{it.toInt()}
        return customSplitList
    } else {
        val basicSplitList = userInputString.split(",",":").map{it.toInt()}
        return basicSplitList
    }
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

fun realUserInputString(userInputString:String):String {
    val end = userInputString.indexOf("\\n")
    return userInputString.substring(end+2)
}
