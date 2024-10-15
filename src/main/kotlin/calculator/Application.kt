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

    val sum = sumNumArray(numArray)
    println("결과 : $sum")
}

fun numberExtraction(inputString: String): Array<String> {
    val numArray: Array<String>
    if(inputString.length > 4 && inputString[0]=='/'&&inputString[1]=='/'&&inputString[3]=='\\'&&inputString[4]=='n'){
        numArray = inputString.substring(5).split(inputString[2]).toTypedArray()
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