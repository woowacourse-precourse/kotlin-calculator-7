package calculator

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val inputString = readLine()!!
    val numArray = numberExtraction(inputString)
}

fun numberExtraction(inputString: String): List<String> {
    val numArray : List<String>
    if(inputString[0]=='/'&&inputString[1]=='/'&&inputString[3]=='\\'&&inputString[4]=='n'){
        numArray = inputString.substring(5).split(inputString[2])
    }else{
        numArray = inputString.trim().split(",",":")
    }
    return numArray
}