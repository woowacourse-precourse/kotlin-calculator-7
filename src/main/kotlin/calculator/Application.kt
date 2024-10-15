package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputString = readLine()!!
    val numArray = numberExtraction(inputString)
    val sum = sumNumArray(numArray)
    println(sum)
}

fun numberExtraction(inputString: String): Array<String> {
    val numArray: Array<String>
    if(inputString[0]=='/'&&inputString[1]=='/'&&inputString[3]=='\\'&&inputString[4]=='n'){
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