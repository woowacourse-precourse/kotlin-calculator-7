package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputString = readLine()

    if (inputString.isNullOrBlank()) {
        println("결과 : 0")
        return
    }

    val numArray = numberExtraction(inputString)

    if(!isAllElementsNumeric(numArray)) throw IllegalArgumentException("잘못된 입력입니다.")
    if(!isAllElementsNumericPositive(numArray)) throw IllegalArgumentException("잘못된 입력입니다.")

    val sum = sumNumArray(numArray)
    println("결과 : $sum")
}

fun numberExtraction(inputString: String): Array<String> {
    val numArray: Array<String>
    val regex = """//(.*?)\\n""".toRegex()
    val matchResult = regex.find(inputString)
    if(matchResult!=null){
        val customSeparator = matchResult.groupValues[1]
        val regex2 = """\\n(.*)""".toRegex()
        val matchResult2 = regex2.find(inputString)
        if (matchResult2 != null) {
            val inputStringSub = matchResult2.groupValues[1]
            numArray = inputStringSub.split(customSeparator).toTypedArray()
        }else{
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }else{
        numArray = inputString.trim().split(",",":").toTypedArray()
    }
    return numArray
}

fun sumNumArray(numArray: Array<String>): Int {
    var sum = 0
    numArray.forEach { sum+=it.toInt() }
    return sum
}

fun isAllElementsNumeric(numArray: Array<String>): Boolean {
    return numArray.all { it.toIntOrNull() != null }
}

fun isAllElementsNumericPositive(numArray: Array<String>): Boolean {
    return numArray.all { it.toInt() > 0 }
}