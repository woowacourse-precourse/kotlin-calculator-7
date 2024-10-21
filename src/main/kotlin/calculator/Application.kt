package calculator

fun main() {
    lateinit var userInputList: List<String>
    var sum = 0
    println("덧셈할 문자열을 입력해 주세요.")
    val userInput = readlnOrNull()
    if (userInput != null) {
        if (userInput.startsWith("//")) {
            val separatorList = userInput.split("\\n")
            val indicator = separatorList[0].substring(2)
            userInputList = separatorList[1].split(indicator)
        }
        else {
            userInputList = userInput.split(",", ":")
        }
    }
    val uIntInputList = userInputList.map { it.toUIntOrNull() ?: throw IllegalArgumentException("잘못된 값($it)을 입력했습니다.") }
    val intInputList = uIntInputList.map { it.toInt() }
    sum += intInputList.sum()
    println("결과 : $sum")
}