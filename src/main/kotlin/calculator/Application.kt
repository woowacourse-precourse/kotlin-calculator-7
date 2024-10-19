package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해주세요.")
    var inputString = Console.readLine()
    try {
        // Classification
        taskClassification(inputString)
    } catch (e: IllegalArgumentException){
        println(e.message)
    }
}

fun taskClassification(inputExt: String){
    val customStart = inputExt.indexOf("//")
    val customEnd = inputExt.indexOf("\\n")
    if (customStart == 0 && customEnd >= 3){
        // Custom Calculator
        val cus = inputExt.substring(customStart+2 until customEnd)
        val processedString = inputExt.substring(cus.length+4)
        cusExtNumToStr(processedString, cus)
    } else{
        // Basic Calculator
        extNumTosStr(inputExt)
    }
}

fun extNumTosStr(inputExt: String) {
    val split1 = inputExt.split(":")
    val split2 = split1.joinToString().replace(" ", "").split(',')

    val sum = split2.mapNotNull { it.toIntOrNull() }.sum()
    println(sum)
}

fun cusExtNumToStr(procStr: String, cus: String){
    val splitStr = procStr.split(cus)

    val sum = splitStr.mapNotNull { it.toIntOrNull() }.sum()
    println(sum)
}