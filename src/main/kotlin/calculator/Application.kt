package calculator

fun main() {
    val userInput = getInput()
    if (handleEmptyInput(userInput)) return
    val userInputList = parseInput(userInput!!)
    val uIntInputList = convertToUIntList(userInputList)
    val sum = calculateSum(uIntInputList)
    printResult(sum)
}

fun getInput(): String? {
    println("덧셈할 문자열을 입력해 주세요.")
    return readlnOrNull()
}

fun handleEmptyInput(input: String?): Boolean {
    if (input.isNullOrEmpty()) {
        println("결과 : 0")
        return true
    }
    return false
}

fun parseInput(input: String): List<String> {
    val userInputList: List<String>
    if (input.startsWith("//")) {
        val separatorList = input.split("\\n")
        val indicator = separatorList[0].substring(2)
        userInputList = separatorList[1].split(indicator)
    }
    else {
        userInputList = input.split(",", ":")
    }
    return userInputList
}

fun convertToUIntList(stringList: List<String>): List<UInt> {
    return stringList.map { it.toUIntOrNull() ?: throw IllegalArgumentException("잘못된 값($it)을 입력했습니다.")}
}

fun calculateSum(uIntList: List<UInt>): Int {
    return uIntList.map { it.toInt() }.sum()
}

fun printResult(sum: Int) {
    println("결과 : $sum")
}