package calculator

fun main() {
    lateinit var userInputList: List<String>
    var sum = 0
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
    val intInputList = userInputList.map { it.toIntOrNull() ?: throw IllegalArgumentException("잘못된 값을 입력했습니다.") }
    sum += intInputList.sum()
}