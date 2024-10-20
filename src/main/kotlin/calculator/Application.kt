package calculator

import camp.nextstep.edu.missionutils.Console


fun exceptionTest(inputString: String, allowedChars: String): Boolean{
    val regex = Regex("^[0-9${Regex.escape(allowedChars)}]*$")
    return !regex.matches(inputString)
}

fun extNumTosStr(inputExt: String) {
    if (exceptionTest(inputExt, "/\\n:,")){
        throw IllegalArgumentException("exception")
    }
    val split1 = inputExt.split(":")
    val split2 = split1.joinToString().replace(" ", "").split(',')
    val sum = split2.mapNotNull { it.toIntOrNull() }.sum()
    println("결과 : $sum")
}

fun cusExtNumToStr(procStr: String, cus: String){
    if (exceptionTest(procStr, "/\\n:,$cus")){
        throw IllegalArgumentException("cusException")
    }
    val splitStr = procStr.split(cus)
    val sum = splitStr.mapNotNull { it.toIntOrNull() }.sum()
    println("결과 : $sum")
}

fun taskClassification(inputExt: String){
    val customStart = inputExt.indexOf("//")
    val customEnd = inputExt.indexOf("\\n")
    if (customStart == 0 && customEnd >= 3){
        // Custom Calculator
        val cus = inputExt.substring(customStart+2 until customEnd)
        val processedString = inputExt.substring(cus.length+4)
        cusExtNumToStr(processedString, cus)
    } else if (customStart != 0 && customEnd >= 3) {
        // Custom Separator \\(X), \n(O)
        throw IllegalArgumentException("customStart: $customStart")
    } else if (customStart == 0 && customEnd < 3){
        // Custom Separator \\(O), \n(X)
        throw IllegalArgumentException("customEnd: $customEnd")
    } else
    {
        // Basic Calculator
        extNumTosStr(inputExt)
    }
}


fun main() {
    println("덧셈할 문자열을 입력해주세요.")
    var inputString = Console.readLine()
    taskClassification(inputString)
}