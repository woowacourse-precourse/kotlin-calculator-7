package calculator

fun main() {
    lateinit var userInputList: List<String>
    var sum = 0
    val userInput = readlnOrNull()
    if (userInput != null) {
        userInputList = userInput.split(",", ":")
    }
}